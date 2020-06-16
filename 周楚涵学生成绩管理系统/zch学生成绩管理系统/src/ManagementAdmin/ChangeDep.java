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

public class ChangeDep extends JFrame implements ActionListener{
	
	private JLabel JLDno = new JLabel("������Ҫ�޸�Ժϵ��Ժϵ�ţ�");
	private JLabel JLChange =new JLabel("������Ҫ�޸ĵ���Ϣ:");
	private JLabel JLDname = new JLabel("Ժϵ����");
	private JLabel JLDhead = new JLabel("�����ˣ�");
	private JLabel JLDphone = new JLabel("��ϵ��ʽ��");
	private JTextField JTDno = new JTextField();
	private JTextField JTDname = new JTextField();
	private JTextField JTDhead = new JTextField();
	private JTextField JTDphone = new JTextField();
	private JButton JBChange = new JButton("�޸�");
	private JButton JBCancel = new JButton("ȡ��");
	
	public ChangeDep() {
		this.setTitle("�޸�Ժϵ��Ϣ");
		getContentPane().setLayout(null);
		JLChange.setBounds(258, 24, 178, 29);
		getContentPane().add(JLChange);
		JLDno.setBounds(25, 24, 178, 29);
		getContentPane().add(JLDno);
		JTDno.setBounds(25, 67, 147, 23);
		getContentPane().add(JTDno);
		JLDname.setBounds(325, 84, 72, 24);
		getContentPane().add(JLDname);
		JTDname.setBounds(407, 85, 147, 23);
		getContentPane().add(JTDname);
		JLDhead.setBounds(325, 157, 72, 24);
		getContentPane().add(JLDhead);
		JTDhead.setBounds(407, 158, 147, 23);
		getContentPane().add(JTDhead);
		JTDphone.setBounds(407, 235, 147, 23);
		getContentPane().add(JTDphone);
		JLDphone.setBounds(325, 235, 72, 23);
		getContentPane().add(JLDphone);
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
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sDname.equals("")){
						try {
			            	String sql="update Department set  Dname=? where Dno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sDname);
							ps.setString(2,sDno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"Ժϵ��2222");
				        }	
					}
					if(!sDhead.equals("")){
						try {
			            	String sql="update Department set  Dhead=? where Dno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sDhead);
							ps.setString(2,sDno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"������2222");
				        }	
					}
					if(!sDphone.equals("")){
						try {
							String sql="update Department set  Dphon=? where Dno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sDphone);
							ps.setString(2,sDno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"��ϵ��ʽ2222");
				        }
					}
					if(sDname.equals("")&&sDphone.equals("")&&sDhead.equals("")){
						JOptionPane.showMessageDialog(this,"�������������޸���Ϣ","����",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(this,"�޸ĳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"û�д�Ժϵ����Ϣ","����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else{
				JOptionPane.showMessageDialog(this,"������Ժϵ��","����",JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}
