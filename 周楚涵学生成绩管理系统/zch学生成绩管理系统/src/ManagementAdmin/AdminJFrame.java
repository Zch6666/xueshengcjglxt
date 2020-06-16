package ManagementAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import ManagementCon.Login;

public class AdminJFrame extends JFrame implements ActionListener{
	
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm = new JMenu("   个人   ");
	private JMenuItem jmi1 = new JMenuItem("修改密码");
	private JMenuItem jmi2 = new JMenuItem("修改删除的记录");
	private JButton JB11 = new JButton("查询信息");
	private JButton JB12 = new JButton("修改信息");
	private JButton JB13 = new JButton("添加信息");
	private JButton JB14 = new JButton("删除信息");
	private JButton JB21 = new JButton("查询信息");
	private JButton JB22 = new JButton("修改信息");
	private JButton JB23 = new JButton("添加信息");
	private JButton JB24 = new JButton("删除信息");
	private JButton JB31 = new JButton("查询信息");
	private JButton JB32 = new JButton("修改信息");
	private JButton JB33 = new JButton("添加信息");
	private JButton JB34 = new JButton("删除信息");
	private JButton JB41 = new JButton("查询信息");
	private JButton JB42 = new JButton("修改信息");
	private JButton JB43 = new JButton("添加信息");
	private JButton JB44 = new JButton("删除信息");
	private JButton JB51 = new JButton("查询信息");
	private JButton JB52 = new JButton("修改信息");
	private JButton JB53 = new JButton("添加信息");
	private JButton JB54 = new JButton("删除信息");
	private JButton JB61 = new JButton("查询信息");
	private JButton JB62 = new JButton("修改信息");
	private JButton JB63 = new JButton("添加信息");
	private JButton JB64 = new JButton("删除信息");
	private JPanel JP1 =new JPanel();
	private JPanel JP2 =new JPanel();
	private JPanel JP3 =new JPanel();
	private JPanel JP4 =new JPanel();
	private JPanel JP5 =new JPanel();
	private JPanel JP6 =new JPanel();
	
	public AdminJFrame(){
		this.setTitle("教务管理界面");
		getContentPane().setLayout(null);
		this.setJMenuBar(jmb);
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		JB11.setBounds(51, 60, 81, 23);
		JB12.setBounds(51, 91, 81, 20);
		JB13.setBounds(51, 135, 81, 20);
		JB14.setBounds(51, 167, 81, 20);
		JB21.setBounds(142, 43, 81, 23);
		JB22.setBounds(142, 90, 80, 22);
		JB23.setBounds(142, 135, 82, 23);
		JB24.setBounds(142, 176, 82, 20);
		JB31.setBounds(233, 44, 82, 23);
		JB32.setBounds(234, 91, 81, 20);
		JB33.setBounds(234, 135, 81, 20);
		JB34.setBounds(234, 176, 81, 20);
		JB41.setBounds(325, 44, 81, 23);
		JB42.setBounds(325, 91, 81, 20);
		JB43.setBounds(325, 135, 81, 20);
		JB44.setBounds(325, 176, 81, 20);
		JB51.setBounds(400, 44, 81, 23);
		JB52.setBounds(400, 91, 81, 20);
		JB53.setBounds(400, 135, 81, 20);
		JB54.setBounds(400, 176, 81, 20);
		JB61.setBounds(500, 44, 81, 23);
		JB62.setBounds(500, 91, 81, 20);
		JB63.setBounds(500, 135, 81, 20);
		JB64.setBounds(500, 176, 81, 20);
		
		JP1.setBounds(10, 10, 104, 241);
		JP2.setBounds(113, 10, 104, 241);
		JP3.setBounds(217, 10, 104, 241);
		JP4.setBounds(320, 10, 104, 241);
		JP5.setBounds(420, 10, 104, 241);
		JP6.setBounds(520, 10, 104, 241);
		
		TitledBorder JB1Border = new TitledBorder("学生管理");
		TitledBorder JB2Border = new TitledBorder("教师管理");
		TitledBorder JB3Border = new TitledBorder("院系管理");
		TitledBorder JB4Border = new TitledBorder("专业管理");
		TitledBorder JB5Border = new TitledBorder("课程管理");
		TitledBorder JB6Border = new TitledBorder("班级管理");
		
		JP1.setBorder(JB1Border);
		JP2.setBorder(JB2Border);
		JP3.setBorder(JB3Border);
		JP4.setBorder(JB4Border);
		JP5.setBorder(JB5Border);
		JP6.setBorder(JB6Border);
		
		JP1.add(JB11);
		JP1.add(JB12);
		JP1.add(JB13);
		JP1.add(JB14);
		JP2.add(JB21);
		JP2.add(JB22);
		JP2.add(JB23);
		JP2.add(JB24);
		JP3.add(JB31);
		JP3.add(JB32);
		JP3.add(JB33);
		JP3.add(JB34);
		JP4.add(JB41);
		JP4.add(JB42);
		JP4.add(JB43);
		JP4.add(JB44);
		JP5.add(JB51);
		JP5.add(JB52);
		JP5.add(JB53);
		JP5.add(JB54);
		JP6.add(JB61);
		JP6.add(JB62);
		JP6.add(JB63);
		JP6.add(JB64);
		
		getContentPane().add(JP1);
		getContentPane().add(JP2);
		getContentPane().add(JP3);
		getContentPane().add(JP4);
		getContentPane().add(JP5);
		getContentPane().add(JP6);
		
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		JB11.addActionListener(this);
		JB12.addActionListener(this);
		JB13.addActionListener(this);
		JB14.addActionListener(this);
		JB21.addActionListener(this);
		JB22.addActionListener(this);
		JB23.addActionListener(this);
		JB24.addActionListener(this);
		JB31.addActionListener(this);
		JB32.addActionListener(this);
		JB33.addActionListener(this);
		JB34.addActionListener(this);
		JB41.addActionListener(this);
		JB42.addActionListener(this);
		JB43.addActionListener(this);
		JB44.addActionListener(this);
		JB51.addActionListener(this);
		JB52.addActionListener(this);
		JB53.addActionListener(this);
		JB54.addActionListener(this);
		JB61.addActionListener(this);
		JB62.addActionListener(this);
		JB63.addActionListener(this);
		JB64.addActionListener(this);
		
		this.setVisible(true);
		this.setBounds(10, 10, 654, 323);
		this.setLocationRelativeTo(null);//窗口在屏幕中间显示 
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jmi1){
			new ChangeAdminPassword();
		}
		if(e.getSource()==jmi2){
			new AdminRecord();
		}
		if(e.getSource()==JB11){
			new SelectStu();
		}
		if(e.getSource()==JB12){
			new ChangeStu();
		}
		if(e.getSource()==JB13){
			new AddStu();
		}
		if(e.getSource()==JB14){
			new DeleteStu();
		}
		if(e.getSource()==JB21){
			new SelectTea();
		}
		if(e.getSource()==JB22){
			new ChangeTea();
		}
		if(e.getSource()==JB23){
			new AddTea();
		}
		if(e.getSource()==JB24){
			new DeleteTea();
		}
		if(e.getSource()==JB31){
			new SelectDep();
		}
		if(e.getSource()==JB32){
			new ChangeDep();
		}
		if(e.getSource()==JB33){
			new AddDep();
		}
		if(e.getSource()==JB34){
			new DeleteDep();
		}
		if(e.getSource()==JB41){
			new SelectMaj();
		}
		if(e.getSource()==JB42){
			new ChangeMaj();
		}
		if(e.getSource()==JB43){
			new AddMaj();
		}
		if(e.getSource()==JB44){
			new DeleteMaj();
		}
		if(e.getSource()==JB51){
			new SelectCou();
		}
		if(e.getSource()==JB52){
			new ChangeCou();
		}
		if(e.getSource()==JB53){
			new AddCou();
		}
		if(e.getSource()==JB54){
			new DeleteCou();
		}
		if(e.getSource()==JB61){
			new SelectCla();
		}
		if(e.getSource()==JB62){
			new ChangeCla();
		}
		if(e.getSource()==JB63){
			new AddCla();
		}
		if(e.getSource()==JB64){
			new DeleteCla();
		}
	}

}