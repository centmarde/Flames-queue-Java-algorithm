import javax.swing.*;
import java.awt.*;

public class UI {
    public static JLabel getResultUI(String result) {
        switch (result) {
            case "Lovers":
                return getHeartUI();
            case "Marriage":
                return getMarriageUI();
            case "Engagement":
                return getEngagementUI();
            case "Friends":
                return getThumbsUpUI();
            case "Anger":
                return getAngerUI();
            case "Soulmates":
                return getBirdUI();
            default:
                return new JLabel("");
        }
    }
    public static JLabel getEngagementUI() {
        return getImageLabel("assets/engagement.png");
    }

    public static JLabel getHeartUI() {
        return getImageLabel("assets/heart.png");
    }

    public static JLabel getMarriageUI() {
        return getImageLabel("assets/married.png");
    }
    
    public static JLabel getThumbsUpUI() {
        return getImageLabel("assets/thumbs_up.png");
    }
    
    public static JLabel getAngerUI() {
        return getImageLabel("assets/angry_face.png");
    }
    
    public static JLabel getBirdUI() {
        return getImageLabel("assets/soulmates.png");
    }

    private static JLabel getImageLabel(String path) {
      
        ImageIcon imageIcon = new ImageIcon(path);

        Image image = imageIcon.getImage();

        Image scaledImage = image.getScaledInstance(100 , 100, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        return new JLabel(scaledIcon);
    }
}
