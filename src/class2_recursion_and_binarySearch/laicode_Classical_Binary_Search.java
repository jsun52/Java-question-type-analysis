package class2_recursion_And_binarySearch;

/*
*
* Given a target integer T and an integer array A sorted in ascending order,
* find the index i such that A[i] == T or return -1 if there is no such index.
*
* Assumptions
*    There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
* Examples
*    A = {1, 2, 3, 4, 5}, T = 3, return 2
*    A = {1, 2, 3, 4, 5}, T = 6, return -1
*    A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
* Corner Cases
*    What if A is null or A is of zero length? We should return -1 in this case.
*/

public class laicode_Classical_Binary_Search {

 // Keep comparing array[mid] with target, 
 // if array[mid] is less than target, left = mid
 // if array[mid] is greater than target, right = mid
 // until right < left, then return -1

 // Time: O(logn)
 // Space: O(1)
 public int binarySearch(int[] array, int target) {
   // Corner Cases
   if (array == null || array.length == 0) {
     return -1;
   }

   int left = 0, right = array.length - 1;

   while (left <= right) {
     // use left + (right - left) / 2 instead of (left + right) / 2 to avoid overflow
     int mid = left + (right - left) / 2;
     if (array[mid] == target) {
       return mid;
     } else if (array[mid] < target) {
       left = mid + 1;
     } else {
       right = mid - 1;
     }
   }

   return -1;
 }

}