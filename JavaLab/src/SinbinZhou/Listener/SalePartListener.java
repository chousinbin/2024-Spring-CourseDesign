package SinbinZhou.Listener;

import SinbinZhou.Controller.SalePartController;
import SinbinZhou.Model.MyTableModel;
import SinbinZhou.Model.ProductionModel;
import SinbinZhou.View.MyJOptionPane;
import SinbinZhou.View.SalePartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class SalePartListener implements ActionListener {
    private SalePartView salePartView;
    private String key;

    // 构造函数，初始化销售部分视图
    public SalePartListener(SalePartView salePartView) {
        this.salePartView = salePartView;
    }

    // 实现ActionListener接口的方法，根据用户操作触发相应的处理
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salePartView.getQueryProductButton()) {
            performProductQuery();  // 执行产品查询
        } else if(e.getSource() == salePartView.getSettlementButton()) {
            handleProductSettlement();  // 处理产品结算
        }
    }

    // 执行产品查询，显示查询结果
    private void performProductQuery() {
        key = salePartView.getQueryProductText().getText().trim();
        if(key.isEmpty()) {
            return;
        }
        MyTableModel myTableModel = SalePartController.query(key, new MyTableModel());
        salePartView.getMyJTable().setMyTableModel(myTableModel);
    }

    // 处理产品结算，进行库存检查和计价
    private void handleProductSettlement() {
        String idStr = salePartView.getProductIDText().getText().trim();
        String numStr = salePartView.getSealNumberText().getText().trim();
//        String vipPhone = salePartView.getVipPhoneText().getText.trim();

        if (idStr.isEmpty() || numStr.isEmpty()) {
            MyJOptionPane.showMessageDialog(null, "请输入商品ID和数量", "错误");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int num = Integer.parseInt(numStr);
            settleTransaction(id, num);  // 结算交易
        } catch (NumberFormatException ex) {
            MyJOptionPane.showMessageDialog(null, "商品ID和数量必须是有效数字", "错误");
        }
    }

    // 结算交易，更新库存和显示新价格
    private void settleTransaction(int id, int num) {
        ProductionModel temp = new ProductionModel();
        temp.setId(id);
        ProductionModel productionModel = SalePartController.idQuery(temp);
        if (productionModel == null) {
            MyJOptionPane.showMessageDialog(null, "未找到指定的商品", "错误");
            return;
        }

        if (productionModel.getPurchaseQuantity() < num) {
            MyJOptionPane.showMessageDialog(null, "库存不足", "提示");
            return;
        }

        double totalPrice = num * productionModel.getSalePrice();
        salePartView.getTotalPriceText().setText("应收: " + formatPrice(totalPrice));
        // 更新库存
        productionModel.setPurchaseQuantity(productionModel.getPurchaseQuantity() - num);
        SalePartController.update(productionModel);
        // 添加销售记录
//        SalePartControllere.addSale(id, num, vipId);
        // 更新积分
//        SalePartController.updateVip(vipPhone, totalPrice);
        // 更新查询列表
        refreshQuery();
        // 添加缺货记录
        if (productionModel.getPurchaseQuantity() - num < 5) {
            SalePartController.addLack(id);  // 添加缺货记录
        }
    }

    // 格式化价格显示
    private String formatPrice(double price) {
        return new DecimalFormat("#.##").format(price);
    }

    // 刷新查询显示，用于更新界面上的表格数据
    private void refreshQuery() {
        MyTableModel myTableModel = SalePartController.query(key, new MyTableModel());
        salePartView.getMyJTable().setMyTableModel(myTableModel);
    }
}