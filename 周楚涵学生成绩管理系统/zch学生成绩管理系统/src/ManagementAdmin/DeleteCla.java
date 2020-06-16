package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ManagementCon.ConAdmDB;

import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCla extends JFrame implements ActionListener{
	private JLabel JLClno = new JLabel("请输入要删除班级的班级号：");
	private JTextField JTClno = new JTextField();
	private JButton JBDelete = new JButton("删除");
	private JButton JBCancel = new JButton("取消");
	
	public DeleteCla() {
		this.setTitle("删除班级信息");
		getContentPane().setLayout(null);
		JLClno.setBounds(32, 60, 178, 29);
		getContentPane().add(JLClno);
		JTClno.setBounds(127, 112, 147, 23);
		getContentPane().add(JTClno, BorderLayout.NORTH);
		JBDelete.setBounds(71, 184, 118, 29);
		JBDelete.addActionListener(this);
		getContentPane().add(JBDelete);
		JBCancel.setBounds(213, 184, 117, 29);
		JBCancel.addActionListener(this);
		getContentPane().add(JBCancel);
		this.setBounds(10, 10, 400, 300);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		PreparedStatement ps=null;
		CallableStatement c=null;
		Connection con=null;
		ResultSet rs=null;
		boolean T=false;
		int i = 0;
		if(e.getSource()==JBDelete){
			String sClno=JTClno.getText();
			if(!sClno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Classes");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sClno.equals(s1)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					try {
						ConAdmDB cd=new ConAdmDB();
				        con=cd.toconnection();
						c=con.prepareCall("{call DeleteCla(?)}");
						c.setString(1, sClno);
						c.execute();
						c.close();
						JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					catch (SQLException ex) {
			            System.out.println(ex.getMessage()+"2222");
			        }
				}
				else{
					JOptionPane.showMessageDialog(this,"没有此班级的信息","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"请输入班级号","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}

