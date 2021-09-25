package S191220053.Task_two;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Scene {
    static int tasksize = 64;
    public static void main(String[] args) throws IOException{
        Faerie faerie = new Faerie(Scene.tasksize);
        Line line = new Line(Scene.tasksize);
        line.randomLoadLinable(faerie);

        Sorter sorter = new QuickSorter();
        // Sorter sorter = new BubbleSorter();
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
        writer = new BufferedWriter(new FileWriter("Task_two_" + sorter.getClass().getName().split("\\.")[2] + ".txt"));
        writer.write(frame);
        writer.flush();
        writer.close();
    }

}
