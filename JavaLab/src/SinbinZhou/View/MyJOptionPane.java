package SinbinZhou.View;

import javax.swing.*;
import java.awt.*;
/**
 * @ClassName: MyJOptionPane
 * @UserName: SinBin
 * @date: 2023-07-09 21:15
 * @Description:
 */

public class MyJOptionPane extends JOptionPane {
    public static void showMessageDialog(Component parentComponent, Object message, String title) {
        UIManager.put("OptionPane.messageFont", new Font("宋体", Font.PLAIN, 40));
        UIManager.put("OptionPane.minimumSize", new Dimension(400, 300));
        UIManager.put("OptionPane.buttonFont", new Font("宋体", Font.PLAIN, 40));

        JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}