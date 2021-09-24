package S191220053.Task_two;

public class BubbleSorter implements Sorter{
    private int[] buffer;
    private String log;

    private String swap(int a, int b){
        int temp = buffer[a];
        buffer[a] = buffer[b];
        buffer[b] = temp;
        return (a + " <-> " + b + '\n');
    }

    @Override
    public void load(int[] array){
        //if (buffer == null || buffer.length < array.length)
        //    this.buffer = new int[array.length];
        buffer = array.clone();
    }

    @Override
    public void sort(Comparer func){
        if (buffer == null)
            return;
        String temp = "";
        for (int iter = 0; iter < buffer.length; ++iter){
            if (!func.cmp(buffer[iter], buffer[iter + 1])){
                temp += swap(iter, iter + 1);
            }
        }
        this.log = temp;
    }

    @Override
    public String getSortScheme(){
        return this.log;
    }
}