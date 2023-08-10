package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image backgroundImage;

    public Background(String imagePath) {
    	this.setLayout(new GridBagLayout());
        // Load the background image from the given file path
        backgroundImage = new ImageIcon(imagePath).getImage();
        // Set the preferred size to match the background image size
        setPreferredSize(new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int imageWidth = backgroundImage.getWidth(null);
        int imageHeight = backgroundImage.getHeight(null);
        
        double aspectRatio = (double) imageWidth / imageHeight;
        double panelAspectRatio = (double) panelWidth / panelHeight;
        
        int drawWidth, drawHeight;
        if (aspectRatio > panelAspectRatio) {
            // Image is wider, so adjust the height to fit the panel
            drawHeight = panelHeight;
            drawWidth = (int) (panelHeight * aspectRatio);
        } else {
            // Image is taller, so adjust the width to fit the panel
            drawWidth = panelWidth;
            drawHeight = (int) (panelWidth / aspectRatio);
        }
        
        // Calculate the position to center the image
        int x = (panelWidth - drawWidth) / 2;
        int y = (panelHeight - drawHeight) / 2;
        
        // Draw the background image with the calculated size and position
        g.drawImage(backgroundImage, x, y, drawWidth, drawHeight, null);
        
       
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
    }
	
	
}
