import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

class MyJFrame extends JFrame {
    private JPanel contentPane, jPanel;
    private int count = 0;
    private String[][] picturesLists = new String[3][2];

    MyJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 1000, 600);
        setTitle("Pictures");

        picturesLists[0][0] = "Selen";
        picturesLists[0][1] = "Selen_Tatsuki_Event_Commission.png";
        picturesLists[1][0] = "Shu";
        picturesLists[1][1] = "Shu.jpg";
        picturesLists[2][0] = "Cloud";
        picturesLists[2][1] = "3.jpg";

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2));

        JLabel pictureName = new JLabel("Selen", JLabel.CENTER);
        contentPane.add(pictureName, BorderLayout.NORTH);

        JLabel pictureShow = new JLabel();
        ImageIcon img = new ImageIcon(picturesLists[0][1]);
        pictureShow.setIcon(img);
        contentPane.add(pictureShow, BorderLayout.CENTER);

        JButton btn_before = new JButton("上一張");
        btn_before.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count >= 0) {
                    ImageIcon img = new ImageIcon(picturesLists[count][1]);
                    pictureShow.setIcon(img);
                    pictureName.setText(picturesLists[count][0]);
                } else {
                    count++;
                    JOptionPane.showMessageDialog(null, "沒有上一張了", "Picture", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jPanel.add(btn_before);

        JButton btn_after = new JButton("下一張");
        btn_after.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count <= 2) {
                    ImageIcon img = new ImageIcon(picturesLists[count][1]);
                    pictureShow.setIcon(img);
                    pictureName.setText(picturesLists[count][0]);
                } else {
                    count--;
                    JOptionPane.showMessageDialog(null, "沒有下一張了", "Picture", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jPanel.add(btn_after);

        contentPane.add(jPanel, BorderLayout.SOUTH);

    }
}

public class Picture {
    public static void main(String[] args) throws Exception {
        MyJFrame f1 = new MyJFrame();
        f1.setVisible(true);
    }
}