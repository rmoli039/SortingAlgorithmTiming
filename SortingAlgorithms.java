//PID: 6140544

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms
{
	public static void bubbleSort(int[] list)
	{
		bubblesort(list);
	}
	
	public static void insertionSort(int[] list)
	{
		insertionsort(list);
	}
	
	public static void mergeSort(int[] list)
	{
		mergesort(list, 0, list.length-1);
	}
	
	public static void quickSort(int[] list)
	{
		quicksort(0, list.length - 1, list);
	}
	
	public static void selectionSort(int[] list)
	{
		selectionsort(list);
	}
	
	public static void fillArray(int[] list)
	{
		Random ran = new Random();
		
		for (int i = 0; i < list.length; i++)
		{
			list[i] = ran.nextInt(100);
		}
	}
	
	public static void printArray(int[] list)
	{
		System.out.print(Arrays.toString(list));
	}
	
	/**
	 *  Bubblesort algorithm 
	 *  @author Prof. A. Hernandez
	 */
	private static void bubblesort(int[] list)
	{
		int n = list.length;
		for(int i = 0; i < n-1; i++)
			for(int j = 0; j < n-i-1; j++)
				if(list[j] > list[j+1])
				{
					//swap list[j] and list[j+1]
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
	}
	
	/**
	 *  Insertionsort algorithm 
	 *  @author Prof. A. Hernandez
	 */
	private static void insertionsort(int[] list)
	{
		for (int i = 1; i < list.length; i++)
		{
			int temp = list[i];
			int j = i-1;
			while(j >= 0 && temp < list[j])
			{
				list[j+1] = list[j];
				j--;
			}
			
			list[j+1] = temp;
		}
	}
	
	/**
	 *  Mergesort algorithm 
	 *  @author Prof. A. Hernandez
	 */
	private static void mergesort(int[] list, int begin, int end)
	{
		if(begin < end)
		{
			int mid = (begin + end) / 2;
			
			mergesort(list, begin, mid);
			mergesort(list, mid + 1, end);
			merge(list, begin, mid, end);
		}
	}
	
	/**
	 *  Merge method 
	 *  @author Prof. A. Hernandez
	 */
	private static void merge(int[] list, int b, int m, int e)
	{
		int[] temp = new int[e - b + 1];
		
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = list[b + i];
		}
		
		int bPtr = b;
		int ePtr = m+1;
		int i = b;
		
		while (bPtr != (m+1) && ePtr != (e+1))
		{
			if (temp[bPtr-b] < temp[ePtr-b])
			{
				list[i] = temp[bPtr-b];
				bPtr++;
			}
			else
			{
				list[i] = temp[ePtr-b];
				ePtr++;
			}
			
			i++;
		}
		
		if (ePtr == e+1)
		{
			while (bPtr != (m+1))
			{
				list[i] = temp[bPtr-b];
				bPtr++;
				i++;
			}
		}
	}
	
	/**
	 *  Recursive quicksort algorithm  
	 *  @author Prof. A. Hernandez
	 */
	private static void quicksort(int begin, int end, int[] list)
	{
		int temp;
		int pivot = findPivotLocation(begin, end);
		
		// swap list[pivot] and list[end]
		temp = list[pivot];
		list[pivot] = list[end];
		list[end] = temp;
		
		pivot = end;
		
		int i = begin,
			j = end - 1;
		
		boolean iterationCompleted = false;
		while (!iterationCompleted)
		{
			while (list[i] < list[pivot])
				i++;
			while ((j >= 0) && (list[pivot] < list[j]))
				j--;
			
			if (i < j)
			{
				//swap list[i] and list[j]
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				
				i++;
				j--;
			} else
				iterationCompleted = true;
		}
		
		//swap list[i] and list[pivot]
		temp = list[i];
		list[i] = list[pivot];
		list[pivot] = temp;
		
		if (begin < i - 1) quicksort(begin, i - 1, list);
		if (i + 1 < end) quicksort(i + 1, end, list);
	}

	/**
	 *  Computes the pivot
	 *  @author Prof. A. Hernandez
	 */
	private static int findPivotLocation(int b, int e)
	{
		return (b + e) / 2;
	}
	
	/**
	 *  Selectionsort algorithm 
	 *  @author https://www.geeksforgeeks.org/selection-sort/
	 */
	private static void selectionsort(int[] list)
	{
		int n = list.length; 
		  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (list[j] < list[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first element 
            int temp = list[min_idx]; 
            list[min_idx] = list[i]; 
            list[i] = temp; 
        } 	
	}
}