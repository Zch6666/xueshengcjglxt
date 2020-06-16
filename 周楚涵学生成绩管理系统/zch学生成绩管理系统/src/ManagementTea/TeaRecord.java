package ManagementTea;

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

import ManagementCon.ConTeaDB;
import ManagementCon.Login;
import ManagementStu.StuBean;
import ManagementTea.TeaBean;

public class TeaRecord extends JFrame implements ActionListener{
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm1 = new JMenu("   ��ѯ   ");
	private JMenuItem jmi1 = new JMenuItem("��ѯ��¼");
	private JMenu jm2 = new JMenu("   ���   ");
	private JMenuItem jmi2 = new JMenuItem("��ռ�¼");
	private JTextArea JT= new JTextArea();
	
	public TeaRecord(){
		this.setTitle("��ѯ��ս���Ĳ�����¼");
		getContentPane().setLayout(null);
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jmb.add(jm2);
		jm2.add(jmi2);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);

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
		int i = 0;
		if(e.getSource()==jmi1){
			TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        ArrayList list = dao.searchSCRecord(bean);
	        if (list.size() == 0) {
	        	JOptionPane.showMessageDialog(this, "û�д˼�¼", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("   ѧ��         �༶�� �ɼ��޸�����        �޸�ʱ��"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi2){
			JT.setText("");
			TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        dao.DeleteSCRecord(bean);
            JOptionPane.showMessageDialog(this,"ɾ���ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
}

