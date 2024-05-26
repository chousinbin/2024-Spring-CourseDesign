package SinbinZhou.Controller;

import SinbinZhou.Model.MyTableModel;

import java.sql.*;
import java.util.Vector;

/**
 * @ClassName: StockQuery
 * @UserName: SinBin
 * @date: 2023-07-09 00:46
 * @Description:
 */
public class StockPartController {
    //查询整张表
    public static MyTableModel stockQueryAll(MyTableModel myTableModel) {
        String sql = "select * from product";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Vector<Vector<Object>> data = new Vector<>();
            while(rs.next()) {
                Vector<Object> dt = new Vector<>();
                for(int i = 1; i <= 9; i++) {
                    dt.addElement(rs.getObject(i));
                }
                data.addElement(dt);
            }

            //向实体对象添加数据
            myTableModel.setDate(data);
            //向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("id");
            columns.addElement("药品名称");
            columns.addElement("生产厂家");
            columns.addElement("生产地址");
            columns.addElement("生产日期");
            columns.addElement("有效期");
            columns.addElement("进价");
            columns.addElement("库存数量");
            columns.addElement("售价");
            myTableModel.setColumns(columns);

            myTableModel.setDataVector(data, columns);
            return myTableModel;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    //模糊查询
    public static MyTableModel stockQueryPart(String key, MyTableModel myTableModel) {
        //模糊查询关键词
        String sql = "SELECT * FROM product WHERE " +
                "name LIKE '%" + key + "%' OR " +
                "factory LIKE '%" + key + "%' OR " +
                "address LIKE '%" + key + "%' OR " +
                "productionDate LIKE '%" + key + "%' OR " +
                "expirationDate LIKE '%" + key + "%'";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Vector<Object>> data = new Vector<>();

        try {
            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //数据库中无结果直接返回null

            while(rs.next()) {
                Vector<Object> dt = new Vector<>();
                for (int i = 1; i <= 9; i++) {
                    dt.addElement(rs.getObject(i));
                }
                data.addElement(dt);
            }

            //向实体对象添加数据
            myTableModel.setDate(data);
            //向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("id");
            columns.addElement("药品名称");
            columns.addElement("生产厂家");
            columns.addElement("生产地址");
            columns.addElement("生产日期");
            columns.addElement("有效期");
            columns.addElement("进价");
            columns.addElement("库存数量");
            columns.addElement("售价");
            myTableModel.setColumns(columns);

            myTableModel.setDataVector(data, columns);
            return myTableModel;
        } catch (SQLException e) {
            System.out.println("发生异常");
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return null;
    }
    //从数据库删除记录
    public static void stockDelete(int id) {
        String sql = "DELETE FROM product WHERE id = " + id +"";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("发生异常");
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
}
