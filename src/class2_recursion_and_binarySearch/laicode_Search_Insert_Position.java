package class2_recursion_And_binarySearch;
/*
 * Given a sorted array and a target value, return the index where it would be if it were inserted in order. 

Assumptions
If there are multiple elements with value same as target, we should insert the target before the first existing element.

Examples

[1,3,5,6], 5 ¡ú 2

[1,3,5,6], 2 ¡ú 1

[1,3,5,6], 7 ¡ú 4

[1,3,3,3,5,6], 3 ¡ú 1

[1,3,5,6], 0 ¡ú 0
 */
public class laicode_Search_Insert_Position {
	public int searchInsert(int[] input, int target) {
	    // Write your solution here
	    if (input == null || input.length == 0) {
	      return 0;
	    }
	    int left = 0;
	    int right = input.length - 1;
	    while (left < right - 1) {
	      int mid = left + (right - left) / 2;
	      if (input[mid] == target) {
	        right = mid;
	      } else if (input[mid] < target) {
	        left = mid;
	      } else {
	        right = mid;
	      }
	    }
	    if (input[left] >= target) {
	      return left;
	    }else if (input[right] >= target) {
	      return right;
	    } else {
	      return right + 1;
	    }
	  }
}
