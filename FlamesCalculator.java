import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;


public class FlamesCalculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("FLAMES Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("FLAMES Calculator ❤️");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label1 = new JLabel("Enter name1:");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField name1Field = new JTextField(20);
        name1Field.setMaximumSize(name1Field.getPreferredSize());
        name1Field.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("Enter name2:");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField name2Field = new JTextField(20);
        name2Field.setMaximumSize(name2Field.getPreferredSize());
        name2Field.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        
        // Set font size and style for JTextArea
        Font font = new Font("Serif", Font.PLAIN, 18); // Change font size (18 here)
        resultArea.setFont(font);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); 
        panel.add(label1);
        panel.add(name1Field); //input 1 nato ni cya
        panel.add(label2);
        panel.add(name2Field); //input 2 nato ni cya
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(calculateButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); 
        panel.add(scrollPane);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        //direa mo pag sugod
        calculateButton.addActionListener(e -> {
            String name1 = name1Field.getText().toLowerCase().replaceAll("\\s+", ""); 
            String name2 = name2Field.getText().toLowerCase().replaceAll("\\s+", "");
           
            CountLeftover counter = new CountLeftover();
            int leftoverCount = counter.getCountLeftover(name1, name2);

            FlamesResult calculator = new FlamesResult(); 
            String result = calculator.getFlamesResult(leftoverCount);

            /* resultArea.setText("\n\t   Leftover letters in total: " + leftoverCount + "\n\t   Result: " + result + " " + UI.getResultUI(result)); */
            resultArea.setText("\n\t   Result: " + result + " " + UI.getResultUI(result));
        });
    }
}
