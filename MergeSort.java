package week10;

/** public class MergeSort which.
  * extends Sorter to implement the Merge
  * Sort method.
  * @author Aidan
  */

public class MergeSort extends Sorter {
    
    /** private int[] temp to hold the array of nums. */
    private int[] temp;
    
    /** public constructor MergeSort to.
      *  set an Integer array to the nums.
      *  as the super.
      *  @param nums to get the numbers for sorting.
      */
    public MergeSort (Integer[] nums) {
        super(nums);
    }
    
    /** public void method sortNums() to implement.
      *  the merge sort method and sort the numbers.
      */
    public void sortNums() {
        this.temp = new int[nums.length];
        comparisons = 0;
        mergeSorter(0, nums.length - 1);
    }
    
    /** public void method mergeSorter to call.
      *  the merge method and recursively call.
      *  mergeSorter to ensure the whole list is.
      *  sorted and recombined properly.
      *  @param left for left of list.
      *  @param right for right of list.
      */ 
    public void mergeSorter(int left, int right) {
        if (left < right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            mergeSorter(left, mid);
            mergeSorter(mid + 1, right);
            merge(left, mid, right);
        }
    }
    
    /** public void method merge to sort.
      *  using the mergeSort method .
      *  @param left for left of list.
      *  @param right for right of list.
      *  @param mid for middle of list.
      */
    public void merge(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            this.temp[i] = nums[i];
        }
        int i = left;
        int j = left;
        int k = mid + 1;
        while(i <= mid && k <= right){
            comparisons += 2;
            if(temp[i] <= temp[k]){
                comparisons++;
                nums[j] = temp[i];
                i++;
            } else {
                comparisons++;
                nums[j] = temp[k];
                k++;
            }
            j++;
            update();
        }
        while(i <= mid){
            comparisons++;
            nums[j] = temp[i];
            j++;
            i++;
            update();
        }
    }
}
