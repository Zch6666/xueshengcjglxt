package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ManagementCon.ConAdmDB;

public class AddTea extends JFrame implements ActionListener{
	
	private JLabel JLChange =new JLabel("请输入要添加教师的信息:");
	private JLabel JLTno = new JLabel("教师号：");
	private JLabel JLTname = new JLabel("姓名：");
	private JLabel JLTsex = new JLabel("性别：");
	private JLabel JLTjob = new JLabel("职位：");
	private JLabel JLTphone = new JLabel("联系方式(11位)：");
	private JLabel JLDno = new JLabel("院系号：");
	private JLabel JLCno = new JLabel("所授课程号：");
	private JTextField JTTno = new JTextField();
	private JTextField JTSname = new JTextField();
	private JRadioButton JRB1 = new JRadioButton("男");
	private JRadioButton JRB2 = new JRadioButton("女");
	private JTextField JTTjob = new JTextField();
	private JTextField JTphone = new JTextField();
	private JTextField JTDno = new JTextField();
	private JTextField JTCno = new JTextField();
	private JButton JBAdd = new JButton("添加");
	private JButton JBCancel = new JButton("取消");
	
	public AddTea() {
		this.setTitle("添加教师信息");
		getContentPane().setLayout(null);
		JLChange.setBounds(52, 27, 178, 29);
		getContentPane().add(JLChange);
		JLTno.setBounds(325, 27, 72, 23);
		getContentPane().add(JLTno);
		JTTno.setBounds(407, 27, 147, 23);
		getContentPane().add(JTTno);	
		JLTname.setBounds(325, 60, 72, 24);
		getContentPane().add(JLTname);
		JTSname.setBounds(407, 60, 147, 23);
		getContentPane().add(JTSname);
		JLTsex.setBounds(325, 94, 72, 24);
		getContentPane().add(JLTsex);
		JRB1.setBounds(407, 96, 43, 20);
		getContentPane().add(JRB1);
		JRB2.setBounds(501, 95, 51, 22);
		getContentPane().add(JRB2);
		JLTphone.setBounds(294, 136, 155, 21);
		getContentPane().add(JLTphone);
		JTphone.setBounds(407, 135, 147, 23);
		getContentPane().add(JTphone);
		JLTjob.setBounds(325, 171, 81, 23);
		getContentPane().add(JLTjob);
		JTTjob.setBounds(407, 171, 147, 23);
		getContentPane().add(JTTjob);
		JLDno.setBounds(325, 214, 81, 23);
		getContentPane().add(JLDno);
		JLCno.setBounds(298, 250, 108, 23);
		getContentPane().add(JLCno);
		JTDno.setBounds(407, 214, 147, 23);
		getContentPane().add(JTDno);
		JTCno.setBounds(407, 250, 147, 23);
		getContentPane().add(JTCno);
		JBAdd.setBounds(279, 304, 118, 29);
		JBAdd.addActionListener(this);
		getContentPane().add(JBAdd);
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
		boolean T=true;
		int i = 0;
		if(e.getSource()==JBAdd){
			String sTno=JTTno.getText();
			String sTname=JTSname.getText();
			String sTphone=JTphone.getText();
			String sTjob=JTTjob.getText();
			String sDno=JTDno.getText();
			String sCno=JTCno.getText();
			if(!sTno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Teacher");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sTno.equals(s1)){
							T=false;
							JOptionPane.showMessageDialog(this,"该教师已经存在","错误",JOptionPane.ERROR_MESSAGE);
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sTname.equals("")&&(JRB1.isSelected()||JRB2.isSelected())&&!sTphone.equals("")&&!sTjob.equals("")&&!sDno.equals("")&&!sCno.equals("")){
			            try {
			            	String ssex="男";
			            	if(JRB2.isSelected()){
			            		ssex="女";
			            	}
		                    
			            	String sql="insert into Teacher values('"+sTno+"','"+sTname+"','"+ssex+"','"+sTjob+"','"+sTphone+"','"+sDno+"')";
							ps = con.prepareStatement(sql);
							i = ps.executeUpdate();
							String sql2="insert into Taccounts values('"+sTno+"','"+123456+"')";
							ps = con.prepareStatement(sql2);
							i = ps.executeUpdate();
							String sql3="insert into Teach values('"+sTno+"','"+sCno+"')";
							ps = con.prepareStatement(sql3);
							i = ps.executeUpdate();
							
							JOptionPane.showMessageDialog(this,"添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"添加2222");
				        }
				    }
					else{
						JOptionPane.showMessageDialog(this,"请输入完整的信息","错误",JOptionPane.ERROR_MESSAGE);
					}
		          }
	          }
			  else{
				  JOptionPane.showMessageDialog(this,"请输入要添加教师的教师号","错误",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}

