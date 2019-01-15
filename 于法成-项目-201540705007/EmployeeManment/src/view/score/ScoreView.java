package view.score;
//主面板
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.DepartmentDao;
import dao.ScoreDao;
import entity.Department;
import entity.Score;

public class ScoreView {
	List<Score> list = new ArrayList<>();
	ScoreDao scDao = new ScoreDao();
	DepartmentDao depDao = new DepartmentDao();
	JTable table;
	ScoreTableModel model;
	JComboBox depBox;

	List<Department> depList;

	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(650, 500);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		JLabel nameLabel = new JLabel();
		nameLabel.setText("姓名");
		panel1.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		JLabel sexLabel = new JLabel();
		sexLabel.setText("性别");
		panel1.add(sexLabel);
		JTextField sexText = new JTextField();
		sexText.setPreferredSize(new Dimension(80, 30));
		panel1.add(sexText);

		JLabel ageLabel = new JLabel();
		ageLabel.setText("年龄");
		panel1.add(ageLabel);
		JTextField ageText = new JTextField();
		ageText.setPreferredSize(new Dimension(80, 30));
		panel1.add(ageText);

		JLabel depLabel = new JLabel();
		depLabel.setText("部门");
		panel1.add(depLabel);
		depList = depDao.search();
		depBox = new JComboBox();
		depBox.addItem("请选择部门");
		for (int i = 0; i < depList.size(); i++) {
			depBox.addItem(depList.get(i).getName());
		}
		depBox.setPreferredSize(new Dimension(100, 30));
		panel1.add(depBox);

		JButton searchBtn = new JButton();
		searchBtn.setText("搜索");
		searchBtn.setPreferredSize(new Dimension(80, 30));
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = nameText.getText();
				String sex = sexText.getText();
				int age = -1;
				try {
					age = Integer.parseInt(ageText.getText());
				} catch (Exception ex) {

				}
				Score sc = new Score();

				Department dep = new Department();
				int index = depBox.getSelectedIndex();
				if (index == 0) {
					dep.setId(-1);
				} else {
					dep = depList.get(index - 1);
				}
				// sc.setDep(dep);
				// list = scDao.searchByCondition(sc);
				// refreshTable(list);
			}
		});
		panel1.add(searchBtn);
		// 查出所有的员工来
		list = scDao.search();

		model = new ScoreTableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600, 300));
		panel2.add(scroll);

		JButton addBtn = new JButton();
		addBtn.setText("保存");
		addBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(addBtn);
		// addBtn.addActionListener(new ActionListenerClass());
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Set<Score> set = model.getSaveSet();
				scDao.save(set);
				refreshTable();
			}
		});

		frame.setVisible(true);

	}

	public void refreshTable() {
		list = scDao.search();
		model.setList(list);
		table.updateUI();
	}

	public static void main(String[] args) {
		new ScoreView().init();
	}
}
