package SinbinZhou.Controller;

import SinbinZhou.Model.ProductionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName: ProductionAdd
 * @UserName: SinBin
 * @date: 2023-07-08 11:50
 * @Description:
 */
public class AddPartController {
    public static boolean productionAdd(ProductionModel productionModel) {
        String sql = "INSERT INTO product VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = DBUtil.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, productionModel.getName());
            ps.setString(2, productionModel.getFactory());
            ps.setString(3, productionModel.getAddress());
            ps.setString(4, productionModel.getProductionDate());
            ps.setString(5, productionModel.getExpirationDate());
            ps.setDouble(6, productionModel.getPurchasePrice());
            ps.setInt(7, productionModel.getPurchaseQuantity());
            ps.setDouble(8, productionModel.getSalePrice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return true;
    }
}