package PhotoFilter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.ShortLookupTable;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * ������ͼ����д���
 * ���Խ��еĴ����������ɫת�ڰ�
 * 					Ȧ����Ե
 * 					���ˮӡ����
 * 					�������ȣ�����  �䰵
 * ��Щ���������ͼ�񱣴���ԭ����·����
 * @author mzs
 *created on  on 2014-6-4
 */

public class PicUtil {


	/**
	 * ͼ��䰵
	 * @param imgPath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static BufferedImage getGrayPicture(String imgPath, String outputImgPath) throws FileNotFoundException, IOException {
		BufferedImage originalPic=ImageIO.read(new FileInputStream(imgPath));
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();

		BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_BYTE_GRAY);

		ColorConvertOp cco = new ColorConvertOp(ColorSpace
				.getInstance(ColorSpace.CS_GRAY), null);
		cco.filter(originalPic, newPic);
		FileOutputStream output = new FileOutputStream(outputImgPath);
		JPEGImageEncoder jpg = JPEGCodec.createJPEGEncoder(output);
		jpg.encode(newPic);
		ImageIO.write(newPic, "bmp", output);
		output.close();
		
		FileOutputStream fos = new FileOutputStream(outputImgPath);  
		ImageIO.write(newPic, "jpg", fos);  
		
		return newPic;
	}
	
	/**
	 * ͼ����
	 * @param imgPath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static BufferedImage getDlurPicture(String imgPath, String outputImgPath) throws FileNotFoundException, IOException {
		BufferedImage originalPic=ImageIO.read(new FileInputStream(imgPath));
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();

		BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_3BYTE_BGR);

		float[] data = { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.125f, 0.125f,
				0.0625f, 0.125f, 0.0625f };

		Kernel kernel = new Kernel(3, 3, data);
		
		ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		co.filter(originalPic, newPic);
		FileOutputStream output = new FileOutputStream(imgPath);
		JPEGImageEncoder jpg = JPEGCodec.createJPEGEncoder(output);
		jpg.encode(newPic);
		ImageIO.write(newPic, "bmp", output);
		output.close();
		
		FileOutputStream fos = new FileOutputStream(outputImgPath);  
		ImageIO.write(newPic, "jpg", fos);  
		
		return newPic;
	}
/**
 * ͼ����
 * @param imgPath
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static BufferedImage getSharperPicture(String imgPath, String outputImgPath) throws FileNotFoundException, IOException {
		BufferedImage originalPic=ImageIO.read(new FileInputStream(imgPath));
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();

		BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_3BYTE_BGR);
		float[] data = { -1.0f, -1.0f, -1.0f, -1.0f, 10.0f, -1.0f, -1.0f,
				-1.0f, -1.0f };

		Kernel kernel = new Kernel(3, 3, data);
		ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		co.filter(originalPic, newPic);
		FileOutputStream output = new FileOutputStream(outputImgPath);
		JPEGImageEncoder jpg = JPEGCodec.createJPEGEncoder(output);
		jpg.encode(newPic);
		ImageIO.write(newPic, "bmp", output);
		output.close();
		
		FileOutputStream fos = new FileOutputStream(outputImgPath);  
		ImageIO.write(newPic, "jpg", fos);  
		
		return newPic;
	}
   /**
    * Ȧ����Ե
    * ��������
    * @param imgPath
    * @return
    * @throws FileNotFoundException
    * @throws IOException
    */
	public static BufferedImage getPicEdge(String imgPath, String outputImgPath) throws FileNotFoundException, IOException {
		BufferedImage originalPic=ImageIO.read(new FileInputStream(imgPath));
		int imageWidth = originalPic.getWidth();
		int imageHeight = originalPic.getHeight();

		BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_3BYTE_BGR);

		float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.0f, -1.0f, 0.0f,
				-1.0f, 0.0f };

		// AffineTransform at = new AffineTransform();
		Kernel kernel = new Kernel(3, 3, elements);
		ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		cop.filter(originalPic, newPic);
		FileOutputStream output = new FileOutputStream(outputImgPath);
		JPEGImageEncoder jpg = JPEGCodec.createJPEGEncoder(output);
		jpg.encode(newPic);
		ImageIO.write(newPic, "bmp", output);
		output.close();
		
		FileOutputStream fos = new FileOutputStream(outputImgPath);  
		ImageIO.write(newPic, "jpg", fos);  
		
		return newPic;
	}
	/**
	 * ��ɫͼ��ת�ڰ�
	 * @param srcImageFile
	 */
	public static void gray(String imgPath, String outputImgPath) {
        try {
            BufferedImage src = ImageIO.read(new File(imgPath));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, "JPEG", new File(outputImgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	 /**
     * ����text�ĳ��ȣ�һ�������������ַ���
     * @param text
     * @return
     */
    public static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }

	// ImageUtils.pressText("����ˮӡ����","e:/abc.jpg","e:/abc_pressText.jpg","����",Font.BOLD,Color.white,80, 0, 0, 0.5f);
	public static void pressText(String pressText,
            String imgPath, String outputImgPath) {
		 String fontName="����";
		 int fontStyle=Font.BOLD;
		 Color color=Color.white;
		 int fontSize=30;
		 int x=0;
		 int y=0;
		 float alpha=0.5f;
        try {
            File img = new File(imgPath);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // ��ָ���������ˮӡ����
            g.drawString(pressText, (width - (getLength(pressText) * fontSize))
                    / 2 + x, (height - fontSize) / 2 + y);
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG", new File(outputImgPath));// ������ļ���
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
