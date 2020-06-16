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
	
	private JLabel JLCno = new JLabel("�γ̺ţ�");
	private JLabel JLCname = new JLabel("�γ�����");
	private JLabel JLTname = new JLabel("��ʦ����");
	private JTextField JTCno = new JTextField();
	private JTextField JTCname = new JTextField();
	private JTextField JTTname = new JTextField();
	private JButton JBCno = new JButton("���γ̺Ų�ѯ");
	private JButton JBCname = new JButton("���γ�����ѯ");
	private JButton JBTname = new JButton("����ʦ����ѯ");
	private JTextArea JT= new JTextArea();
	
	public SelectCou() {
		this.setTitle("��ѯ�γ���Ϣ");
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
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(201, 10, 488, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBCno){
			AdminDAO dao = new AdminDAO();
	        CouBean bean = new CouBean();
	        bean.setCno(JTCno.getText());
	        ArrayList list = dao.searchCouById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˿γ̵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      ��ʦ��         ���� �γ̺�        �γ�                         �γ�ʱ��                        �γ̵ص�  ѧ�� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBCname){
			AdminDAO dao = new AdminDAO();
			CouBean bean = new CouBean();
	        bean.setCname(JTCname.getText());
	        ArrayList list = dao.searchCouByCname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˿γ̵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      ��ʦ��         ���� �γ̺�        �γ�                         �γ�ʱ��                        �γ̵ص�  ѧ�� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBTname){
			AdminDAO dao = new AdminDAO();
			CouBean bean = new CouBean();
	        bean.setTname(JTTname.getText());
	        ArrayList list = dao.searchCouByTname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˿γ̵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      ��ʦ��         ���� �γ̺�        �γ�                         �γ�ʱ��                        �γ̵ص�  ѧ�� "+"\n"+list.toString());
	        }
		}
	}
}
	



