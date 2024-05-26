package SinbinZhou.View;

import SinbinZhou.Listener.AddPartListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: InsertPart
 * @UserName: SinBin
 * @date: 2023-07-07 17:49
 * @Description:
 */
public class AddPartView extends JPanel {
    private JButton confirmButton;
    private JButton resetButton;
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
    private SpringLayout springLayout;
    private Font font;
    private Dimension dimension;
    private AddPartListener listener;

    public AddPartView() {
        //创建对象
        createObject();
        //设置布局
        setLayout(springLayout);
        //初始化字体
        initFont();
        //初始化尺寸
        initDimension();
        //添加组件
        addComponents();
        //调整布局
        initLayout();
        //为组件添加监听器
        confirmButton.addActionListener(listener);
        resetButton.addActionListener(listener);
    }

    private void addComponents() {
        add(nameLabel);
        add(nameText);
        add(productionFactoryLabel);
        add(productionFactoryText);
        add(productionPlaceLabel);
        add(productionPlaceText);
        add(productionDateLabel);
        add(productionDateText);
        add(expirationDateLabel);
        add(expirationDateText);
        add(purchasePriceLabel);
        add(purchasePriceText);
        add(purchaseQuantityLabel);
        add(purchaseQuantityText);
        add(salePriceLabel);
        add(salePriceText);
        add(confirmButton);
        add(resetButton);
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
        confirmButton.setFont(font);
        resetButton.setFont(font);
    }

    private void createObject() {
        springLayout= new SpringLayout();
        font = new Font("宋体", Font.PLAIN, 36);
        dimension = new Dimension(300, 50);
        nameLabel = new JLabel("药品名称");
        productionFactoryLabel = new JLabel("生产厂家");
        productionPlaceLabel = new JLabel("生产地址");
        productionDateLabel = new JLabel("生产日期");
        expirationDateLabel = new JLabel("有效期");
        purchasePriceLabel = new JLabel("进货价格");
        purchaseQuantityLabel = new JLabel("进货数量");
        salePriceLabel = new JLabel("售价");
        nameText = new JTextField();
        productionFactoryText = new JTextField();
        productionPlaceText = new JTextField();
        productionDateText = new JTextField();
        expirationDateText = new JTextField();
        purchasePriceText = new JTextField();
        purchaseQuantityText = new JTextField();
        salePriceText = new JTextField();
        confirmButton = new JButton("确认入库");
        resetButton = new JButton("重置信息");
        listener = new AddPartListener(this);
    }

    private void initLayout() {
        Spring tempWidth = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameText)),
                Spring.constant(20));
        int offSetX = tempWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 300,
                SpringLayout.NORTH, this);

        springLayout.putConstraint(SpringLayout.WEST, nameText, 20,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, nameText, 0,
                SpringLayout.VERTICAL_CENTER, nameLabel);

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

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmButton, 300,
                SpringLayout.VERTICAL_CENTER, salePriceLabel);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmButton, 0,
                SpringLayout.HORIZONTAL_CENTER, this);

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, resetButton, 100,
                SpringLayout.VERTICAL_CENTER, confirmButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, resetButton, 0,
                SpringLayout.HORIZONTAL_CENTER, this);
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getResetButton() {
        return resetButton;
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
}