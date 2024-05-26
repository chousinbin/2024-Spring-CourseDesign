package SinbinZhou.View;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: MainView
 * @UserName: SinBin
 * @date: 2023-07-06 17:06
 * @Description:
 */
public class MainView extends JFrame {
    public MainView() {
        setTitle("药品进销存管理软件");
        setSize(1280, 960);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建选项卡对象
        JTabbedPane tabbedPane = new JTabbedPane();
        //设置选项卡标签字体
        tabbedPane.setFont(new Font("黑体", Font.PLAIN, 36));
        //选项卡添加分面板和设置标题
        tabbedPane.addTab("药品入库", new AddPartView());
        tabbedPane.addTab("药品销售", new SalePartView());
        tabbedPane.addTab("药品修改", new UpdatePartView());
        tabbedPane.addTab("药品盘点", new StockPartView());
        //选项卡添加到主界面
        add(tabbedPane);
    }
}