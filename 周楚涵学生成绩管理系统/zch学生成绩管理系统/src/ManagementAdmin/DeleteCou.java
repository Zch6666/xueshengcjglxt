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

public class DeleteCou extends JFrame implements ActionListener{
	private JLabel JLCno = new JLabel("请输入要删除课程的课程号：");
	private JTextField JTCno = new JTextField();
	private JButton JBDelete = new JButton("删除");
	private JButton JBCancel = new JButton("取消");
	
	public DeleteCou() {
		this.setTitle("删除课程信息");
		getContentPane().setLayout(null);
		JLCno.setBounds(32, 60, 178, 29);
		getContentPane().add(JLCno);
		JTCno.setBounds(127, 112, 147, 23);
		getContentPane().add(JTCno, BorderLayout.NORTH);
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
		Connection con=null;
		CallableStatement c=null;
		ResultSet rs=null;
		boolean T=false;
		int i = 0;
		if(e.getSource()==JBDelete){
			String sCno=JTCno.getText();
			if(!sCno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Course");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sCno.equals(s1)){
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
						c=con.prepareCall("{call DeleteCou(?)}");
						c.setString(1, sCno);
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
					JOptionPane.showMessageDialog(this,"没有此课程的信息","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"请输入课程号","错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}

