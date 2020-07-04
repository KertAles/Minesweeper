import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ales on 10.2.16.
 */
public class Lose extends JFrame{
    JButton quitButton;
    JLabel loseLabel;
    public Lose(){
        super("Ya lost... ya bastard.");
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,1,10,10));
        loseLabel= new JLabel("You suck.");
        quitButton = new JButton("Fuck off!");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(loseLabel);
        panel.add(quitButton);
        add(panel);

        Mainsweeper.uncoverAll();

        setLocationRelativeTo(null);
        setSize(300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
