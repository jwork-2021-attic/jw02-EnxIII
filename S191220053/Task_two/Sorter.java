package S191220053.Task_two;

public interface Sorter{
    public void load(int[] array);
    public void sort(Comparer func);
    public String getSortScheme();
}

