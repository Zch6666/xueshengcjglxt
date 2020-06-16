package ManagementStu;

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

public class StudentJFrame extends JFrame implements ActionListener{
	
	private JMenuBar jm = new JMenuBar();
	private JMenu jm1 = new JMenu("   ��Ϣ   ");
	private JMenuItem jmi1 = new JMenuItem("������Ϣ��ѯ");
	private JMenuItem jmi2 = new JMenuItem("�޸�����");
	private JMenu jm2 = new JMenu("   �ɼ�   ");
	private JMenuItem jmi21 = new JMenuItem("�ɼ���ѯ");
	private JMenu jm3 = new JMenu("   �γ�   ");
	private JMenuItem jmi31 = new JMenuItem("�γ̲�ѯ");
	private JTextArea JT= new JTextArea();
	
	
	public StudentJFrame(){
		this.setTitle("ѧ������");
		getContentPane().setLayout(null);
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm.add(jm3);
		jm1.add(jmi1);
		jmi1.addActionListener(this);
		jm1.add(jmi2);
		jmi2.addActionListener(this);
		jm2.add(jmi21);
		jmi21.addActionListener(this);
		jm3.add(jmi31);
		jmi31.addActionListener(this);
		this.setBounds(10, 10, 536, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(10, 10, 512, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jmi2){
			new ChangeStuPassword();
		}
		if(e.getSource()==jmi1){
			StuDAO dao = new StuDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(Login.Sno);
	        ArrayList list = dao.searchById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��            ����   �Ա�         ���֤��                 ��ѧʱ��             �༶          רҵ          ϵ��        "+"\n"+list.toString());
	        }
		}
		if(e.getSource()==jmi31){
			StuDAO dao = new StuDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(Login.Sno);
	        ArrayList list = dao.searchCourseById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	String str[]=list.toString().split("\t");
	        	JT.setText("  �γ�                            �γ�ʱ��               �γ̵ص�      ��ʦ      ѧ��"+"\n"+str[0]+"\n"+str[1]+"\n"
	        	+str[2]+"\n"+str[3]);
	        }
		}
		if(e.getSource()==jmi21){
			StuDAO dao = new StuDAO();
	        StuBean bean = new StuBean();
	        bean.setSno(Login.Sno);
	        ArrayList list = dao.searchScoreById(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д��˵���Ϣ", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	String str[]=list.toString().split("\t");
	        	JT.setText("        �γ�            �ɼ�   ѧ��                                                                                                                                "+str[0]+"\n"+"        "+str[1]+"\n"+"        "+str[2]+"\n"+"        "+str[3]);
	        }
		}
	}
	
	/*public static void main(String[] args){
		new StudentJFrame();
	}*/

}
