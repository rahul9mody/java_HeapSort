//Rahul Mody


import java.util.Random;

public class Sorts 
{
	private static int len;
	
	/**
	 * Sorts a given array of a generic type T in ascending order 
	 * @param array is the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void heapSort(T[] array) 
	{
		// the initial length of the array
		len = array.length - 1;
	    
		//finds the half of the length and orders the array in to an initial sort order
		for (int i = len / 2; i >= 0; i--)
		{
			heapify(array, i); 
		}
		
		//now we will continuously heapify smaller and smaller segments of the array
		for (int i = len; i > 0; i--) 
		{
			//follows the heap sort algorith of swapping the first and the last element 
			swap(array, 0, i);
			//the length to heapify lessens with each recursion
			len--;
	        
			//recursive call to heapify
			heapify(array, 0);
		}
	}

	/**
	 * swaps the values at given indices
	 * @param s is the proxy for sorting array
	 * @param a is the first index
	 * @param b is the last index
	 */
	private static <T extends Comparable<? super T>> void swap(T[] s, int a, int b)
	{
		T temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}
	
	/**
	 * organizes the elements of the array into a heap form essentially sorting it in ascending order.
	 * @param a is the array to be heapified
	 * @param i is the index that will act as the head of the heap.
	 */
	private static <T extends Comparable<? super T>> void heapify(T[] a, int i)
	{
		//element at index l are on the left node of the head 
		int l = i * 2;
		// element at index r are on the right node of the head 
		int r = l + 1;
		// is the head to be compared with
		int curr = i;
		
		if (l <= len && a[l].compareTo(a[curr]) > 0)
		{
			curr = l;
		}
	    
		if (r <= len && a[r].compareTo(a[curr]) > 0)
		{
	        curr = r;	
	    }
		
		// if curr has been changed, the elements are swapped and the rest of the array is heapified
		if (curr != i) 
	    {
			swap(a, i, curr);
			heapify(a, curr);
	    }
	}
	
	/**
	 * main class provided with the in class example
	 * 
	 */
	public static void main(String[] args)
	{
		int num = args.length == 1 ? Integer.parseInt(args[0]) : 10;
		Integer[] a = new Integer[num];
	    Random rand = new Random(1);

	    for (int i = 0; i < a.length; ++i)
	    {
	    	a[i] = rand.nextInt(num);
	    }
	    	
	    //Displaying array causes significant delays when testing with numbers greater than 100,000.
	    //System.out.println(java.util.Arrays.toString(a));
	    	
	    long start = System.currentTimeMillis();
	    Sorts.heapSort(a);
	    	
	    long stop = System.currentTimeMillis();
	    System.out.println("select: " + (stop - start) + " ");
	    	
	    for (int i = 0; i < a.length - 1; ++i) 
	    {
	    	if (a[i] > a[i+1]) 
	    	{
	    		System.out.println("Fail");
	    		System.exit(0);
	    	}
	    }
	    	
	    System.out.println("Pass");
	    	
	    //System.out.println(java.util.Arrays.toString(a));
	}
}

