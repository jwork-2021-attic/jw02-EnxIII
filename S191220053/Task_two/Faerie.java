package S191220053.Task_two;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Faerie {
    private ColorBlock[] list;

    public Faerie(int len) throws IOException{
        this.list = new ColorBlock[len];
        File pngfile = new File("c256.png");
        BufferedImage image = ImageIO.read(pngfile);
        int pixel = 0, prepixel = 0, minx = image.getMinX(), miny = image.getMinY(), index = 0;
        for (int y = miny + 1, ye = image.getHeight(); y < ye; ++y){
            // y orient consecutive
            if (image.getRGB(minx, y) == image.getRGB(minx, y - 1)){
                pixel = image.getRGB(minx, y);
                for (int x = image.getMinX() + 1, xe = image.getWidth(); x < xe; ++x){
                    pixel = image.getRGB(x, y);
                    // x orient consecutive
                    if (pixel == prepixel)
                        this.genColorBlock(index++, pixel);
                    prepixel = pixel;
                }
            }
        }
    }

    public Linable getLinable(int rank){ return this.list[rank];}
    public int size(){ return this.list.length;}

    private void genColorBlock(int index, int rgb){
        if (index < 0 || index > this.list.length)
            return;
        if (this.list[index] == null)
            this.list[index] = new ColorBlock(index, (rgb & 0xFF0000) >> 16, (rgb & 0xFF00) >> 8, rgb & 0xFF);
        else 
            this.list[index].modifyColorBlock(index, (rgb & 0xFF0000) >> 16, (rgb & 0xFF00) >> 8, rgb & 0xFF);
    }

    class ColorBlock implements Linable{
        private int r;
        private int g;
        private int b;
        private int index;

        private ColorBlock(int index, int r, int g, int b){
            this.index = index;
            this.r = r;
            this.g = g;
            this.b = b;
        }

        private void modifyColorBlock(int newindex, int newr, int newg, int newb){
            this.index = newindex;
            this.r = newr;
            this.g = newg;
            this.b = newb;
        }

        @Override
        public int getRank(){return this.index;}
        
        @Override
        public String getRGBInfo(){
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.getRank() + "  \033[0m";
        }
    }
    
    

}
