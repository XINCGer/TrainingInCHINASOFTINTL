package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import common.DataBaseUtil;

public class MainFrame implements ActionListener {
	JButton btnDept;
	JButton btnDuty;
	JButton btnStaffManage;
	JFrame frame;

	public MainFrame() {
		frame = new JFrame();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowHandler());
		frame.setVisible(true);
		frame.setTitle("主菜单");
		frame.setBounds(440, 264, 405, 260);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		Font font = new Font("黑体", Font.BOLD, 16);

		btnDept = new JButton("部门管理");
		btnDept.addActionListener(this);
		btnDept.setFont(font);
		btnDept.setBounds(50, 10, 300, 50);
		frame.add(btnDept);

		btnDuty = new JButton("职务管理");
		btnDuty.addActionListener(this);
		btnDuty.setFont(font);
		btnDuty.setBounds(50, 80, 300, 50);
		frame.add(btnDuty);

		btnStaffManage = new JButton("员工管理");
		btnStaffManage.setFont(font);
		btnStaffManage.addActionListener(this);
		btnStaffManage.setBounds(50, 150, 300, 50);
		frame.add(btnStaffManage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("部门管理")) {
			new DeptFrame();
		} else if (e.getActionCommand().equals("职务管理")) {
			new DutyFrame();
		} else if (e.getActionCommand().equals("员工管理")) {
			new StaffFrame();
		}

	}

	class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			int i = JOptionPane.showConfirmDialog(null, "您确定要退出吗？");
			if (i == 0) {
				// System.exit(0);
				frame.dispose();
				DataBaseUtil.close();
			} else {
				frame.dispose();
				new MainFrame();
			}
		}
	}
}
