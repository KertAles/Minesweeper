import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by ales on 4.2.16.
 */

public class Initsweeper extends JFrame {
    JTextField difficultyField, sizeField;
    JLabel sizeLabel, difficultyLabel;
    JButton okeButton;

    public Initsweeper(){
        super("Initsweeper v1.1");
        sizeLabel = new JLabel("Size(0-99): ");
        sizeField = new JTextField(2);
        difficultyLabel = new JLabel("Difficulty(0-99%%): ");
        difficultyField = new JTextField(2);
        okeButton = new JButton("OK");

        okeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(sizeField.getText()) < 100 && Integer.parseInt(difficultyField.getText()) < 100) {
                    Mainsweeper miner = new Mainsweeper(Integer.parseInt(sizeField.getText()),
                            Integer.parseInt(difficultyField.getText()));
                    dispose();
                }
            }
        });

        JLabel bigMT = new JLabel("");
        JPanel panel = new JPanel(new GridLayout(3,2,1,1));
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.add(sizeLabel);
        panel.add(sizeField);
        panel.add(difficultyLabel);
        panel.add(difficultyField);
        panel.add(bigMT);
        panel.add(okeButton);
        add(panel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,110);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args){
        new Initsweeper();
    }
}
