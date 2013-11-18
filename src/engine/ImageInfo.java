package engine;

import java.util.HashMap;

public class ImageInfo {
	
	private HashMap<String, String> myImagePath;
	
	public ImageInfo() {
		myImagePath = new HashMap<String, String>();
	}
	
	
	public HashMap<String, String> getImagePath() {
		return myImagePath;
	}
	
}