package ManagementStu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import ManagementCon.Login;

public class StudentJFrame extends JFrame implements ActionListener{
	
	private JMenuBar jm = new JMenuBar();
	private JMenu jm1 = new JMenu("   信息   ");
	private JMenuItem jmi1 = new JMenuItem("个人信息查询");
	private JMenuItem jmi2 = new JMenuItem("修改密码");
	private JMenu jm2 = new JMenu("   成绩   ");
	private JMenuItem jmi21 = new JMenuItem("成绩查询");
	private JMenu jm3 = new JMenu("   课程   ");
	private JMenuItem jmi31 = new JMenuItem("课程查询");
	private JTextArea JT= new JTextArea();
	
	
	public StudentJFrame(){
		this.setTitle("学生界面");
		getContentPane().setLayout(null);
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm.add(jm3);
		jm1.add(jmi1);
		jmi1.addActionListener(this);
		jm1.add(jmi2);
		jmi2.addActionListener(this);
		jm2.add(jmi21);
		jmi21.addActionListener(this);
		jm3.add(jmi31);
		jmi31.addActionListener(this);
		this.setBounds(10, 10, 536, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(10, 10, 512, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jmi2){
			new ChangeStuPassword();
		}
		if(e.getSource()==jmi1){
			StuDAO dao = new StuDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(Login.Sno);
	        ArrayList list = dao.searchById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        学号            姓名   性别         身份证号                 入学时间             班级          专业          系别        "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==jmi31){
			StuDAO dao = new StuDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(Login.Sno);
	        ArrayList list = dao.searchCourseById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	String str[]=list.toString().split("\t");
	        	JT.setText("  课程                            课程时间               课程地点      教师      学分"+"\n"+str[0]+"\n"+str[1]+"\n"
	        	+str[2]+"\n"+str[3]);
	        }
		}
		if(e.getSource()==jmi21){
			StuDAO dao = new StuDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(Login.Sno);
	        ArrayList list = dao.searchScoreById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	String str[]=list.toString().split("\t");
	        	JT.setText("        课程            成绩   学分                                                                                                                                "+str[0]+"\n"+"        "+str[1]+"\n"+"        "+str[2]+"\n"+"        "+str[3]);
	        }
		}
	}
	
	/*public static void main(String[] args){
		new StudentJFrame();
	}*/

}
