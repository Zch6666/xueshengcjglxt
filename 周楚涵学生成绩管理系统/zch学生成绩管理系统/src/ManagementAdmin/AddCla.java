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
	
	private JLabel JLChange =new JLabel("������Ҫ��Ӱ༶����Ϣ:");
	private JLabel JLClno = new JLabel("�༶�ţ�");
	private JLabel JLClname = new JLabel("�༶����");
	private JLabel JLMno = new JLabel("רҵ�ţ�");
	private JLabel JLClhead = new JLabel("�����Σ�");
	private JLabel JLClphone = new JLabel("��ϵ��ʽ(11λ)��");
	private JTextField JTClno = new JTextField();
	private JTextField JTClname = new JTextField();
	private JTextField JTMno = new JTextField();
	private JTextField JTClhead = new JTextField();
	private JTextField JTClphone = new JTextField();
	private JButton JBAdd = new JButton("���");
	private JButton JBCancel = new JButton("ȡ��");
	
	public AddCla() {
		this.setTitle("��Ӱ༶��Ϣ");
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
							JOptionPane.showMessageDialog(this,"�ð༶�Ѿ�����","����",JOptionPane.ERROR_MESSAGE);
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
	          }
			  else{
				  JOptionPane.showMessageDialog(this,"������Ҫ��ӵİ༶��","����",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}



