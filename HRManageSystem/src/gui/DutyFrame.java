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

import service.DutyService;
import vo.Duty;
import common.DataBaseUtil;
import common.ExportUtil;


public class DutyFrame implements ActionListener {
	JLabel IDLabel;
	JLabel nameLabel;
	JLabel minSalaryLabel;
	JLabel maxSalaryLabel;
	JTextField IDTextField;
	JTextField nameTextField;
	JTextField minSalaryTextField;
	JTextField maxSalaryTextField;
	JButton btnAdd;
	JButton btnDelete;
	JButton btnQuery;
	JButton btnUpdate;
	JButton btnExport;
	JFrame frame;
	
	public DutyFrame() {
		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowHandler());
		frame.setVisible(true);
		frame.setTitle("ְ�����");
		frame.setBounds(440, 264, 405, 320);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Font font = new Font("����", Font.BOLD, 16);

		// init
		IDLabel = new JLabel("ְ����:");
		// nameLabel.setFont(font);
		IDLabel.setBounds(60, 10, 180, 30);
		frame.add(IDLabel);

		nameLabel = new JLabel("ְ������:");
		nameLabel.setBounds(60, 70, 180, 30);
		frame.add(nameLabel);

		minSalaryLabel = new JLabel("��͹���:");
		minSalaryLabel.setBounds(60, 130, 180, 30);
		frame.add(minSalaryLabel);

		maxSalaryLabel = new JLabel("��߹���:");
		maxSalaryLabel.setBounds(60, 190, 180, 30);
		frame.add(maxSalaryLabel);

		IDTextField = new JTextField();
		IDTextField.setBounds(120, 10, 200, 30);
		frame.add(IDTextField);

		nameTextField = new JTextField();
		nameTextField.setBounds(120, 70, 200, 30);
		frame.add(nameTextField);

		minSalaryTextField = new JTextField();
		minSalaryTextField.setBounds(120, 130, 200, 30);
		frame.add(minSalaryTextField);

		maxSalaryTextField = new JTextField();
		maxSalaryTextField.setBounds(120, 190, 200, 30);
		frame.add(maxSalaryTextField);

		btnAdd = new JButton("����");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(10, 230, 60, 30);
		frame.add(btnAdd);

		btnDelete = new JButton("ɾ��");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(90, 230, 60, 30);
		frame.add(btnDelete);

		btnQuery = new JButton("��ѯ");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(170, 230, 60, 30);
		frame.add(btnQuery);

		btnUpdate = new JButton("�޸�");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(250, 230, 60, 30);
		frame.add(btnUpdate);

		btnExport = new JButton("����");
		btnExport.addActionListener(this);
		btnExport.setBounds(330, 230, 60, 30);
		frame.add(btnExport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DutyService service = new DutyService();
		if (e.getActionCommand().equals("����")) {
			boolean matchResult = Pattern.matches("[1-9][0-9]{2}",IDTextField.getText());
			if (matchResult) {
				Duty duty= new Duty(IDTextField.getText(), nameTextField.getText(), minSalaryTextField.getText(), maxSalaryTextField.getText());
				int result=service.insert(duty);
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
				Duty duty = new Duty();
				duty.setId(IDTextField.getText());
				int result = service.delete(duty);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "�ɹ�ɾ����������", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ������ʧ��!", "����",
							JOptionPane.ERROR_MESSAGE);
				}
				IDTextField.setText("");
				nameTextField.setText("");
				minSalaryTextField.setText("");
				maxSalaryTextField.setText("");
			}
		} else if (e.getActionCommand().equals("��ѯ")) {
			Duty duty = new Duty();
			duty.setId(IDTextField.getText());
			if(service.query(duty)!=null){
				nameTextField.setText(duty.getName());
				minSalaryTextField.setText(duty.getMinSalary());
				maxSalaryTextField.setText(duty.getMaxSalary());
			}
			else{
				JOptionPane.showMessageDialog(null, "û�и�������!", "����",JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("�޸�")) {
			Duty duty= new Duty(IDTextField.getText(), nameTextField.getText(), minSalaryTextField.getText(), maxSalaryTextField.getText());
			int result = service.update(duty);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "�ɹ��޸ĸ�������", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�޸�����ʧ��!", "����",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("����")) {
			if(ExportUtil.export("duty", 4)){
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
//				System.exit(0);
				frame.dispose();
				DataBaseUtil.close();
			} else {
				frame.dispose();
				new DutyFrame();
			}
		}
	}

}
