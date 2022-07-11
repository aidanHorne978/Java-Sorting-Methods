package week10;

/** public class HeapSort which.
 *  extends Sorter to implement the Heap.
 *  Sort method.
 *  @author Aidan.
 */

public class HeapSort extends Sorter {

    /** public constructor to make the Integer.
     *  array super.
     *  @param nums which is the numbers to be sorted.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /** public void sortNums() to build the.
     *  heap.
     */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i--){
            comparisons++;
            siftDown(nums.length, i);
        }
        for(int i = n -1; i >= 0; i--){
            comparisons++;
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            update();
            siftDown(i, 0);
        }
    }

    /** public void siftDown() to find the
     *  roots and revursively sift down and
     *  sort.
     *  @param n which is the size of the heap.
     *  @param i which is the root node.
     */
    public void siftDown(int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < n && nums[l] > nums[largest]){
            comparisons+=2;
            largest = l;
            update();
        }
        if(r < n && nums[r] > nums[largest]){
            comparisons+=2;
            largest = r;
            update();
        }
        if(largest != i){
            comparisons++;
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            update();

            siftDown(n, largest);
        }
    }
}
