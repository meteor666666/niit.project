package view.employee;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;
import util.CallBack;
//面板主体
public class EmployeeView {
	List<Employee> list  = new ArrayList<>();
	EmployeeDao empDao = new EmployeeDao();
	DepartmentDao depDao = new DepartmentDao();
	JTable table;
	EmployeeTableModel model;
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
				Employee emp = new Employee();
				emp.setName(name);
				emp.setSex(sex);
				emp.setAge(age);
				Department dep = new Department();
				int index = depBox.getSelectedIndex();
				if (index == 0) {
					dep.setId(-1);
				} else {

					dep = depList.get(index - 1);
				}
				emp.setDep(dep);
				list = empDao.searchByCondition(emp);
				refreshTable(list);
			}
		});
		panel1.add(searchBtn);
		// 查出所有的员工来
		list = empDao.search();

		model = new EmployeeTableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600, 300));
		panel2.add(scroll);

		JButton addBtn = new JButton();
		addBtn.setText("增加");
		addBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(addBtn);

		// addBtn.addActionListener(new ActionListenerClass());
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddEmployeeView aev = AddEmployeeView.getInstance(new CallBack() {
					@Override
					public void call() {
						refreshTable();

					}
				});
				aev.openFrame();

			}
		});

		JButton modifyBtn = new JButton();
		modifyBtn.setText("修改");
		modifyBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(modifyBtn);
		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index > -1) {

					Employee selectEmp = list.get(index);
					new ModifyEmployeeView(selectEmp, new CallBack() {

						@Override
						public void call() {
							table.updateUI();
						}
					}).init();
				} else {
					JOptionPane.showMessageDialog(null, "请选中一条数据");

				}
			}
		});

		JButton deleteBtn = new JButton();
		deleteBtn.setText("删除");
		deleteBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(deleteBtn);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// delete();

				deleteBatch();
			}
		});

		frame.setVisible(true);

	}

	public void delete() {

		int index = table.getSelectedRow();
		if (index > -1) {
			int option = JOptionPane.showConfirmDialog(null, "确认删除吗？", "确认", JOptionPane.YES_NO_OPTION);
			if (option == 0) {
				int id = list.get(index).getId();
				boolean flag = empDao.delete(id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}

				refreshTable();
			}

		} else {
			JOptionPane.showMessageDialog(null, "请选中一条数据");

		}
	}

	public void deleteBatch() {
		int[] indexs = table.getSelectedRows();
		if (indexs.length > 0) {
			int option = JOptionPane.showConfirmDialog(null, "确认删除吗？", "确认", JOptionPane.YES_NO_OPTION);
			String deleteIds = "";
			if (option == 0) {
				for (int i = indexs.length - 1; i >= 0; i--) {
					deleteIds += list.get(indexs[i]).getId() + ",";
				}
				deleteIds = deleteIds.substring(0, deleteIds.length() - 1);
				empDao.delete(deleteIds);
				refreshTable();
			}

		} else {
			JOptionPane.showMessageDialog(null, "请选中一条数据");

		}
	}

	public void refreshTable() {
		list = empDao.search();
		model.setList(list);
		table.updateUI();
	}

	public void refreshTable(List<Employee> list) {
		model.setList(list);
		table.updateUI();
	}

	public static void main(String[] args) {
		new EmployeeView().init();
	}
}
