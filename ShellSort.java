
/*
   Implementation of Shell sort numbers and returns a sorted list.
   Shell Sort Overview:
   ---------------------
   A naive sorting that compares and swaps adjacent elements
   ================================
   Worst case performance O(n*log(n))
   Best case performance  O(n^2)
   Average case performance O(n^2)
   --------------------------------
   Space Complexity: O(1) Auxiliary
 */
import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
	
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

		shellSort(arr, arr.length - 1);

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
	private static void shellSort(int Arr[], int array_size) {
			int i, j, increment, temp;
			increment = 3;
			while (increment > 0) {
			for (i=0; i < array_size; i++) {
			j = i; temp = Arr[i];
			while ((j >= increment) && (Arr[j-increment] > temp)) {
			Arr[j] = Arr[j - increment];
			j = j - increment;
			}
			Arr[j] = temp;
			}
			if (increment/2 != 0) increment = increment/2;
			else if (increment == 1) increment = 0;
			else increment = 1;
			}
	}
}
