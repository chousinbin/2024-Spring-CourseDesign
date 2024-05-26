package SinbinZhou.Listener;

import SinbinZhou.Controller.UpdatePartController;
import SinbinZhou.Model.MyTableModel;
import SinbinZhou.Model.ProductionModel;
import SinbinZhou.View.UpdatePartView;
import SinbinZhou.Controller.StockPartController;
import SinbinZhou.View.MyJTable;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: UpdatePartListener
 * @UserName: SinBin
 * @date: 2023-07-09 15:53
 * @Description:
 */
public class UpdatePartListener implements ActionListener , ListSelectionListener {
    private UpdatePartView updatePartView;
    private ProductionModel productionModel;

    public UpdatePartListener(UpdatePartView updatePartView) {
        this.updatePartView = updatePartView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updatePartView.getUpdateButton()) {
            //判断是否已经选中要修改的信息
            if(productionModel == null) {
                return;
            }
            //获取文本框数据
            String name = updatePartView.getNameText().getText();
            String factory = updatePartView.getProductionFactoryText().getText();
            String address = updatePartView.getProductionPlaceText().getText();
            String productionDate = updatePartView.getProductionDateText().getText();
            String expirationDate = updatePartView.getExpirationDateText().getText();
            String purchasePrice = updatePartView.getPurchasePriceText().getText();
            String purchaseNum = updatePartView.getPurchaseQuantityText().getText();
            String salePrice = updatePartView.getSalePriceText().getText();
            //判断文本框内容是否为空
            if(name == null || "".equals(name.trim()) ||
                    factory == null || "".equals(factory.trim()) ||
                    address == null || "".equals(address.trim()) ||
                    productionDate == null || "".equals(productionDate.trim()) ||
                    expirationDate == null || "".equals(expirationDate.trim()) ||
                    purchasePrice == null || "".equals(purchasePrice.trim()) ||
                    purchaseNum == null || "".equals(purchaseNum.trim()) ||
                    salePrice == null || "".equals(salePrice.trim()) ) {
                return;
            }
            //文本框数据到入到实体
            productionModel.setName(name);
            productionModel.setFactory(factory);
            productionModel.setAddress(address);
            productionModel.setProductionDate(productionDate);
            productionModel.setExpirationDate(expirationDate);
            productionModel.setPurchasePrice(Double.parseDouble(purchasePrice));
            productionModel.setPurchaseQuantity(Integer.parseInt(purchaseNum));
            productionModel.setSalePrice(Double.parseDouble(salePrice));
            //根据id和更新的实体进行数据库记录更新
            UpdatePartController.updateSelected(productionModel);
            //修改完成之后, 查询最新数据库, 把结果显示到JTable中
            MyTableModel myTableModel = StockPartController.stockQueryAll(new MyTableModel());
            updatePartView.getMyJTable().setMyTableModel(myTableModel);
        }
        //查询数据库, 返回列表模型, 添加到面板
        if(e.getSource() == updatePartView.getSearchButton()) {
            MyTableModel myTableModel = StockPartController.stockQueryAll(new MyTableModel());
            updatePartView.getMyJTable().setMyTableModel(myTableModel);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        MyJTable myJTable = updatePartView.getMyJTable();
        int selectedRom = myJTable.getSelectedRow();

        if(selectedRom != -1)
        {
            //把选中行的数据提取到实体对象中
            productionModel = new ProductionModel();
            productionModel.setId((int)myJTable.getValueAt(selectedRom, 0));
            productionModel.setName((String)myJTable.getValueAt(selectedRom, 1));
            productionModel.setFactory((String) myJTable.getValueAt(selectedRom, 2));
            productionModel.setAddress((String) myJTable.getValueAt(selectedRom, 3));
            productionModel.setProductionDate((String) myJTable.getValueAt(selectedRom, 4));
            productionModel.setExpirationDate((String) myJTable.getValueAt(selectedRom, 5));
            productionModel.setPurchasePrice((double)myJTable.getValueAt(selectedRom, 6));
            productionModel.setPurchaseQuantity((int)myJTable.getValueAt(selectedRom, 7));
            productionModel.setSalePrice((double)myJTable.getValueAt(selectedRom, 8));
            //实体对象存放的选中的数据 显示到 修改框
            updatePartView.getNameText().setText(productionModel.getName());
            updatePartView.getProductionFactoryText().setText(productionModel.getFactory());
            updatePartView.getProductionPlaceText().setText(productionModel.getAddress());
            updatePartView.getProductionDateText().setText(productionModel.getProductionDate());
            updatePartView.getExpirationDateText().setText(productionModel.getExpirationDate());
            updatePartView.getPurchasePriceText().setText(productionModel.getPurchasePrice() + "");
            updatePartView.getPurchaseQuantityText().setText(productionModel.getPurchaseQuantity() + "");
            updatePartView.getSalePriceText().setText(productionModel.getSalePrice() + "");
        }
    }
}