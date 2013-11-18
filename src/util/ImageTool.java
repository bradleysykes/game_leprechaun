package util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Dylan Jackson and Bernard Park
 * Class that provides methods for resizing images to specified dimensions. Can either loop through a folder and resize all images,
 * or allow individual resizing of files.
 */
public class ImageTool {
	
	//look up BufferedImage, Graphics2D, ImageIO
	
	public static void scaleImage(String originalImagePath, int desiredWidth, int desiredHeight) {
		File originalImageFile = new File(originalImagePath);
		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(originalImageFile);
		} catch (IOException e) {}
		int type = originalImage.getType();
		BufferedImage scaledImage = new BufferedImage(desiredWidth, desiredHeight, type);
		Graphics2D graphics = scaledImage.createGraphics();
		graphics.drawImage(originalImage, 0, 0, desiredWidth, desiredHeight, null);
		graphics.dispose();
		try {
		ImageIO.write(scaledImage, filePathExtension(originalImagePath), new File("C:\\"));
		} catch (IOException e) {}
	}
	
	public static void scaleAllImages(String folderPath, int desiredWidth, int desiredHeight) {
		
	}
	
	private static String filePathExtension(String filePath) {
		return filePath.substring(filePath.lastIndexOf('.'));
	}
	
}
