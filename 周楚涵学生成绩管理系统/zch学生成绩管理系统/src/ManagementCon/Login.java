package ManagementCon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.sql.*;
import java.util.*;

import javax.swing.event.*;

import ManagementAdmin.AdminJFrame;
import ManagementStu.StudentJFrame;
import ManagementTea.TeacherJFrame;

public class Login extends JFrame implements ActionListener{
	private JLabel JL = new JLabel("�� ӭ ʹ �ú����� ѧ �� �� �� �� �� ϵ ͳ");    //ʹ���ı�����һ����ǩ����
	private JLabel JLUserName = new JLabel("�û�����");    //ʹ���ı�����һ����ǩ����
	private JLabel JLPaw = new JLabel("��  �룺");         //ʹ���ı�����һ����ǩ����
	private JTextField JTUserName = new JTextField();     //����һ���ı������
	private JPasswordField JPsw = new JPasswordField();       //����һ����������
	private JButton JB1 = new JButton("��¼");            //������ť����
	private JButton JB2 = new JButton("ȡ��");
	private JLabel JLIdentify = new JLabel("��     �ݣ�");          //ʹ���ı�����һ����ǩ����
	private JComboBox JC = new JComboBox();              //����һ����Ͽ����
	public static String Sno;
	public static String Tno;
	public static String Ano;
	
	public Login(){
		this.setTitle("������ѧ����Ϣ����ϵͳ");                //���ô��ڱ���
		getContentPane().setLayout(null);                            //���ô��ڲ��ֹ�����
		JL.setBounds(34, 9, 340, 64);
		JL.setForeground(Color.RED);
		JL.setFont(new Font("�� ӭ ʹ �� ������ѧ �� �� �� �� �� ϵ ͳ",Font.BOLD,15));
		getContentPane().add(JL);
		JLUserName.setBounds(66, 83, 60, 20);             //����������ǩ�ĳ�ʼλ��
		getContentPane().add(JLUserName);
		JTUserName.setBounds(117, 83, 163, 20);
		getContentPane().add(JTUserName);
		JLPaw.setBounds(66, 128, 48, 20);             
		getContentPane().add(JLPaw);
		JPsw.setBounds(117, 128, 163, 20);            
		getContentPane().add(JPsw);
		JLIdentify.setBounds(69, 175, 80, 20);
		getContentPane().add(JLIdentify);
		JC.setBounds(175, 175, 72, 20);
		getContentPane().add(JC);
		JC.addItem(new String("ѧ��"));
		JC.addItem(new String("��ʦ"));
		JC.addItem(new String("����"));
		JB1.setBounds(100, 212, 60, 20);
		getContentPane().add(JB1);
		JB1.addActionListener(this);
		JB2.setBounds(200, 212, 60, 20);
		getContentPane().add(JB2);
		JB2.addActionListener(this);
		this.setVisible(true);
		this.setBounds(10, 10, 400, 300);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		boolean T=false;
		if(e.getSource()==JB1){
			String name = JTUserName.getText();
			String password = new String(JPsw.getPassword());
			String box = (String)JC.getSelectedItem();
			if(box.equals("ѧ��")){
				try{
					ConStuDB cd=new ConStuDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Saccounts");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						if(name.equals(s1)&&password.equals(s2)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					Sno=JTUserName.getText();
					new StudentJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this,"��֤����","����",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(box.equals("��ʦ")){
				try{
					ConTeaDB cd=new ConTeaDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Taccounts");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						if(name.equals(s1)&&password.equals(s2)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					Tno=JTUserName.getText();
					new TeacherJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this,"��֤����","����",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(box.equals("����")){
				try{
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					ps=con.prepareStatement("select * from Adminaccounts");
					rs=ps.executeQuery();
					while(rs.next()){
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						if(name.equals(s1)&&password.equals(s2)){
							T=true;
					        break;
						}				
					}				
				}
				catch (Exception e1){
					System.out.println(e1.toString());
				}
				if(T==true){
					Ano=JTUserName.getText();
					new AdminJFrame();
				}
				else{
					JOptionPane.showMessageDialog(this,"��֤����","����",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(e.getSource()==JB2){
			JTUserName.setText(null);
			JPsw.setText(null);
		}
	}
    
	public static void main(String[] args){
		new Login();
	}
	
}
