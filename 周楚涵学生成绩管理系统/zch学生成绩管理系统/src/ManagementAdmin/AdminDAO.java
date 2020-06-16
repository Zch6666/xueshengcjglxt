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

    //��ѧ�Ų�ѯѧ����Ϣ
	 public ArrayList searchStuById(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
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
	 //��������ѯѧ����Ϣ
	 public ArrayList searchStuBySname(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_message where ����=?";
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
	 
	 //���༶��ѯѧ����Ϣ
	 public ArrayList searchStuByClass(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from student_message where �༶=?";
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
	 
	//���γ̲�ѯѧ����Ϣ
	 public ArrayList searchStuByCname(StuBean bean) {
		 ConAdmDB cd = new ConAdmDB();
	        ArrayList arr = new ArrayList();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String sql = "Select * from admin_student_ankechengchaxun where �γ�=?";
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
		//���γ̲�ѯѧ����Ϣ
		 public ArrayList searchStuByStime(StuBean bean) {
		        ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from student_message where ��ѧʱ��=?";
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
		 
		//����ʦ�Ų�ѯ��ʦ��Ϣ
		 public ArrayList searchTeaById(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where ��ʦ��=?";
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
		//��������ѯ��ʦ��Ϣ
		 public ArrayList searchTeaByTname(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where ����=?";
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
		//��ְλ��ѯ��ʦ��Ϣ
		 public ArrayList searchTeaByTjob(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where ְ��=?";
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
		//���γ̲�ѯ��ʦ��Ϣ
		 public ArrayList searchTeaByCname(TeaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from admin_teacher_teach_course where �γ�=?";
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
		 
		//��Ժϵ�Ų�ѯԺϵ��Ϣ
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
		//��Ժϵ����ѯԺϵ��Ϣ
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
		//�������˲�ѯԺϵ��Ϣ
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
		 
		//��רҵ�Ų�ѯרҵ��Ϣ
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
		//��רҵ����ѯרҵ��Ϣ
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
		//�������˲�ѯרҵ��Ϣ
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
		 
		//���γ̺Ų�ѯ�γ���Ϣ
		 public ArrayList searchCouById(CouBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where �γ̺�=?";
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
		//���γ�����ѯ�γ���Ϣ
		 public ArrayList searchCouByCname(CouBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where �γ���=?";
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
		//����ʦ����ѯ�γ���Ϣ
		 public ArrayList searchCouByTname(CouBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from teacher_teach_course where ��ʦ��=?";
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

		//���༶�Ų�ѯ�༶��Ϣ
		 public ArrayList searchClaById(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where �༶��=?";
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
		//���༶����ѯ�༶��Ϣ
		 public ArrayList searchClaByClname(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where �༶��=?";
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
		//��רҵ����ѯ�༶��Ϣ
		 public ArrayList searchClaByMname(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where רҵ��=?";
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
		//��Ժϵ����ѯ�༶��Ϣ
		 public ArrayList searchClaByDname(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where Ժϵ��=?";
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
		//�������β�ѯ�༶��Ϣ
		 public ArrayList searchClaByClhead(ClaBean bean) {
			 ConAdmDB cd = new ConAdmDB();
		        ArrayList arr = new ArrayList();
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String sql = "Select * from classes_major_department where ������=?";
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
		 
		//��ѯѧ����¼
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
		//��ѯ��ʦ��¼
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
		//��ѯ�γ̼�¼
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
		//��ѯ�ڿμ�¼
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
		//��ѯ�༶��¼
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
		//��ѯרҵ��¼
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
		//��ѯרҵ��¼
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

