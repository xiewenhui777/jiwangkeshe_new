package cat.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cat.util.CatUtil;

public class CatResign extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel;

	public CatResign() {
		setTitle("Registered cat chat room\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 600, 400);
		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon("images\\register.jpg").getImage(), 0,0, getWidth(), getHeight(), null);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);




		final JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setBounds(145, 75, 151, 21);
		lblNewLabel1.setForeground(Color.white);
		lblNewLabel1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblNewLabel1.setText("�û���");
		getContentPane().add(lblNewLabel1);

		textField = new JTextField();
		textField.setBounds(230, 70, 200, 30);			//�ı����λ������
		textField.setOpaque(false);
		textField.setFont(new Font("΢���ź�", Font.BOLD, 15));
		textField.setForeground(Color.white);
		contentPane.add(textField);
		textField.setColumns(10);

		final JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setBounds(145, 135, 151, 21);
		lblNewLabel2.setForeground(Color.white);
		lblNewLabel2.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblNewLabel2.setText("��������");
		getContentPane().add(lblNewLabel2);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.white);
		passwordField.setFont(new Font("΢���ź�", Font.BOLD, 15));
		passwordField.setEchoChar('*');		//�ַ���������
		passwordField.setOpaque(false);
		passwordField.setBounds(230, 130, 200, 30);
		contentPane.add(passwordField);

		final JLabel lblNewLabel3 = new JLabel();
		lblNewLabel3.setBounds(145, 195, 151, 21);
		lblNewLabel3.setForeground(Color.white);
		lblNewLabel3.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblNewLabel3.setText("ȷ������");
		getContentPane().add(lblNewLabel3);

		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(Color.white);
		passwordField_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
		passwordField_1.setEchoChar('*');		//�ַ���������
		passwordField_1.setOpaque(false);
		passwordField_1.setBounds(230, 190, 200, 30);
		contentPane.add(passwordField_1);

		//ע�ᰴť
//		final JButton btnNewButton_1 = new JButton();
//		btnNewButton_1.setIcon(new ImageIcon("images\\ע��1.jpg"));
//		btnNewButton_1.setBounds(320, 198, 80, 40);
//		getRootPane().setDefaultButton(btnNewButton_1);
//		contentPane.add(btnNewButton_1);

		final JButton btnNewButton_1 = new JButton("ע��");
//		btnNewButton_1.setIcon(new ImageIcon("images\\\u6CE8\u518C.jpg"));
		btnNewButton_1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		btnNewButton_1.setBounds(360, 250, 80, 40);
		contentPane.add(btnNewButton_1);

		//���ذ�ť
//		final JButton btnNewButton = new JButton("����");
////		btnNewButton.setIcon(new ImageIcon("images\\����.jpg"));
//		btnNewButton.setBounds(230, 198, 80, 40);
//		contentPane.add(btnNewButton);

		final JButton btnNewButton = new JButton("����");
//		btnNewButton.setIcon(new ImageIcon("images\\\u767B\u9646.jpg"));
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 20));
		btnNewButton.setBounds(190, 250, 80, 40);
		getRootPane().setDefaultButton(btnNewButton);
		contentPane.add(btnNewButton);

		//��ʾ��Ϣ
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(55, 250, 185, 20);
		lblNewLabel.setForeground(Color.red);
		contentPane.add(lblNewLabel);

		//���ذ�ť����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				//���ص�½����
				CatLogin frame = new CatLogin();
				frame.setVisible(true);
				setVisible(false);
			}
		});

		//ע�ᰴť����
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Properties userPro = new Properties();
				File file = new File("Users.properties");
				CatUtil.loadPro(userPro, file);

				String u_name = textField.getText();
				String u_pwd = new String(passwordField.getPassword());
				String u_pwd_ag = new String(passwordField_1.getPassword());

				// �ж��û����Ƿ�����ͨ�û����Ѵ���
				if (u_name.length() != 0) {	//�����û�������Ϊ��

					if (userPro.containsKey(u_name)) {		//�ж��û����Ƿ���userPro�������Ϣ���Ѿ�����
						lblNewLabel.setText("�û����Ѵ���!");
					} else {
						isPassword(userPro, file, u_name, u_pwd, u_pwd_ag);
					}
				} else {
					lblNewLabel.setText("�û�������Ϊ�գ�");
				}
			}

			private void isPassword(Properties userPro, File file, String u_name, String u_pwd, String u_pwd_ag) {
				if (u_pwd.equals(u_pwd_ag)) {		//�ж��������������Ƿ�һ��
					if (u_pwd.length() != 0) {	//���벻��Ϊ��
						userPro.setProperty(u_name, u_pwd_ag);			//userPro��ʼ��������Properties�����ļ����û����������Ϊһ�Լ�ֵ�ԣ�
						try {
							userPro.store(new FileOutputStream(file),	//��Properties�����������б��浽�������
									"Copyright (c) Boxcode Studio");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btnNewButton_1.setEnabled(false);			//ע������Զ����ص�¼����
						//���ص�½����
						CatLogin frame = new CatLogin();			//��¼�Ľ�����й�����ͨ����������д�����ɵ�¼�������ʾ��
						frame.setVisible(true);
						setVisible(false);
					} else {
						lblNewLabel.setText("����Ϊ�գ�");
					}
				} else {
					lblNewLabel.setText("���벻һ�£�");
				}
			}
		});
	}
}
