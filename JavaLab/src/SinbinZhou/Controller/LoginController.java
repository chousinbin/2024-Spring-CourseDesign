package SinbinZhou.Controller;

import SinbinZhou.Model.AccountModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName: VerifyAccount
 * @UserName: SinBin
 * @date: 2023-07-08 10:55
 * @Description:
 */
public class LoginController {
    public static boolean accountVerify(AccountModel accountModel) {
        String sql = "select password from user where usrName = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            if(conn == null) {
                return false;
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1, accountModel.getUsrName());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String pwd = resultSet.getString(1);
                if(accountModel.getPwd().equals(pwd)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return false;
    }
}
