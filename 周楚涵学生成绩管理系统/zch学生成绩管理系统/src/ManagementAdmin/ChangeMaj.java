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

public class ChangeMaj extends JFrame implements ActionListener{
	
	private JLabel JLMno = new JLabel("请输入要修改专业的专业号：");
	private JLabel JLChange =new JLabel("请输入要修改的信息:");
	private JLabel JLMname = new JLabel("专业名：");
	private JLabel JLDno = new JLabel("院系号：");
	private JLabel JLMhead = new JLabel("负责人：");
	private JLabel JLMphone = new JLabel("联系方式：");
	private JTextField JTMno = new JTextField();
	private JTextField JTMname = new JTextField();
	private JTextField JTDno = new JTextField();
	private JTextField JTMhead = new JTextField();
	private JTextField JTMphone = new JTextField();
	private JButton JBChange = new JButton("修改");
	private JButton JBCancel = new JButton("取消");
	
	public ChangeMaj() {
		this.setTitle("修改专业信息");
		getContentPane().setLayout(null);
		JLChange.setBounds(258, 24, 178, 29);
		getContentPane().add(JLChange);
		JLMno.setBounds(25, 24, 178, 29);
		getContentPane().add(JLMno);
		JTMno.setBounds(25, 67, 147, 23);
		getContentPane().add(JTMno);
		JLMname.setBounds(325, 84, 72, 24);
		getContentPane().add(JLMname);
		JTMname.setBounds(407, 85, 147, 23);
		getContentPane().add(JTMname);
		JLMhead.setBounds(325, 183, 72, 24);
		JLDno.setBounds(325, 135, 72, 23);
		getContentPane().add(JLDno);
		JTDno.setBounds(407, 135, 147, 23);
		getContentPane().add(JTDno);
		getContentPane().add(JLMhead);
		JTMhead.setBounds(407, 184, 147, 23);
		getContentPane().add(JTMhead);
		JTMphone.setBounds(407, 235, 147, 23);
		getContentPane().add(JTMphone);
		JLMphone.setBounds(325, 235, 72, 23);
		getContentPane().add(JLMphone);
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
			String sMno=JTMno.getText();
			String sMname=JTMname.getText();
			String sDno=JTDno.getText();
			String sMhead=JTMhead.getText();
			String sMphone=JTMphone.getText();
			if(!sMno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Major");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sMno.equals(s1)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sMname.equals("")){
						try {
			            	String sql="update Major set  Mname=? where Mno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sMname);
							ps.setString(2,sMno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"专业名2222");
				        }	
					}
					if(!sDno.equals("")){
						try {
			            	String sql="update Major set  Dno=? where Mno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sDno);
							ps.setString(2,sMno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"专业名2222");
				        }	
					}
					if(!sMhead.equals("")){
						try {
							String sql="update Major set  Mhead=? where Mno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sMhead);
							ps.setString(2,sMno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"负责人2222");
				        }	
					}
					if(!sMphone.equals("")){
						try {
							String sql="update Major set  Mphone=? where Mno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sMphone);
							ps.setString(2,sMno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"联系方式2222");
				        }
					}
					if(sMname.equals("")&&sMphone.equals("")&&sMhead.equals("")){
						JOptionPane.showMessageDialog(this,"请输入完整的修改信息","错误",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(this,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"没有此专业的信息","错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else{
				JOptionPane.showMessageDialog(this,"请输入专业号","错误",JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}
