import java.util.Arrays;
import java.util.Scanner;

/*
   Implementation of Insertion sort numbers and returns a sorted list.
   Insertion Sort Overview:
   ---------------------
   A naive sorting that compares and swaps adjacent elements
   ================================
   Worst case performance O(n^2)
   Best case performance  O(n)
   Average case performance O(n^2)
   --------------------------------
   Space Complexity: O(1) Auxiliary
 */


public class InsertionSort {
	
	public static int[] insertionSort(int[] array) {
    int valueToInsert = 0;
    for (int i=1; i<array.length; i++) { // i is the index of the next value to insert - insert index
        for (int j=0; j<i; j++) { // j will be the index of where to insert
            if (array[i]<array[j]) {
                valueToInsert = array[i]; // Move values over first if necessary
                for (int k=i; k>j; k--) {
                    array[k] = array[k-1];
                }
                array[j] = valueToInsert; // Insert array[i] at index j
                break;
            }
        }
    }
    return array;
	}


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

		insertionSort(arr);

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
}