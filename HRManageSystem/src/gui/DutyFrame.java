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
		frame.setTitle("职务管理");
		frame.setBounds(440, 264, 405, 320);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Font font = new Font("黑体", Font.BOLD, 16);

		// init
		IDLabel = new JLabel("职务编号:");
		// nameLabel.setFont(font);
		IDLabel.setBounds(60, 10, 180, 30);
		frame.add(IDLabel);

		nameLabel = new JLabel("职务名称:");
		nameLabel.setBounds(60, 70, 180, 30);
		frame.add(nameLabel);

		minSalaryLabel = new JLabel("最低工资:");
		minSalaryLabel.setBounds(60, 130, 180, 30);
		frame.add(minSalaryLabel);

		maxSalaryLabel = new JLabel("最高工资:");
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

		btnAdd = new JButton("增加");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(10, 230, 60, 30);
		frame.add(btnAdd);

		btnDelete = new JButton("删除");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(90, 230, 60, 30);
		frame.add(btnDelete);

		btnQuery = new JButton("查询");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(170, 230, 60, 30);
		frame.add(btnQuery);

		btnUpdate = new JButton("修改");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(250, 230, 60, 30);
		frame.add(btnUpdate);

		btnExport = new JButton("导出");
		btnExport.addActionListener(this);
		btnExport.setBounds(330, 230, 60, 30);
		frame.add(btnExport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DutyService service = new DutyService();
		if (e.getActionCommand().equals("增加")) {
			boolean matchResult = Pattern.matches("[1-9][0-9]{2}",IDTextField.getText());
			if (matchResult) {
				Duty duty= new Duty(IDTextField.getText(), nameTextField.getText(), minSalaryTextField.getText(), maxSalaryTextField.getText());
				int result=service.insert(duty);
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
			} else {
				JOptionPane.showMessageDialog(null, "输入有误!", "警告",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("删除")) {
			int flag=JOptionPane.showConfirmDialog(null, "确认是否删除该条数据?");
			if(flag==0){
				Duty duty = new Duty();
				duty.setId(IDTextField.getText());
				int result = service.delete(duty);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "成功删除该条数据", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "删除数据失败!", "警告",
							JOptionPane.ERROR_MESSAGE);
				}
				IDTextField.setText("");
				nameTextField.setText("");
				minSalaryTextField.setText("");
				maxSalaryTextField.setText("");
			}
		} else if (e.getActionCommand().equals("查询")) {
			Duty duty = new Duty();
			duty.setId(IDTextField.getText());
			if(service.query(duty)!=null){
				nameTextField.setText(duty.getName());
				minSalaryTextField.setText(duty.getMinSalary());
				maxSalaryTextField.setText(duty.getMaxSalary());
			}
			else{
				JOptionPane.showMessageDialog(null, "没有该条数据!", "警告",JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("修改")) {
			Duty duty= new Duty(IDTextField.getText(), nameTextField.getText(), minSalaryTextField.getText(), maxSalaryTextField.getText());
			int result = service.update(duty);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "成功修改该条数据", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "修改数据失败!", "警告",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("导出")) {
			if(ExportUtil.export("duty", 4)){
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
