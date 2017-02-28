/*
   Implementation of Quick sort numbers and returns a sorted list.
   Quick Sort Overview:
   ---------------------
   A naive sorting that compares and swaps adjacent elements
   ================================
   Worst case performance O(n^2)
   Best case performance  O(n*log(n))
   Average case performance O(n*log(n))
   --------------------------------
   Space Complexity: O(log(n)) Auxiliary
 */
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

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

		sort(arr, 0, arr.length - 1);

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
	public static void partition_first(int array[], int leftend, int rightend) {
	    int pivot = array[leftend];
	    	    int i = leftend + 1;
	    	    for (int j = leftend + 1; j <= rightend; j++) {
	    	        if (array[j] < pivot);
	    	            int temp = array[j];
	    	            array[j] = array[i];
	    	            array[i] = temp;
	    	            i += 1;
	    	    }
	    	    int leftendval = array[leftend];
	    	    array[leftend] = array[i-1];
	    	    array[i-1] = leftendval;
	}
	public static void partition_last(int array[], int leftend, int rightend) {
	    int pivot = array[leftend];
	    int num = 10;
	    if (array.length < num)
	    	insertionSort(array);
	    	
	    int i = leftend + 1;
	    for (int j = leftend + 1; j <= rightend; j++) {
	        if (array[j] < pivot);
	            int temp = array[j];
	            array[j] = array[i];
	            array[i] = temp;
	            i += 1;
	    }
	    int leftendval = array[leftend];
	    array[leftend] = array[i-1];
	    array[i-1] = leftendval;
	}
	
//A method to calculate the median of three numbers using two comparisons
	public static int median(int left, int right, int midian) {
	    if ((left - right) * (midian - left) >= 0)
	        return left;
	    if ((right - left) * (midian - right) >= 0) {
	        return right;
	    }
	    else {
	        return midian;
	    }
	}
	public static void partition_median(int array[], int leftend, int rightend) {
		int middle;
	    int left = array[leftend];
	    int right = array[rightend-1];
	    int length = rightend - leftend;
	    if (length % 2 == 0) 
	        middle = array[leftend + (length/2 - 1)];
	    else {
	        middle = array[leftend + length/2];
	  
	    int pivot = median(left, right, middle);

	    int i = leftend + 1;
	    for (int j = leftend + 1; j <= rightend; j++) {
	        if (array[j] < pivot);
	            int temp = array[j];
	            array[j] = array[i];
	            array[i] = temp;
	            i += 1;
	    }
	    int leftendval = array[leftend];
	    array[leftend] = array[i-1];
	    array[i-1] = leftendval;
	    }
	}
	
	static void sort(int arr[], int start, int end) {
		if (start < end) {
			int pIndex = partition(arr, start, end);
			sort(arr, start, pIndex - 1);
			sort(arr, pIndex + 1, end);
		}
	}

	static int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		swap(arr, pIndex, end);
		return pIndex;
	}

	static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
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
	
	
	
}
