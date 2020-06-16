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
	
	private JLabel JLChange =new JLabel("������Ҫ���Ժϵ����Ϣ:");
	private JLabel JLDno = new JLabel("Ժϵ�ţ�");
	private JLabel JLDname = new JLabel("Ժϵ����");
	private JLabel JLDhead = new JLabel("�����ˣ�");
	private JLabel JLDphone = new JLabel("��ϵ��ʽ(11λ)��");
	private JTextField JTDno = new JTextField();
	private JTextField JTDname = new JTextField();
	private JTextField JTDhead = new JTextField();
	private JTextField JTDphone = new JTextField();
	private JButton JBAdd = new JButton("���");
	private JButton JBCancel = new JButton("ȡ��");
	
	public AddDep() {
		this.setTitle("���Ժϵ��Ϣ");
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
							JOptionPane.showMessageDialog(this,"��Ժϵ�Ѿ�����","����",JOptionPane.ERROR_MESSAGE);
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
				  JOptionPane.showMessageDialog(this,"������Ҫ��ӵ�Ժϵ��","����",JOptionPane.ERROR_MESSAGE);
			  }

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}


