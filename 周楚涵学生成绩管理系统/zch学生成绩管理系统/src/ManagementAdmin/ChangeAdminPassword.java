package ManagementAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ManagementCon.ConAdmDB;
import ManagementCon.Login;

public class ChangeAdminPassword extends JFrame implements ActionListener{
	private JLabel JL = new JLabel("��    ��    ��    ��",JLabel.CENTER);
	private JLabel JLOld = new JLabel("�����룺");
	private JTextField JTOld = new JTextField();
	private JLabel JLNew = new JLabel("�����룺");
	private JPasswordField JTNew = new JPasswordField();
	private JLabel JLRenew = new JLabel("�ٴ����룺");
	private JPasswordField JTRenew = new JPasswordField();
	private JButton JBSet = new JButton("�޸�");
	private JButton JBCancel = new JButton("ȡ��");
	private String sql="";
	
	public ChangeAdminPassword(){
		this.setTitle("�޸�����");
		getContentPane().setLayout(null);
		JL.setBounds(100, 30, 200, 40);
		getContentPane().add(JL);
		JLOld.setBounds(100, 102, 54, 20);
		getContentPane().add(JLOld);
		JTOld.setBounds(164, 102, 157, 20);
		getContentPane().add(JTOld);
		JLNew.setBounds(100, 158, 54, 20);
		getContentPane().add(JLNew);
		JTNew.setBounds(164, 158, 157, 20);
		getContentPane().add(JTNew);
		JLRenew.setBounds(100, 210, 68, 20);
		getContentPane().add(JLRenew);
		JTRenew.setBounds(164, 210, 157, 20);
		getContentPane().add(JTRenew);
		JBSet.setBounds(128, 285, 90, 20);
		getContentPane().add(JBSet);
		JBSet.addActionListener(this);
		JBCancel.setBounds(253, 285, 90, 20);
		getContentPane().add(JBCancel);
		JBCancel.addActionListener(this);
		this.setVisible(true);
		this.setBounds(10, 10, 500, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
	}
	
	public void actionPerformed(ActionEvent e){
		CallableStatement c=null;
		Connection con=null;
		if(e.getSource()==JBSet){
			String sOld=JTOld.getText();
			String sNew=JTNew.getText();
			String sRnew=JTRenew.getText();
			if(sOld.equals("")||sNew.equals("")||sRnew.equals("")){
				JOptionPane.showMessageDialog(this,"������������Ϣ","����",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					c=con.prepareCall("{call UpdateAdmPwd(?,?,?,?)}");
					c.setString(1, Login.Ano);
					c.setString(2, sOld);
					c.setString(3, sNew);
					c.setString(4, sRnew);
					c.execute();
					c.close();
					JOptionPane.showMessageDialog(this,"�޸ĳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch (SQLException ex) {
		            System.out.println(ex.getMessage()+"2222");
		        }
			}
		}
		if(e.getSource()==JBCancel){
			dispose();
		}
			
	}
	
	/*public static void main(String[] args){
		new ChangePassword();
	}*/

}
