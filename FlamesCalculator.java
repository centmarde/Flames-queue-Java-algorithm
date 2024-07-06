import javax.swing.*;
import java.awt.*;

public class FlamesCalculator {
    private static final String INITIAL_TITLE = "FLAMES Calculator ❤️";
    private static final String CALCULATING_TITLE = "Calculating...";

    public static void main(String[] args) {
        JFrame frame = new JFrame("FLAMES Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title
        JLabel title = new JLabel(INITIAL_TITLE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Dialog", Font.BOLD, 28));

        // Labels and text fields
        JLabel label1 = new JLabel("Enter name1:");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label1.setFont(new Font("Serif", Font.PLAIN, 20));
        JTextField name1Field = new JTextField(30);
        name1Field.setMaximumSize(new Dimension(400, name1Field.getPreferredSize().height));
        name1Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        name1Field.setFont(new Font("Serif", Font.PLAIN, 18));

        JLabel label2 = new JLabel("Enter name2:");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setFont(new Font("Serif", Font.PLAIN, 20));
        JTextField name2Field = new JTextField(30);
        name2Field.setMaximumSize(new Dimension(400, name2Field.getPreferredSize().height));
        name2Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        name2Field.setFont(new Font("Serif", Font.PLAIN, 18));

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.setFont(new Font("Dialog", Font.BOLD, 20));
        calculateButton.setPreferredSize(new Dimension(150, 50));

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));
        resetButton.setPreferredSize(new Dimension(150, 50));

        // Action listener for calculate button
        calculateButton.addActionListener(e -> {
            String name1 = name1Field.getText().toLowerCase().replaceAll("\\s+", "");
            String name2 = name2Field.getText().toLowerCase().replaceAll("\\s+", "");

            // Calculate FLAMES result
            CountLeftover counter = new CountLeftover();
            int leftoverCount = counter.getCountLeftover(name1, name2);

            FlamesResult calculator = new FlamesResult();
            String result = calculator.getFlamesResult(leftoverCount);

            // Update title during calculation
            updateTitle(title, CALCULATING_TITLE);

            // Create result components
            JLabel resultLabel = new JLabel("\n\t   Result: " + result);
            resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultLabel.setFont(new Font("Serif", Font.BOLD, 24));

            JLabel resultImage = UI.getResultUI(result);
            resultImage.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Clear panel and add result components
            clearPanel(panel);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));
            panel.add(title);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(label1);
            panel.add(name1Field);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(label2);
            panel.add(name2Field);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(resultLabel);
            panel.add(resultImage);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(resetButton);

            // Refresh frame
            frame.pack();
            panel.revalidate();
            panel.repaint();
        });

        // Action listener for reset button
        resetButton.addActionListener(e -> {
            // Reset fields and panel
            name1Field.setText("");
            name2Field.setText("");

            // Reset title
            updateTitle(title, INITIAL_TITLE);

            clearPanel(panel);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));
            panel.add(title);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(label1);
            panel.add(name1Field);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(label2);
            panel.add(name2Field);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(calculateButton);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));

            // Refresh frame
            frame.pack();
            panel.revalidate();
            panel.repaint();
        });

        // Adding components to the panel initially
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label1);
        panel.add(name1Field);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(label2);
        panel.add(name2Field);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(calculateButton);
        panel.add(Box.createRigidArea(new Dimension(0, 40)));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // Method to clear panel contents
    private static void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    // Method to update the title of the frame
    private static void updateTitle(JLabel titleLabel, String newTitle) {
        titleLabel.setText(newTitle);
        titleLabel.revalidate();
        titleLabel.repaint();
    }
}
