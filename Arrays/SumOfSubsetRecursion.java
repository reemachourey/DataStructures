//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
/**
    We include current element in subset and recurse the remaining elements within remaining sum
    We exclude current element from subset and recurse for remaining elements.
    Finally, we return true if we get subset by including or excluding current item else we return false.

Complexity Analysis: The above solution may try all subsets of given set in worst case. Therefore time complexity of the above solution is exponential. The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).

*/
public class SumOfSubsetRecursion{
  public static void main (String[] args) {
		//get the input
	/*	Scanner s= new Scanner(System.in);
		int testcases = s.nextInt();
		//System.out.println(testcases);
	    
		for(int i=0;i<testcases;i++){
		    int size= s.nextInt();
		    int sum = s.nextInt();
		     int arr[]= new int[size];
		    for(int j=0;j<size;j++){
		       arr[j]=s.nextInt();
		    } */
		    //Call the method to find sum of Subset
    int set[] = { 3, 34, 4, 12, 5, 2 };
    int sum = 9;
    int index=0;
    if (isSubsetSum(set, index, sum) == true)
        printf("Found a subset with given sum");
    else
        printf("No subset with given sum");
    return 0;
	/*	}*/
	}

  public boolean isSubsetSum(int [] arr, int index, int sum){
    if(sum==0)
      return true;

    if(arr.length-(index)==1) {
      if(arr[index]==sum)
       return true;
      else return false;
    } 

    boolean value1 = isSubsetSum(arr, index+1, sum - arr[index]); //include the first element;
    boolean value2 = isSubsetSum(arr, index+1, sum); //exclude the first element

    return value1 || value2; 
  }
}