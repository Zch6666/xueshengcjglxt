package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import ManagementCon.ConAdmDB;
import ManagementTea.TeaBean;

public class AdminRecord extends JFrame implements ActionListener{
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm1 = new JMenu("   查询记录   ");
	private JMenuItem jmi11 = new JMenuItem("查询“学生”的记录");
	private JMenuItem jmi12 = new JMenuItem("查询“教师”的记录");
	private JMenuItem jmi13 = new JMenuItem("查询“课程”的记录");
	private JMenuItem jmi14 = new JMenuItem("查询“授课”的记录");
	private JMenuItem jmi15 = new JMenuItem("查询“班级”的记录");
	private JMenuItem jmi16 = new JMenuItem("查询“专业”的记录");
	private JMenuItem jmi17 = new JMenuItem("查询“院系”的记录");
	private JMenu jm2 = new JMenu("   清空记录   ");
	private JMenuItem jmi21 = new JMenuItem("清空“学生”的记录");
	private JMenuItem jmi22 = new JMenuItem("清空“教师”的记录");
	private JMenuItem jmi23 = new JMenuItem("清空“课程”的记录");
	private JMenuItem jmi24 = new JMenuItem("清空“授课”的记录");
	private JMenuItem jmi25 = new JMenuItem("清空“班级”的记录");
	private JMenuItem jmi26 = new JMenuItem("清空“专业”的记录");
	private JMenuItem jmi27 = new JMenuItem("清空“院系”的记录");
	private JTextArea JT= new JTextArea();
	
	public AdminRecord(){
		this.setTitle("查询清空教务的操作记录");
		getContentPane().setLayout(null);
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi11);
		jm1.add(jmi12);
		jm1.add(jmi13);
		jm1.add(jmi14);
		jm1.add(jmi15);
		jm1.add(jmi16);
		jm1.add(jmi17);
		jmb.add(jm2);
		jm2.add(jmi21);
		jm2.add(jmi22);
		jm2.add(jmi23);
		jm2.add(jmi24);
		jm2.add(jmi25);
		jm2.add(jmi26);
		jm2.add(jmi27);
		jmi11.addActionListener(this);
		jmi12.addActionListener(this);
		jmi13.addActionListener(this);
		jmi14.addActionListener(this);
		jmi15.addActionListener(this);
		jmi16.addActionListener(this);
		jmi17.addActionListener(this);
		jmi21.addActionListener(this);
		jmi22.addActionListener(this);
		jmi23.addActionListener(this);
		jmi24.addActionListener(this);
		jmi25.addActionListener(this);
		jmi26.addActionListener(this);
		jmi27.addActionListener(this);

		this.setBounds(10, 10, 525, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(10, 11, 489, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);

	}
	public void actionPerformed(ActionEvent e){
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		int i = 0;
		if(e.getSource()==jmi11){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchStuRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        学号          姓名   性别           身份证号             班级 入学时间        修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi12){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchTeaRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      教师号          姓名   性别   职称   联系方式      院系号 修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi13){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchCouRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("课程号名     属性   学分  上课地点                        上课时间                     修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi14){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchTeachRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      教师号      课程号 修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi15){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchClaRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("班级号   班级名  专业号 班主任   联系方式    人数修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi16){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchMajRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("专业号   专业名  院系号 负责人   联系方式   修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi17){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchDepRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("院系号   院系名 负责人    联系方式    修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi21){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Stu_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi22){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Tea_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi23){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Cou_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi24){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Teach_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi25){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Cla_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi26){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Maj_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi27){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Dep_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"删除2222");
	        }
		  JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
