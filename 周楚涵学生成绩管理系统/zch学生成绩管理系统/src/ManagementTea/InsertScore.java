package ManagementTea;

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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ManagementCon.ConAdmDB;
import ManagementCon.ConTeaDB;
import ManagementCon.Login;

public class InsertScore extends JFrame implements ActionListener{
	private JLabel JL = new JLabel("录    入    成    绩",JLabel.CENTER);
	private JLabel JLSno = new JLabel("学号：");
	private JTextField JTSno = new JTextField();
	private JLabel JLCno = new JLabel("课程号：");
	private JTextField JTCno = new JTextField();
	private JLabel JLScore = new JLabel("成绩：");
	private JTextField JTScore = new JTextField();
	private JButton JBSet = new JButton("录入");
	private JButton JBCancel = new JButton("取消");
	private String sql="";
	
	public InsertScore(){
		this.setTitle("录入成绩");
		getContentPane().setLayout(null);
		JL.setBounds(100, 30, 200, 40);
		getContentPane().add(JL);
		JLSno.setBounds(100, 102, 54, 20);
		getContentPane().add(JLSno);
		JTSno.setBounds(164, 102, 157, 20);
		getContentPane().add(JTSno);
		JLCno.setBounds(100, 158, 54, 20);
		getContentPane().add(JLCno);
		JTCno.setBounds(164, 158, 157, 20);
		getContentPane().add(JTCno);
		JLScore.setBounds(100, 210, 81, 20);
		getContentPane().add(JLScore);
		JTScore.setBounds(164, 210, 157, 20);
		getContentPane().add(JTScore);
		JBSet.setBounds(128, 285, 90, 20);
		getContentPane().add(JBSet);
		JBSet.addActionListener(this);
		JBCancel.setBounds(253, 285, 90, 20);
		getContentPane().add(JBCancel);
		JBCancel.addActionListener(this);
		this.setVisible(true);
		this.setBounds(10, 10, 500, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
	}
	
	public void actionPerformed(ActionEvent e){
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		int i = 0;
		if(e.getSource()==JBSet){
			String sSno=JTSno.getText();
			String sCno=JTCno.getText();
			String sScore=JTScore.getText();
			if(sSno.equals("")||sCno.equals("")||sScore.equals("")){
				JOptionPane.showMessageDialog(this,"请输入完整信息","错误",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					ConAdmDB cd=new ConAdmDB();
			        con=cd.toconnection();
					String sql="insert into SC values('"+sSno+"','"+sCno+"','"+sScore+"')";
					ps = con.prepareStatement(sql);
					i = ps.executeUpdate();
					JOptionPane.showMessageDialog(this,"录入成功","提示",JOptionPane.INFORMATION_MESSAGE);
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
