package S191220053.Task_two;

public class BubbleSorter extends BasicSorter{
    @Override
    public void sort(Comparer func){
        if (buffer == null)
            return;
        String temp = "";
        for (int end = buffer.length; end > 0; --end){
            for (int iter = 1; iter < end; ++iter){
                if (!func.cmp(buffer[iter - 1], buffer[iter])){
                    temp += swap(iter - 1, iter);
                }
            }
        }
        this.log = temp;
    }
}
