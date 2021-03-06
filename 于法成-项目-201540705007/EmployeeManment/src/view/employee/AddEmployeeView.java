package view.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Department;
import entity.Employee;
import util.CallBack;
//增加员工
public class AddEmployeeView extends SuperEmployeeView {

	CallBack callBack;
	private static AddEmployeeView instance;

	private AddEmployeeView(CallBack callBack) {
		this.callBack = callBack;
	}

	public static AddEmployeeView getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddEmployeeView(callBack);
		}
		return instance;
	}

	public void openFrame() {
		if (frame == null) {
			init();
		} else {
			nameText.setText("");
			sexBox.setSelectedItem("男");
			ageText.setText("");
			frame.setVisible(true);
		}
	}

	public void init() {
		super.init();
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String sex = (String) sexBox.getSelectedItem();
				int age = Integer.parseInt(ageText.getText());
				int index = depBox.getSelectedIndex();
				Department dep = depList.get(index);
				Employee emp = new Employee();
				emp.setName(name);
				emp.setAge(age);
				emp.setSex(sex);
				emp.setDep(dep);
				boolean flag = empDao.add(emp);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}

				frame.dispose();
				callBack.call();

			}
		});
	}

}
