package view.department;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.DepartmentDao;
import entity.Department;
import util.CallBack;
import view.department.mangeProject.Project2DepartmentView;
//�������
public class DepartmentView {
	List<Department> list = new ArrayList<>();
	DepartmentDao depDao = new DepartmentDao();
	JTable table;
	DepartmentTableModel model;

	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		JLabel nameLabel = new JLabel();
		nameLabel.setText("����");
		panel1.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		JLabel empCountLabel = new JLabel();
		empCountLabel.setText("����");
		panel1.add(empCountLabel);
		JTextField empCountText = new JTextField();
		empCountText.setPreferredSize(new Dimension(80, 30));
		panel1.add(empCountText);

		JButton searchBtn = new JButton();
		searchBtn.setText("����");
		searchBtn.setPreferredSize(new Dimension(80, 30));
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				int empCount = -1;
				try {
					empCount = Integer.parseInt(empCountText.getText());
				} catch (Exception ex) {
				}
				Department dep = new Department();
				dep.setName(name);
				dep.setEmpCount(empCount);
				list = depDao.searchByCondition(dep);
				refreshTable(list);
			}
		});
		panel1.add(searchBtn);
		// ������е�Ա����
		list = depDao.search();

		model = new DepartmentTableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(500, 300));
		panel2.add(scroll);

		JButton addBtn = new JButton();
		addBtn.setText("����");
		addBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(addBtn);

		// addBtn.addActionListener(new ActionListenerClass());
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddDepartmentView aev = AddDepartmentView.getInstance(new CallBack() {
					@Override
					public void call() {
						refreshTable();

					}
				});
				aev.openFrame();

			}
		});

		JButton modifyBtn = new JButton();
		modifyBtn.setText("�޸�");
		modifyBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(modifyBtn);
		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index > -1) {

					Department selectEmp = list.get(index);
					new ModifyDepartmentView(selectEmp, new CallBack() {

						@Override
						public void call() {
							table.updateUI();
						}
					}).init();
				} else {
					JOptionPane.showMessageDialog(null, "��ѡ��һ������");

				}
			}
		});

		JButton deleteBtn = new JButton();
		deleteBtn.setText("ɾ��");
		deleteBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(deleteBtn);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				delete();

				// deleteBatch();
			}
		});
		JButton manageProjectBtn = new JButton();
		manageProjectBtn.setText("������Ŀ");
		manageProjectBtn.setPreferredSize(new Dimension(120, 30));
		panel3.add(manageProjectBtn);

		manageProjectBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = table.getSelectedRow();
				if (index > -1) {

					Project2DepartmentView view = new Project2DepartmentView(list.get(index));

					view.init();
				} else {
					JOptionPane.showMessageDialog(null, "��ѡ��һ������");

				}
			}
		});

		frame.setVisible(true);

	}

	public void delete() {

		int index = table.getSelectedRow();
		if (index > -1) {
			int option = JOptionPane.showConfirmDialog(null, "ȷ��ɾ����", "ȷ��", JOptionPane.YES_NO_OPTION);
			if (option == 0) {
				int id = list.get(index).getId();
				boolean flag = depDao.delete(id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "����ɹ���");
				} else {
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				}

				refreshTable();
			}

		} else {
			JOptionPane.showMessageDialog(null, "��ѡ��һ������");

		}
	}

	public void deleteBatch() {
		int[] indexs = table.getSelectedRows();
		if (indexs.length > 0) {
			int option = JOptionPane.showConfirmDialog(null, "ȷ��ɾ����", "ȷ��", JOptionPane.YES_NO_OPTION);
			String deleteIds = "";
			if (option == 0) {
				for (int i = indexs.length - 1; i >= 0; i--) {
					deleteIds += list.get(indexs[i]).getId() + ",";
				}
				deleteIds = deleteIds.substring(0, deleteIds.length() - 1);
				depDao.delete(deleteIds);
				refreshTable();
			}

		} else {
			JOptionPane.showMessageDialog(null, "��ѡ��һ������");

		}
	}

	public void refreshTable() {
		list = depDao.search();
		model.setList(list);
		table.updateUI();
	}

	public void refreshTable(List<Department> list) {
		model.setList(list);
		table.updateUI();
	}

	public static void main(String[] args) {
		new DepartmentView().init();
	}
}
