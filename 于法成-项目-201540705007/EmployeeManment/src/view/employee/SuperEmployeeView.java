package view.employee;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
//样式父类
public class SuperEmployeeView {
	JFrame frame;
	JTextField nameText;
	JComboBox sexBox;
	JTextField ageText;
	JButton saveBtn;
	JComboBox depBox;
	EmployeeDao empDao = new EmployeeDao();
	DepartmentDao depDao = new DepartmentDao();
	List<Department> depList;

	public void init() {
		frame = new JFrame();
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		JLabel nameLabel = new JLabel();
		nameLabel.setText("姓名");
		panel1.add(nameLabel);
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		JLabel sexLabel = new JLabel();
		sexLabel.setText("性别");
		panel2.add(sexLabel);
		// JTextField sexText = new JTextField();
		// sexText.setPreferredSize(new Dimension(80, 30));
		// panel2.add(sexText);
		sexBox = new JComboBox();
		sexBox.addItem("男");
		sexBox.addItem("女");
		sexBox.setPreferredSize(new Dimension(80, 30));
		panel2.add(sexBox);
		JLabel ageLabel = new JLabel();
		ageLabel.setText("年龄");
		panel3.add(ageLabel);
		ageText = new JTextField();
		ageText.setPreferredSize(new Dimension(80, 30));
		panel3.add(ageText);

		JLabel depLabel = new JLabel();
		depLabel.setText("部门");
		panel4.add(depLabel);
		depList = depDao.search();
		depBox = new JComboBox();
		for (int i = 0; i < depList.size(); i++) {
			depBox.addItem(depList.get(i).getName());
		}
		depBox.setPreferredSize(new Dimension(80, 30));
		panel4.add(depBox);

		saveBtn = new JButton();
		saveBtn.setText("保存");
		saveBtn.setPreferredSize(new Dimension(80, 30));
		panel5.add(saveBtn);

		frame.setVisible(true);
	}
}
