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
	private JMenu jm1 = new JMenu("   查询   ");
	private JMenuItem jmi1 = new JMenuItem("查询记录");
	private JMenu jm2 = new JMenu("   清空   ");
	private JMenuItem jmi2 = new JMenuItem("清空记录");
	private JTextArea JT= new JTextArea();
	
	public TeaRecord(){
		this.setTitle("查询清空教务的操作记录");
		getContentPane().setLayout(null);
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jm1.add(jmi1);
		jmb.add(jm2);
		jm2.add(jmi2);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);

		this.setBounds(10, 10, 525, 400);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
		this.setVisible(true);
		JT.setBounds(10, 11, 489, 320);
		JT.setLineWrap(true);//设置自动换行
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
	        	JOptionPane.showMessageDialog(this, "没有此记录", "alert",
                        JOptionPane.INFORMATION_MESSAGE);
	        }
	        else{
	        	JT.setText("   学号         班级号 成绩修改日期        修改时间"+"\n"+list.toString()+"\n");
	        }
		}
		if(e.getSource()==jmi2){
			JT.setText("");
			TeaDAO dao = new TeaDAO();
        	TeaBean bean = new TeaBean();
	        bean.setTno(Login.Tno);
	        dao.DeleteSCRecord(bean);
            JOptionPane.showMessageDialog(this,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
}

