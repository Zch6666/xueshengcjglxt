package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import ManagementCon.ConAdmDB;
import ManagementTea.TeaBean;

public class AdminRecord extends JFrame implements ActionListener{
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm1 = new JMenu("   ��ѯ��¼   ");
	private JMenuItem jmi11 = new JMenuItem("��ѯ��ѧ�����ļ�¼");
	private JMenuItem jmi12 = new JMenuItem("��ѯ����ʦ���ļ�¼");
	private JMenuItem jmi13 = new JMenuItem("��ѯ���γ̡��ļ�¼");
	private JMenuItem jmi14 = new JMenuItem("��ѯ���ڿΡ��ļ�¼");
	private JMenuItem jmi15 = new JMenuItem("��ѯ���༶���ļ�¼");
	private JMenuItem jmi16 = new JMenuItem("��ѯ��רҵ���ļ�¼");
	private JMenuItem jmi17 = new JMenuItem("��ѯ��Ժϵ���ļ�¼");
	private JMenu jm2 = new JMenu("   ��ռ�¼   ");
	private JMenuItem jmi21 = new JMenuItem("��ա�ѧ�����ļ�¼");
	private JMenuItem jmi22 = new JMenuItem("��ա���ʦ���ļ�¼");
	private JMenuItem jmi23 = new JMenuItem("��ա��γ̡��ļ�¼");
	private JMenuItem jmi24 = new JMenuItem("��ա��ڿΡ��ļ�¼");
	private JMenuItem jmi25 = new JMenuItem("��ա��༶���ļ�¼");
	private JMenuItem jmi26 = new JMenuItem("��ա�רҵ���ļ�¼");
	private JMenuItem jmi27 = new JMenuItem("��ա�Ժϵ���ļ�¼");
	private JTextArea JT= new JTextArea();
	
	public AdminRecord(){
		this.setTitle("��ѯ��ս���Ĳ�����¼");
		getContentPane().setLayout(null);
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi11);
		jm1.add(jmi12);
		jm1.add(jmi13);
		jm1.add(jmi14);
		jm1.add(jmi15);
		jm1.add(jmi16);
		jm1.add(jmi17);
		jmb.add(jm2);
		jm2.add(jmi21);
		jm2.add(jmi22);
		jm2.add(jmi23);
		jm2.add(jmi24);
		jm2.add(jmi25);
		jm2.add(jmi26);
		jm2.add(jmi27);
		jmi11.addActionListener(this);
		jmi12.addActionListener(this);
		jmi13.addActionListener(this);
		jmi14.addActionListener(this);
		jmi15.addActionListener(this);
		jmi16.addActionListener(this);
		jmi17.addActionListener(this);
		jmi21.addActionListener(this);
		jmi22.addActionListener(this);
		jmi23.addActionListener(this);
		jmi24.addActionListener(this);
		jmi25.addActionListener(this);
		jmi26.addActionListener(this);
		jmi27.addActionListener(this);

		this.setBounds(10, 10, 525, 400);
		this.setLocationRelativeTo(null);//��������Ļ�м���ʾ 
		this.setVisible(true);
		JT.setBounds(10, 11, 489, 320);
		JT.setLineWrap(true);//�����Զ�����
		getContentPane().add(JT);

	}
	public void actionPerformed(ActionEvent e){
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		int i = 0;
		if(e.getSource()==jmi11){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchStuRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("        ѧ��          ����   �Ա�           ���֤��             �༶ ��ѧʱ��        �޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi12){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchTeaRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      ��ʦ��          ����   �Ա�   ְ��   ��ϵ��ʽ      Ժϵ�� �޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi13){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchCouRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("�γ̺���     ����   ѧ��  �Ͽεص�                        �Ͽ�ʱ��                     �޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi14){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchTeachRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("      ��ʦ��      �γ̺� �޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi15){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchClaRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("�༶��   �༶��  רҵ�� ������   ��ϵ��ʽ    �����޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi16){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchMajRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("רҵ��   רҵ��  Ժϵ�� ������   ��ϵ��ʽ   �޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi17){
			AdminDAO dao = new AdminDAO();
	        ArrayList list = dao.searchDepRecord();
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("Ժϵ��   Ժϵ�� ������    ��ϵ��ʽ    �޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi21){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Stu_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi22){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Tea_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi23){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Cou_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi24){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Teach_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi25){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Cla_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi26){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Maj_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jmi27){
			JT.setText("");
			try {
				ConAdmDB cd=new ConAdmDB();
		        con=cd.toconnection();
            	String sql="delete from Dep_record";
				ps = con.prepareStatement(sql);
				i = ps.executeUpdate();
			} catch (SQLException ex) {
	            System.out.println(ex.getMessage()+"ɾ��2222");
	        }
		  JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
