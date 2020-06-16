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

public class AddCla extends JFrame implements ActionListener{
	
	private JLabel JLChange =new JLabel("请输入要添加班级的信息:");
	private JLabel JLClno = new JLabel("班级号：");
	private JLabel JLClname = new JLabel("班级名：");
	private JLabel JLMno = new JLabel("专业号：");
	private JLabel JLClhead = new JLabel("班主任：");
	private JLabel JLClphone = new JLabel("联系方式(11位)：");
	private JTextField JTClno = new JTextField();
	private JTextField JTClname = new JTextField();
	private JTextField JTMno = new JTextField();
	private JTextField JTClhead = new JTextField();
	private JTextField JTClphone = new JTextField();
	private JButton JBAdd = new JButton("添加");
	private JButton JBCancel = new JButton("取消");
	
	public AddCla() {
		this.setTitle("添加班级信息");
		getContentPane().setLayout(null);
		JLChange.setBounds(52, 27, 178, 29);
		getContentPane().add(JLChange);
		JLClno.setBounds(325, 67, 72, 23);
		getContentPane().add(JLClno);
		JTClno.setBounds(407, 67, 147, 23);
		getContentPane().add(JTClno);	
		JLClname.setBounds(325, 116, 72, 24);
		getContentPane().add(JLClname);
		JTClname.setBounds(407, 117, 147, 23);
		getContentPane().add(JTClname);
		JLMno.setBounds(325, 165, 72, 23);
		getContentPane().add(JLMno);
		JTMno.setBounds(407, 163, 147, 23);
		getContentPane().add(JTMno);
		JLClhead.setBounds(325, 205, 72, 24);
		getContentPane().add(JLClhead);
		JTClhead.setBounds(407, 206, 147, 23);
		getContentPane().add(JTClhead);
		JLClphone.setBounds(279, 252, 155, 21);
		getContentPane().add(JLClphone);
		JTClphone.setBounds(407, 251, 147, 23);
		getContentPane().add(JTClphone);
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
			String sClno=JTClno.getText();
			String sClname=JTClname.getText();
			String sMno=JTMno.getText();
			String sClhead=JTClhead.getText();
			String sClphone=JTClphone.getText();
			if(!sClno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Classes");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sClno.equals(s1)){
							T=false;
							JOptionPane.showMessageDialog(this,"该班级已经存在","错误",JOptionPane.ERROR_MESSAGE);
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sClname.equals("")&&!sClphone.equals("")&&!sClhead.equals("")&&!sClno.equals("")&&!sMno.equals("")){
						try{
			            	String sql="insert into Classes values('"+sClno+"','"+sClname+"','"+sMno+"','"+sClhead+"','"+sClphone+"','"+0+"')";
							ps = con.prepareStatement(sql);
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
				  JOptionPane.showMessageDialog(this,"请输入要添加的班级号","错误",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}



