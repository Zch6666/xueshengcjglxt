package ManagementTea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ManagementCon.ConAdmDB;
import ManagementCon.ConTeaDB;
import ManagementStu.StuBean;

public class TeaDAO {

    //查询个人信息
	 public ArrayList searchById(TeaBean bean) {
	        ConTeaDB cd = new ConTeaDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from Teacher where Tno=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getTno());
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                arr.add(rs.getString(1));
	                arr.add(rs.getString(2));
	                arr.add(rs.getString(3));
	                arr.add(rs.getString(4));
	                arr.add(rs.getString(5));
	                arr.add(rs.getString(6));
	            }
	            //cd.toClose(rs, ps, con);
	            return arr;
	        } catch (SQLException ex) {
	        }
	        return arr;
	    }
	 
	//按学号查询成绩
		 public ArrayList searchScoreBySno(TeaBean bean1,StuBean bean2) {
		        ConTeaDB cd = new ConTeaDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_sc where 教师号=? and 学号=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean1.getTno());
		            ps.setString(2, bean2.getSno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		                arr.add(rs.getString(5));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
	 //按姓名查询成绩
	 public ArrayList searchScoreBySname(TeaBean bean1,StuBean bean2) {
	        ConTeaDB cd = new ConTeaDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from teacher_teach_sc where 教师号=? and 姓名=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean1.getTno());
	            ps.setString(2, bean2.getSname());
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                arr.add(rs.getString(2));
	                arr.add(rs.getString(3));
	                arr.add(rs.getString(4));
	                arr.add(rs.getString(5));
	            }
	            //cd.toClose(rs, ps, con);
	            return arr;
	        } catch (SQLException ex) {
	        }
	        return arr;
	    }
	//按班级查询成绩
		 public ArrayList searchScoreByClname(TeaBean bean1,StuBean bean2) {
		        ConTeaDB cd = new ConTeaDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_sc where 教师号=? and 班级=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean1.getTno());
		            ps.setString(2, bean2.getClname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		                arr.add(rs.getString(5));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
		//按分数查询成绩
		 public ArrayList searchScoreByGrade(TeaBean bean1,StuBean bean2,TeaBean bean3,TeaBean bean4) {
		        ConTeaDB cd = new ConTeaDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_sc where 教师号=? and 班级=? and 成绩>=? and 成绩<=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean1.getTno());
		            ps.setString(2, bean2.getClname());
		            ps.setString(3, bean3.getGrade());
		            ps.setString(4, bean4.getGrade());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		                arr.add(rs.getString(5));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
	 
	//查询课程
		 public ArrayList searchCourseById(TeaBean bean) {
		        ConTeaDB cd = new ConTeaDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where 教师号=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getTno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		            	arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		                arr.add(rs.getString(5));
		                arr.add(rs.getString(6));
		                arr.add(rs.getString(7));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
		 
		//查询专业记录
		 public ArrayList searchSCRecord(TeaBean bean) {
			 ConTeaDB cd = new ConTeaDB();
			 ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String CourseNo=null;
		        String sql = "Select * from Teach where Tno=?";
		        String sql2 = "Select * from SC_record where Cno=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getTno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		            	CourseNo=rs.getString(2);
		            }		            
		            //cd.toClose(rs, ps, con);
		        } catch (SQLException ex) {
		        }
		        try {
		            ps = con.prepareStatement(sql2);
		            ps.setString(1, CourseNo);
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		                arr.add(rs.getString(5));
		            }		            
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		 }
		 
		//删除记录
		 public void  DeleteSCRecord(TeaBean bean) {
			 ConTeaDB cd = new ConTeaDB();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        int i = 0;
		        String CourseNo=null;
		        String sql = "Select * from Teach where Tno=?";
		        String sql2 = "Delete from SC_record where Cno=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getTno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		            	CourseNo=rs.getString(2);
		            }		            
		            //cd.toClose(rs, ps, con);
		        } catch (SQLException ex) {
		        }
		        try {
		            ps = con.prepareStatement(sql2);
		            ps.setString(1, CourseNo);
		            i = ps.executeUpdate();
		        }  catch (SQLException ex) {
		            System.out.println(ex.getMessage()+"删除2222");
		        }
		 }


}
