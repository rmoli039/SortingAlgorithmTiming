//PID: 6140544

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		new Main();
	}

	public Main()
	{
		String outputFilename = "output.csv";	//csv file
	
		PrintWriter output = null;
	
		try        
		{            
			output = new PrintWriter(new FileWriter(outputFilename));
		} 
		catch (IOException ex)     
		{            
			System.exit(1);
		}
		
		int [] a, b, c, d, e;	//five list variables, one for each algorithm
		for (int i = 100; i <= 100000; i += 100) 	//runs 1000 times, with n starting at 100 and incrementing by +100
		{
			a = new int[i];		//constructs list 'a' with size n
			long bubbleTime, insertionTime, selectionTime, quickTime, mergeTime;
			long startTime;
			
			SortingAlgorithms.fillArray(a);		//fills list 'a' with random numbers
			b = Arrays.copyOf(a, a.length);		//copies list 'a' into list 'b'
			c = Arrays.copyOf(a, a.length);		//copies list 'a' into list 'c'
			d = Arrays.copyOf(a, a.length);		//copies list 'a' into list 'd'
			e = Arrays.copyOf(a, a.length);		//copies list 'a' into list 'e'
			
			startTime = System.nanoTime();
			SortingAlgorithms.bubbleSort(a);				//runs bubbleSort on list 'a'
			bubbleTime = System.nanoTime() - startTime;		//times bubbleSort
			
			startTime = System.nanoTime();
			SortingAlgorithms.insertionSort(b);				//runs insertionSort on list 'b'
			insertionTime = System.nanoTime() - startTime;	//times insertionSort
			
			startTime = System.nanoTime();
			SortingAlgorithms.selectionSort(c);				//runs selectionSort on list 'c'
			selectionTime = System.nanoTime() - startTime;	//times selectionSort
			
			startTime = System.nanoTime();
			SortingAlgorithms.quickSort(d);					//runs quickSort on list 'd'
			quickTime = System.nanoTime() - startTime;		//times quickSort
			
			startTime = System.nanoTime();
			SortingAlgorithms.mergeSort(e);					//runs mergeSort on list 'e'
			mergeTime = System.nanoTime() - startTime;		//times mergeSort
			
			output.println(i + "," + bubbleTime + "," + insertionTime + "," + selectionTime + "," + quickTime + "," + mergeTime);		//prints n and the algorithm runtimes to output.csv
		}
		
		output.close();		//closes the printWriter
	}
}