package S191220053.Task_two;

public abstract class BasicSorter implements Sorter{
    protected int[] buffer;
    protected String log;

    protected String swap(int a, int b){
        int temp = buffer[a];
        buffer[a] = buffer[b];
        buffer[b] = temp;
        return (a + "<->" + b + '\n');
    }

    @Override
    public void load(int[] array){
        buffer = array.clone();
    }

    @Override
    public String getSortScheme(){
        return this.log;
    }
}


