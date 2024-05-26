package SinbinZhou.View;

import SinbinZhou.Model.MyTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

/**
 * @ClassName: MyJTable
 * @UserName: SinBin
 * @date: 2023-07-08 23:21
 * @Description:
 */
public class MyJTable extends JTable {

    public void setMyTableModel(MyTableModel myTableModel) {
        setModel(myTableModel);
        //设置渲染格式
        Vector<Object> columns = myTableModel.getColumns();
        for (Object o : columns) {
            TableColumn column = getColumn(o);
            column.setCellRenderer(new MyCellRender());
        }
    }

    public MyJTable() {
        //设置表头
        JTableHeader tableHeader = getTableHeader();
        tableHeader.setFont(new Font("楷体", Font.BOLD, 36));
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 60));
        //设置表格体
        setFont(new Font("宋体", Font.PLAIN, 36));
        setForeground(Color.BLACK);
        setGridColor(Color.BLACK);
        setRowHeight(60);
        //单行选择
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
