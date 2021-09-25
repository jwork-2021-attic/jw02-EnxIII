package S191220053.Task_three;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import S191220053.Task_two.Sorter;
import S191220053.Task_two.Faerie;
import S191220053.Task_two.QuickSorter;
import S191220053.Task_two.Comparer;
import S191220053.Task_two.Snake;
import S191220053.Task_two.BubbleSorter;
import S191220053.Task_two.AnimateEngine;

public class Scene {
    static int taskrow = 8;
    static int taskcol = 8;
    static int tasksize = 64;
    public static void main(String[] args) throws IOException{
        Faerie faerie = new Faerie(Scene.tasksize);
        // Line line = new Line(Scene.tasksize);
        Matrix line = new Matrix(Scene.taskrow, Scene.taskcol);
        line.randomLoadLinable(faerie);

        // Sorter sorter = new BubbleSorter();
        Sorter sorter = new QuickSorter();
        Snake snake = new Snake();

        snake.loadSorter(sorter);
        snake.loadSortable(line);
        snake.sortUp(Comparer.smaller);

        String scheme = snake.getSortScheme();

        AnimateEngine engine = new AnimateEngine();
        engine.loadScheme(scheme);
        engine.loadAnimable(line);
        engine.rendering();

        String frame = engine.getFrames();
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("Task_three_" + sorter.getClass().getName().split("\\.")[2] + ".txt"));
        writer.write(frame);
        writer.flush();
        writer.close();
    }

}
