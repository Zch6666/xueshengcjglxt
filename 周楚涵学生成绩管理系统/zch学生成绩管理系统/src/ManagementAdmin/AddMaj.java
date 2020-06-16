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

public class AddMaj extends JFrame implements ActionListener{
	
	private JLabel JLChange =new JLabel("������Ҫ���רҵ����Ϣ:");
	private JLabel JLMno = new JLabel("רҵ�ţ�");
	private JLabel JLMname = new JLabel("רҵ����");
	private JLabel JLDno = new JLabel("Ժϵ�ţ�");
	private JLabel JLMhead = new JLabel("�����ˣ�");
	private JLabel JLMphone = new JLabel("��ϵ��ʽ(11λ)��");
	private JTextField JTMno = new JTextField();
	private JTextField JTMname = new JTextField();
	private JTextField JTDno = new JTextField();
	private JTextField JTMhead = new JTextField();
	private JTextField JTMphone = new JTextField();
	private JButton JBAdd = new JButton("���");
	private JButton JBCancel = new JButton("ȡ��");
	
	public AddMaj() {
		this.setTitle("���רҵ��Ϣ");
		getContentPane().setLayout(null);
		JLChange.setBounds(52, 27, 178, 29);
		getContentPane().add(JLChange);
		JLMno.setBounds(325, 67, 72, 23);
		getContentPane().add(JLMno);
		JTMno.setBounds(407, 67, 147, 23);
		getContentPane().add(JTMno);	
		JLMname.setBounds(325, 116, 72, 24);
		getContentPane().add(JLMname);
		JTMname.setBounds(407, 117, 147, 23);
		getContentPane().add(JTMname);
		JLDno.setBounds(325, 165, 72, 23);
		getContentPane().add(JLDno);
		JTDno.setBounds(407, 163, 147, 23);
		getContentPane().add(JTDno);
		JLMhead.setBounds(325, 205, 72, 24);
		getContentPane().add(JLMhead);
		JTMhead.setBounds(407, 206, 147, 23);
		getContentPane().add(JTMhead);
		JLMphone.setBounds(279, 252, 155, 21);
		getContentPane().add(JLMphone);
		JTMphone.setBounds(407, 251, 147, 23);
		getContentPane().add(JTMphone);
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
			String sMno=JTMno.getText();
			String sMname=JTMname.getText();
			String sDno=JTDno.getText();
			String sMhead=JTMhead.getText();
			String sMphone=JTMphone.getText();
			if(!sMno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Major");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sMno.equals(s1)){
							T=false;
							JOptionPane.showMessageDialog(this,"��רҵ�Ѿ�����","����",JOptionPane.ERROR_MESSAGE);
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sMname.equals("")&&!sMphone.equals("")&&!sMhead.equals("")&&!sMno.equals("")&&!sDno.equals("")){
						try{
			            	String sql="insert into Major values('"+sMno+"','"+sMname+"','"+sDno+"','"+sMhead+"','"+sMphone+"')";
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
				  JOptionPane.showMessageDialog(this,"������Ҫ��ӵ�רҵ��","����",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}



