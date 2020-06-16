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
	private JLabel JL = new JLabel("欢 迎 使 用湖工大 学 生 成 绩 管 理 系 统");    //使用文本创建一个标签对象
	private JLabel JLUserName = new JLabel("用户名：");    //使用文本创建一个标签对象
	private JLabel JLPaw = new JLabel("密  码：");         //使用文本创建一个标签对象
	private JTextField JTUserName = new JTextField();     //创建一个文本框对象
	private JPasswordField JPsw = new JPasswordField();       //创建一个密码框对象
	private JButton JB1 = new JButton("登录");            //创建按钮对象
	private JButton JB2 = new JButton("取消");
	private JLabel JLIdentify = new JLabel("身     份：");          //使用文本创建一个标签对象
	private JComboBox JC = new JComboBox();              //创建一个组合框对象
	public static String Sno;
	public static String Tno;
	public static String Ano;
	
	public Login(){
		this.setTitle("湖工大学生信息管理系统");                //设置窗口标题
		getContentPane().setLayout(null);                            //设置窗口布局管理器
		JL.setBounds(34, 9, 340, 64);
		JL.setForeground(Color.RED);
		JL.setFont(new Font("欢 迎 使 用 湖工大学 生 成 绩 管 理 系 统",Font.BOLD,15));
		getContentPane().add(JL);
		JLUserName.setBounds(66, 83, 60, 20);             //设置姓名标签的初始位置
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
		JC.addItem(new String("学生"));
		JC.addItem(new String("教师"));
		JC.addItem(new String("教务"));
		JB1.setBounds(100, 212, 60, 20);
		getContentPane().add(JB1);
		JB1.addActionListener(this);
		JB2.setBounds(200, 212, 60, 20);
		getContentPane().add(JB2);
		JB2.addActionListener(this);
		this.setVisible(true);
		this.setBounds(10, 10, 400, 300);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
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
			if(box.equals("学生")){
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
					JOptionPane.showMessageDialog(this,"验证错误","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(box.equals("教师")){
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
					JOptionPane.showMessageDialog(this,"验证错误","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(box.equals("教务")){
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
					JOptionPane.showMessageDialog(this,"验证错误","错误",JOptionPane.ERROR_MESSAGE);
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
