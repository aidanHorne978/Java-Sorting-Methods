package week10;

/** public class SelectionSort which extends.
  * Sorter class to sort with selection type.
  * @author Aidan.
  */
public class SelectionSort extends Sorter {
    /** public constructor SelectionSort.
      * which initilizes and sets nums as.
      * the super.
      * @param nums which is an Interger.
      */
    public SelectionSort (Integer[] nums) {
        super(nums);
    }
    /** public void sortNums() which.
      * exectues the selection sort algorithm.
      */
    public void sortNums() {
        comparisons = 0;
        int l = nums.length;
        
        for (int i = 0; i < l-1; i++) {
            int index = i;
            for (int j = i+1; j < l; j++) {
                comparisons++;
                if (nums[j] < nums[index]) {
                    index = j;
                }
                update();
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
