package S191220053.Task_two;

public class QuickSorter extends BasicSorter{
    @Override
    public void sort(Comparer func){
        if (buffer == null)
            return;
        this.log = "";
        this.quicksort(0, this.buffer.length, func);
    }

    private void quicksort(int left, int right, Comparer func){
        if (right - left <= 1)
            return;
        int pivot = left, lboudary = left;
        for (int k = left + 1; k < right; ++k){
            if (!func.cmp(this.buffer[pivot], this.buffer[k])){
                if (++lboudary != k)
                    this.log += swap(lboudary, k);
            }
        }
        if (pivot != lboudary)
            this.log += swap(pivot, lboudary);
        quicksort(left, lboudary, func);
        quicksort(lboudary + 1, right, func);
    }
}