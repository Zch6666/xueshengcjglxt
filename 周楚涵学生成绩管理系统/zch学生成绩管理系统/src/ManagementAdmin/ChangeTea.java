package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ManagementCon.ConAdmDB;
import ManagementStu.StudentJFrame;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeTea extends JFrame implements ActionListener{
	
	private JLabel JLTno = new JLabel("请输入要修改教师的教师号：");
	private JLabel JLChange =new JLabel("请输入要修改的信息:");
	private JLabel JLTname = new JLabel("姓名：");
	private JLabel JLTsex = new JLabel("性别：");
	private JLabel JLTjob = new JLabel("职位：");
	private JLabel JLTphone = new JLabel("联系方式(11位)：");
	private JTextField JTTno = new JTextField();
	private JTextField JTTname = new JTextField();
	private JRadioButton JRB1 = new JRadioButton("男");
	private JRadioButton JRB2 = new JRadioButton("女");
	private JTextField JTTjob = new JTextField();
	private JTextField JTTphone = new JTextField();
	private JButton JBChange = new JButton("修改");
	private JButton JBCancel = new JButton("取消");
	
	public ChangeTea() {
		this.setTitle("修改教师信息");
		getContentPane().setLayout(null);
		JLChange.setBounds(258, 24, 178, 29);
		getContentPane().add(JLChange);
		JLTno.setBounds(25, 24, 178, 29);
		getContentPane().add(JLTno);
		JTTno.setBounds(25, 67, 147, 23);
		getContentPane().add(JTTno);
		JLTname.setBounds(325, 63, 72, 24);
		getContentPane().add(JLTname);
		JTTname.setBounds(407, 67, 147, 23);
		getContentPane().add(JTTname);
		JLTsex.setBounds(325, 126, 72, 24);
		getContentPane().add(JLTsex);
		JRB1.setBounds(413, 128, 43, 20);
		getContentPane().add(JRB1);
		JRB2.setBounds(503, 127, 51, 22);
		getContentPane().add(JRB2);
		JLTphone.setBounds(303, 181, 105, 23);
		getContentPane().add(JLTphone);
		JTTphone.setBounds(407, 181, 147, 23);
		getContentPane().add(JTTphone);
		JLTjob.setBounds(325, 235, 72, 23);
		getContentPane().add(JLTjob);
		JTTjob.setBounds(407, 235, 147, 23);
		getContentPane().add(JTTjob);
		JBChange.setBounds(279, 304, 118, 29);
		JBChange.addActionListener(this);
		getContentPane().add(JBChange);
		JBCancel.setBounds(437, 304, 117, 29);
		JBCancel.addActionListener(this);
		getContentPane().add(JBCancel);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
			
	}
	
	public void actionPerformed(ActionEvent e){
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		boolean T=false;
		int i = 0;
		if(e.getSource()==JBChange){
			String sTno=JTTno.getText();
			String sTname=JTTname.getText();
			String sTphone=JTTphone.getText();
			String sTjob=JTTjob.getText();
			if(!sTno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Teacher");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sTno.equals(s1)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sTname.equals("")){
						try {
			            	String sql="update Teacher set  Tname=? where Tno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sTname);
							ps.setString(2,sTno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"姓名2222");
				        }	
					}
					if(JRB1.isSelected()||JRB2.isSelected()){
						try {
			            	String sql="update Teacher set  Tsex=? where Tno=?";
							ps = con.prepareStatement(sql);
							if(JRB1.isSelected()){
								 ps.setString(1,"男");
							}
							else{
								ps.setString(1,"女");
							}
							ps.setString(2,sTno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"性别2222");
				        }
					}
					if(!sTphone.equals("")){
						try {
			            	String sql="update Teacher set  Tphone=? where Tno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sTphone);
							ps.setString(2,sTno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"联系方式2222");
				        }
					}
					if(!sTjob.equals("")){
						try {
			            	String sql="update Teacher set  Tjob=? where Tno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sTjob);
							ps.setString(2,sTno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"职位2222");
				        }
					}
					if(sTname.equals("")&&!JRB1.isSelected()&&!JRB2.isSelected()&&sTphone.equals("")&&sTjob.equals("")){
						JOptionPane.showMessageDialog(this,"请输入完整的修改信息","错误",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(this,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"没有此人的信息","错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else{
				JOptionPane.showMessageDialog(this,"请输入教师号","错误",JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}


