package week10;

/** public class InsertionSort which.
  * extends Sorter to implement the Insertion
  * Sort method.
  * @author Aidan
  */
public class InsertionSort extends Sorter {
    
    /** public constructor InsertionSort to.
      * set an Integer array nums as the.
      * super.
      * @param nums to get the numbers to sort.
      */
    public InsertionSort (Integer[] nums) {
        super(nums);
    }
    
    /** public void method sortNums() to execute.
      * the Insertion Sort and sort the numbers.
      */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;
        for (int i = 1; i < n; ++i){
            int key = nums[i];
            int x = i-1;
            while (x >= 0 && nums[x] > key){
                comparisons++;
                nums[x+1] = nums[x];
                x--;
                update();
            }
            nums[x+1] = key;
        }
    }
}
