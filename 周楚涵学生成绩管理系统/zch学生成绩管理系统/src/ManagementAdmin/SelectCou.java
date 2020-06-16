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

import ManagementCon.CouBean;
import ManagementCon.DepBean;


public class SelectCou extends JFrame implements ActionListener{
	
	private JLabel JLCno = new JLabel("课程号：");
	private JLabel JLCname = new JLabel("课程名：");
	private JLabel JLTname = new JLabel("教师名：");
	private JTextField JTCno = new JTextField();
	private JTextField JTCname = new JTextField();
	private JTextField JTTname = new JTextField();
	private JButton JBCno = new JButton("按课程号查询");
	private JButton JBCname = new JButton("按课程名查询");
	private JButton JBTname = new JButton("按教师名查询");
	private JTextArea JT= new JTextArea();
	
	public SelectCou() {
		this.setTitle("查询课程信息");
		getContentPane().setLayout(null);
		JLCno.setBounds(10, 28, 64, 20);
		getContentPane().add(JLCno);
		JLCname.setBounds(10, 148, 64, 20);
		getContentPane().add(JLCname);
		JLTname.setBounds(10, 257, 64, 20);
		getContentPane().add(JLTname);
		JTCno.setBounds(60, 28, 123, 20);
		getContentPane().add(JTCno);
		JTCname.setBounds(60, 148, 123, 20);
		getContentPane().add(JTCname);
		JTTname.setBounds(60, 257, 123, 20);
		getContentPane().add(JTTname);
		JBCno.setBounds(61, 58, 122, 29);
		JBCno.addActionListener(this);
		getContentPane().add(JBCno);
		JBCname.setBounds(60, 178, 123, 29);
		JBCname.addActionListener(this);
		getContentPane().add(JBCname);
		JBTname.setBounds(60, 287, 123, 29);
		JBTname.addActionListener(this);
		getContentPane().add(JBTname);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(201, 10, 488, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBCno){
			AdminDAO dao = new AdminDAO();
	        CouBean bean = new CouBean();
	        bean.setCno(JTCno.getText());
	        ArrayList list = dao.searchCouById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此课程的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      教师号         姓名 课程号        课程                         课程时间                        课程地点  学分 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBCname){
			AdminDAO dao = new AdminDAO();
			CouBean bean = new CouBean();
	        bean.setCname(JTCname.getText());
	        ArrayList list = dao.searchCouByCname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此课程的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      教师号         姓名 课程号        课程                         课程时间                        课程地点  学分 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBTname){
			AdminDAO dao = new AdminDAO();
			CouBean bean = new CouBean();
	        bean.setTname(JTTname.getText());
	        ArrayList list = dao.searchCouByTname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此课程的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      教师号         姓名 课程号        课程                         课程时间                        课程地点  学分 "+"\n"+list.toString());
	        }
		}
	}
}
	



