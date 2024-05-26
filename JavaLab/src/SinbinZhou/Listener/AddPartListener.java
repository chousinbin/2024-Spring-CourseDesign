package SinbinZhou.Listener;

import SinbinZhou.Controller.AddPartController;
import SinbinZhou.Model.ProductionModel;
import SinbinZhou.View.AddPartView;
import SinbinZhou.View.MyJOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: InsertListener
 * @UserName: SinBin
 * @date: 2023-07-07 17:47
 * @Description:
 */
public class AddPartListener implements ActionListener {
    private AddPartView addPartView;

    public AddPartListener(AddPartView addPartView) {
        this.addPartView = addPartView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //入库按钮, 入库
        if(e.getSource() == addPartView.getConfirmButton()) {
            //接收插入信息
            String name = addPartView.getNameText().getText();
            String factory = addPartView.getProductionFactoryText().getText();
            String address = addPartView.getProductionPlaceText().getText();
            String productionDate = addPartView.getProductionDateText().getText();
            String expirationDate = addPartView.getExpirationDateText().getText();
            String purchasePriceString = addPartView.getPurchasePriceText().getText();
            String purchaseQuantityString = addPartView.getPurchaseQuantityText().getText();
            String salePriceString = addPartView.getSalePriceText().getText();
            //判断是否未录入完整
            if(name == null || "".equals(name.trim()) ||
                    factory == null || "".equals(factory.trim()) ||
                    address == null || "".equals(address.trim()) ||
                    productionDate == null || "".equals(productionDate.trim()) ||
                    expirationDate == null || "".equals(expirationDate.trim()) ||
                    purchasePriceString == null || "".equals(purchasePriceString.trim()) ||
                    purchaseQuantityString == null || "".equals(purchaseQuantityString.trim()) ||
                    salePriceString == null || "".equals(salePriceString.trim()) ) {

                MyJOptionPane.showMessageDialog(null, "商品信息不完整", "提示");
                return;
            }
            //数据转换
            double purchasePrice = Double.parseDouble(purchasePriceString);
            int purchaseQuantity = Integer.parseInt(purchaseQuantityString);
            double salePrice = Double.parseDouble(salePriceString);
            //把数据传入商品实体对象
            ProductionModel productionModel = new ProductionModel();
            productionModel.setName(name);
            productionModel.setFactory(factory);
            productionModel.setAddress(address);
            productionModel.setProductionDate(productionDate);
            productionModel.setExpirationDate(expirationDate);
            productionModel.setPurchasePrice(purchasePrice);
            productionModel.setPurchaseQuantity(purchaseQuantity);
            productionModel.setSalePrice(salePrice);
            //向数据库插入
            boolean st = AddPartController.productionAdd(productionModel);
            if(st == false) {
                MyJOptionPane.showMessageDialog(null, "入库失败", "提示");
            } else {
                MyJOptionPane.showMessageDialog(null, "入库成功", "提示");
                cleanInformation();  //入库成功 清除文本框信息
            }
        }
        //重置信息
        if(e.getSource() == addPartView.getResetButton()) {
            cleanInformation();
        }
    }

    private void cleanInformation() {
        addPartView.getNameText().setText("");
        addPartView.getProductionFactoryText().setText("");
        addPartView.getProductionPlaceText().setText("");
        addPartView.getProductionDateText().setText("");
        addPartView.getExpirationDateText().setText("");
        addPartView.getPurchasePriceText().setText("");
        addPartView.getPurchaseQuantityText().setText("");
        addPartView.getSalePriceText().setText("");
    }
}