package view.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ProjectDao;
import entity.Project;
import util.CallBack;

public class AddProjectView extends SuperProjectView {

	CallBack callBack;
	private static AddProjectView instance;

	private AddProjectView(CallBack callBack) {
		this.callBack = callBack;
	}

	public static AddProjectView getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddProjectView(callBack);
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

				Project pro = new Project();
				pro.setName(name);

				ProjectDao proDao = new ProjectDao();
				boolean flag = proDao.add(pro);
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
