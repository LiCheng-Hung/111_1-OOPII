import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyJFrame extends JFrame {
    private JPanel contentPane;

    MyJFrame() {
        Map<String, String> mountain = new HashMap<String, String>();
        JTextArea jta;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 200, 200);
        setTitle("各地名山");
        setLayout(new GridLayout(2, 1));

        JPanel pan1 = new JPanel();
        add(pan1);
        pan1.setLayout(new GridLayout(1, 2));
        JPanel pan2 = new JPanel();
        add(pan2);

        JLabel lab1 = new JLabel("找各地名山：", SwingConstants.RIGHT);
        pan1.add(lab1);

        String[] city = { "台北", "宜蘭", "桃園", "台中", "南投", "彰化" };
        mountain.put("台北", "七星山");
        mountain.put("宜蘭", "大礁溪山");
        mountain.put("桃園", "大棟山");
        mountain.put("台中", "梨山");
        mountain.put("南投", "水社大山");
        mountain.put("彰化", "八卦山");

        String str = "可選擇地名";
        jta = new JTextArea(str, 3, 15);
        pan2.add(jta);
        JPanel list = new JPanel();
        JList<String> jl1 = new JList<>(city);
        jl1.setVisibleRowCount(4);
        jl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jl1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    List<String> req = jl1.getSelectedValuesList();
                    String string = "";
                    for (int i = 0; i < req.size(); i++) {
                        if (i == req.size() - 1) {
                            string += req.get(i) + " 名山： " + mountain.get(req.get(i));
                        } else {
                            string += req.get(i) + " 名山： " + mountain.get(req.get(i)) + "\n";
                        }
                    }
                    jta.setText(string);
                }
            }
        });
        list.add(new JScrollPane(jl1));
        pan1.add(list);

        JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(50, 50, 200, 200);
        pan2.add(jsp);
    }
}

public class Mountain {
    public static void main(String[] args) throws Exception {
        MyJFrame f1 = new MyJFrame();
        f1.setVisible(true);
    }
}
