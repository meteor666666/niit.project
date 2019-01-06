package view.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Department;
import entity.Employee;
import util.CallBack;

public class ModifyEmployeeView extends SuperEmployeeView {
	CallBack callBack;
	Employee selectEmp;

	public ModifyEmployeeView(Employee selectEmp, CallBack callBack) {
		this.callBack = callBack;
		this.selectEmp = selectEmp;
	}

	public void init() {
		super.init();
		nameText.setText(selectEmp.getName());
		sexBox.setSelectedItem(selectEmp.getSex());
		ageText.setText(String.valueOf(selectEmp.getAge()));

		depBox.setSelectedItem(selectEmp.getDep().getName());

		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String sex = (String) sexBox.getSelectedItem();
				int age = Integer.parseInt(ageText.getText());
				// Employee emp = new Employee();
				selectEmp.setName(name);
				selectEmp.setAge(age);
				selectEmp.setSex(sex);

				Department dep = depList.get(depBox.getSelectedIndex());
				selectEmp.setDep(dep);
				// list.add(emp);

				boolean flag = empDao.update(selectEmp);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}

				frame.dispose();
				callBack.call();

			}
		});

		frame.setVisible(true);
	}

}
