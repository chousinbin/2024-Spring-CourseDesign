package SinbinZhou.Listener;

import SinbinZhou.Controller.StockPartController;
import SinbinZhou.Model.MyTableModel;
import SinbinZhou.View.MyJTable;
import SinbinZhou.View.StockPartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: StockPartListener
 * @UserName: SinBin
 * @date: 2023-07-09 13:31
 * @Description:
 */
public class StockPartListener implements ActionListener {
    private StockPartView stockPartView;
    private MyTableModel myTableModel;
    private String key;
    private boolean preSt = false;  //记录上当前所在查询类型 false为全局, true为模糊搜索

    public StockPartListener(StockPartView stockPartView) {
        this.stockPartView = stockPartView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == stockPartView.getSearchButton()) {
            key = stockPartView.getSearchText().getText();

            if(key == null || "".equals(key.trim())) {
                preSt = false;
                myTableModel = StockPartController.stockQueryAll(new MyTableModel());
                stockPartView.getMyJTable().setMyTableModel(myTableModel);
            } else {  //关键词模糊搜索
                preSt = true;
                myTableModel = StockPartController.stockQueryPart(key, new MyTableModel());
                stockPartView.getMyJTable().setMyTableModel(myTableModel);
            }
        }

        if(e.getSource() == stockPartView.getDeleteButton()) {
            MyJTable myJTable = stockPartView.getMyJTable();
            //选中行的索引
            int selectedRom = myJTable.getSelectedRow();
            if(selectedRom == -1) return;
            //存放行数据的数组
            Object[] rowDate = new Object[myJTable.getColumnCount()];
            //提取选中行的数据
            for (int i = 0; i < myJTable.getColumnCount(); i++) {
                rowDate[i] = myJTable.getValueAt(selectedRom, i);
            }
            //得到要删除的商品的id
            int id = (int)rowDate[0];
            //执行删除操作
            StockPartController.stockDelete(id);
            //回显的查询结果要和上次查询类型一样
            if(preSt == false) {
                myTableModel = StockPartController.stockQueryAll(new MyTableModel());
            } else {
                myTableModel = StockPartController.stockQueryPart(key, new MyTableModel());
            }
            //删除完重新回显查询结果
            stockPartView.getMyJTable().setMyTableModel(myTableModel);
        }
    }
}