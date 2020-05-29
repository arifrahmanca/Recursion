import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] fibArray(int n) {
		if(n == 2) {
			int[] seq = {1, 1};
			return seq;
		}
		else {
			int[] seq = new int[n];
			seq[0] = 1;
			seq[1] = 1;
			fibArrayHelper(2, seq);
			return seq;
		}
	}
	
	private void fibArrayHelper(int i, int[] seq) {
		if(i < seq.length) {
			seq[i] = seq[i - 1] + seq[i - 2];
			fibArrayHelper(i + 1, seq);
		}
	}
	
	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> fibList(int n) {
		if(n == 2) {
			ArrayList<Integer> seq = new ArrayList<>();
			seq.add(1);
			seq.add(1);
			return seq;
		}
		else {
			ArrayList<Integer> seq = new ArrayList<>();
			seq.add(1);
			seq.add(1);
			fibListHelper(2, seq, n);
			return seq;
		}
	}
	
	private void fibListHelper(int i, List<Integer> seq, int size) {
		if(i < size) {
			seq.add(seq.get(i - 1) + seq.get(i - 2));
			fibListHelper(i + 1, seq, size);
		}
	}
	
	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibArray({1, 2}) returns false and isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibArray(int[] a) {
		if(a.length == 0) {
			return false;
		}
		else if(a.length == 1) {
			return a[0] == 1;
		}
		else if(a.length == 2) {
			return a[0] == 1 && a[1] == 1;
		}
		else {
			return 
				a[0] == 1 
				&&
				a[1] == 1
				&&
				isFibArrayHelper(2, a);
		}
	}
	
	private boolean isFibArrayHelper(int i, int[] a) {
		boolean result = a[i] == a[i - 1] + a[i - 2];
		if(i == a.length - 1) {
			return result;
		}
		else {
			return result && isFibArrayHelper(i + 1, a);
		}
	}
	
	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibList({1, 2}) returns false and isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibList(List<Integer> list) {
		if(list.size() == 0) {
			return false;
		}
		else if(list.size() == 1) {
			return list.get(0).intValue() == 1;
		}
		else if(list.size() == 2) {
			return 
				list.get(0).intValue() == 1 
				&&
				list.get(1).intValue() == 1;
		}
		else {
			return 
				list.get(0).intValue() == 1 
				&&
				list.get(1).intValue() == 1
				&&
				isFibListHelper(2, list);
		}
	}
	
	private boolean isFibListHelper(int i, List<Integer> list) {
		boolean result = 
			list.get(i).intValue() == 
				list.get(i - 1).intValue() + list.get(i - 2).intValue();
		if(i == list.size() - 1) {
			return result;
		}
		else {
			return result && isFibListHelper(i + 1, list);
		}
	}
	
	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of array a and integer i.
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		int[] newSortedArray = new int[a.length + 1];
		if(a.length == 0) {
			newSortedArray[0] = i;
		}
		else {
			insertIntoSortedArrayHelper(a, i, newSortedArray, 0, false);
		}
		return newSortedArray;
	}
	
	private void insertIntoSortedArrayHelper(int[] a, int i, int[] na, int current, boolean inserted) {
		if(current == a.length - 1) {
			if(inserted) {
				na[current + 1] = a[current];
			}
			else {
				if(a[current] <= i) {
					na[current] = a[current];
					na[current + 1] = i;
				}
				else {
					na[current] = i;
					na[current + 1] = a[current];
				}
			}
		}
		else {
			if(inserted) {
				na[current + 1] = a[current];
				insertIntoSortedArrayHelper(a, i, na, current + 1, inserted);
			}
			else {
				if(a[current] <= i) {
					na[current] = a[current];
					insertIntoSortedArrayHelper(a, i, na, current + 1, inserted);
				}
				else {
					na[current] = i;
					insertIntoSortedArrayHelper(a, i, na, current, true);
				}
			}
		}
	}
	
	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * @param list a list that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of the input list and integer i.
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		ArrayList<Integer> newSortedList= new ArrayList<>();
		if(list.size()== 0) {
			newSortedList.add(i);
		}
		else {
			insertIntoSortedListHelper(list, i, newSortedList, 0, false);
		}
		return newSortedList;
	}
	
	private void insertIntoSortedListHelper(List<Integer> list, int i, List<Integer> nl, int current, boolean inserted) {
		if(current == list.size() - 1) {
			if(inserted) {
				nl.add(list.get(current));
			}
			else {
				if(list.get(current) <= i) {
					nl.add(list.get(current));
					nl.add(i);
				}
				else {
					nl.add(i);
					nl.add(list.get(current));
				}
			}
		}
		else {
			if(inserted) {
				nl.add(list.get(current));
				insertIntoSortedListHelper(list, i, nl, current + 1, inserted);
			}
			else {
				if(list.get(current) <= i) {
					nl.add(list.get(current));
					insertIntoSortedListHelper(list, i, nl, current + 1, inserted);
				}
				else {
					nl.add(i);
					insertIntoSortedListHelper(list, i, nl, current, true);
				}
			}
		}
	}
	
	/**
	 * Given two sorted arrays left and right, 
	 * return a sorted array of size left.length + right.length, 
	 * consisting of all elements of arrays left and right.
	 * @param left a sorted array
	 * @param right a sorted array 
	 * @return a sorted array of size left.length + right.length, consisting of all elements of arrays left and right.
	 * e.g., mergeSortedArrays({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedLists method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		int[] merge = new int[left.length + right.length];
		mergeSortedArraysHelper(left, right, 0, 0, merge, 0);
		return merge;
	}
	
	private void mergeSortedArraysHelper(int[] left, int[] right, int L, int R, int[] merge, int current) {
		if(L < left.length || R < right.length) {
			if(L < left.length && R < right.length) {
				if(left[L] <= right[R]) {
					merge[current] = left[L];
					mergeSortedArraysHelper(left, right, L + 1, R, merge, current + 1);
				}
				else {
					merge[current] = right[R];
					mergeSortedArraysHelper(left, right, L, R + 1, merge, current + 1);
				}
			}
			else { /* L >= left.length || R >= right.length */
				if(L >= left.length) {
					merge[current] = right[R];
					mergeSortedArraysHelper(left, right, L, R + 1, merge, current + 1);
				}
				else { /* R >= right.length */
					merge[current] = left[L];
					mergeSortedArraysHelper(left, right, L + 1, R, merge, current + 1);
				}
			}
		}
		else {
			/* L >= left.length && R >= right.length
			 * --> DONE!  
			 */
		}
	}
	
	/**
	 * Given two sorted lists left and right, 
	 * return a sorted list of size left.size() + right.size(), 
	 * consisting of all elements of lists left and right.
	 * @param left a sorted list
	 * @param right a sorted list 
	 * @return a sorted list of size left.size() + right.size(), consisting of all elements of lists left and right.
	 * e.g., mergeSortedLists({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedArrays method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> merge = new ArrayList<>();
		mergeSortedListsHelper(left, right, 0, 0, merge, 0);
		return merge;
	}
	
	private void mergeSortedListsHelper(List<Integer> left, List<Integer> right, int L, int R, List<Integer> merge, int current) {
		if(L < left.size() || R < right.size()) {
			if(L < left.size() && R < right.size()) {
				if(left.get(L) <= right.get(R)) {
					merge.add(left.get(L));
					mergeSortedListsHelper(left, right, L + 1, R, merge, current + 1);
				}
				else {
					merge.add(right.get(R));
					mergeSortedListsHelper(left, right, L, R + 1, merge, current + 1);
				}
			}
			else { /* L >= left.length || R >= right.length */
				if(L >= left.size()) {
					merge.add(right.get(R));
					mergeSortedListsHelper(left, right, L, R + 1, merge, current + 1);
				}
				else { /* R >= right.length */
					merge.add(left.get(L));
					mergeSortedListsHelper(left, right, L + 1, R, merge, current + 1);
				}
			}
		}
		else {
			/* L >= left.size() && R >= right.size()
			 * --> DONE!  
			 */
		}
	}
}