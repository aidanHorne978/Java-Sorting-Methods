package week10;

/** public class QuickSort which.
  * extends Sorter to implement the Quick
  * Sort method.
  * @author Aidan
  */
public class QuickSort extends Sorter {
    
    /** public class QuickSort which.
      *  Sets the super to the array.
      *  nums.
      * @param nums to get the numbers to sort.
      */
    public QuickSort (Integer nums[]) {
        super(nums);
    }
    
    /** public void sortNums() which.
      *  sets the value of comparisons.
      *  to zero and calls quickSort with.
      *  the left value at 0 and the right.
      *  at the length of nums - 1.
      */
    public void sortNums() {
        comparisons = 0;
        quickSort(0, nums.length - 1);
    }
    
    /** public void quickSort() which recursively.
      *  calls itself to join together the partitioned.
      *  values to ensure the whole list is sorted correctly.
      *  @param left for the left of the list.
      *  @param right for the right of the list.
      */
    public void quickSort(int left, int right) {
        comparisons++;
        if (left < right) {
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
        }
    }
    
    /** public int partition() which splits the list.
      *  into 3 parts with the left side, the right side, and.
      *  the pivot which is used as a centre point to sort numbers.
      *  on to either side of pivot.
      *  @param left for the left side to partition.
      *  @param right for the right side to partition.
      *  @return hole as the final value.
      */
    public int partition(int left, int right) {
        int pivot = nums[left];
        int hole = left;
        int i = left + 1;
        int j = right;
        while (true) {
            while (j > hole && nums[j] >= pivot) {
                comparisons += 2;
                j--;
            }
            if (j == hole) {
                comparisons++;
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            update();
            while (i < hole && nums[i] < pivot) {
                comparisons += 2;
                i++;
                
            }
            if (i == hole) {
                comparisons++;
                break;
            }
            nums[hole] = nums[i];
            hole = i;
            update();
        }
        nums[hole] = pivot;
        return hole;
    }
}
