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

public class ChangeStu extends JFrame implements ActionListener{
	
	private JLabel JLSno = new JLabel("请输入要修改学生的学号：");
	private JLabel JLChange =new JLabel("请输入要修改的信息:");
	private JLabel JLDepartment = new JLabel("系别：");
	private JLabel JLMajor = new JLabel("专业：");
	private JLabel JLClno = new JLabel("班级号：");
	private JLabel JLSname = new JLabel("姓名：");
	private JLabel JLSsex = new JLabel("性别：");
	private JLabel JLScard = new JLabel("身份证号(18位)：");
	private JLabel JLStime = new JLabel("入学时间(xxxx-xx-xx)：");
	private JTextField JTSno = new JTextField();
	private JTextField JTDepartment = new JTextField();
	private JTextField JTMajor = new JTextField();
	private JTextField JTClno = new JTextField();
	private JTextField JTSname = new JTextField();
	private JRadioButton JRB1 = new JRadioButton("男");
	private JRadioButton JRB2 = new JRadioButton("女");
	private JTextField JTScard = new JTextField();
	private JTextField JTStime = new JTextField();
	private JButton JBChange = new JButton("修改");
	private JButton JBCancel = new JButton("取消");
	
	public ChangeStu() {
		this.setTitle("修改学生信息");
		getContentPane().setLayout(null);
		JLChange.setBounds(258, 24, 178, 29);
		getContentPane().add(JLChange);
		JLSno.setBounds(25, 24, 178, 29);
		getContentPane().add(JLSno);
		JTSno.setBounds(25, 67, 147, 23);
		getContentPane().add(JTSno);
		JLDepartment.setBounds(325, 63, 72, 24);
		getContentPane().add(JLDepartment);
		JTDepartment.setBounds(407, 66, 147, 23);
		getContentPane().add(JTDepartment);
		JLMajor.setBounds(325, 97, 72, 24);
		getContentPane().add(JLMajor);
		JTMajor.setBounds(407, 98, 147, 23);
		getContentPane().add(JTMajor);
		JLClno.setBounds(325, 131, 72, 26);
		getContentPane().add(JLClno);
		JTClno.setBounds(407, 131, 147, 23);
		getContentPane().add(JTClno);		
		JLSname.setBounds(325, 163, 72, 24);
		getContentPane().add(JLSname);
		JTSname.setBounds(407, 164, 147, 23);
		getContentPane().add(JTSname);
		JLSsex.setBounds(325, 197, 72, 24);
		getContentPane().add(JLSsex);
		JRB1.setBounds(410, 199, 43, 20);
		getContentPane().add(JRB1);
		JRB2.setBounds(503, 198, 51, 22);
		getContentPane().add(JRB2);
		JLStime.setBounds(258, 225, 155, 21);
		getContentPane().add(JLStime);
		JTStime.setBounds(407, 225, 147, 23);
		getContentPane().add(JTStime);
		JLScard.setBounds(269, 256, 128, 23);
		getContentPane().add(JLScard);
		JTScard.setBounds(407, 256, 226, 23);
		getContentPane().add(JTScard);
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
			String sSno=JTSno.getText();
			String sClno=JTClno.getText();
			String sSname=JTSname.getText();
			String sStime=JTStime.getText();
			String sScard=JTScard.getText();
			if(!sSno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Student");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sSno.equals(s1)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sSname.equals("")){
						try {
			            	String sql="update Student set  Sname=? where Sno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sSname);
							ps.setString(2,sSno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"姓名2222");
				        }	
					}
					if(!sClno.equals("")){
			            try {
			            	String sql="update Student set  Clno=? where Sno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sClno);
							ps.setString(2,sSno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"班级名2222");
				        }
				    }
					if(JRB1.isSelected()||JRB2.isSelected()){
						try {
			            	String sql="update Student set  ssex=? where Sno=?";
							ps = con.prepareStatement(sql);
							if(JRB1.isSelected()){
								 ps.setString(1,"男");
							}
							else{
								ps.setString(1,"女");
							}
							ps.setString(2,sSno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"性别2222");
				        }
					}
					if(!sStime.equals("")){
						try {
			            	String sql="update Student set  Stime=? where Sno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sStime);
							ps.setString(2,sSno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"入学时间2222");
				        }
					}
					if(!sScard.equals("")){
						try {
			            	String sql="update Student set  Scard=? where Sno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sScard);
							ps.setString(2,sSno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"身份证号2222");
				        }
					}
					if(sClno.equals("")&&sSname.equals("")&&!JRB1.isSelected()&&!JRB2.isSelected()&&sStime.equals("")&&sScard.equals("")){
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
				JOptionPane.showMessageDialog(this,"请输入学号","错误",JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}

