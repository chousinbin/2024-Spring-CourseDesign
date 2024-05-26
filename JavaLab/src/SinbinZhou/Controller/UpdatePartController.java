package SinbinZhou.Controller;

import SinbinZhou.Model.ProductionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName: UpdatePartController
 * @UserName: SinBin
 * @date: 2023-07-09 15:54
 * @Description:
 */
public class UpdatePartController {
    //更新记录信息
    public static void updateSelected(ProductionModel productionModel) {
        String sql = "UPDATE product SET name=?, factory=?, address=?, productionDate=?, " +
                "expirationDate=?, purchasePrice=?, purchaseQuantity=?, salePrice=? " +
                "WHERE id=?";
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
            ps.setInt(9, productionModel.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
}