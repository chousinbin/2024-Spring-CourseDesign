package SinbinZhou.View;
import SinbinZhou.Listener.LoginListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: LoginView
 * @UserName: SinBin
 * @date: 2023-07-02 22:20
 * @Description:
 * 登录界面
 */
public class LoginView extends JFrame {
    private JLabel titleLabel;
    private JLabel usrLabel;
    private JLabel pwdLabel;
    private JTextField usrText;
    private JPasswordField pwdText;
    private JButton loginButton;
    private JButton resetButton;
    private SpringLayout springLayout;
    private JPanel centerPanel;

    public LoginView() {
        createObject();
        initSizeFront();  //字体的初始化, 文本框的大小的初始化
        initLayout();  //初始化JPanel面板的弹簧布局, 以及组件添加
        addListener();  //为组件增加监听器

        setTitle("药品进销存管理软件");
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createObject() {
        titleLabel = new JLabel("药品进销存管理软件", JLabel.CENTER);
        usrLabel = new JLabel("用户名:");
        pwdLabel = new JLabel("密码:");
        usrText = new JTextField();
        pwdText = new JPasswordField();
        loginButton = new JButton("登录");
        resetButton = new JButton("重置");
        springLayout = new SpringLayout();
        centerPanel = new JPanel(springLayout);
    }
    void initSizeFront() {
        //初始化标题大小和字体
        titleLabel.setPreferredSize(new Dimension(0,180));
        titleLabel.setFont(new Font("楷体", Font.PLAIN, 60));
        //初始化标签文本框按钮字体
        Font centerFont = new Font("宋体", Font.PLAIN, 30);
        usrLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginButton.setFont(centerFont);
        resetButton.setFont(centerFont);
        usrText.setFont(centerFont);
        pwdText.setFont(centerFont);
        //初始化文本框大小
        usrText.setPreferredSize(new Dimension(200, 50));
        pwdText.setPreferredSize(new Dimension(200, 50));
        //初始化密码框默认字符
        pwdText.setEchoChar('*');
    }
    void initLayout() {
        centerPanel.add(usrLabel);
        Spring width1 = Spring.sum(Spring.sum(Spring.width(usrLabel), Spring.width(usrText)), Spring.constant(20));
        int offsetX = width1.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, usrLabel, -offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usrLabel, 40, SpringLayout.NORTH, centerPanel);

        centerPanel.add(usrText);
        springLayout.putConstraint(SpringLayout.WEST, usrText, 20, SpringLayout.EAST, usrLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, usrText, 0, SpringLayout.VERTICAL_CENTER, usrLabel);

        centerPanel.add(pwdLabel);
        springLayout.putConstraint(SpringLayout.EAST, pwdLabel, 0, SpringLayout.EAST, usrLabel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdLabel, 40, SpringLayout.SOUTH, usrLabel);

        centerPanel.add(pwdText);
        springLayout.putConstraint(SpringLayout.WEST, pwdText, 20, SpringLayout.EAST, pwdLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, pwdText, 0, SpringLayout.VERTICAL_CENTER, pwdLabel);

        centerPanel.add(loginButton);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, -offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, loginButton, 110, SpringLayout.SOUTH, pwdLabel);

        centerPanel.add(resetButton);
        springLayout.putConstraint(SpringLayout.EAST, resetButton, offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, resetButton, 0, SpringLayout.SOUTH, loginButton);

        //把标题和面板加到主面板
        add(titleLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    void addListener() {
        LoginListener listener = new LoginListener(this);
        loginButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        pwdText.addActionListener(listener);
    }

    public JTextField getUsrText() {
        return usrText;
    }

    public JPasswordField getPwdText() {
        return pwdText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
}
