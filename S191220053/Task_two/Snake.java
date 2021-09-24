package S191220053.Task_two;

public class Snake {
    private String log;
    private Sorter sorter;
    private Sortable sortable;

    public void loadSorter(Sorter sorter){
        this.sorter = sorter;
    }

    public void loadSortable(Sortable sortable){
        this.sortable = sortable;
    }

    public void sortUp(Comparer comparer){
        if (sorter == null || sortable == null){
            this.log = "";
            return;
        }
        sorter.load(this.sortable.toIntArray());
        sorter.sort(comparer);
        String scheme = sorter.getSortScheme();
        this.log = scheme;
    }

    public String getSortScheme(){
        return this.log;
    }
}
