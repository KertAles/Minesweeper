import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/**
 * Created by ales on 5.2.16.
 */
public class Buttonsweeper extends JButton {
    public int x,y;
    public byte visible; // 0 - nein, 1 - ja, 2 - fleg
    public byte status;

    public Buttonsweeper(int i, int j, int difficulty){
        Random random = new Random();
        x=i; y=j;
        status=-1; //0-9 - x mines around, 10 - mine
        if(random.nextInt(100)<difficulty) {
            status=10;
        }
        visible=0;
    }

    public void click(MouseEvent e){
        if(e.getButton()==1){
            if(visible==2)
                return;
            uncover();
            Mainsweeper.recursionCheck(x,y, true);
            if(Mainsweeper.fieldsLeft==0)
                new Winsweeper();
        }
        else if(e.getButton()==3){
            if(visible==0) {
                setIcon(new ImageIcon(getClass().getResource("resources/fleg.png")));
                visible=2;
            }
            else if (visible==2){
                setIcon(null);
                visible=0;
            }
        }
    }

    public void uncover(){
        Icon icon;
        switch (status){
            case 0: icon = new ImageIcon(getClass().getResource("resources/0.png")); break;
            case 1: icon = new ImageIcon(getClass().getResource("resources/1.png")); break;
            case 2: icon = new ImageIcon(getClass().getResource("resources/2.png")); break;
            case 3: icon = new ImageIcon(getClass().getResource("resources/3.png")); break;
            case 4: icon = new ImageIcon(getClass().getResource("resources/4.png")); break;
            case 5: icon = new ImageIcon(getClass().getResource("resources/5.png")); break;
            case 6: icon = new ImageIcon(getClass().getResource("resources/6.png")); break;
            case 7: icon = new ImageIcon(getClass().getResource("resources/7.png")); break;
            case 8: icon = new ImageIcon(getClass().getResource("resources/8.png")); break;
            case 10: icon = new ImageIcon(getClass().getResource("resources/mine_red.png")); new Lose(); break;
            case 11: icon = new ImageIcon(getClass().getResource("resources/mine.png")); break;
            default: return;
        }
        visible=1;
        setDisabledIcon(icon);
        setIcon(icon);
        setEnabled(false);

        Mainsweeper.decreaseFieldsLeft();
    }
}
