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
	
	private JLabel JLTno = new JLabel("��ʦ�ţ�");
	private JLabel JLTname = new JLabel("������");
	private JLabel JLTjob = new JLabel("ְλ��");
	private JLabel JLCname = new JLabel("�γ̣�");
	private JTextField JTTno = new JTextField();
	private JTextField JTTname = new JTextField();
	private JTextField JTTjob = new JTextField();
	private JTextField JTCname = new JTextField();
	private JButton JBTno = new JButton("����ʦ�Ų�ѯ");
	private JButton JBTname = new JButton("��������ѯ");
	private JButton JBTjob = new JButton("��ְλ��ѯ");
	private JButton JBCname = new JButton("���γ̲�ѯ");
	private JTextArea JT= new JTextArea();
	
	public SelectTea() {
		this.setTitle("��ѯ��ʦ��Ϣ");
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
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(351, 10, 314, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBTno){
			AdminDAO dao = new AdminDAO();
	        TeaBean bean = new TeaBean();
	        bean.setTno(JTTno.getText());
	        ArrayList list = dao.searchTeaById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    ��ʦ��       ����  �Ա�   ְλ    ��ϵ��ʽ   Ժϵ��  �γ���"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==JBTname){
			AdminDAO dao = new AdminDAO();
			TeaBean bean = new TeaBean();
	        bean.setTname(JTTname.getText());
	        ArrayList list = dao.searchTeaByTname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    ��ʦ��       ����  �Ա�   ְλ    ��ϵ��ʽ   Ժϵ��  �γ���"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==JBTjob){
			AdminDAO dao = new AdminDAO();
			TeaBean bean = new TeaBean();
	        bean.setTjob(JTTjob.getText());
	        ArrayList list = dao.searchTeaByTjob(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    ��ʦ��       ����  �Ա�   ְλ    ��ϵ��ʽ   Ժϵ��  �γ���"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==JBCname){
			AdminDAO dao = new AdminDAO();
			TeaBean bean = new TeaBean();
	        bean.setCname(JTCname.getText());
	        ArrayList list = dao.searchTeaByCname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˿γ̵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    ��ʦ��       ����  �Ա�   ְλ    ��ϵ��ʽ   Ժϵ��  �γ���"+"\n"+list.toString()+"\n");
	        }
		}
	}
}
	

