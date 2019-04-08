package class2_recursion_And_binarySearch;
/*
 * /**
 * K Closest In Sorted Array
 * Description
 * Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.
 *
 * Assumptions
 * A is not null
 * K is guranteed to be >= 0 and K is guranteed to be <= A.length
 *
 * Return
 * A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
 *
 * Examples
 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 * A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 *
 * time = O(logn + k)
 * space = O(1)
 */
 
public class laicode_K_Closest_In_Sorted_Array {
	public int[] kClosest(int[] array, int target, int k) {
	    // Write your solution here
	    if (array == null || array.length == 0) {
	      return new int[0];
	    }
	    if (k == 0) {
	      return new int[0];
	    }
	    int[] res = new int[k];
	    int left = helper (array, target);
	    int right = left + 1;
	    for (int i = 0; i < k; i++) {
	      if (left < 0) {
	        res[i] = array[right++];
	      } else if (right > array.length - 1) {
	        res[i] = array[left--];
	      } else if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
	        res[i] = array[left--];
	      } else {
	        res[i] = array[right++];
	      }
	    }
	    return res;
	  }
	  public int helper (int[] array, int target) {
	    if (array == null || array.length == 0) {
	      return -1;
	    }
	    int left = 0;
	    int right = array.length - 1;
	    while (left < right - 1) {
	      int mid = left + (right - left) / 2;
	      if (array[mid] == target) {
	        return mid;
	      } else if (array[mid] < target) {
	        left = mid;
	      } else {
	        right = mid;
	      }
	    }
	    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
	      return left;
	    } else {
	      return right;
	    }
	  }
}
