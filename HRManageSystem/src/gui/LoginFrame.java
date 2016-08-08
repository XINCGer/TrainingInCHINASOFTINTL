package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.AdminService;
import vo.Admin;

public class LoginFrame {
	JTextField nameTextField;
	JPasswordField passTextField;
	JFrame frame;

	public LoginFrame() {
		frame = new JFrame();
		frame.addWindowListener(new WindowHandler());
		frame.setVisible(true);
		frame.setTitle("��¼");
		frame.setBounds(440, 264, 260, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		Font font = new Font("����", Font.BOLD, 16);
		JLabel userNameLabel = new JLabel("�û�����");
		userNameLabel.setFont(font);
		userNameLabel.setBounds(30, 10, 100, 30);
		frame.add(userNameLabel);

		JLabel passwordLabel = new JLabel("��  �룺");
		passwordLabel.setFont(font);
		passwordLabel.setBounds(30, 50, 100, 30);
		frame.add(passwordLabel);

		nameTextField = new JTextField();
		nameTextField.addKeyListener(new TextFieldHandler());
		passTextField = new JPasswordField();
		passTextField.setEchoChar('*');
		nameTextField.setBounds(120, 10, 100, 25);
		frame.add(nameTextField);
		passTextField.setBounds(120, 50, 100, 25);
		frame.add(passTextField);

		JButton loginBtn = new JButton("��¼");
		JButton resetBtn = new JButton("����");
		loginBtn.setBounds(40, 90, 70, 25);
		frame.add(loginBtn);
		resetBtn.setBounds(130, 90, 70, 25);
		frame.add(resetBtn);

		ButtonHandler handler = new ButtonHandler();
		loginBtn.addActionListener(handler);
		resetBtn.addActionListener(handler);
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			AdminService service = new AdminService();
			if (ae.getActionCommand().equals(new String("��¼"))) {
				String name = nameTextField.getText();
				String password = String.valueOf(passTextField.getPassword());
				Admin ad = new Admin(name, password);
				if(service.login(ad)){
					JOptionPane.showMessageDialog(null, "��¼�ɹ�!");
					new MainFrame();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "�û������������!");
				}
			} else if (ae.getActionCommand() == "����") {
				nameTextField.setText("");
				passTextField.setText("");
			}

		}

	}

	class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			int i = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�˳���");
			if (i == 0) {
				System.exit(0);
			} else {
				frame.dispose();
				new LoginFrame();
			}
		}
	}

	class TextFieldHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (KeyEvent.VK_ENTER == e.getKeyCode()) {
				System.out.println("�û�����" + nameTextField.getText());
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
