package ManagementTea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ManagementCon.Login;
import ManagementStu.StuBean;
import ManagementStu.StuDAO;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class SelectGrade extends JFrame implements ActionListener{
	
	private JLabel JLSno= new JLabel("ѧ�ţ�");
	private JLabel JLSname = new JLabel("������");
	private JLabel JLClname = new JLabel("�༶��");
	private JLabel JLState = new JLabel("����������Ϣ���ɼ�״����ѯ");
	private JLabel JLState1 = new JLabel("��ѯ");
	private JLabel JLState2 = new JLabel("�� ������");
	private JLabel JLState3 = new JLabel("����");
	private JLabel JLState4 = new JLabel("��ѧ��");
	private JTextField JTSno = new JTextField();
	private JTextField JTSname = new JTextField();
	private JTextField JTClname = new JTextField();
	private JTextField JTClname2 = new JTextField();
	private JTextField JTGrade1 = new JTextField();
	private JTextField JTGrade2 = new JTextField();
	private JButton JBSno = new JButton("��ѧ�Ų�ѯ");
	private JButton JBSname = new JButton("��������ѯ");
	private JButton JBClname = new JButton("���༶��ѯ");
	private JButton JBState = new JButton("��ѯ");
	private JTextArea JT= new JTextArea();
	
	public SelectGrade() {
		this.setTitle("��ѯѧ���ɼ���Ϣ");
		getContentPane().setLayout(null);
		JLSno.setBounds(10, 40, 47, 20);
		getContentPane().add(JLSno);
		JLSname.setBounds(10, 80, 47, 20);
		getContentPane().add(JLSname);
		JLClname.setBounds(10, 121, 47, 20);
		getContentPane().add(JLClname);
		JLState.setBounds(10, 181, 174, 29);
		getContentPane().add(JLState);
		JLState1.setBounds(10, 232, 36, 20);
		getContentPane().add(JLState1);
		JTClname2.setBounds(49, 232, 82, 20);
		getContentPane().add(JTClname2);
		JLState2.setBounds(133, 232, 82, 20);
		getContentPane().add(JLState2);
		JTGrade1.setBounds(194, 232, 42, 20);
		getContentPane().add(JTGrade1);
		JLState3.setBounds(247, 232, 36, 20);
		getContentPane().add(JLState3);
		JTGrade2.setBounds(278, 232, 42, 20);
		getContentPane().add(JTGrade2);
		JLState4.setBounds(330, 232, 59, 20);
		getContentPane().add(JLState4);
		JTSno.setBounds(56, 40, 108, 20);
		getContentPane().add(JTSno);
		JTSname.setBounds(56, 80, 108, 20);
		getContentPane().add(JTSname);
		JTClname.setBounds(56, 121, 108, 20);
		getContentPane().add(JTClname);
		JBSno.setBounds(212, 36, 108, 29);
		JBSno.addActionListener(this);
		getContentPane().add(JBSno);
		JBSname.setBounds(212, 76, 108, 29);
		JBSname.addActionListener(this);
		getContentPane().add(JBSname);
		JBClname.setBounds(212, 117, 108, 29);
		JBClname.addActionListener(this);
		getContentPane().add(JBClname);
		JBState.setBounds(220, 262, 108, 29);
		JBState.addActionListener(this);
		getContentPane().add(JBState);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(421, 10, 215, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==JBSno){
			TeaDAO dao = new TeaDAO();
        	TeaBean bean1 = new TeaBean();
        	StuBean bean2 = new StuBean();
	        bean1.setTno(Login.Tno);
	        bean2.setSno(JTSno.getText());
	        ArrayList list = dao.searchScoreBySno(bean1,bean2);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    �༶                   ѧ��         ����    �ɼ�"+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBSname){
			TeaDAO dao = new TeaDAO();
        	TeaBean bean1 = new TeaBean();
        	StuBean bean2 = new StuBean();
	        bean1.setTno(Login.Tno);
	        bean2.setSname(JTSname.getText());
	        ArrayList list = dao.searchScoreBySname(bean1,bean2);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д�ѧ������Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    �༶                   ѧ��         ����    �ɼ�"+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBClname){
			TeaDAO dao = new TeaDAO();
        	TeaBean bean1 = new TeaBean();
        	StuBean bean2 = new StuBean();
	        bean1.setTno(Login.Tno);
	        bean2.setClname(JTClname.getText());
	        ArrayList list = dao.searchScoreByClname(bean1,bean2);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    �༶                   ѧ��         ����    �ɼ�"+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBState){
			TeaDAO dao = new TeaDAO();
        	TeaBean bean1 = new TeaBean();
        	StuBean bean2 = new StuBean();
        	TeaBean bean3 = new TeaBean();
        	TeaBean bean4 = new TeaBean();
	        bean1.setTno(Login.Tno);
	        bean2.setClname(JTClname2.getText());
	        bean3.setGrade(JTGrade1.getText());
	        bean4.setGrade(JTGrade2.getText());
	        ArrayList list = dao.searchScoreByGrade(bean1,bean2,bean3,bean4);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û����ص���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    �༶                   ѧ��         ����    �ɼ�"+"\n"+list.toString());
	        }
		}
	}
}
