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

public class ChangeCla extends JFrame implements ActionListener{
	
	private JLabel JLClno = new JLabel("������Ҫ�޸İ༶�İ༶�ţ�");
	private JLabel JLChange =new JLabel("������Ҫ�޸ĵ���Ϣ:");
	private JLabel JLClname = new JLabel("�༶����");
	private JLabel JLMno = new JLabel("רҵ�ţ�");
	private JLabel JLClhead = new JLabel("�����Σ�");
	private JLabel JLClphone = new JLabel("��ϵ��ʽ��");
	private JTextField JTClno = new JTextField();
	private JTextField JTClname = new JTextField();
	private JTextField JTMno = new JTextField();
	private JTextField JTClhead = new JTextField();
	private JTextField JTClphone = new JTextField();
	private JButton JBChange = new JButton("�޸�");
	private JButton JBCancel = new JButton("ȡ��");
	
	public ChangeCla() {
		this.setTitle("�޸İ༶��Ϣ");
		getContentPane().setLayout(null);
		JLChange.setBounds(258, 24, 178, 29);
		getContentPane().add(JLChange);
		JLClno.setBounds(25, 24, 178, 29);
		getContentPane().add(JLClno);
		JTClno.setBounds(25, 67, 147, 23);
		getContentPane().add(JTClno);
		JLClname.setBounds(325, 84, 72, 24);
		getContentPane().add(JLClname);
		JTClname.setBounds(407, 85, 147, 23);
		getContentPane().add(JTClname);
		JLClhead.setBounds(325, 183, 72, 24);
		JLMno.setBounds(325, 135, 72, 23);
		getContentPane().add(JLMno);
		JTMno.setBounds(407, 135, 147, 23);
		getContentPane().add(JTMno);
		getContentPane().add(JLClhead);
		JTClhead.setBounds(407, 184, 147, 23);
		getContentPane().add(JTClhead);
		JTClphone.setBounds(407, 235, 147, 23);
		getContentPane().add(JTClphone);
		JLClphone.setBounds(325, 235, 72, 23);
		getContentPane().add(JLClphone);
		JBChange.setBounds(279, 304, 118, 29);
		JBChange.addActionListener(this);
		getContentPane().add(JBChange);
		JBCancel.setBounds(437, 304, 117, 29);
		JBCancel.addActionListener(this);
		getContentPane().add(JBCancel);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
			
	}
	
	public void actionPerformed(ActionEvent e){
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		boolean T=false;
		int i = 0;
		if(e.getSource()==JBChange){
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
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sClname.equals("")){
						try {
			            	String sql="update Classes set  Clname=? where Clno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sClname);
							ps.setString(2,sClno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"�༶��2222");
				        }	
					}
					if(!sMno.equals("")){
						try {
			            	String sql="update Classes set  Mno=? where Clno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sMno);
							ps.setString(2,sClno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"רҵ��2222");
				        }	
					}
					if(!sClhead.equals("")){
						try {
							String sql="update Classes set  Clhead=? where Clno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sClhead);
							ps.setString(2,sClno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"������2222");
				        }	
					}
					if(!sClphone.equals("")){
						try {
							String sql="update Classes set  Clphone=? where Clno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sClphone);
							ps.setString(2,sClno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"��ϵ��ʽ2222");
				        }
					}
					if(sClname.equals("")&&sClphone.equals("")&&sClhead.equals("")&&sMno.equals("")){
						JOptionPane.showMessageDialog(this,"�������������޸���Ϣ","����",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(this,"�޸ĳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"û�д˰༶����Ϣ","����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else{
				JOptionPane.showMessageDialog(this,"������༶��","����",JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}

