/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SumOfSubset {
	public static void main (String[] args) {
		//get the input
		Scanner s= new Scanner(System.in);
		int testcases = s.nextInt();
		//System.out.println(testcases);
	    
		for(int i=0;i<testcases;i++){
		    int size= s.nextInt();
		    int sum = s.nextInt();
		     int arr[]= new int[size];
		    for(int j=0;j<size;j++){
		       arr[j]=s.nextInt();
		    }
		    //Call the method to find sum of Subset
		    sumOfSubset(arr,size,sum);
		}
	}
	
	public static void sumOfSubset(int arr[], int size,int sum){
	    for(int i=0;i<size;i++){
	       int curr_sum=arr[i];
	       for(int j=i+1;j<size;j++){
	          
	           if(curr_sum>sum){
	               break;
	           }
	           
	           if(curr_sum==sum){
	               System.out.println((i+1)+" "+(j));
	               return;
	           } else
	               curr_sum = curr_sum+arr[j];
	       } 
	       if(curr_sum==sum){
	               System.out.println((i+1)+" "+(size));
	               return;
	    }
	    }
	     
	    System.out.println("-1");
	}
}