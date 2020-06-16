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

public class AddCou extends JFrame implements ActionListener{
	
	private JLabel JLChange =new JLabel("������Ҫ��ӿγ̵���Ϣ:");
	private JLabel JLCno = new JLabel("�γ̺ţ�");
	private JLabel JLCname = new JLabel("�γ�����");
	private JLabel JLCcredit = new JLabel("ѧ�֣�");
	private JLabel JLCatt = new JLabel("�γ����ԣ�");
	private JLabel JLCplace = new JLabel("�Ͽεص㣺");
	private JLabel JLCtime = new JLabel("�Ͽ�ʱ�䣺");
	private JLabel JLCtname = new JLabel("��ʦ����");
	private JTextField JTCno = new JTextField();
	private JTextField JTCname = new JTextField();
	private JTextField JTCcredit = new JTextField();
	private JTextField JTCatt = new JTextField();
	private JTextField JTCplace = new JTextField();
	private JTextField JTCtime = new JTextField();
	private JTextField JTCtname = new JTextField();
	private JButton JBAdd = new JButton("���");
	private JButton JBCancel = new JButton("ȡ��");
	
	public AddCou() {
		this.setTitle("��ӿγ���Ϣ");
		getContentPane().setLayout(null);
		JLChange.setBounds(52, 27, 178, 29);
		getContentPane().add(JLChange);
		JLCno.setBounds(325, 30, 72, 23);
		getContentPane().add(JLCno);
		JTCno.setBounds(407, 30, 147, 23);
		getContentPane().add(JTCno);	
		JLCname.setBounds(325, 63, 72, 24);
		getContentPane().add(JLCname);
		JTCname.setBounds(407, 63, 147, 23);
		getContentPane().add(JTCname);
		JLCcredit.setBounds(325, 97, 72, 24);
		getContentPane().add(JLCcredit);
		JTCcredit.setBounds(407, 98, 147, 23);
		getContentPane().add(JTCcredit);
		JLCatt.setBounds(325, 131, 72, 23);
		getContentPane().add(JLCatt);
		JTCatt.setBounds(407, 131, 147, 23);
		getContentPane().add(JTCatt);
		JLCplace.setBounds(325, 164, 81, 22);
		getContentPane().add(JLCplace);
		JTCplace.setBounds(407, 164, 147, 23);
		getContentPane().add(JTCplace);
		JLCtime.setBounds(325, 196, 81, 22);
		getContentPane().add(JLCtime);
		JTCtime.setBounds(407, 196, 147, 23);
		getContentPane().add(JTCtime);
		JLCtname.setBounds(325, 228, 81, 22);
		getContentPane().add(JLCtname);
		JTCtname.setBounds(407, 229, 147, 23);
		getContentPane().add(JTCtname);
		JBAdd.setBounds(276, 304, 118, 29);
		JBAdd.addActionListener(this);
		getContentPane().add(JBAdd);
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
		boolean T=true;
		int i = 0;
		if(e.getSource()==JBAdd){
			String sCno=JTCno.getText();
			String sCname=JTCname.getText();
			String sCcredit=JTCcredit.getText();
			String sCatt=JTCatt.getText();
			String sCplace=JTCplace.getText();
			String sCtime=JTCtime.getText();
			String sCtname=JTCtname.getText();
			String sCtno=null;
			if(!sCno.equals("")&&!sCtname.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Course");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sCno.equals(s1)){
							T=false;
							JOptionPane.showMessageDialog(this,"�ÿγ��Ѿ�����","����",JOptionPane.ERROR_MESSAGE);
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
						else{
							T=false;
						}
					}
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sCname.equals("")&&!sCatt.equals("")&&!sCcredit.equals("")&&!sCno.equals("")&&!sCplace.equals("")&&!sCtime.equals("")&&!sCtname.equals("")){
						try{
			            	String sql="insert into course values('"+sCno+"','"+sCname+"','"+sCatt+"','"+sCcredit+"','"+sCplace+"','"+sCtime+"')";
							ps = con.prepareStatement(sql);
							i = ps.executeUpdate();	
							JOptionPane.showMessageDialog(this,"��ӳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"���2222");
				        }
						
						try{
			            	String sql="insert into teach values('"+sCtno+"','"+sCno+"')";
							ps = con.prepareStatement(sql);
							i = ps.executeUpdate();	
							JOptionPane.showMessageDialog(this,"��ӳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} catch (SQLException ex) {
				            System.out.println(ex.getMessage()+"���2222");
				        }
				    }
					else{
						JOptionPane.showMessageDialog(this,"��������������Ϣ","����",JOptionPane.ERROR_MESSAGE);
					}
		          }
				else{
					JOptionPane.showMessageDialog(this,"û�иý�ʦ��������Ӹý�ʦ��Ϣ","����",JOptionPane.ERROR_MESSAGE);
				}
	          }
			  else{
				  JOptionPane.showMessageDialog(this,"������Ҫ��ӵĿγ̺źͽ�ʦ��","����",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}


