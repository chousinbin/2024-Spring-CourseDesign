package SinbinZhou.Controller;

import SinbinZhou.Model.ProductionModel;
import SinbinZhou.Model.MyTableModel;

import java.sql.*;
import java.util.Vector;

/**
 * @ClassName: Query
 * @UserName: SinBin
 * @date: 2023-07-08 21:50
 * @Description:
 * 用于销售界面模糊查询
 * 模糊搜索, 返回表格实体, 包含表头和数据
 * ?返回类型应该修改为实体
 * 表格模式应该根据实体设置date和columns
 */
public class SalePartController {
    //模糊查询关键词, 不显示进价
    public static MyTableModel query(String key, MyTableModel myTableModel) {
        String sql = "SELECT id, name, factory, address, productionDate, " +
                "expirationDate, purchaseQuantity, salePrice" +
                " FROM product WHERE " +
                "name LIKE '%" + key + "%' OR " +
                "factory LIKE '%" + key + "%' OR " +
                "address LIKE '%" + key + "%'";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Vector<Object>> data = new Vector<>();

        try {
            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Vector<Object> dt = new Vector<>();
                for (int i = 1; i <= 8; i++) {
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
            columns.addElement("库存数量");
            columns.addElement("售价");
            myTableModel.setColumns(columns);
            //表格实体设置表头和数据
            myTableModel.setDataVector(data, columns);
            return myTableModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    //根据id查询商品, 返回该id商品的库存和售价, 返回类型为Product
    public static ProductionModel idQuery(ProductionModel productionModel) {
        int qid = productionModel.getId();
        String sql = "select purchaseQuantity, salePrice from product where " +
                "id = " + qid + "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                productionModel.setPurchaseQuantity(rs.getInt(1));
                productionModel.setSalePrice(rs.getDouble(2));
            }
            return productionModel;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return null;
    }
    //更新库存
    public static void update(ProductionModel productionModel) {
        String sql = "update product set purchaseQuantity = " +
                productionModel.getPurchaseQuantity() + " " +
                "where id = " + productionModel.getId() + "";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
    // 添加缺货日志
    public static void addLack(int id)
    {
        String sql = "insert into lackLog (lackId, lackDate) values (?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, new Date(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
}