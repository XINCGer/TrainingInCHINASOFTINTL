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
		frame.setTitle("部门管理");
		frame.setBounds(440, 264, 405, 260);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		// Font font = new Font("黑体", Font.BOLD, 16);

		// init
		IDLabel = new JLabel("部门编号:");
		// nameLabel.setFont(font);
		IDLabel.setBounds(60, 10, 180, 30);
		frame.add(IDLabel);

		nameLabel = new JLabel("部门名称:");
		nameLabel.setBounds(60, 70, 180, 30);
		frame.add(nameLabel);

		addressLabel = new JLabel("部门地址:");
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

		btnAdd = new JButton("增加");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(10, 180, 60, 30);
		frame.add(btnAdd);

		btnDelete = new JButton("删除");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(90, 180, 60, 30);
		frame.add(btnDelete);

		btnQuery = new JButton("查询");
		btnQuery.addActionListener(this);
		btnQuery.setBounds(170, 180, 60, 30);
		frame.add(btnQuery);

		btnUpdate = new JButton("修改");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(250, 180, 60, 30);
		frame.add(btnUpdate);

		btnExport = new JButton("导出");
		btnExport.addActionListener(this);
		btnExport.setBounds(330, 180, 60, 30);
		frame.add(btnExport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DeptService service =new DeptService();
		if (e.getActionCommand().equals("增加")) {
			boolean matchResult = Pattern.matches("[1-9][0-9]{2}",
					IDTextField.getText());
			if (matchResult) {
				Dept dept=new Dept(IDTextField.getText(), nameTextField.getText(), addressTextField.getText());
				int result=service.insert(dept);
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
				Dept dept=new Dept();
				dept.setId(IDTextField.getText());
				int result = service.delete(dept);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "成功删除该条数据", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "删除数据失败!", "警告",
							JOptionPane.ERROR_MESSAGE);
				}
				IDTextField.setText("");
				nameTextField.setText("");
				addressTextField.setText("");
			}
			
		} else if (e.getActionCommand().equals("查询")) {
			Dept dept = new Dept();
			dept.setId(IDTextField.getText());
			if(service.query(dept)!=null){
				IDTextField.setText(dept.getId());
				nameTextField.setText(dept.getName());
				addressTextField.setText(dept.getAddress());
			}
			else{
				JOptionPane.showMessageDialog(null, "没有该条数据!", "警告",JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getActionCommand().equals("修改")) {
			Dept dept=new Dept(IDTextField.getText(), nameTextField.getText(), addressTextField.getText());
			int result = service.update(dept);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "成功修改该条数据", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "修改数据失败!", "警告",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("导出")) {
			if(ExportUtil.export("dept", 3)){
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