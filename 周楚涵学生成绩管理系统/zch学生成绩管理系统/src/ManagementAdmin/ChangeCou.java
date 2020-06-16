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

public class ChangeCou extends JFrame implements ActionListener{
	
	private JLabel JLCno = new JLabel("������Ҫ�޸Ŀγ̵Ŀγ̺ţ�");
	private JLabel JLChange =new JLabel("������Ҫ�޸ĵ���Ϣ:");
	private JLabel JLCname = new JLabel("�γ�����");
	private JLabel JLCcredit = new JLabel("ѧ�֣�");
	private JLabel JLCtype = new JLabel("�γ����ԣ�");
	private JLabel JLCplace = new JLabel("�Ͽεص㣺");
	private JLabel JLCtime = new JLabel("�Ͽ�ʱ�䣺");
	private JLabel JLCtname = new JLabel("��ʦ����");
	private JTextField JTCno = new JTextField();
	private JTextField JTCname = new JTextField();
	private JTextField JTCcredit = new JTextField();
	private JTextField JTCtype = new JTextField();
	private JTextField JTCplace = new JTextField();
	private JTextField JTCtime = new JTextField();
	private JTextField JTCtname = new JTextField();
	private JButton JBChange = new JButton("�޸�");
	private JButton JBCancel = new JButton("ȡ��");
	
	public ChangeCou() {
		this.setTitle("�޸�רҵ��Ϣ");
		getContentPane().setLayout(null);
		JLChange.setBounds(258, 24, 178, 29);
		getContentPane().add(JLChange);
		JLCno.setBounds(25, 24, 178, 29);
		getContentPane().add(JLCno);
		JTCno.setBounds(25, 67, 147, 23);
		getContentPane().add(JTCno);
		JLCname.setBounds(325, 63, 72, 24);
		getContentPane().add(JLCname);
		JTCname.setBounds(407, 67, 147, 23);
		getContentPane().add(JTCname);
		JLCtype.setBounds(325, 130, 72, 24);
		JLCcredit.setBounds(325, 97, 72, 23);
		getContentPane().add(JLCcredit);
		JTCcredit.setBounds(407, 100, 147, 23);
		getContentPane().add(JTCcredit);
		getContentPane().add(JLCtype);
		JTCtype.setBounds(407, 133, 147, 23);
		getContentPane().add(JTCtype);
		JTCplace.setBounds(407, 166, 147, 23);
		getContentPane().add(JTCplace);
		JLCplace.setBounds(325, 164, 72, 23);
		getContentPane().add(JLCplace);
		JLCtime.setBounds(325, 196, 81, 22);
		getContentPane().add(JLCtime);
		JTCtime.setBounds(407, 196, 147, 23);
		getContentPane().add(JTCtime);
		JLCtname.setBounds(325, 228, 81, 22);
		getContentPane().add(JLCtname);
		JTCtname.setBounds(407, 229, 147, 23);
		getContentPane().add(JTCtname);
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
			String sCno=JTCno.getText();
			String sCname=JTCname.getText();
			String sCcredit=JTCcredit.getText();
			String sCtype=JTCtype.getText();
			String sCplace=JTCplace.getText();
			String sCtime=JTCtime.getText();
			String sCtname=JTCtname.getText();
			String sCtno=null;
			if(!sCno.equals("")&&!sCtname.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from course");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sCno.equals(s1)){
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Teacher");
					rs=ps.executeQuery();
					while(rs.next()){
						sCtno=rs.getString(1);
						String s2=rs.getString(2);
						if(sCtname.equals(s2)){
							T=true;
							break;
						}
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sCname.equals("")){
						try {
			            	String sql="update Course set  Cname=? where Cno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sCname);
							ps.setString(2,sCno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"�γ���2222");
				        }	
					}
					if(!sCcredit.equals("")){
						try {
			            	String sql="update Course set  Ccredit=? where Cno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sCcredit);
							ps.setString(2,sCno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"ѧ��2222");
				        }	
					}
					if(!sCtype.equals("")){
						try {
							String sql="update Course set  Ctype=? where Cno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sCtype);
							ps.setString(2,sCno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"�γ�����2222");
				        }	
					}
					if(!sCplace.equals("")){
						try {
							String sql="update Course set  Cplace=? where Cno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sCplace);
							ps.setString(2,sCno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"�Ͽεص�2222");
				        }
					}
					if(!sCtime.equals("")){
						try {
							String sql="update Course set  Ctime=? where Cno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sCtime);
							ps.setString(2,sCno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"�Ͽ�ʱ��2222");
				        }
					}
					if(!sCtname.equals("")){
						try {
							String sql="update Teach set  Tno=? where Cno=?";
							ps = con.prepareStatement(sql);
				            ps.setString(1,sCtno);
							ps.setString(2,sCno);
							i = ps.executeUpdate();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"��ʦ��2222");
				        }
					}
					if(sCname.equals("")&&sCplace.equals("")&&sCtype.equals("")){
						JOptionPane.showMessageDialog(this,"�������������޸���Ϣ","����",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(this,"�޸ĳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"û�д˿γ̻�˽�ʦ����Ϣ","����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else{
				JOptionPane.showMessageDialog(this,"������γ̺źͽ�ʦ��","����",JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}

}

