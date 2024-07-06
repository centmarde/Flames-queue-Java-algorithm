import javax.swing.*;
import java.awt.*;

public class FlamesCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FLAMES Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel("FLAMES Calculator ❤️");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Dialog", Font.BOLD, 28)); //font size

        // Labels and text fields
        JLabel label1 = new JLabel("Enter name1:");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label1.setFont(new Font("Serif", Font.PLAIN, 20)); //font size
        JTextField name1Field = new JTextField(30); //text field size
        name1Field.setMaximumSize(new Dimension(400, name1Field.getPreferredSize().height));
        name1Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        name1Field.setFont(new Font("Serif", Font.PLAIN, 18)); //font size

        JLabel label2 = new JLabel("Enter name2:");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setFont(new Font("Serif", Font.PLAIN, 20)); //font size
        JTextField name2Field = new JTextField(30); //text field size
        name2Field.setMaximumSize(new Dimension(400, name2Field.getPreferredSize().height));
        name2Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        name2Field.setFont(new Font("Serif", Font.PLAIN, 18)); //font size

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.setFont(new Font("Dialog", Font.BOLD, 20)); //font size
        calculateButton.setPreferredSize(new Dimension(150, 50)); //button size

        // Add components to panel
        panel.add(Box.createRigidArea(new Dimension(0, 40))); // top spacing
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); //spacing after title
        panel.add(label1);
        panel.add(name1Field);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); //spacing between fields
        panel.add(label2);
        panel.add(name2Field);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); //spacing before button
        panel.add(calculateButton);
        panel.add(Box.createRigidArea(new Dimension(0, 40))); //bottom spacing

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        // Calculate button action
        calculateButton.addActionListener(e -> {
            String name1 = name1Field.getText().toLowerCase().replaceAll("\\s+", "");
            String name2 = name2Field.getText().toLowerCase().replaceAll("\\s+", "");

            // Calculate FLAMES result
            CountLeftover counter = new CountLeftover();
            int leftoverCount = counter.getCountLeftover(name1, name2);

            FlamesResult calculator = new FlamesResult();
            String result = calculator.getFlamesResult(leftoverCount);

            // Clear and update panel with result text and image
            panel.removeAll();
            panel.add(Box.createRigidArea(new Dimension(0, 40))); //top spacing
            panel.add(title);
            panel.add(Box.createRigidArea(new Dimension(0, 20))); //spacing after title
            panel.add(label1);
            panel.add(name1Field);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); //spacing between fields
            panel.add(label2);
            panel.add(name2Field);
            panel.add(Box.createRigidArea(new Dimension(0, 20))); //spacing before button

            // Create a JLabel for result text with larger font size
            JLabel resultLabel = new JLabel("\n\t   Result: " + result);
            resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultLabel.setFont(new Font("Serif", Font.BOLD, 24)); //font size
            panel.add(resultLabel);

            // Add the result image UI inside the resultLabel panel
            JLabel resultImage = UI.getResultUI(result);
            resultImage.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(resultImage);

            // Refresh the frame
            frame.pack();
            panel.revalidate();
            panel.repaint();
        });
    }
}
