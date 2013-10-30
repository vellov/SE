package ee.ut.math.tvt.murdjad;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class IntroUI extends JFrame {
	static String teamLeader;
	static String teamLeaderEmail;
	static String teamMembers;
	static String teamName;
	static String version;
	private static final Logger log = Logger.getLogger(IntroUI.class);
	
	
	/**
	 * Retrieves data from the two predefined
	 * properties files (application.properties
	 * & version.properties) and stores it in
	 * class variables.
	 */
	public static void getProp() {
		Properties appProp = new Properties();
		Properties verProp = new Properties();
		
		// Retrieves data from application.properties.
		try {
			appProp.load(new FileInputStream("application.properties"));
			teamLeader = appProp.getProperty("team.leader");
			teamLeaderEmail = appProp.getProperty("team.leader.email");
			teamMembers = appProp.getProperty("team.members");
			teamName = appProp.getProperty("team.name");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Retrieves data from version.properties.
		try {
			verProp.load(new FileInputStream("version.properties"));
			version = verProp.getProperty("build.number");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launches our ugly-ass window
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Updates properties' variables
		getProp();
		
		// Creates frames
		JFrame baseFrame = new JFrame("POS");
		JLabel textLabel = new JLabel("<html>" + teamLeader +
				"<br>" + teamLeaderEmail + "<br>" + teamMembers +
				"<br>" + teamName + "<br>" + version);
		JLabel imgLabel = new JLabel();
		Image image = null;
		try {
			image = ImageIO.read(new File("jli24.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imgLabel.setIcon(new ImageIcon(image));

		// Sets the layout
		baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		baseFrame.getContentPane().add(textLabel, BorderLayout.PAGE_START);
		baseFrame.getContentPane().add(imgLabel, BorderLayout.PAGE_END);
		
		baseFrame.pack();
		baseFrame.setVisible(true);
		log.info("Intro window opened");
	}

}