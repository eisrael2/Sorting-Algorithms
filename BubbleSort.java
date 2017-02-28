/*
   Implementation of bubble sort on a list and returns a sorted list.
   Bubble Sort Overview:
   ---------------------
   A naive sorting that compares and swaps adjacent elements
   ================================
   Worst case performance O(n^2)
   Best case performance  O(n)
   Average case performance O(n^2)
   --------------------------------
   Space Complexity: O(1) Auxiliary
 */

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort { 
	
	private static Scanner scan;

	public static void main(String args[]) {
		scan = new Scanner(System.in);
		final long startTime = System.nanoTime();

		System.out.println("Enter no of terms");
		int n = scan.nextInt();

		System.out.println("Enter the terms");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scan.nextInt();

		System.out.println("The unsorted array is:" + " " + Arrays.toString(arr));

		bubbleSort(arr);
		
		System.out.println("The unsorted array in ascending order is:");
		for(int i = arr.length -1; i >=0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		System.out.println("The unsorted array in decending order is:");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}	
		System.out.println("\n");
		System.out.println("The sorted array is:" + " " + Arrays.toString(arr));
		
		final long duration = System.nanoTime() - startTime;
		System.out.println("The running time in milliseconds is: " + " " + duration);
	}

	
 public static void bubbleSort(int[] array){
    for(int i=0; i<array.length-1; i++){
       for(int j=0; j<array.length-i-1; j++)
          if(array[j+1]<array[j])
            swap(array, j, j+1);
    }
 }

 public static void swap(int[] array, int index1, int index2){
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
 }
}