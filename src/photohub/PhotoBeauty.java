package photohub;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PhotoBeauty
{
	public int[][] getImageGRB(String filePath) {
        File file  = new File(filePath);
        int[][] result = null;
        if (!file.exists()) {
             return result;
        }
        try {
             BufferedImage bufImg = ImageIO.read(file);
             int height = bufImg.getHeight();
             int width = bufImg.getWidth();
             result = new int[width][height];
             for (int i = 0; i < width; i++) {
                  for (int j = 0; j < height; j++) {
                        result[i][j] = bufImg.getRGB(i, j) & 0xFFFFFF;
                        System.out.println(bufImg.getRGB(i, j) & 0xFFFFFF);
                        
                  }
             }
             
        } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
        
        return result;
  }

}
