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

public class DeleteStu extends JFrame implements ActionListener{
	private JLabel JLSno = new JLabel("������Ҫɾ��ѧ����ѧ�ţ�");
	private JTextField JTSno = new JTextField();
	private JButton JBDelete = new JButton("ɾ��");
	private JButton JBCancel = new JButton("ȡ��");
	
	public DeleteStu() {
		this.setTitle("ɾ��ѧ����Ϣ");
		getContentPane().setLayout(null);
		JLSno.setBounds(32, 60, 178, 29);
		getContentPane().add(JLSno);
		JTSno.setBounds(127, 112, 147, 23);
		getContentPane().add(JTSno, BorderLayout.NORTH);
		JBDelete.setBounds(71, 184, 118, 29);
		JBDelete.addActionListener(this);
		getContentPane().add(JBDelete);
		JBCancel.setBounds(213, 184, 117, 29);
		JBCancel.addActionListener(this);
		getContentPane().add(JBCancel);
		this.setBounds(10, 10, 400, 300);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
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
			String sSno=JTSno.getText();
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
					try {
						ConAdmDB cd=new ConAdmDB();
				        con=cd.toconnection();
						c=con.prepareCall("{call DeleteStu(?)}");
						c.setString(1, sSno);
						c.execute();
						c.close();
						JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					catch (SQLException ex) {
			            System.out.println(ex.getMessage()+"2222");
			        }
				}
				else{
					JOptionPane.showMessageDialog(this,"û�д��˵���Ϣ","����",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"������ѧ��","����",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}
