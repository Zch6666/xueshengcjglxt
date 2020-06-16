package ManagementStu;

import java.sql.*;

public class ConDB {
    public static Connection toconnection() {
        Connection con = null;
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=周楚涵学生成绩管理系统","sa","123456");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        return con;
    }

    public static void toClose(ResultSet rs, PreparedStatement ps,
                               Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}

