package view.department;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.DepartmentDao;
import entity.Department;
import util.CallBack;
//增加
public class AddDepartmentView extends SuperDepartmentView {

	CallBack callBack;
	private static AddDepartmentView instance;

	private AddDepartmentView(CallBack callBack) {
		this.callBack = callBack;
	}

	public static AddDepartmentView getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddDepartmentView(callBack);
		}
		return instance;
	}

	public void openFrame() {
		if (frame == null) {
			init();
		} else {
			nameText.setText("");
	
			frame.setVisible(true);
		}
	}

	public void init() {
		super.init();
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				
				Department dep = new Department();
				dep.setName(name);

				DepartmentDao depDao = new DepartmentDao();
				boolean flag = depDao.add(dep);
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
