package SinbinZhou.View;

import SinbinZhou.Listener.SalePartListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: DeletePart_rebuild
 * @UserName: SinBin
 * @date: 2023-07-07 22:18
 * @Description:
 */
public class SalePartView extends JPanel {
    private JLabel queryProductLabel;
    private JTextField queryProductText;
    private JButton queryProductButton;
    private JScrollPane scrollPane;
    private JLabel productIDLabel;
    private JTextField productIDText;
    private JLabel sealNumberLabel;
    private JTextField sealNumberText;
    private JButton settlementButton;
    private JLabel totalPriceLabel;
    private JTextField totalPriceText;
    private MyJTable myJTable;
    private SpringLayout springLayout;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel downPanel;
    private Font font;
    private Dimension dimension;

    public SalePartView() {
        setLayout(new BorderLayout());
        //创建组件对象
        createObject();
        //初始化字体
        initFont();
        //初始化尺寸
        initDimension();
        //初始化布局
        init_topPanel();
        init_centerPanel();
        init_downPanel();
        //添加到主面板
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);
        //初始化监听器
        init_listener();
    }

    private void initDimension() {
        scrollPane.setPreferredSize(new Dimension(2880, 600));
        queryProductText.setPreferredSize(dimension);
        productIDText.setPreferredSize(dimension);
        sealNumberText.setPreferredSize(dimension);
    }

    private void initFont() {
        queryProductLabel.setFont(font);
        queryProductText.setFont(font);
        queryProductButton.setFont(font);
        productIDLabel.setFont(font);
        productIDText.setFont(font);
        sealNumberLabel.setFont(font);
        sealNumberText.setFont(font);
        settlementButton.setFont(font);
        totalPriceLabel.setFont(font);
        totalPriceText.setFont(new Font("黑体", Font.BOLD, 80));
    }

    private void createObject() {
        springLayout = new SpringLayout();
        centerPanel = new JPanel(new BorderLayout());
        downPanel = new JPanel(springLayout);
        topPanel = new JPanel(springLayout);
        queryProductLabel = new JLabel("品名");
        queryProductText = new JTextField();
        queryProductButton = new JButton("查询");
        scrollPane = new JScrollPane();
        myJTable = new MyJTable();
        productIDLabel = new JLabel("药品ID");
        productIDText = new JTextField();
        sealNumberLabel = new JLabel("出售数量");
        sealNumberText = new JTextField();
        settlementButton = new JButton("结算");
        totalPriceLabel = new JLabel("总额");
        totalPriceText = new JTextField();
        font = new Font("宋体", Font.PLAIN, 50);
        dimension = new Dimension(500, 60);
    }

    private void init_topPanel() {
        topPanel.add(queryProductLabel);
        topPanel.add(queryProductText);
        topPanel.add(queryProductButton);

        topPanel.setPreferredSize(new Dimension(0, 300));

        Spring tempWidth = Spring.sum(Spring.width(queryProductLabel),
                Spring.sum(Spring.width(queryProductText),
                        Spring.sum(Spring.width(queryProductButton),
                                Spring.constant(40))));
        int offSetX = tempWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, queryProductLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, topPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, queryProductLabel, 150,
                SpringLayout.NORTH, this);

        springLayout.putConstraint(SpringLayout.WEST, queryProductText, 20,
                SpringLayout.EAST, queryProductLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, queryProductText, 0,
                SpringLayout.VERTICAL_CENTER, queryProductLabel);

        springLayout.putConstraint(SpringLayout.WEST, queryProductButton, 20,
                SpringLayout.EAST, queryProductText);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, queryProductButton, 0,
                SpringLayout.VERTICAL_CENTER, queryProductLabel);
    }

    private void init_centerPanel() {
        centerPanel.add(scrollPane);
        scrollPane.setViewportView(myJTable);
        centerPanel.setPreferredSize(new Dimension(0, 600));
    }

    private void init_downPanel() {
        downPanel.setPreferredSize(new Dimension(0, 500));

        downPanel.add(productIDLabel);
        downPanel.add(productIDText);
        downPanel.add(sealNumberLabel);
        downPanel.add(sealNumberText);
        downPanel.add(settlementButton);
        downPanel.add(totalPriceText);

        Spring tempWidth = Spring.sum(Spring.width(queryProductLabel),
                Spring.sum(Spring.width(queryProductText),
                        Spring.sum(Spring.width(queryProductButton),
                                Spring.constant(40))));
        int offSetX = tempWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.EAST, productIDLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, downPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productIDLabel, 100,
                SpringLayout.NORTH, downPanel);

        springLayout.putConstraint(SpringLayout.WEST, productIDText, 20,
                SpringLayout.EAST, productIDLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productIDText, 0,
                SpringLayout.VERTICAL_CENTER, productIDLabel);

        springLayout.putConstraint(SpringLayout.EAST, sealNumberLabel, 0,
                SpringLayout.EAST, productIDLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sealNumberLabel, 70,
                SpringLayout.VERTICAL_CENTER, productIDLabel);

        springLayout.putConstraint(SpringLayout.WEST, sealNumberText, 20,
                SpringLayout.EAST, sealNumberLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sealNumberText, 0,
                SpringLayout.VERTICAL_CENTER, sealNumberLabel);

        springLayout.putConstraint(SpringLayout.NORTH, settlementButton, 0,
                SpringLayout.NORTH, productIDText);
        springLayout.putConstraint(SpringLayout.WEST, settlementButton, 20,
                SpringLayout.EAST, productIDText);

        springLayout.putConstraint(SpringLayout.WEST, totalPriceText, 0,
                SpringLayout.WEST, sealNumberLabel);
        springLayout.putConstraint(SpringLayout.NORTH, totalPriceText, 60,
                SpringLayout.SOUTH, sealNumberText);

        totalPriceText.setEditable(false);

        settlementButton.setPreferredSize(new Dimension(Spring.width(queryProductButton).getValue(),
                120));

        int totalPriceTextWidth = Spring.sum(Spring.width(sealNumberLabel),
                Spring.sum(Spring.width(sealNumberText),
                        Spring.sum(Spring.width(settlementButton),
                                Spring.constant(40)))).getValue();
        totalPriceText.setPreferredSize(new Dimension(totalPriceTextWidth, 140));
    }

    private void init_listener() {
        SalePartListener salePartListener = new SalePartListener(this);
        queryProductButton.addActionListener(salePartListener);
        settlementButton.addActionListener(salePartListener);
    }

    public JTextField getQueryProductText() {
        return queryProductText;
    }

    public JButton getQueryProductButton() {
        return queryProductButton;
    }

    public JTextField getProductIDText() {
        return productIDText;
    }

    public JTextField getSealNumberText() {
        return sealNumberText;
    }

    public JButton getSettlementButton() {
        return settlementButton;
    }

    public JTextField getTotalPriceText() {
        return totalPriceText;
    }

    public MyJTable getMyJTable() {
        return myJTable;
    }
}
