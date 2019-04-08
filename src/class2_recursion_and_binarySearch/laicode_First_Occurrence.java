package class2_recursion_And_binarySearch;

/*
*
* Given a target integer T and an integer array A sorted in ascending order,
* find the index of the first occurrence of T in A or return -1 if there is no such index.
*
* Assumptions
*    There can be duplicate elements in the array.
* Examples
*    A = {1, 2, 3}, T = 2, return 1
*    A = {1, 2, 3}, T = 4, return -1
*    A = {1, 2, 2, 2, 3}, T = 2, return 1
* Corner Cases
*    What if A is null or A of zero length? We should return -1 in this case.
*/

public class laicode_First_Occurrence {

 // keep comparing array[mid] with target
 // if array[mid] > target, right = mid - 1
 // if array[mid] < target, left = mid + 1;
 // if array[mid] == target, right = mid;
 // until left == right
 // return array[left] == target ? left : -1

 // Time: O(logn)
 // Space: O(1)
 public int firstOccur(int[] array, int target) {
   // Corner Cases
   if (array == null || array.length == 0) {
     return -1;
   }

   int left = 0, right = array.length - 1;

   while (left < right) {
     // left + (right - left) / 2 instead of (left + right) / 2 to avoid overflow
     int mid = left + (right - left) / 2;
     if (array[mid] == target) {
       right = mid;
     } else if (array[mid] < target) {
       left = mid + 1;
     } else {
       right = mid - 1;
     }
   }

   return array[left] == target ? left : -1;
   /*while (left < right - 1) {  
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        right = mid;  //we want find the first occurrence of target
      } else if (array[mid] < target) {
        left = mid;  //or left = mid + 1; both are ok
      } else {
        right = mid;  //right = mid - 1; both are ok
      }
    }
    if (array[left] == target) {
      return left;
    }
    if (array[right] == target) {
      return right;
    }
    return -1;*/
 }

}