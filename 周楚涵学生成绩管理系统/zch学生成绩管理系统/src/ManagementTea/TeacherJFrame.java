package ManagementTea;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import ManagementCon.Login;

public class TeacherJFrame extends JFrame implements ActionListener{
	
	private JMenuBar jm = new JMenuBar();
	private JMenu jm1 = new JMenu("   ��Ϣ   ");
	private JMenuItem jmi1 = new JMenuItem("������Ϣ��ѯ");
	private JMenuItem jmi2 = new JMenuItem("�ο���Ϣ��ѯ");
	private JMenuItem jmi3 = new JMenuItem("�޸�����");
	private JMenuItem jmi4 = new JMenuItem("�޸ļ�¼��ѯ");
	private JMenu jm2 = new JMenu("   �ɼ�   ");
	private JMenuItem jmi21 = new JMenuItem("��ѯ�ɼ�");
	private JMenuItem jmi22 = new JMenuItem("�޸ĳɼ�");
	private JMenuItem jmi23 = new JMenuItem("¼��ɼ�");
	private JTextArea JT= new JTextArea();
	
	
	public TeacherJFrame(){
		this.setTitle("��ʦ����");
		getContentPane().setLayout(null);
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm1.add(jmi1);
		jmi1.addActionListener(this);
		jm1.add(jmi2);
		jmi2.addActionListener(this);
		jm1.add(jmi3);
		jmi3.addActionListener(this);
		jm1.add(jmi4);
		jmi4.addActionListener(this);
		jm2.add(jmi21);
		jmi21.addActionListener(this);
		jm2.add(jmi22);
		jmi22.addActionListener(this);
		jm2.add(jmi23);
		jmi23.addActionListener(this);
		this.setBounds(10, 10, 536, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(112, 10, 294, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);

	}
	
	public void actionPerformed(ActionEvent e){
        if(e.getSource()==jmi1){
        	TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        ArrayList list = dao.searchById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("    ��ʦ��       ����   �Ա�    ְλ     ��ϵ��ʽ    Ժϵ��"+"\n"+list.toString());
	        }
		}
        if(e.getSource()==jmi2){
        	TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        ArrayList list = dao.searchCourseById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("�γ̺�  ����                    �γ�ʱ��           �γ̵ص�   ѧ�� "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==jmi3){
			new ChangeTeaPassword();
		}
		if(e.getSource()==jmi4){
			new TeaRecord();
		}
		
		if(e.getSource()==jmi21){
			new SelectGrade();
		}
        if(e.getSource()==jmi22){
			new ChangeScore();
		}
        if(e.getSource()==jmi23){
			new InsertScore();
		}
	}
	
	/*public static void main(String[] args){
		new TeacherJFrame();
	}*/

}

