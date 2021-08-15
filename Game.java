import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {
    public static void main(String[] args) {
        Game frame= new Game();
        frame.setVisible(true);
    }

    private JPanel panel;
    private JLabel[] holes= new JLabel[16];
    private int[] board= new int[16];

    private int score= 0;
    private JLabel lblScore;
    private JLabel lblTimeLeft;
    private JLabel lblHighScore;
    private int timeLeft= 30;
    private int highscore= 0;

    private JButton btnStart;
    private Timer timer;

    /** Constructor: initialize the game **/
    public Game() {

        initGUI();
        clearBoard();
        initEvents();

    }

    /** Take in a string and returns an ImageIcon **/
    private ImageIcon loadImage(String path) {
        // this.getClass().getResource points to res
        Image image= new ImageIcon(this.getClass().getResource(path)).getImage();
        // resize image to fit 132x132 pixels
        Image scaledImage= image.getScaledInstance(132, 132, java.awt.Image.SCALE_SMOOTH);
        // COnvert scaled image back to ImageIcon
        return new ImageIcon(scaledImage);

    }

    /** Determine which hole a mole will appear from **/
    private void genRanMole() {
        // 0 = empty
        // 1 = mole out
        Random rnd= new Random(System.currentTimeMillis());// init Rand obj
        int moleID= rnd.nextInt(16);
        board[moleID]= 1;
        holes[moleID].setIcon(loadImage("moleOut.png"));

    }

    /** Empty the holes **/
    private void clearBoard() {
        for (int j= 0; j < holes.length; j++ ) {
            holes[j].setIcon(loadImage("Screen Shot 2021-06-19 at 9.06.39 PM.png"));
            board[j]= 0;
        }
    }

    /** Initialize the JFrame and GUI **/
    private void initGUI() {
        setTitle("Whack A Mole");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 720);

        JPanel contentPane= new JPanel();
        contentPane.setBackground(new Color(0, 100, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        // Label for Title
        JLabel label= new JLabel();
        JLabel lblTitle= new JLabel("Whack A Mole");
        lblTitle.setForeground(new Color(192, 192, 192));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblTitle.setBounds(0, 0, 602, 47);

        contentPane.add(lblTitle);

        // Label for Score
        lblScore= new JLabel("Score: 0");
        lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblScore.setFont(new Font("Cambria", Font.BOLD, 14));
        lblScore.setForeground(new Color(0, 0, 0));
        lblScore.setBounds(423, 54, 144, 33);

        contentPane.add(lblScore);

        // Label for Highscore
        lblHighScore= new JLabel("High Score: 0");
        lblHighScore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHighScore.setForeground(new Color(240, 255, 240));
        lblHighScore.setFont(new Font("Cambria", Font.BOLD, 14));
        lblHighScore.setBounds(433, 18, 134, 33);

        contentPane.add(lblHighScore);

        // Label for TimeLeft
        lblTimeLeft= new JLabel("30");
        lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLeft.setForeground(new Color(178, 34, 34));
        lblTimeLeft.setFont(new Font("Cambria Math", Font.BOLD, 24));
        lblTimeLeft.setBounds(232, 54, 144, 33);

        contentPane.add(lblTimeLeft);

        // Start Button
        btnStart= new JButton("Start");
        btnStart.setBackground(Color.WHITE);
        btnStart.setBounds(32, 60, 110, 33);

        contentPane.add(btnStart);

        // Panel for Holes
        panel= new JPanel();
        panel.setBackground(new Color(25, 75, 55));
        panel.setBounds(32, 105, 535, 546);
        panel.setLayout(null);

        contentPane.add(panel);

        // Label for each 16 holes
        holes[0]= new JLabel("0");
        holes[0].setName("0");
        holes[0].setBounds(0, 396, 132, 132);
        panel.add(holes[0]);

        holes[1]= new JLabel("1");
        holes[1].setName("1");
        holes[1].setBounds(132, 396, 132, 132);
        panel.add(holes[1]);

        holes[2]= new JLabel("2");
        holes[2].setName("2");
        holes[2].setBounds(264, 396, 132, 132);
        panel.add(holes[2]);

        holes[3]= new JLabel("3");
        holes[3].setName("3");
        holes[3].setBounds(396, 396, 132, 132);
        panel.add(holes[3]);

        holes[4]= new JLabel("4");
        holes[4].setName("4");
        holes[4].setBounds(0, 264, 132, 132);
        panel.add(holes[4]);

        holes[5]= new JLabel("5");
        holes[5].setName("5");
        holes[5].setBounds(132, 264, 132, 132);
        panel.add(holes[5]);

        holes[6]= new JLabel("6");
        holes[6].setName("6");
        holes[6].setBounds(264, 264, 132, 132);
        panel.add(holes[6]);

        holes[7]= new JLabel("7");
        holes[7].setName("7");
        holes[7].setBounds(396, 264, 132, 132);
        panel.add(holes[7]);

        holes[8]= new JLabel("8");
        holes[8].setName("8");
        holes[8].setBounds(0, 132, 132, 132);
        panel.add(holes[8]);

        holes[9]= new JLabel("9");
        holes[9].setName("9");
        holes[9].setBounds(132, 132, 132, 132);
        panel.add(holes[9]);

        holes[10]= new JLabel("10");
        holes[10].setName("10");
        holes[10].setBounds(264, 132, 132, 132);
        panel.add(holes[10]);

        holes[11]= new JLabel("11");
        holes[11].setName("11");
        holes[11].setBounds(396, 132, 132, 132);
        panel.add(holes[11]);

        holes[12]= new JLabel("12");
        holes[12].setName("12");
        holes[12].setBounds(0, 0, 132, 132);
        panel.add(holes[12]);

        holes[13]= new JLabel("13");
        holes[13].setName("13");
        holes[13].setBounds(132, 0, 132, 132);
        panel.add(holes[13]);

        holes[14]= new JLabel("14");
        holes[14].setName("14");
        holes[14].setBounds(264, 0, 132, 132);
        panel.add(holes[14]);

        holes[15]= new JLabel("15");
        holes[15].setName("15");
        holes[15].setBounds(396, 0, 132, 132);
        panel.add(holes[15]);
    }

    /** Mouse Click Event Listener: execute certain code when the corresponding label detects a
     * mouse click **/
    // loop through each label in the array
    // add a mouse listener for each label
    private void initEvents() {
        for (int i= 0; i < holes.length; i++ ) {
            holes[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel lbl= (JLabel) e.getSource();
                    int id= Integer.parseInt(lbl.getName());
                    pressedButton(id);
                }
            });
        }
        // take action when the start button was clicked
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);// start button is disabled
                clearBoard();// board is cleared and reset
                genRanMole();// random mole is generated
                timer.start();// timer started
            }
        });

        // initialize the timer and an action listener, triggering every 1000ms
        timer= new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (timeLeft == 0) { // update the label and decrement timeLeft by 1
                    lblTimeLeft.setText("" + timeLeft);
                    timer.stop();
                    gameOver();// then called function gameOver()
                }
                lblTimeLeft.setText("" + timeLeft); // countdown timer when not time is not up
                timeLeft-- ;
            }
        });
    }

    /** (1) check whether the pressed button is 0 or 1 (2) if 1, increment score by 1 (3) if 0,
     * decrement score by 1 (4) update the score label (5) clear the board (6) generate another
     * random mole **/
    private void pressedButton(int id) {
        int val= board[id];
        if (val == 1) {
            score++ ;
        } else {
            score-- ;
        }

        lblScore.setText("Score: " + score);

        clearBoard();
        genRanMole();
    }

    /** Game is over and the time Left==0 (1) Re-enable the start button (2) check whether the high
     * score has been beaten, update if so (3) display a messagebox to the player indicating the
     * game is over (4) reset all variables (5) clear the board **/

    // JOptionPane display a message box
    private void gameOver() {
        btnStart.setEnabled(true);
        if (score > highscore) {
            highscore= score;
            lblHighScore.setText("Highscore: " + highscore);
            JOptionPane.showMessageDialog(this, "Your final score is: " + score,
                "You beat the high score!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "YOur final score is: " + score, "Game Over!",
                JOptionPane.INFORMATION_MESSAGE);
        }
        score= 0;
        timeLeft= 30;
        lblScore.setText("Score: 0");
        lblTimeLeft.setText("30");

        clearBoard();
    }

}
