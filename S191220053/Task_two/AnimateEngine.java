package S191220053.Task_two;

public class AnimateEngine {
    private String frames;
    private String scheme;
    private Animable sketch;

    public void loadAnimable(Animable sketch){
        this.sketch = sketch;
    }

    public void loadScheme(String scheme){
        this.scheme = scheme;
    }

    public void rendering(){
        if (this.scheme == null || this.sketch == null)
            return;
        String log = "";
        String[] couple;
        String [] pairs = this.scheme.split("\n");
        for (var iter : pairs){
            couple = iter.split("<->");
            this.sketch.swap(Integer.parseInt(couple[0]), Integer.parseInt(couple[1]));
            log += this.sketch.getFrame();
        }
        this.frames = log;
    }

    public String getFrames(){
        return this.frames;
    }
}
