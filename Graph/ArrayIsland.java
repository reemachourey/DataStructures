/*Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands

                  {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} 

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int maxSize=0;
        for(int row=0; row<matrix.length;row++){
            for(int col = 0; col<matrix[0].length;col++){
                if(matrix[row][col]==1){
                    int size=getRegionSize(matrix,row,col);
                    maxSize=Math.max(maxSize,size);
                }
            }
        }
        return maxSize;
    }
    
    static int getRegionSize(int [][] matrix,int row, int col){
        
        if(row <0 || col <0 || row >=matrix.length || col >= matrix[row].length)
            return 0;
        
        if(matrix[row][col]==0)
            return 0;
        int size=1;
        matrix[row][col]=0; // make current element 0 from one to avoid visiting same element
        for(int r=row-1;r<=row+1;r++){ //visit all the eight connected indices of one matrix cell
            for(int c=col-1;c<=col+1;c++){
                if(r!=row || c!=col)
                    size+=getRegionSize(matrix,r,c);
            }
        }
        return size;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /**BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*/

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}