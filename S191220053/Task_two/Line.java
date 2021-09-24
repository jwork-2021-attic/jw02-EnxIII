package S191220053.Task_two;

import java.util.Random;

public class Line implements Sortable, Animable{
    private Linable[] list;

    public Line(int size){
        this.list = new Linable[size];
    }

    public void randomLoadLinable(Faerie faerie){
        if (faerie == null)
            return;
        for (int k = 0; k < list.length; ++k)
            this.list[k] = faerie.getLinable(k);
        Random random = new Random(System.currentTimeMillis());
        for (int k = 1, r; k < list.length; ++k){
            r = random.nextInt(k);
            swap(k, r);
        }
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
