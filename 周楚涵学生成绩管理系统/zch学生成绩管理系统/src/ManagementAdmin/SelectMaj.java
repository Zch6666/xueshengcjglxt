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
	
	private JLabel JLMno = new JLabel("רҵ�ţ�");
	private JLabel JLMname = new JLabel("רҵ����");
	private JLabel JLMhead = new JLabel("�����ˣ�");
	private JTextField JTMno = new JTextField();
	private JTextField JTMname = new JTextField();
	private JTextField JTMhead = new JTextField();
	private JButton JBMno = new JButton("��רҵ�Ų�ѯ");
	private JButton JBMname = new JButton("��רҵ����ѯ");
	private JButton JBMhead = new JButton("�������˲�ѯ");
	private JTextArea JT= new JTextArea();
	
	public SelectMaj() {
		this.setTitle("��ѯרҵ��Ϣ");
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
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(307, 10, 382, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBMno){
			AdminDAO dao = new AdminDAO();
	        MajBean bean = new MajBean();
	        bean.setMno(JTMno.getText());
	        ArrayList list = dao.searchMajById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�רҵ����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" רҵ����    Ժϵ��  ������      ��ϵ��ʽ "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBMname){
			AdminDAO dao = new AdminDAO();
            MajBean bean = new MajBean();
	        bean.setMname(JTMname.getText());
	        ArrayList list = dao.searchMajByMname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�רҵ����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" רҵ����    Ժϵ��  ������      ��ϵ��ʽ "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBMhead){
			AdminDAO dao = new AdminDAO();
			MajBean bean = new MajBean();
	        bean.setMhead(JTMhead.getText());
	        ArrayList list = dao.searchMajByMhead(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�רҵ����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText(" רҵ����    Ժϵ��  ������      ��ϵ��ʽ "+"\n"+list.toString());
	        }
		}
	}
}
	



