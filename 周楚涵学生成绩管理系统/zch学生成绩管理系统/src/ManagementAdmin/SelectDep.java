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

import ManagementCon.DepBean;


public class SelectDep extends JFrame implements ActionListener{
	
	private JLabel JLDno = new JLabel("院系号：");
	private JLabel JLDname = new JLabel("院系名：");
	private JLabel JLDhead = new JLabel("负责人：");
	private JTextField JTDno = new JTextField();
	private JTextField JTDname = new JTextField();
	private JTextField JTDhead = new JTextField();
	private JButton JBDno = new JButton("按院系号查询");
	private JButton JBDname = new JButton("按院系名查询");
	private JButton JBDhead = new JButton("按负责人查询");
	private JTextArea JT= new JTextArea();
	
	public SelectDep() {
		this.setTitle("查询院系信息");
		getContentPane().setLayout(null);
		JLDno.setBounds(19, 28, 64, 20);
		getContentPane().add(JLDno);
		JLDname.setBounds(19, 148, 48, 20);
		getContentPane().add(JLDname);
		JLDhead.setBounds(19, 257, 48, 20);
		getContentPane().add(JLDhead);
		JTDno.setBounds(93, 28, 108, 20);
		getContentPane().add(JTDno);
		JTDname.setBounds(93, 148, 108, 20);
		getContentPane().add(JTDname);
		JTDhead.setBounds(93, 257, 108, 20);
		getContentPane().add(JTDhead);
		JBDno.setBounds(81, 58, 119, 29);
		JBDno.addActionListener(this);
		getContentPane().add(JBDno);
		JBDname.setBounds(81, 178, 120, 29);
		JBDname.addActionListener(this);
		getContentPane().add(JBDname);
		JBDhead.setBounds(81, 287, 120, 29);
		JBDhead.addActionListener(this);
		getContentPane().add(JBDhead);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(239, 10, 450, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBDno){
			AdminDAO dao = new AdminDAO();
	        DepBean bean = new DepBean();
	        bean.setDno(JTDno.getText());
	        ArrayList list = dao.searchDepById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此院系的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" 院系号   院系名      负责人      联系方式 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBDname){
			AdminDAO dao = new AdminDAO();
			DepBean bean = new DepBean();
	        bean.setDname(JTDname.getText());
	        ArrayList list = dao.searchDepByDname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此院系的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" 院系号   院系名      负责人      联系方式 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBDhead){
			AdminDAO dao = new AdminDAO();
			DepBean bean = new DepBean();
	        bean.setDhead(JTDhead.getText());
	        ArrayList list = dao.searchDepByDhead(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此院系的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" 院系号   院系名      负责人      联系方式 "+"\n"+list.toString());
	        }
		}
	}
}
	


