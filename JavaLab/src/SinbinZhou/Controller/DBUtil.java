package SinbinZhou.Controller;

import java.sql.*;

/**
 * @ClassName: DBUtil
 * @UserName: SinBin
 * @date: 2023-07-08 09:57
 * @Description: 用于管理数据库连接的单例类
 */
public class DBUtil {
    // 创建该类的静态实例
    private static DBUtil instance = new DBUtil();
    private static String url = "jdbc:mysql://127.0.0.1:3306/javalab";
    private static String username = "root";
    private static String password = "";

    // 私有构造函数防止其他类实例化
    private DBUtil() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("未找到驱动: " + e.getMessage());
            System.exit(1);
        }
    }

    // 公共静态方法获取实例
    public static DBUtil getInstance() {
        return instance;
    }

    // 获取数据库连接的方法
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("SQL错误: " + e.getMessage());
            System.exit(1);
            return null; // 此行代码永远不会执行，但为了编译需要保留。
        }
    }

    // 静态方法关闭连接
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("关闭连接失败: " + e.getMessage());
                System.exit(1);
            }
        }
    }

    // 静态方法关闭PreparedStatement
    public static void closePs(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.err.println("关闭PreparedStatement失败: " + e.getMessage());
                System.exit(1);
            }
        }
    }

    // 静态方法关闭ResultSet
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.println("关闭ResultSet失败: " + e.getMessage());
                System.exit(1);
            }
        }
    }
}