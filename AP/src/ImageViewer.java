import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class ImageViewer {
	public ImageViewer() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new JFrame("Image Viewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				BufferedImage img = null;
				
				try {
					img = ImageIO.read(getClass().getResource(/biceps-curl-strength-curve.jpg))
				}
			}
		});
	}
}