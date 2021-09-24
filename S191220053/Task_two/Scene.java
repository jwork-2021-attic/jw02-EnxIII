package S191220053.Task_two;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Scene {
    public static void main(String[] args) throws IOException{
        Faerie faerie = new Faerie(256);
        Line line = new Line(256);
        line.loadLinable(faerie);

        Sorter sorter = new BubbleSorter();
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
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(frame);
        writer.flush();
        writer.close();
    }

}
