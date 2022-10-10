import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFrame extends JFrame implements ActionListener {
    private int screenWidth;
    private int screenHeight;
    private int moveCounter = 0;
    private boolean playerXToPlay;
    private boolean gameEnds = false;
    private JPanel gameBoardPanel;
    private JButton button21;
    private JButton button11;
    private JButton button31;
    private JButton button12;
    private JButton button22;
    private JButton button32;
    private JButton button13;
    private JButton button23;
    private JButton button33;
    private JLabel gameInformationLabelUpper;
    private JLabel gameInformationLabelLower;
    private JButton[][] boardArray = {
            {button11,button12,button13},
            {button21,button22,button23},
            {button31,button32,button33}
    };
    private final JButton[] topRow = {button11,button12,button13};
    private final JButton[] middleRow = {button21,button22,button23};
    private final JButton[] downRow = {button31,button32,button33};
    private final JButton[] leftColumn = {button11,button21,button31};
    private final JButton[] middleColumn = {button12,button22,button32};
    private final JButton[] rightColumn = {button13,button23,button33};
    private final JButton[] downToTopDiagonal = {button11,button22,button33};
    private final JButton[] topToDownDiagonal = {button31,button22,button13};
    private ArrayList<JButton> xButtons = new ArrayList<>();
    private ArrayList<JButton> oButtons = new ArrayList<>();
    GameFrame(){
        getScreenSize();
        this.setBounds(screenWidth/2-200,screenHeight/2-200,400,400);
        initComponents();
        gameStart();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
    }

    private void initComponents(){
        createActionListener(boardArray);
        this.getContentPane().add(gameBoardPanel);
    }

    private void gameStart() {
        Random random = new Random();
        playerXToPlay = random.nextBoolean();
        if(playerXToPlay)
            gameInformationLabelLower.setText("X starts");
        else gameInformationLabelLower.setText("O starts");
    }

    private JButton findButtonInArray(Object source){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(source.equals(boardArray[i][j]))
                    return boardArray[i][j];
            }
        }
        return null;
    }

    private void setGameLabels(){
        if(moveCounter <= 8) {
            gameInformationLabelUpper.setText("Move " + ++moveCounter);
            if (playerXToPlay) {
                gameInformationLabelLower.setText("O to move");
                playerXToPlay = false;
            } else {
                gameInformationLabelLower.setText("X to move");
                playerXToPlay = true;
            }
        }
    }

    private void setButtonLabels(Object source) {
        if (findButtonInArray(source) == null) throw new AssertionError();
        else if (playerXToPlay) {
            findButtonInArray(source).setText("O");
            oButtons.add(findButtonInArray(source));
        } else {
            findButtonInArray(source).setText("X");
            xButtons.add(findButtonInArray(source));
        }

    }

    private boolean checkCollision(Object source) {
        assert findButtonInArray(source) != null;
        return !findButtonInArray(source).getText().equals("");
    }

    private void checkWin(){
        if(xButtons.containsAll(List.of(topRow)) || xButtons.containsAll(List.of(middleRow)) || xButtons.containsAll(List.of(downRow))
                || xButtons.containsAll(List.of(leftColumn)) || xButtons.containsAll(List.of(rightColumn)) || xButtons.containsAll(List.of(middleColumn))
                || xButtons.containsAll(List.of(downToTopDiagonal)) || xButtons.containsAll(List.of(topToDownDiagonal))){
            gameInformationLabelUpper.setText("Game ends!");
            gameInformationLabelLower.setText("Player with X wins!");
            gameEnds = true;
        }
        else if(oButtons.containsAll(List.of(topRow)) || oButtons.containsAll(List.of(middleRow)) || oButtons.containsAll(List.of(downRow))
                || oButtons.containsAll(List.of(leftColumn)) || oButtons.containsAll(List.of(rightColumn)) || oButtons.containsAll(List.of(middleColumn))
                || oButtons.containsAll(List.of(downToTopDiagonal)) || oButtons.containsAll(List.of(topToDownDiagonal))){
            gameInformationLabelUpper.setText("Game ends!");
            gameInformationLabelLower.setText("Player with O wins!");
            gameEnds = true;
        }
        else if(moveCounter == 9){
            gameInformationLabelUpper.setText("Game ends!");
            gameInformationLabelLower.setText("It is a draw");
            gameEnds = true;
        }
    }

    private void createActionListener(JButton[][] boardArray){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                boardArray[i][j].addActionListener(this);
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameEnds){
            return;
        }
        else if (!checkCollision(e.getSource())) {
            setGameLabels();
            setButtonLabels(e.getSource());
            if (moveCounter >= 5)
                checkWin();
        }
        else {
            gameInformationLabelUpper.setText("Illegal move!");
            gameInformationLabelLower.setText("Field already taken");
        }

    }

}
