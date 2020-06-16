package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ManagementTea.TeaBean;



public class SelectTea extends JFrame implements ActionListener{
	
	private JLabel JLTno = new JLabel("教师号：");
	private JLabel JLTname = new JLabel("姓名：");
	private JLabel JLTjob = new JLabel("职位：");
	private JLabel JLCname = new JLabel("课程：");
	private JTextField JTTno = new JTextField();
	private JTextField JTTname = new JTextField();
	private JTextField JTTjob = new JTextField();
	private JTextField JTCname = new JTextField();
	private JButton JBTno = new JButton("按教师号查询");
	private JButton JBTname = new JButton("按姓名查询");
	private JButton JBTjob = new JButton("按职位查询");
	private JButton JBCname = new JButton("按课程查询");
	private JTextArea JT= new JTextArea();
	
	public SelectTea() {
		this.setTitle("查询教师信息");
		getContentPane().setLayout(null);
		JLTno.setBounds(10, 28, 64, 20);
		getContentPane().add(JLTno);
		JLTname.setBounds(10, 108, 48, 20);
		getContentPane().add(JLTname);
		JLTjob.setBounds(10, 188, 48, 20);
		getContentPane().add(JLTjob);
		JLCname.setBounds(10, 271, 48, 20);
		getContentPane().add(JLCname);
		JTTno.setBounds(60, 28, 108, 20);
		getContentPane().add(JTTno);
		JTTname.setBounds(60, 108, 108, 20);
		getContentPane().add(JTTname);
		JTTjob.setBounds(60, 188, 108, 20);
		getContentPane().add(JTTjob);
		JTCname.setBounds(60, 271, 108, 20);
		getContentPane().add(JTCname);
		JBTno.setBounds(181, 24, 108, 29);
		JBTno.addActionListener(this);
		getContentPane().add(JBTno);
		JBTname.setBounds(181, 104, 108, 29);
		JBTname.addActionListener(this);
		getContentPane().add(JBTname);
		JBTjob.setBounds(181, 184, 108, 29);
		JBTjob.addActionListener(this);
		getContentPane().add(JBTjob);
		JBCname.setBounds(181, 267, 108, 29);
		JBCname.addActionListener(this);
		getContentPane().add(JBCname);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(351, 10, 314, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBTno){
			AdminDAO dao = new AdminDAO();
	        TeaBean bean = new TeaBean();
	        bean.setTno(JTTno.getText());
	        ArrayList list = dao.searchTeaById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    教师号       姓名  性别   职位    联系方式   院系号  课程名"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==JBTname){
			AdminDAO dao = new AdminDAO();
			TeaBean bean = new TeaBean();
	        bean.setTname(JTTname.getText());
	        ArrayList list = dao.searchTeaByTname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此人的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    教师号       姓名  性别   职位    联系方式   院系号  课程名"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==JBTjob){
			AdminDAO dao = new AdminDAO();
			TeaBean bean = new TeaBean();
	        bean.setTjob(JTTjob.getText());
	        ArrayList list = dao.searchTeaByTjob(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此班级的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    教师号       姓名  性别   职位    联系方式   院系号  课程名"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==JBCname){
			AdminDAO dao = new AdminDAO();
			TeaBean bean = new TeaBean();
	        bean.setCname(JTCname.getText());
	        ArrayList list = dao.searchTeaByCname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此课程的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    教师号       姓名  性别   职位    联系方式   院系号  课程名"+"\n"+list.toString()+"\n");
	        }
		}
	}
}
	

