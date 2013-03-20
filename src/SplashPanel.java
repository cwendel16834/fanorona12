package twelve.team;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashPanel extends JFrame
{
	
	private BufferedImage img;
	private JLabel label;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6174475639324933305L;
	
	public SplashPanel()
	{
		try {
			setUndecorated(true);
			img = ImageIO.read(new File("imgs/SplashScreen.jpg"));
			label = new JLabel();
			label.setIcon(new ImageIcon(img));
			this.add(label);
			this.pack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}