import javax.swing.*;
import java.awt.*;

public class swing_01 extends JFrame {
    public swing_01() {
        setTitle("ContentPane과 JFrame 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        swing_01 contentPane = getContentPane();

        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300,150);
        setVisible(true);
}
    public static void main(String[] args) {
        new swing_01();
    }
}
