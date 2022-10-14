import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Calculator extends JFrame implements ActionListener {
    public static final int width = 250;
    public static final int hight = 250;
    public static JTextField tf = new JTextField();
    private List<String> lists = new ArrayList<String>();

    public Calculator() {
        super("Calculator");
        this.setBounds(200, 200, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        tf.setBackground(Color.WHITE);
        tf.setBorder(BorderFactory.createLoweredBevelBorder());
        tf.setEditable(false);
        this.add(tf, BorderLayout.NORTH);

        ActionListener numBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 得到輸入文字框的內容
                String text = tf.getText();
                // 判斷有沒有這句話 （0不能做分母，請清零後重試）,如果有 ，當點選數字按鈕的時候要它消失
                if ("除數不能為0".equals(text)) {
                    tf.setText(e.getActionCommand());
                    return;
                }
                // 如果第一個數是0，就不能輸入其他數字了，只能輸入小數點了
                if ("0".equals(text)) {
                    return;
                }
                if ("".equals(text)) { // 當文字域中沒資料的時候，把當前點選的數字顯示上去
                    tf.setText(e.getActionCommand());
                } else {
                    // 如果當前輸入框有資料，並且是操作符時，記錄下該操作符
                    if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
                        lists.add(text); // 將操作符新增到集合中
                        tf.setText("");
                        text = ""; // 將得到的文字符空，也就是將+或-或 *或/賦空值
                    }
                    text += e.getActionCommand();
                    tf.setText(text);
                }
            }
        };
        ActionListener operationBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 獲取輸入文字框內的內容
                String text = tf.getText();
                if ("".equals(text)) {
                    return;
                }
                if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                    return;
                }
                // 將內容新增到集合中
                lists.add(text);
                // 將輸入框清空
                tf.setText("");
                // 把按鈕上面的字顯示進去
                tf.setText(e.getActionCommand());
            }
        };

        ActionListener resultBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 判斷集合中的資料
                if (lists.isEmpty()) {
                    return;
                }
                // 獲取文字輸入框的內容
                String text = tf.getText();
                if ("".equals(tf) || "+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                    return;
                }
                // 將其新增到集合中
                lists.add(text);
                if (lists.size() < 3) {
                    return;
                }
                String one = lists.get(0); // 得到集合中的第一個數
                String two = lists.get(1); // 得到集合中的第二個數
                String three = lists.get(2); // 得到集合中的第三個數
                switch (two) {
                    case "+":
                        double i = Double.parseDouble(one);
                        double j = Double.parseDouble(three);
                        tf.setText((i + j) + ""); // 顯示結果
                        break;
                    case "-":
                        double x = Double.parseDouble(one);
                        double y = Double.parseDouble(three);
                        tf.setText((x - y) + ""); // 顯示結果
                        break;

                    case "*":
                        double a = Double.parseDouble(one);
                        double b = Double.parseDouble(three);
                        tf.setText((a * b) + "");
                        break;
                    case "/":
                        double k = Double.parseDouble(one);
                        double h = Double.parseDouble(three);
                        if (h == 0) {
                            tf.setText("除數不能為0");
                            lists.clear();
                            return;
                        }
                        tf.setText((k / h) + "");
                        break;
                }
                // 將集合中的資料清空
                lists.clear();
            }
        };

        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        p.setLayout(new GridLayout(4, 4, 3, 3));

        JButton seven = new JButton("7");
        seven.setBackground(Color.LIGHT_GRAY);
        seven.addActionListener(numBtnListener);
        p.add(seven);

        JButton eight = new JButton("8");
        eight.setBackground(Color.LIGHT_GRAY);
        eight.addActionListener(numBtnListener);
        p.add(eight);

        JButton nine = new JButton("9");
        nine.setBackground(Color.LIGHT_GRAY);
        nine.addActionListener(numBtnListener);
        p.add(nine);

        JButton divide = new JButton("/");
        divide.setBackground(Color.LIGHT_GRAY);
        divide.addActionListener(operationBtnListener);
        p.add(divide);

        JButton four = new JButton("4");
        four.setBackground(Color.LIGHT_GRAY);
        four.addActionListener(numBtnListener);
        p.add(four);

        JButton five = new JButton("5");
        five.setBackground(Color.LIGHT_GRAY);
        five.addActionListener(numBtnListener);
        p.add(five);

        JButton six = new JButton("6");
        six.setBackground(Color.LIGHT_GRAY);
        six.addActionListener(numBtnListener);
        p.add(six);

        JButton mul = new JButton("*");
        mul.setBackground(Color.LIGHT_GRAY);
        mul.addActionListener(operationBtnListener);
        p.add(mul);

        JButton one = new JButton("1");
        one.setBackground(Color.LIGHT_GRAY);
        one.addActionListener(numBtnListener);
        p.add(one);

        JButton two = new JButton("2");
        two.setBackground(Color.LIGHT_GRAY);
        two.addActionListener(numBtnListener);
        p.add(two);

        JButton three = new JButton("3");
        three.setBackground(Color.LIGHT_GRAY);
        three.addActionListener(numBtnListener);
        p.add(three);

        JButton minus = new JButton("-");
        minus.setBackground(Color.LIGHT_GRAY);
        minus.addActionListener(operationBtnListener);
        p.add(minus);

        JButton zero = new JButton("0");
        zero.setBackground(Color.LIGHT_GRAY);
        zero.addActionListener(e -> {
            // 得到輸入文字框
            String text = tf.getText();
            if ("0".equals(text)) { // 如果第一個數是0，不能再出現0了
                return;
            }
            // 如果出現操作符,就記錄下來
            if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                lists.add(text);
                text = ""; // 把操作符情況
            }
            text += e.getActionCommand();
            tf.setText(text);
        });
        p.add(zero);

        JButton point = new JButton(".");
        point.setBackground(Color.LIGHT_GRAY);
        point.addActionListener(e -> {
            // 得到輸入文字框
            String text = tf.getText();
            if ("".equals(text)) {
                return;
            }
            // 判斷文字是否為+ - * / .
            if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                return;
            }
            // 如果該數字後面已經有小數點了，那麼就不能連續出現兩次小數點了
            if (text.contains(".")) {
                return;
            }
            text += e.getActionCommand();
            tf.setText(text); // 設定進去
        });
        p.add(point);

        JButton equal = new JButton("=");
        equal.setBackground(Color.LIGHT_GRAY);
        equal.addActionListener(resultBtnListener);
        p.add(equal);

        JButton pul = new JButton("+");
        pul.setBackground(Color.LIGHT_GRAY);
        pul.addActionListener(operationBtnListener);
        p.add(pul);

        this.add(p);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
