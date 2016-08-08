package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import service.DeptService;
import vo.Dept;
import common.DataBaseUtil;
import common.ExportUtil;

public class DeptFrame implements ActionListener {
	JLabel IDLabel;
	JLabel nameLabel;
	JLabel addressLabel;
	JTextField IDTextField;
	JTextField nameTextField;
	JTextField addressTextField;
	JButton btnAdd;
	JButton btnDelete;
	JButton btnQuery;
	JButton btnUpdate;
	JButton btnExport;
	JFrame frame;

	public DeptFrame() {
		frame = new JFrame();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowHandler());
		frame.setVisible(true);
		frame.setTitle("���Ź���");
		frame.setBounds(440, 264, 405, 260);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Font font = new Font("����", Font.BOLD, 16);

		// init
		IDLabel = new JLabel("���ű��:");
		// nameLabel.setFont(font);
		IDLabel.setBounds(60, 10, 180, 30);
		frame.add(IDLabel);

		nameLabel = new JLabel("��������:");
		nameLabel.setBounds(60, 70, 180, 30);
		frame.add(nameLabel);

		addressLabel = new JLabel("���ŵ�ַ:");
		addressLabel.setBounds(60, 130, 180, 30);
		frame.add(addressLabel);

		IDTextField = new JTextField();
		IDTextField.setBounds(120, 10, 200, 30);
		frame.add(IDTextField);

		nameTextField = new JTextField();
		nameTextField.setBounds(120, 70, 200, 30);
		frame.add(nameTextField);

		addressTextField = new JTextField();
		addressTextField.setBounds(120, 130, 200, 30);
		frame.add(addressTextField);

		btnAdd = new JButton("����");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(10, 180, 60, 30);
		frame.add(btnAdd);

		btnDelete = new JButton("ɾ��");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(90, 180, 60, 30);
		frame.add(btnDelete);

		btnQuery = new JButton("��ѯ");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(170, 180, 60, 30);
		frame.add(btnQuery);

		btnUpdate = new JButton("�޸�");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(250, 180, 60, 30);
		frame.add(btnUpdate);

		btnExport = new JButton("����");
		btnExport.addActionListener(this);
		btnExport.setBounds(330, 180, 60, 30);
		frame.add(btnExport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DeptService service =new DeptService();
		if (e.getActionCommand().equals("����")) {
			boolean matchResult = Pattern.matches("[1-9][0-9]{2}",
					IDTextField.getText());
			if (matchResult) {
				Dept dept=new Dept(IDTextField.getText(), nameTextField.getText(), addressTextField.getText());
				int result=service.insert(dept);
				if (result > 0) {
					JOptionPane.showMessageDialog(null,
							"�ɹ�����" + result + "������", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (result == -1) {
					JOptionPane.showMessageDialog(null, "���������Ѵ���!", "����",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��������ʧ��!", "����",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "��������!", "����",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (e.getActionCommand().equals("ɾ��")) {
			int flag=JOptionPane.showConfirmDialog(null, "ȷ���Ƿ�ɾ����������?");
			if(flag==0){
				Dept dept=new Dept();
				dept.setId(IDTextField.getText());
				int result = service.delete(dept);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "�ɹ�ɾ����������", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ������ʧ��!", "����",
							JOptionPane.ERROR_MESSAGE);
				}
				IDTextField.setText("");
				nameTextField.setText("");
				addressTextField.setText("");
			}
			
		} else if (e.getActionCommand().equals("��ѯ")) {
			Dept dept = new Dept();
			dept.setId(IDTextField.getText());
			if(service.query(dept)!=null){
				IDTextField.setText(dept.getId());
				nameTextField.setText(dept.getName());
				addressTextField.setText(dept.getAddress());
			}
			else{
				JOptionPane.showMessageDialog(null, "û�и�������!", "����",JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("�޸�")) {
			Dept dept=new Dept(IDTextField.getText(), nameTextField.getText(), addressTextField.getText());
			int result = service.update(dept);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "�ɹ��޸ĸ�������", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�޸�����ʧ��!", "����",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("����")) {
			if(ExportUtil.export("dept", 3)){
				JOptionPane.showMessageDialog(null, "�����ɹ�!", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "����ʧ��!", "��ʾ",
						JOptionPane.ERROR_MESSAGE);
			}
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
				new DeptFrame();
			}
		}
	}

}