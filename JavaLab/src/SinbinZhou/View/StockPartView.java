package SinbinZhou.View;

import SinbinZhou.Listener.StockPartListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: QueryPart
 * @UserName: SinBin
 * @date: 2023-07-07 19:41
 * @Description:
 */
public class StockPartView extends JPanel {
    private JPanel topPanel;
    private JPanel centerPanel;
    private JLabel searchLabel;
    private JScrollPane jScrollPane;
    private JTextField searchText;
    private JButton searchButton;
    private JButton deleteButton;
    private SpringLayout springLayout;
    private MyJTable myJTable;
    private Font font;
    private Dimension dimension;
    private StockPartListener listener;

    public StockPartView() {
        //组件对象创建
        createObject();
        //主布局
        setLayout(new BorderLayout());
        //添加组件
        addComponent();
        //初始化字体
        initFont();
        //初始化尺寸
        searchText.setPreferredSize(dimension);
        //北部优化格式
        initTopLayout();
        //中部优化格式
        initCenterLayout();
        //添加监视器
        searchButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
    }

    private void initFont() {
        searchLabel.setFont(font);
        searchText.setFont(font);
        searchButton.setFont(font);
        deleteButton.setFont(font);
    }

    private void addComponent() {
        //北部组件添加
        topPanel.add(searchLabel);
        topPanel.add(searchText);
        topPanel.add(searchButton);
        topPanel.add(deleteButton);
        add(topPanel, BorderLayout.NORTH);
        //中间部分组件添加
        jScrollPane.setViewportView(myJTable);
        centerPanel.add(jScrollPane);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void createObject() {
        springLayout = new SpringLayout();
        //北部组件对象创建
        topPanel = new JPanel(springLayout);
        searchLabel = new JLabel("模糊搜索");
        searchText = new JTextField();
        searchButton = new JButton("搜索");
        deleteButton = new JButton("删除");
        //中间组件对象创建
        centerPanel = new JPanel(new BorderLayout());
        myJTable = new MyJTable();
        jScrollPane = new JScrollPane();
        //字体与尺寸
        font = new Font("宋体", Font.PLAIN, 50);
        dimension = new Dimension(500, 60);
        listener = new StockPartListener(this);
    }

    private void initTopLayout() {
        topPanel.setPreferredSize(new Dimension(0, 300));

        Spring tempWidth = Spring.sum(Spring.width(searchLabel),
                Spring.sum(Spring.width(searchText),
                        Spring.sum(Spring.width(searchButton),
                                Spring.constant(40))));
        int offSetX = tempWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, searchLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, topPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchLabel, 150,
                SpringLayout.NORTH, topPanel);

        springLayout.putConstraint(SpringLayout.WEST, searchText, 20,
                SpringLayout.EAST, searchLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchText,0,
                SpringLayout.VERTICAL_CENTER, searchLabel);

        springLayout.putConstraint(SpringLayout.WEST, searchButton, 20,
                SpringLayout.EAST, searchText);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchButton, 0,
                SpringLayout.VERTICAL_CENTER, searchLabel);

        springLayout.putConstraint(SpringLayout.EAST, deleteButton, -100,
                SpringLayout.EAST, topPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, deleteButton, 0,
                SpringLayout.VERTICAL_CENTER, searchLabel);
    }

    private void initCenterLayout() {
        centerPanel.setPreferredSize(new Dimension(0, 1000));
    }

    public JTextField getSearchText() {
        return searchText;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public MyJTable getMyJTable() {
        return myJTable;
    }
}
