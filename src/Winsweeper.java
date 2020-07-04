import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ales on 10.2.16.
 */
public class Winsweeper extends JFrame{
    JButton quitButton;
    JLabel loseLabel;
    public Winsweeper(){
        super("Ya won... ya bastard.");
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,1,10,10));
        loseLabel= new JLabel("You cheeky bastard.");
        quitButton = new JButton("G'bye!");
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        setResizable(false);
        setVisible(true);
    }
}