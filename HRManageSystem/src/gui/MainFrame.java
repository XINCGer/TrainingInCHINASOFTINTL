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
		frame.setTitle("���˵�");
		frame.setBounds(440, 264, 405, 260);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		Font font = new Font("����", Font.BOLD, 16);

		btnDept = new JButton("���Ź���");
		btnDept.addActionListener(this);
		btnDept.setFont(font);
		btnDept.setBounds(50, 10, 300, 50);
		frame.add(btnDept);

		btnDuty = new JButton("ְ�����");
		btnDuty.addActionListener(this);
		btnDuty.setFont(font);
		btnDuty.setBounds(50, 80, 300, 50);
		frame.add(btnDuty);

		btnStaffManage = new JButton("Ա������");
		btnStaffManage.setFont(font);
		btnStaffManage.addActionListener(this);
		btnStaffManage.setBounds(50, 150, 300, 50);
		frame.add(btnStaffManage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("���Ź���")) {
			new DeptFrame();
		} else if (e.getActionCommand().equals("ְ�����")) {
			new DutyFrame();
		} else if (e.getActionCommand().equals("Ա������")) {
			new StaffFrame();
		}

	}

	class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			int i = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�˳���");
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
