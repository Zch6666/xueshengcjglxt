package ManagementTea;

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

public class TeacherJFrame extends JFrame implements ActionListener{
	
	private JMenuBar jm = new JMenuBar();
	private JMenu jm1 = new JMenu("   信息   ");
	private JMenuItem jmi1 = new JMenuItem("个人信息查询");
	private JMenuItem jmi2 = new JMenuItem("任课信息查询");
	private JMenuItem jmi3 = new JMenuItem("修改密码");
	private JMenuItem jmi4 = new JMenuItem("修改记录查询");
	private JMenu jm2 = new JMenu("   成绩   ");
	private JMenuItem jmi21 = new JMenuItem("查询成绩");
	private JMenuItem jmi22 = new JMenuItem("修改成绩");
	private JMenuItem jmi23 = new JMenuItem("录入成绩");
	private JTextArea JT= new JTextArea();
	
	
	public TeacherJFrame(){
		this.setTitle("教师界面");
		getContentPane().setLayout(null);
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm1.add(jmi1);
		jmi1.addActionListener(this);
		jm1.add(jmi2);
		jmi2.addActionListener(this);
		jm1.add(jmi3);
		jmi3.addActionListener(this);
		jm1.add(jmi4);
		jmi4.addActionListener(this);
		jm2.add(jmi21);
		jmi21.addActionListener(this);
		jm2.add(jmi22);
		jmi22.addActionListener(this);
		jm2.add(jmi23);
		jmi23.addActionListener(this);
		this.setBounds(10, 10, 536, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(112, 10, 294, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);

	}
	
	public void actionPerformed(ActionEvent e){
        if(e.getSource()==jmi1){
        	TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        ArrayList list = dao.searchById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    教师号       姓名   性别    职位     联系方式    院系号"+"\n"+list.toString());
	        }
		}
        if(e.getSource()==jmi2){
        	TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        ArrayList list = dao.searchCourseById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("课程号  课名                    课程时间           课程地点   学分 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==jmi3){
			new ChangeTeaPassword();
		}
		if(e.getSource()==jmi4){
			new TeaRecord();
		}
		
		if(e.getSource()==jmi21){
			new SelectGrade();
		}
        if(e.getSource()==jmi22){
			new ChangeScore();
		}
        if(e.getSource()==jmi23){
			new InsertScore();
		}
	}
	
	/*public static void main(String[] args){
		new TeacherJFrame();
	}*/

}

