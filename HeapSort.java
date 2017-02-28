/*
   Implementation of Shell sort numbers and returns a sorted list.
   Shell Sort Overview:
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

public class HeapSort {
	
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

		heap(arr);

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
		System.out.println("The running time in nanoseconds is: " + " " + duration);
	}

	static void heapify(int a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (a[child] > a[max])
				max = child;
		if (child + 1 < n)
			if (a[child + 1] > a[max])
				max = child + 1;
			if (max != i) {
				int temp = a[i];
				a[i] = a[max];
				a[max] = temp;
				heapify(a, n, max);
			}
		}

		static void buildheap(int a[]) {
			for (int i = a.length / 2 - 1; i >= 0; i--)
				heapify(a, a.length, i);
		}

		static void heap(int a[]) {
			buildheap(a);
			for (int i = a.length - 1; i >= 1; i--) {
				int temp = a[0];
				a[0] = a[i];
				a[i] = temp;
				heapify(a, i, 0);
			}
		}
	}
