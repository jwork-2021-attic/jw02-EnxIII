package S191220053.Task_three;

import S191220053.Task_two.Sortable;
import S191220053.Task_two.Animable;
import S191220053.Task_two.Line;
import S191220053.Task_two.Linable;
import S191220053.Task_two.Faerie;

public class Matrix implements Sortable, Animable{
    private int row;
    private int col;
    private Line[] lines;

    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        lines = new Line[row];
        for (int r = 0; r < row; ++r)
            lines[r] = new Line(col);
    }

    public void randomLoadLinable(Faerie faerie){
        if (faerie == null)
            return;
        Line temp = new Line(this.row * this.col);
        temp.randomLoadLinable(faerie);
        for (int r = 0, iter = 0; r < lines.length; ++r){
            for (int c = 0; c < lines[r].length(); ++c){
                lines[r].putLinable(c, temp.getLinable(iter++));
            }
        }
    }

    @Override
    public int[] toIntArray(){
        int[] array = new int[this.row * this.col];
        for (int r = 0, iter = 0; r < lines.length; ++r){
            for (int c = 0; c < lines[r].length(); ++c){
                array[iter++] = lines[r].getLinable(c).getRank();
            }
        }
        return array;
    }
    
    @Override
    public void swap(int a, int b){
        int rowA = a / this.col, colA = a % this.col;
        int rowB = b / this.col, colB = b % this.col;
        Linable temp = lines[rowA].getLinable(colA);
        lines[rowA].putLinable(colA, lines[rowB].getLinable(colB));
        lines[rowB].putLinable(colB, temp);
    }

    @Override
    public String getFrame(){
        String log = "";
        for (int r = 0; r < lines.length; ++r){
            for (int c = 0; c < lines[r].length(); ++c){
                log += lines[r].getLinable(c).getRGBInfo();
            }
            log += "\n";
        }
        log += "[frame]\n";
        return log;
    }
}
