package SinbinZhou.View;

import SinbinZhou.Listener.UpdatePartListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: UpdatePart
 * @UserName: SinBin
 * @date: 2023-07-07 19:41
 * @Description:
 */
public class UpdatePartView extends JPanel {
    private JPanel westPanel;
    private JPanel centerPanel;
    private JScrollPane jScrollPane;
    private MyJTable myJTable;
    private JButton updateButton;
    private JTextField nameText;
    private JTextField productionFactoryText;
    private JTextField productionPlaceText;
    private JTextField productionDateText;
    private JTextField expirationDateText;
    private JTextField purchasePriceText;
    private JTextField purchaseQuantityText;
    private JTextField salePriceText;
    private JLabel nameLabel;
    private JLabel productionFactoryLabel;
    private JLabel productionPlaceLabel;
    private JLabel productionDateLabel;
    private JLabel expirationDateLabel;
    private JLabel purchasePriceLabel;
    private JLabel purchaseQuantityLabel;
    private JLabel salePriceLabel;
    private JButton searchButton;
    private SpringLayout springLayout;
    private Font font;
    private Dimension dimension;
    private UpdatePartListener listener;

    public UpdatePartView() {
        setLayout(new BorderLayout());
        //创建组件对象
        createObject();
        //初始化字体
        initFont();
        //初始化尺寸
        initDimension();
        //组件添加
        addComponent();
        //初始化布局
        initWestPanel();
        initCenterPanel();
        //分面板到主面板
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        //设置监听
        updateButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        myJTable.getSelectionModel().addListSelectionListener(listener);
    }

    private void initCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(2000, 1600));
        jScrollPane.setViewportView(myJTable);
    }

    private void initWestPanel() {
        westPanel.setPreferredSize(new Dimension(880,1600));

        Spring tempWidth = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameText)),
                Spring.constant(20));
        int offSetX = tempWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 300,
                SpringLayout.NORTH, westPanel);

        springLayout.putConstraint(SpringLayout.WEST, nameText, 20,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, nameText, 0,
                SpringLayout.NORTH, nameLabel);

        springLayout.putConstraint(SpringLayout.EAST, productionFactoryLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionFactoryLabel, 40,
                SpringLayout.SOUTH, nameLabel);

        springLayout.putConstraint(SpringLayout.WEST, productionFactoryText, 20,
                SpringLayout.EAST, productionFactoryLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productionFactoryText, 0,
                SpringLayout.VERTICAL_CENTER, productionFactoryLabel);

        springLayout.putConstraint(SpringLayout.EAST, productionPlaceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionPlaceLabel, 40,
                SpringLayout.SOUTH, productionFactoryLabel);

        springLayout.putConstraint(SpringLayout.WEST, productionPlaceText, 20,
                SpringLayout.EAST, productionPlaceLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productionPlaceText, 0,
                SpringLayout.VERTICAL_CENTER, productionPlaceLabel);

        springLayout.putConstraint(SpringLayout.EAST, productionDateLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionDateLabel, 40,
                SpringLayout.SOUTH, productionPlaceLabel);

        springLayout.putConstraint(SpringLayout.WEST, productionDateText, 20,
                SpringLayout.EAST, productionDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productionDateText, 0,
                SpringLayout.VERTICAL_CENTER, productionDateLabel);

        springLayout.putConstraint(SpringLayout.EAST, expirationDateLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, expirationDateLabel, 40,
                SpringLayout.SOUTH, productionDateLabel);

        springLayout.putConstraint(SpringLayout.WEST, expirationDateText, 20,
                SpringLayout.EAST, expirationDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, expirationDateText, 0,
                SpringLayout.VERTICAL_CENTER, expirationDateLabel);

        springLayout.putConstraint(SpringLayout.EAST, purchasePriceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchasePriceLabel, 40,
                SpringLayout.SOUTH, expirationDateLabel);

        springLayout.putConstraint(SpringLayout.WEST, purchasePriceText, 20,
                SpringLayout.EAST, purchasePriceLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, purchasePriceText, 0,
                SpringLayout.VERTICAL_CENTER, purchasePriceLabel);

        springLayout.putConstraint(SpringLayout.EAST, purchaseQuantityLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchaseQuantityLabel, 40,
                SpringLayout.SOUTH, purchasePriceLabel);

        springLayout.putConstraint(SpringLayout.WEST, purchaseQuantityText, 20,
                SpringLayout.EAST, purchaseQuantityLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, purchaseQuantityText, 0,
                SpringLayout.VERTICAL_CENTER, purchaseQuantityLabel);

        springLayout.putConstraint(SpringLayout.EAST, salePriceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, salePriceLabel, 40,
                SpringLayout.SOUTH, purchaseQuantityLabel);

        springLayout.putConstraint(SpringLayout.WEST, salePriceText, 20,
                SpringLayout.EAST, salePriceLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, salePriceText, 0,
                SpringLayout.VERTICAL_CENTER, salePriceLabel);

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, updateButton, 300,
                SpringLayout.VERTICAL_CENTER, salePriceLabel);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, updateButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchButton, 100,
                SpringLayout.VERTICAL_CENTER, updateButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, searchButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
    }

    private void createObject() {
        springLayout = new SpringLayout();
        westPanel = new JPanel(springLayout);
        centerPanel = new JPanel(new BorderLayout());
        font = new Font("宋体", Font.PLAIN, 36);
        dimension = new Dimension(300, 50);
        nameLabel = new JLabel("药品名称");
        productionFactoryLabel = new JLabel("生产厂家");
        productionPlaceLabel = new JLabel("生产地址");
        productionDateLabel = new JLabel("生产日期");
        expirationDateLabel = new JLabel("有效期");
        purchasePriceLabel = new JLabel("进货价格");
        purchaseQuantityLabel = new JLabel("库存数量");
        salePriceLabel = new JLabel("售价");
        nameText = new JTextField();
        productionFactoryText = new JTextField();
        productionPlaceText = new JTextField();
        productionDateText = new JTextField();
        expirationDateText = new JTextField();
        purchasePriceText = new JTextField();
        purchaseQuantityText = new JTextField();
        salePriceText = new JTextField();
        updateButton = new JButton("修改信息");
        searchButton = new JButton("查询");
        jScrollPane = new JScrollPane();
        myJTable = new MyJTable();
        listener = new UpdatePartListener(this);
    }

    private void initFont() {
        nameLabel.setFont(font);
        productionFactoryLabel.setFont(font);
        productionPlaceLabel.setFont(font);
        productionDateLabel.setFont(font);
        expirationDateLabel.setFont(font);
        purchasePriceLabel.setFont(font);
        purchaseQuantityLabel.setFont(font);
        salePriceLabel.setFont(font);
        nameText.setFont(font);
        productionFactoryText.setFont(font);
        productionPlaceText.setFont(font);
        productionDateText.setFont(font);
        expirationDateText.setFont(font);
        purchasePriceText.setFont(font);
        purchaseQuantityText.setFont(font);
        salePriceText.setFont(font);
        updateButton.setFont(font);
        searchButton.setFont(font);
    }

    private void addComponent() {
        westPanel.add(nameLabel);
        westPanel.add(nameText);
        westPanel.add(productionFactoryLabel);
        westPanel.add(productionFactoryText);
        westPanel.add(productionPlaceLabel);
        westPanel.add(productionPlaceText);
        westPanel.add(productionDateLabel);
        westPanel.add(productionDateText);
        westPanel.add(expirationDateLabel);
        westPanel.add(expirationDateText);
        westPanel.add(purchasePriceLabel);
        westPanel.add(purchasePriceText);
        westPanel.add(purchaseQuantityLabel);
        westPanel.add(purchaseQuantityText);
        westPanel.add(updateButton);
        westPanel.add(salePriceLabel);
        westPanel.add(salePriceText);
        westPanel.add(searchButton);
        centerPanel.add(jScrollPane);
    }

    private void initDimension() {
        nameText.setPreferredSize(dimension);
        productionFactoryText.setPreferredSize(dimension);
        productionPlaceText.setPreferredSize(dimension);
        productionDateText.setPreferredSize(dimension);
        expirationDateText.setPreferredSize(dimension);
        purchasePriceText.setPreferredSize(dimension);
        purchaseQuantityText.setPreferredSize(dimension);
        salePriceText.setPreferredSize(dimension);
    }

    public MyJTable getMyJTable() {
        return myJTable;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getProductionFactoryText() {
        return productionFactoryText;
    }

    public JTextField getProductionPlaceText() {
        return productionPlaceText;
    }

    public JTextField getProductionDateText() {
        return productionDateText;
    }

    public JTextField getExpirationDateText() {
        return expirationDateText;
    }

    public JTextField getPurchasePriceText() {
        return purchasePriceText;
    }

    public JTextField getPurchaseQuantityText() {
        return purchaseQuantityText;
    }

    public JTextField getSalePriceText() {
        return salePriceText;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
