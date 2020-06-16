package ManagementAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ManagementCon.ClaBean;
import ManagementCon.ConAdmDB;
import ManagementCon.CouBean;
import ManagementCon.DepBean;
import ManagementCon.MajBean;
import ManagementStu.StuBean;
import ManagementTea.TeaBean;

public class AdminDAO {

    //按学号查询学生信息
	 public ArrayList searchStuById(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_message where 学号=?";
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
	 //按姓名查询学生信息
	 public ArrayList searchStuBySname(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_message where 姓名=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getSname());
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
	 
	 //按班级查询学生信息
	 public ArrayList searchStuByClass(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_message where 班级=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getClname());
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
	 
	//按课程查询学生信息
	 public ArrayList searchStuByCname(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from admin_student_ankechengchaxun where 课程=?";
	        con = cd.toconnection();
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, bean.getCname());
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                arr.add(rs.getString(1));
	                arr.add(rs.getString(2));
	                arr.add(rs.getString(4));
	                arr.add(rs.getString(3));
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
		//按课程查询学生信息
		 public ArrayList searchStuByStime(StuBean bean) {
		        ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from student_message where 入学时间=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getStime());
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
		 
		//按教师号查询教师信息
		 public ArrayList searchTeaById(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where 教师号=?";
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
		                arr.add(rs.getString(7));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
		//按姓名查询教师信息
		 public ArrayList searchTeaByTname(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where 姓名=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getTname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按职位查询教师信息
		 public ArrayList searchTeaByTjob(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where 职务=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getTjob());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按课程查询教师信息
		 public ArrayList searchTeaByCname(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where 课程=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getCname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		 
		//按院系号查询院系信息
		 public ArrayList searchDepById(DepBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from Department where Dno=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getDno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
		//按院系名查询院系信息
		 public ArrayList searchDepByDname(DepBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from Department where Dname=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getDname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
		//按负责人查询院系信息
		 public ArrayList searchDepByDhead(DepBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from Department where Dhead=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getDhead());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		    }
		 
		//按专业号查询专业信息
		 public ArrayList searchMajById(MajBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from Major where Mno=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getMno());
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
		//按专业名查询专业信息
		 public ArrayList searchMajByMname(MajBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from Major where Mname=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getMname());
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
		//按负责人查询专业信息
		 public ArrayList searchMajByMhead(MajBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from Major where Mhead=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getMhead());
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
		 
		//按课程号查询课程信息
		 public ArrayList searchCouById(CouBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where 课程号=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getCno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按课程名查询课程信息
		 public ArrayList searchCouByCname(CouBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where 课程名=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getCname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		            	arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按教师名查询课程信息
		 public ArrayList searchCouByTname(CouBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where 教师名=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getTname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		            	arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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

		//按班级号查询班级信息
		 public ArrayList searchClaById(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where 班级号=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getClno());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按班级名查询班级信息
		 public ArrayList searchClaByClname(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where 班级名=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getClname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按专业名查询班级信息
		 public ArrayList searchClaByMname(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where 专业名=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getMname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按院系名查询班级信息
		 public ArrayList searchClaByDname(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where 院系名=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getDname());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		//按班主任查询班级信息
		 public ArrayList searchClaByClhead(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where 班主任=?";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            ps.setString(1, bean.getClhead());
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		 
		//查询学生记录
		 public ArrayList searchStuRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Stu_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
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
		//查询教师记录
		 public ArrayList searchTeaRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Tea_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
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
		//查询课程记录
		 public ArrayList searchCouRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Cou_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
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
		//查询授课记录
		 public ArrayList searchTeachRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Teach_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
		                arr.add(rs.getString(3));
		                arr.add(rs.getString(4));
		            }
		            //cd.toClose(rs, ps, con);
		            return arr;
		        } catch (SQLException ex) {
		        }
		        return arr;
		 }
		//查询班级记录
		 public ArrayList searchClaRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Cla_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
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
		//查询专业记录
		 public ArrayList searchMajRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Maj_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                arr.add(rs.getString(1));
		                arr.add(rs.getString(2));
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
		 public ArrayList searchDepRecord() {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "select * from Dep_record";
		        con = cd.toconnection();
		        try {
		            ps = con.prepareStatement(sql);
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

}

