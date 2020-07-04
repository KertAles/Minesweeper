import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.lang.*;
/**
 * Created by ales on 4.2.16.
 */
public class Mainsweeper extends JFrame{
    private static Buttonsweeper[][] fields;
    public static int fieldsLeft;
    public static int size, difficulty;

    public Mainsweeper(int sizeIn, int difficultyIn){
        super("Mainsweeper v1.2");
        size=sizeIn; difficulty=difficultyIn;

        setCursor(Cursor.WAIT_CURSOR);
        fieldsLeft=0;
        MouseAdapter action = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((Buttonsweeper)e.getSource()).click(e);
            }
        };
        fields = new Buttonsweeper[size][size];
        JPanel minePanel = new JPanel(new GridLayout(size,size));
        //minePanel.setBorder(new EmptyBorder(5,5,5,5));
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                try {
                    fields[i][j] = new Buttonsweeper(i, j, difficulty);
                    if(fields[i][j].status!=10)
                        fieldsLeft++;
                    fields[i][j].addMouseListener(action);
                    minePanel.add(fields[i][j]);
                }
                catch(NullPointerException e){
                }
            }
        add(minePanel);
        minePanel.setVisible(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(size*16, size*16+20);
        setResizable(false);
        setVisible(true);
        initFieldsStatus();
        setCursor(Cursor.getDefaultCursor());
    }

    public void initFieldsStatus(){
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++) {
                if (fields[i][j].status != 10) {
                    fields[i][j].status=0;
                        for (int k = i-1; k < i+2; k++)
                            for (int l = j-1; l < j+2; l++) {
                                try {
                                if (fields[k][l].status == 10)
                                    fields[i][j].status++;
                            } catch (ArrayIndexOutOfBoundsException e) {}
                        }
                }
            }
    }

    public static void recursionCheck(int x, int y){
        for( int i=x-1; i<x+2; i++)
            for( int j=y-1; j<y+2; j++)
                try{
                    if(fields[i][j].status!=10 && fields[i][j].visible==0) {
                        fields[i][j].uncover();
                        if(fields[i][j].status == 0)
                            recursionCheck(i,j);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){}
    }
    public static void recursionCheck(int x, int y, boolean first){
        for( int i=x-1; i<x+2; i++)
            for( int j=y-1; j<y+2; j++)
                try{
                    if(fields[i][j].status==0) {
                        recursionCheck(i,j);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){}
    }
    public static void decreaseFieldsLeft(){
        fieldsLeft--;
    }

    public static void uncoverAll(){
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++){
                if(fields[i][j].status==10) {
                    fields[i][j].status=11;
                    fields[i][j].uncover();
                }
            }
    }
}
