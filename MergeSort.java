/*
   Implementation of Merge sort on a list and returns a sorted list.
   Merge Sort Overview:
   ---------------------
   A naive sorting that compares and swaps adjacent elements
   ================================
   Worst case performance O(n*log(n))
   Best case performance  O(n*log(n))
   Average case performance O(n*log(n))
   --------------------------------
   Space Complexity: O(1) Auxiliary
 */
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

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

		System.out.println("The unsorted array is:");
		System.out.println(Arrays.toString(arr));

		mergeSort(arr);

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

	public static void mergeSort(int[] array){
		System.out.println("sorting " + Arrays.toString(array));
		if(array.length > 1){
			int[] left  = Arrays.copyOfRange(array, 0, array.length/2);
			int[] right = Arrays.copyOfRange(array, array.length/2, array.length);

			mergeSort(left);
			mergeSort(right);

			merge(array, left, right);
		}
	}

	public static void merge(int[] array, int[] left, int[] right){
		System.out.println("merging " + Arrays.toString(left) + " and " + Arrays.toString(right));

		int leftIndex = 0, rightIndex = 0;
		for(int i=0; i<array.length; i++){
			if(rightIndex >= right.length || (leftIndex <= left.length-1 && left[leftIndex] < right[rightIndex])) {
				array[i] = left[leftIndex];
				leftIndex++;
			} else {
				array[i] = right[rightIndex];
				rightIndex++;
			}
		}
	}
}

