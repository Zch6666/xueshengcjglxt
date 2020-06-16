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

public class AddStu extends JFrame implements ActionListener{
	
	private JLabel JLChange =new JLabel("������Ҫ���ѧ������Ϣ:");
	private JLabel JLSno = new JLabel("ѧ�ţ�");
	private JLabel JLDepartment = new JLabel("ϵ��");
	private JLabel JLMajor = new JLabel("רҵ��");
	private JLabel JLClno = new JLabel("�༶�ţ�");
	private JLabel JLSname = new JLabel("������");
	private JLabel JLSsex = new JLabel("�Ա�");
	private JLabel JLScard = new JLabel("���֤��(18λ)��");
	private JLabel JLStime = new JLabel("��ѧʱ��(xxxx-xx-xx)��");
	private JTextField JTSno = new JTextField();
	private JTextField JTDepartment = new JTextField();
	private JTextField JTMajor = new JTextField();
	private JTextField JTClno = new JTextField();
	private JTextField JTSname = new JTextField();
	private JRadioButton JRB1 = new JRadioButton("��");
	private JRadioButton JRB2 = new JRadioButton("Ů");
	private JTextField JTScard = new JTextField();
	private JTextField JTStime = new JTextField();
	private JButton JBAdd = new JButton("���");
	private JButton JBCancel = new JButton("ȡ��");
	
	public AddStu() {
		this.setTitle("���ѧ����Ϣ");
		getContentPane().setLayout(null);
		JLChange.setBounds(52, 27, 178, 29);
		getContentPane().add(JLChange);
		JLSno.setBounds(325, 30, 72, 23);
		getContentPane().add(JLSno);
		JTSno.setBounds(407, 30, 147, 23);
		getContentPane().add(JTSno);
		JLDepartment.setBounds(325, 63, 72, 24);
		getContentPane().add(JLDepartment);
		JTDepartment.setBounds(407, 66, 147, 23);
		getContentPane().add(JTDepartment);
		JLMajor.setBounds(325, 97, 72, 24);
		getContentPane().add(JLMajor);
		JTMajor.setBounds(407, 98, 147, 23);
		getContentPane().add(JTMajor);
		JLClno.setBounds(325, 131, 72, 26);
		getContentPane().add(JLClno);
		JTClno.setBounds(407, 131, 147, 23);
		getContentPane().add(JTClno);		
		JLSname.setBounds(325, 163, 72, 24);
		getContentPane().add(JLSname);
		JTSname.setBounds(407, 164, 147, 23);
		getContentPane().add(JTSname);
		JLSsex.setBounds(325, 197, 72, 24);
		getContentPane().add(JLSsex);
		JRB1.setBounds(410, 199, 43, 20);
		getContentPane().add(JRB1);
		JRB2.setBounds(503, 198, 51, 22);
		getContentPane().add(JRB2);
		JLStime.setBounds(258, 225, 155, 21);
		getContentPane().add(JLStime);
		JTStime.setBounds(407, 225, 147, 23);
		getContentPane().add(JTStime);
		JLScard.setBounds(269, 256, 128, 23);
		getContentPane().add(JLScard);
		JTScard.setBounds(407, 256, 226, 23);
		getContentPane().add(JTScard);
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
			String sSno=JTSno.getText();
			String sClno=JTClno.getText();
			String sSname=JTSname.getText();
			String sStime=JTStime.getText();
			String sScard=JTScard.getText();
			if(!sSno.equals("")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Student");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						if(sSno.equals(s1)){
							T=false;
							JOptionPane.showMessageDialog(this,"��ѧ���Ѿ�����","����",JOptionPane.ERROR_MESSAGE);
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					if(!sClno.equals("")&&!sSname.equals("")&&(JRB1.isSelected()||JRB2.isSelected())&&!sStime.equals("")&&!sScard.equals("")){
			            try {
			            	String ssex="��";
			            	if(JRB2.isSelected()){
			            		ssex="Ů";
			            	}
		                    
			            	String sql="insert into Student values('"+sSno+"','"+sSname+"','"+ssex+"','"+sScard+"','"+sClno+"','"+sStime+"')";
							ps = con.prepareStatement(sql);
							i = ps.executeUpdate();
							String sql2="insert into Saccounts values('"+sSno+"','"+123456+"')";
							ps = con.prepareStatement(sql2);
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
				JOptionPane.showMessageDialog(this,"������Ҫ���ѧ����ѧ��","����",JOptionPane.ERROR_MESSAGE);
			}

		}
		if(e.getSource()==JBCancel){
			dispose();
		}
	}
}
