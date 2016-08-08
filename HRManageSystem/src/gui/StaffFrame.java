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

import common.ExportUtil;

import service.DeptService;
import service.DutyService;
import service.StaffService;
import vo.Dept;
import vo.Duty;
import vo.Staff;

public class StaffFrame implements ActionListener {
	JLabel IDLabel;
	JLabel nameLabel;
	JLabel sexLabel;
	JLabel salaryLabel;
	JLabel telLabel;
	JLabel deptLabel;
	JLabel dutyLabel;
	JTextField IDTextField;
	JTextField nameTextField;
	JTextField sexTextField;
	JTextField salaryTextField;
	JTextField telTextField;
	JTextField deptTextField;
	JTextField dutyTextField;
	JButton btnAdd;
	JButton btnDelete;
	JButton btnQuery;
	JButton btnUpdate;
	JButton btnExport;
	JFrame frame;

	public StaffFrame() {
		frame = new JFrame();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowHandler());
		frame.setVisible(true);
		frame.setTitle("Ա������");
		frame.setBounds(440, 264, 395, 535);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Font font = new Font("����", Font.BOLD, 16);

		IDLabel = new JLabel("Ա�����:");
		// nameLabel.setFont(font);
		IDLabel.setBounds(60, 10, 180, 30);
		frame.add(IDLabel);

		nameLabel = new JLabel("Ա������:");
		nameLabel.setBounds(60, 70, 180, 30);
		frame.add(nameLabel);

		sexLabel = new JLabel("Ա���Ա�:");
		sexLabel.setBounds(60, 130, 180, 30);
		frame.add(sexLabel);

		salaryLabel = new JLabel("Ա������:");
		salaryLabel.setBounds(60, 190, 180, 30);
		frame.add(salaryLabel);

		telLabel = new JLabel("Ա���绰:");
		telLabel.setBounds(60, 250, 180, 30);
		frame.add(telLabel);

		deptLabel = new JLabel("Ա������:");
		deptLabel.setBounds(60, 310, 180, 30);
		frame.add(deptLabel);

		dutyLabel = new JLabel("Ա��ְ��:");
		dutyLabel.setBounds(60, 370, 180, 30);
		frame.add(dutyLabel);

		IDTextField = new JTextField();
		IDTextField.setBounds(120, 10, 200, 30);
		frame.add(IDTextField);

		nameTextField = new JTextField();
		nameTextField.setBounds(120, 70, 200, 30);
		frame.add(nameTextField);

		sexTextField = new JTextField();
		sexTextField.setBounds(120, 130, 200, 30);
		frame.add(sexTextField);

		salaryTextField = new JTextField();
		salaryTextField.setBounds(120, 190, 200, 30);
		frame.add(salaryTextField);

		telTextField = new JTextField();
		telTextField.setBounds(120, 250, 200, 30);
		frame.add(telTextField);

		deptTextField = new JTextField();
		deptTextField.setBounds(120, 310, 200, 30);
		frame.add(deptTextField);

		dutyTextField = new JTextField();
		dutyTextField.setBounds(120, 370, 200, 30);
		frame.add(dutyTextField);

		btnAdd = new JButton("����");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(5, 420, 90, 30);
		frame.add(btnAdd);

		btnDelete = new JButton("ɾ��");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(100, 420, 90, 30);
		frame.add(btnDelete);

		btnQuery = new JButton("��ѯ");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(195, 420, 90, 30);
		frame.add(btnQuery);

		btnUpdate = new JButton("�޸�");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(290, 420, 90, 30);
		frame.add(btnUpdate);

		btnExport = new JButton("����");
		btnExport.addActionListener(this);
		btnExport.setBounds(145, 460, 90, 30);
		frame.add(btnExport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StaffService service = new StaffService();
		DeptService service1=new DeptService();
		DutyService service2=new DutyService();
		
		if (e.getActionCommand().equals("����")) {
			boolean matchResult = false;
			matchResult = Pattern.matches("[1-9][0-9]{3}",
					IDTextField.getText());
			if (matchResult) {
				matchResult = Pattern.matches("[1][3,8,5,7,4][0-9]{9}",
						telTextField.getText());
				if(matchResult){
					Dept dept=new Dept();
					dept.setName(deptTextField.getText());
					if(service1.isExist(dept)){
						Duty duty=new Duty();
						duty.setName(dutyTextField.getText());
						if(service2.isExist(duty)!=null){
							float salary=0.0f;
							try {
								salary=Float.parseFloat(salaryTextField.getText());
								float minSalary=Float.parseFloat(duty.getMinSalary());
								float maxSalary=Float.parseFloat(duty.getMaxSalary());
								if(salary>=minSalary && salary<=maxSalary){
									Staff staff= new Staff(IDTextField.getText(), nameTextField.getText(), sexTextField.getText(), salaryTextField.getText(), telTextField.getText(), deptTextField.getText(), dutyTextField.getText());
									int result=service.insert(staff);
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
								}
								else{
									JOptionPane.showMessageDialog(null, "����ʲ�����ȷ��Χ��!", "����",
											JOptionPane.WARNING_MESSAGE);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "����ʲ�����ȷ��Χ��!", "����",
										JOptionPane.WARNING_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "��ѡְ�񲻴���!", "����",
									JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "��ѡ���Ų�����!", "����",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "�绰������������!", "����",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "ID��������!", "����",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("ɾ��")) {
			int flag=JOptionPane.showConfirmDialog(null, "ȷ���Ƿ�ɾ����������?");
			if(flag==0){
				Staff staff= new Staff();
				staff.setId(IDTextField.getText());
				int result = service.delete(staff);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "�ɹ�ɾ����������", "��ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "ɾ������ʧ��!", "����",
							JOptionPane.ERROR_MESSAGE);
				}
				IDTextField.setText("");
				nameTextField.setText("");
				sexTextField.setText("");
				salaryTextField.setText("");
				telTextField.setText("");
				deptTextField.setText("");
				dutyTextField.setText("");
			}
		} else if (e.getActionCommand().equals("��ѯ")) {
			Staff staff= new Staff();
			staff.setId(IDTextField.getText());
			if(service.query(staff)!=null){
				IDTextField.setText(staff.getId());
				nameTextField.setText(staff.getName());
				sexTextField.setText(staff.getSex());
				salaryTextField.setText(staff.getSalary());
				telTextField.setText(staff.getTel());
				deptTextField.setText(staff.getDept());
				dutyTextField.setText(staff.getDuty());
			}
			else{
				JOptionPane.showMessageDialog(null, "û�и�������!", "����",JOptionPane.WARNING_MESSAGE);
			}
		} 
		else if (e.getActionCommand().equals("�޸�")) {
			Staff staff= new Staff(IDTextField.getText(), nameTextField.getText(), sexTextField.getText(), salaryTextField.getText(), telTextField.getText(), deptTextField.getText(), dutyTextField.getText());
			int result = service.update(staff);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "�ɹ��޸ĸ�������", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "�޸�����ʧ��!", "����",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("����")) {
			if(ExportUtil.export("staff", 7)){
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
				frame.dispose();
			} else {
				frame.dispose();
				new StaffFrame();
			}
		}
	}

}