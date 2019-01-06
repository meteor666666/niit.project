package view.department;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.DepartmentDao;
import entity.Department;
import util.CallBack;

public class ModifyDepartmentView extends SuperDepartmentView {
	CallBack callBack;
	Department selectEmp;

	public ModifyDepartmentView(Department selectEmp, CallBack callBack) {
		this.callBack = callBack;
		this.selectEmp = selectEmp;
	}

	public void init() {
		super.init();
		nameText.setText(selectEmp.getName());


		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				
				// Department dep = new Department();
				selectEmp.setName(name);
		
				// list.add(dep);
				DepartmentDao depDao = new DepartmentDao();
				boolean flag = depDao.update(selectEmp);
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
