package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ManagementStu.StuBean;
import ManagementStu.StuDAO;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class SelectStu extends JFrame implements ActionListener{
	
	private JLabel JLSno = new JLabel("ѧ�ţ�");
	private JLabel JLSname = new JLabel("������");
	private JLabel JLClname = new JLabel("�༶��");
	private JLabel JLCname = new JLabel("�γ̣�");
	private JLabel JLStime = new JLabel("��ѧʱ�䣺");
	private JTextField JTSno = new JTextField();
	private JTextField JTSname = new JTextField();
	private JTextField JTClname = new JTextField();
	private JTextField JTCname = new JTextField();
	private JTextField JTStime = new JTextField();
	private JButton JBSno = new JButton("��ѧ�Ų�ѯ");
	private JButton JBSname = new JButton("��������ѯ");
	private JButton JBClname = new JButton("���༶��ѯ");
	private JButton JBCname = new JButton("���γ̲�ѯ");
	private JButton JBStime = new JButton("����ѧʱ���ѯ");
	private JTextArea JT= new JTextArea();
	
	public SelectStu() {
		this.setTitle("��ѯѧ����Ϣ");
		getContentPane().setLayout(null);
		JLSno.setBounds(10, 11, 55, 20);
		getContentPane().add(JLSno);
		JLSname.setBounds(10, 80, 55, 20);
		getContentPane().add(JLSname);
		JLClname.setBounds(10, 149, 55, 20);
		getContentPane().add(JLClname);
		JLCname.setBounds(10, 218, 55, 20);
		getContentPane().add(JLCname);
		JLStime.setBounds(0, 287, 66, 20);
		getContentPane().add(JLStime);
		JTSno.setBounds(60, 11, 108, 20);
		getContentPane().add(JTSno);
		JTSname.setBounds(60, 80, 108, 20);
		getContentPane().add(JTSname);
		JTClname.setBounds(60, 149, 108, 20);
		getContentPane().add(JTClname);
		JTCname.setBounds(60, 218, 108, 20);
		getContentPane().add(JTCname);
		JTStime.setBounds(60, 287, 108, 20);
		getContentPane().add(JTStime);
		JBSno.setBounds(60, 41, 108, 29);
		JBSno.addActionListener(this);
		getContentPane().add(JBSno);
		JBSname.setBounds(60, 110, 108, 29);
		JBSname.addActionListener(this);
		getContentPane().add(JBSname);
		JBClname.setBounds(60, 179, 108, 29);
		JBClname.addActionListener(this);
		getContentPane().add(JBClname);
		JBCname.setBounds(60, 248, 108, 29);
		JBCname.addActionListener(this);
		getContentPane().add(JBCname);
		JBStime.setBounds(51, 317, 117, 29);
		JBStime.addActionListener(this);
		getContentPane().add(JBStime);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(178, 10, 511, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBSno){
			AdminDAO dao = new AdminDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(JTSno.getText());
	        ArrayList list = dao.searchStuById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��            ����   �Ա�         ���֤��                 ��ѧʱ��             �༶          רҵ          ϵ��        "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBSname){
			AdminDAO dao = new AdminDAO();
	        StuBean bean = new StuBean();
	        bean.setSname(JTSname.getText());
	        ArrayList list = dao.searchStuBySname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��            ����   �Ա�         ���֤��                 ��ѧʱ��             �༶          רҵ          ϵ��        "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBClname){
			AdminDAO dao = new AdminDAO();
	        StuBean bean = new StuBean();
	        bean.setClname(JTClname.getText());
	        ArrayList list = dao.searchStuByClass(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��            ����   �Ա�         ���֤��                 ��ѧʱ��             �༶          רҵ          ϵ��        "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBCname){
			AdminDAO dao = new AdminDAO();
	        StuBean bean = new StuBean();
	        bean.setCname(JTCname.getText());
	        ArrayList list = dao.searchStuByCname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��            ����   �Ա�         ���֤��                 ��ѧʱ��             �༶          רҵ          ϵ��        "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBStime){
			AdminDAO dao = new AdminDAO();
	        StuBean bean = new StuBean();
	        bean.setStime(JTStime.getText());
	        ArrayList list = dao.searchStuByStime(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��            ����   �Ա�         ���֤��                 ��ѧʱ��             �༶          רҵ          ϵ��        "+"\n"+list.toString());
	        }
		}
	}
}
	

