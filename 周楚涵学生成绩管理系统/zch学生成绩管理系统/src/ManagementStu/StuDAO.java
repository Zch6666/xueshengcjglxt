package ManagementStu;

import java.sql.*;
import java.util.*;

import ManagementCon.ConStuDB;

public class StuDAO {

    //��ѯ������Ϣ
	 public ArrayList searchById(StuBean bean) {
	        ConStuDB cd = new ConStuDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_message where ѧ��=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getSno());
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                arr.add(rs.getString(1));
	                arr.add(rs.getString(2));
	                arr.add(rs.getString(3));
	                arr.add(rs.getString(4));
	                arr.add(rs.getString(5));
	                arr.add(rs.getString(6));
	                arr.add(rs.getString(7));
	                arr.add(rs.getString(8));
	            }
	            //cd.toClose(rs, ps, con);
	            return arr;
	        } catch (SQLException ex) {
	        }
	        return arr;
	    }
	 //��ѯ�ɼ�
	 public ArrayList searchScoreById(StuBean bean) {
	        ConStuDB cd = new ConStuDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_score where ѧ��=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getSno());
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                arr.add(rs.getString(2));
	                arr.add(rs.getString(3));
	                arr.add(rs.getString(4)+"\t");
	            }
	            //cd.toClose(rs, ps, con);
	            return arr;
	        } catch (SQLException ex) {
	        }
	        return arr;
	    }
	 
	//��ѯ�γ�
		 public ArrayList searchCourseById(StuBean bean) {
		        ConStuDB cd = new ConStuDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from course_major_tea where ѧ��=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getSno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		                arr.add(rs.getString(5));
		                arr.add(rs.getString(6)+"\t");
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }


}
