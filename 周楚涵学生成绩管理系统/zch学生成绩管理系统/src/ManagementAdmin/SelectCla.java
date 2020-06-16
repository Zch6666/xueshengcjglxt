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

import ManagementCon.ClaBean;
import ManagementCon.DepBean;
import ManagementCon.MajBean;


public class SelectCla extends JFrame implements ActionListener{
	
	private JLabel JLClno = new JLabel("�༶�ţ�");
	private JLabel JLClname = new JLabel("�༶����");
	private JLabel JLDname = new JLabel("Ժϵ����");
	private JLabel JLMname = new JLabel("רҵ����");
	private JLabel JLClhead = new JLabel("�����Σ�");
	private JTextField JTClno = new JTextField();
	private JTextField JTClname = new JTextField();
	private JTextField JTDname = new JTextField();
	private JTextField JTMname = new JTextField();
	private JTextField JTClhead = new JTextField();
	private JButton JBClno = new JButton("���༶�Ų�ѯ");
	private JButton JBClname = new JButton("���༶����ѯ");
	private JButton JBDname = new JButton("��Ժϵ����ѯ");
	private JButton JBMname = new JButton("��רҵ����ѯ");
	private JButton JBClhead = new JButton("�������β�ѯ");
	private JTextArea JT= new JTextArea();
	
	public SelectCla() {
		this.setTitle("��ѯ�༶��Ϣ");
		getContentPane().setLayout(null);
		JLClno.setBounds(61, 12, 64, 20);
		getContentPane().add(JLClno);
		JLClname.setBounds(61, 80, 64, 20);
		getContentPane().add(JLClname);
		JLDname.setBounds(61, 145, 64, 20);
		getContentPane().add(JLDname);
		JLMname.setBounds(61, 213, 64, 20);
		getContentPane().add(JLMname);
		JLClhead.setBounds(61, 283, 64, 20);
		getContentPane().add(JLClhead);
		JTClno.setBounds(135, 12, 121, 20);
		getContentPane().add(JTClno);
		JTClname.setBounds(135, 80, 121, 20);
		getContentPane().add(JTClname);
		JTDname.setBounds(135, 145, 121, 20);
		getContentPane().add(JTDname);
		JTMname.setBounds(135, 213, 121, 20);
		getContentPane().add(JTMname);
		JTClhead.setBounds(135, 283, 121, 20);
		getContentPane().add(JTClhead);
		JBClno.setBounds(135, 42, 121, 28);
		JBClno.addActionListener(this);
		getContentPane().add(JBClno);
		JBClname.setBounds(135, 106, 121, 29);
		JBClname.addActionListener(this);
		getContentPane().add(JBClname);
		JBDname.setBounds(135, 173, 121, 29);
		JBDname.addActionListener(this);
		getContentPane().add(JBDname);
		JBMname.setBounds(135, 242, 121, 29);
		JBMname.addActionListener(this);
		getContentPane().add(JBMname);
		JBClhead.setBounds(135, 313, 121, 29);
		JBClhead.addActionListener(this);
		getContentPane().add(JBClhead);
		this.setBounds(10, 10, 736, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(309, 11, 342, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);
			
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==JBClno){
			AdminDAO dao = new AdminDAO();
	        ClaBean bean = new ClaBean();
	        bean.setClno(JTClno.getText());
	        ArrayList list = dao.searchClaById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    Ժϵ��       רҵ��  �༶�� �༶��    ������        ��ϵ��ʽ    ���� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBClname){
			AdminDAO dao = new AdminDAO();
            ClaBean bean = new ClaBean();
	        bean.setClname(JTClname.getText());
	        ArrayList list = dao.searchClaByClname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    Ժϵ��       רҵ��  �༶�� �༶��    ������        ��ϵ��ʽ    ���� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBDname){
			AdminDAO dao = new AdminDAO();
            ClaBean bean = new ClaBean();
	        bean.setDname(JTDname.getText());
	        ArrayList list = dao.searchClaByDname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    Ժϵ��       רҵ��  �༶�� �༶��    ������        ��ϵ��ʽ    ���� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBMname){
			AdminDAO dao = new AdminDAO();
            ClaBean bean = new ClaBean();
	        bean.setMname(JTMname.getText());
	        ArrayList list = dao.searchClaByMname(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    Ժϵ��       רҵ��  �༶�� �༶��    ������        ��ϵ��ʽ    ���� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==JBClhead){
			AdminDAO dao = new AdminDAO();
			ClaBean bean = new ClaBean();
	        bean.setClhead(JTClhead.getText());
	        ArrayList list = dao.searchClaByClhead(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˰༶����Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    Ժϵ��       רҵ��  �༶�� �༶��    ������        ��ϵ��ʽ    ���� "+"\n"+list.toString());
	        }
		}
	}
}
	




