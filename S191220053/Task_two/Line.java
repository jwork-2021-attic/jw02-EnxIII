package S191220053.Task_two;

public class Line implements Sortable, Animable{
    private Linable[] list;

    public Line(int size){
        this.list = new Linable[size];
    }

    public void loadLinable(Faerie faerie){
        if (faerie == null)
            return;
        if (list.length != faerie.size())
            list = new Linable[faerie.size()];
        for (int k = 0, e = faerie.size(); k < e; ++k)
            this.putLinable(k, faerie.getLinable(k));
    }

    public void putLinable(int index, Linable linable){
        this.list[index] = linable;
    }

    @Override
    public int[] toIntArray(){
        int[] array = new int[list.length];
        for (int i = 0; i < list.length; ++i)
            array[i] = list[i].getRank();
        return array;
    }
    
    @Override
    public void swap(int a, int b){
        Linable temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    @Override
    public String getFrame(){
        String line = "\t";
        for (var iter : this.list)
            line += iter.getRGBInfo();
        line += "\n[frame]\n";
        return line;
    }
}
