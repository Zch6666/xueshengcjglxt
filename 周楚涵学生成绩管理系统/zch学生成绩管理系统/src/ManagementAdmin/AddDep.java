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

public class AddDep extends JFrame implements ActionListener{
	
	private JLabel JLChange =new JLabel("请输入要添加院系的信息:");
	private JLabel JLDno = new JLabel("院系号：");
	private JLabel JLDname = new JLabel("院系名：");
	private JLabel JLDhead = new JLabel("负责人：");
	private JLabel JLDphone = new JLabel("联系方式(11位)：");
	private JTextField JTDno = new JTextField();
	private JTextField JTDname = new JTextField();
	private JTextField JTDhead = new JTextField();
	private JTextField JTDphone = new JTextField();
	private JButton JBAdd = new JButton("添加");
	private JButton JBCancel = new JButton("取消");
	
	public AddDep() {
		this.setTitle("添加院系信息");
		getContentPane().setLayout(null);
		JLChange.setBounds(52, 27, 178, 29);
		getContentPane().add(JLChange);
		JLDno.setBounds(325, 67, 72, 23);
		getContentPane().add(JLDno);
		JTDno.setBounds(407, 67, 147, 23);
		getContentPane().add(JTDno);	
		JLDname.setBounds(325, 131, 72, 24);
		getContentPane().add(JLDname);
		JTDname.setBounds(407, 132, 147, 23);
		getContentPane().add(JTDname);
		JLDhead.setBounds(325, 195, 72, 24);
		getContentPane().add(JLDhead);
		JTDhead.setBounds(407, 196, 147, 23);
		getContentPane().add(JTDhead);
		JLDphone.setBounds(279, 252, 155, 21);
		getContentPane().add(JLDphone);
		JTDphone.setBounds(407, 251, 147, 23);
		getContentPane().add(JTDphone);
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
			String sDno=JTDno.getText();
			String sDname=JTDname.getText();
			String sDhead=JTDhead.getText();
			String sDphone=JTDphone.getText();
			if(!sDno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Department");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sDno.equals(s1)){
							T=false;
							JOptionPane.showMessageDialog(this,"该院系已经存在","错误",JOptionPane.ERROR_MESSAGE);
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sDname.equals("")&&!sDphone.equals("")&&!sDhead.equals("")&&!sDno.equals("")){
						try{
			            	String sql="insert into Department values('"+sDno+"','"+sDname+"','"+sDhead+"','"+sDphone+"')";
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
				  JOptionPane.showMessageDialog(this,"请输入要添加的院系号","错误",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}


