package homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePractice {

    static class Bomb extends JFrame {
        public Bomb() {
            setTitle("Beware of Jake");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(300, 300, 500, 550);
            setVisible(true);
            setResizable(false);
            setLayout(new BorderLayout());

            JPanel info = new JPanel();
            JTextField text = new JTextField("Не попадись Джейку!");
            text.setFont(new Font("Arrial", Font.BOLD,22));
            info.add(text);
            add(info, BorderLayout.NORTH);

            JPanel pan = new JPanel();
            add(pan,BorderLayout.CENTER);

            JButton[][] button = new JButton[10][10];
            int[][] gameField = MineField.getArr();
            pan.setLayout(new GridLayout(10, 10));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    button[i][j] = new JButton();
                    pan.add(button[i][j]);
                    int finalI = i;
                    int finalJ = j;
                    button[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (gameField[finalI][finalJ] == 9) {
                                button[finalI][finalJ].setEnabled(true);
                                for (int i = 0; i < 10; i++) {
                                    for (int j = 0; j < 10; j++) {
                                        if (gameField[i][j] == 9)
                                            button[i][j].setIcon(new ImageIcon(getClass().getResource("img.png")));
                                    }
                                }
                                text.setText("Вы проиграли =(");
                            } else if (gameField[finalI][finalJ] == 0) {
                                button[finalI][finalJ].setEnabled(false);
                                for (int q = 1; q < 10; q++) {
                                    if (finalI + q < 10) {
                                        button[finalI + q][finalJ].setEnabled(false);
                                        if (gameField[finalI + q][finalJ] > 0) {
                                            button[finalI + q][finalJ].setText(String.valueOf(gameField[finalI + q][finalJ]));
                                            break;
                                        }
                                    }
                                }
                                for (int q = 1; q < 10; q++) {
                                    if (finalI - q >= 0) {
                                        button[finalI - q][finalJ].setEnabled(false);
                                        if (gameField[finalI - q][finalJ] > 0) {
                                            button[finalI - q][finalJ].setText(String.valueOf(gameField[finalI - q][finalJ]));
                                            break;
                                        }
                                    }
                                }
                                for (int q = 1; q < 10; q++) {
                                    if (finalJ - q >= 0) {
                                        button[finalI][finalJ - q].setEnabled(false);
                                        if (gameField[finalI][finalJ - q] > 0) {
                                            button[finalI][finalJ - q].setText(String.valueOf(gameField[finalI][finalJ - q]));
                                            break;
                                        }
                                    }
                                }
                                for (int q = 1; q < 10; q++) {
                                    if (finalJ + q < 10) {
                                        button[finalI][finalJ + q].setEnabled(false);
                                        if (gameField[finalI][finalJ + q] > 0) {
                                            button[finalI][finalJ + q].setText(String.valueOf(gameField[finalI][finalJ + q]));
                                            break;
                                        }
                                    }
                                }


                            } else {
                                button[finalI][finalJ].setEnabled(false);
                                button[finalI][finalJ].setText(String.valueOf(gameField[finalI][finalJ]));
                            }
                            int count=0;
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++) {
                                    if(button[i][j].isEnabled())
                                        count++;
                                }
                            }
                            if(count==10){
                                text.setText("Победа!");
                            }
                        }
                    });
                }
            }

        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Bomb::new);
    }
}

