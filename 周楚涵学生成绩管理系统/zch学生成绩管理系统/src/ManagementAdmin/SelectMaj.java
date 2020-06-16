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
import ManagementCon.MajBean;


public class SelectMaj extends JFrame implements ActionListener{
	
	private JLabel JLMno = new JLabel("专业号：");
	private JLabel JLMname = new JLabel("专业名：");
	private JLabel JLMhead = new JLabel("负责人：");
	private JTextField JTMno = new JTextField();
	private JTextField JTMname = new JTextField();
	private JTextField JTMhead = new JTextField();
	private JButton JBMno = new JButton("按专业号查询");
	private JButton JBMname = new JButton("按专业名查询");
	private JButton JBMhead = new JButton("按负责人查询");
	private JTextArea JT= new JTextArea();
	
	public SelectMaj() {
		this.setTitle("查询专业信息");
		getContentPane().setLayout(null);
		JLMno.setBounds(10, 28, 64, 20);
		getContentPane().add(JLMno);
		JLMname.setBounds(10, 148, 64, 20);
		getContentPane().add(JLMname);
		JLMhead.setBounds(10, 257, 64, 20);
		getContentPane().add(JLMhead);
		JTMno.setBounds(60, 28, 108, 20);
		getContentPane().add(JTMno);
		JTMname.setBounds(60, 148, 108, 20);
		getContentPane().add(JTMname);
		JTMhead.setBounds(60, 257, 108, 20);
		getContentPane().add(JTMhead);
		JBMno.setBounds(173, 24, 124, 29);
		JBMno.addActionListener(this);
		getContentPane().add(JBMno);
		JBMname.setBounds(172, 144, 125, 29);
		JBMname.addActionListener(this);
		getContentPane().add(JBMname);
		JBMhead.setBounds(175, 253, 124, 29);
		JBMhead.addActionListener(this);
		getContentPane().add(JBMhead);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(307, 10, 382, 320);
		JT.setLineWrap(true);//设置自动换行
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBMno){
			AdminDAO dao = new AdminDAO();
	        MajBean bean = new MajBean();
	        bean.setMno(JTMno.getText());
	        ArrayList list = dao.searchMajById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此专业的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" 专业号名    院系号  负责人      联系方式 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBMname){
			AdminDAO dao = new AdminDAO();
            MajBean bean = new MajBean();
	        bean.setMname(JTMname.getText());
	        ArrayList list = dao.searchMajByMname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此专业的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" 专业号名    院系号  负责人      联系方式 "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBMhead){
			AdminDAO dao = new AdminDAO();
			MajBean bean = new MajBean();
	        bean.setMhead(JTMhead.getText());
	        ArrayList list = dao.searchMajByMhead(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "没有此专业的信息", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" 专业号名    院系号  负责人      联系方式 "+"\n"+list.toString());
	        }
		}
	}
}
	



