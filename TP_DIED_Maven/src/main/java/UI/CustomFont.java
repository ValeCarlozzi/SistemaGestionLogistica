package UI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class CustomFont {

	public static Font loadCustomFont(String font, Float size) {
		
		 try {
		     //create the font to use. Specify the size!
		     Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("CODE Light.otf")).deriveFont(size);
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     //register the font
		     ge.registerFont(customFont);
		     return(customFont);
		 } catch (IOException e) {
		     e.printStackTrace();
		 } catch(FontFormatException e) {
		     e.printStackTrace();
		 }
		 return new Font("Arial",Font.PLAIN,12);
		
	}
	
	
}
