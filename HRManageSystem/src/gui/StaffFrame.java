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
		frame.setTitle("员工管理");
		frame.setBounds(440, 264, 395, 535);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Font font = new Font("黑体", Font.BOLD, 16);

		IDLabel = new JLabel("员工编号:");
		// nameLabel.setFont(font);
		IDLabel.setBounds(60, 10, 180, 30);
		frame.add(IDLabel);

		nameLabel = new JLabel("员工姓名:");
		nameLabel.setBounds(60, 70, 180, 30);
		frame.add(nameLabel);

		sexLabel = new JLabel("员工性别:");
		sexLabel.setBounds(60, 130, 180, 30);
		frame.add(sexLabel);

		salaryLabel = new JLabel("员工工资:");
		salaryLabel.setBounds(60, 190, 180, 30);
		frame.add(salaryLabel);

		telLabel = new JLabel("员工电话:");
		telLabel.setBounds(60, 250, 180, 30);
		frame.add(telLabel);

		deptLabel = new JLabel("员工部门:");
		deptLabel.setBounds(60, 310, 180, 30);
		frame.add(deptLabel);

		dutyLabel = new JLabel("员工职务:");
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

		btnAdd = new JButton("增加");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(5, 420, 90, 30);
		frame.add(btnAdd);

		btnDelete = new JButton("删除");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(100, 420, 90, 30);
		frame.add(btnDelete);

		btnQuery = new JButton("查询");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(195, 420, 90, 30);
		frame.add(btnQuery);

		btnUpdate = new JButton("修改");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(290, 420, 90, 30);
		frame.add(btnUpdate);

		btnExport = new JButton("导出");
		btnExport.addActionListener(this);
		btnExport.setBounds(145, 460, 90, 30);
		frame.add(btnExport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StaffService service = new StaffService();
		DeptService service1=new DeptService();
		DutyService service2=new DutyService();
		
		if (e.getActionCommand().equals("增加")) {
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
												"成功插入" + result + "条数据", "提示",
												JOptionPane.INFORMATION_MESSAGE);
									} else if (result == -1) {
										JOptionPane.showMessageDialog(null, "该条数据已存在!", "警告",
												JOptionPane.ERROR_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "插入数据失败!", "警告",
												JOptionPane.ERROR_MESSAGE);
									}
								}
								else{
									JOptionPane.showMessageDialog(null, "所填工资不在正确范围内!", "警告",
											JOptionPane.WARNING_MESSAGE);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "所填工资不在正确范围内!", "警告",
										JOptionPane.WARNING_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "所选职务不存在!", "警告",
									JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "所选部门不存在!", "警告",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "电话号码输入有误!", "警告",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "ID输入有误!", "警告",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("删除")) {
			int flag=JOptionPane.showConfirmDialog(null, "确认是否删除该条数据?");
			if(flag==0){
				Staff staff= new Staff();
				staff.setId(IDTextField.getText());
				int result = service.delete(staff);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "成功删除该条数据", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "删除数据失败!", "警告",
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
		} else if (e.getActionCommand().equals("查询")) {
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
				JOptionPane.showMessageDialog(null, "没有该条数据!", "警告",JOptionPane.WARNING_MESSAGE);
			}
		} 
		else if (e.getActionCommand().equals("修改")) {
			Staff staff= new Staff(IDTextField.getText(), nameTextField.getText(), sexTextField.getText(), salaryTextField.getText(), telTextField.getText(), deptTextField.getText(), dutyTextField.getText());
			int result = service.update(staff);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "成功修改该条数据", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "修改数据失败!", "警告",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("导出")) {
			if(ExportUtil.export("staff", 7)){
				JOptionPane.showMessageDialog(null, "导出成功!", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "导出失败!", "提示",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			int i = JOptionPane.showConfirmDialog(null, "您确定要退出吗？");
			if (i == 0) {
				frame.dispose();
			} else {
				frame.dispose();
				new StaffFrame();
			}
		}
	}

}