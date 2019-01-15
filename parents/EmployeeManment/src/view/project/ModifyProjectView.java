package view.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ProjectDao;
import entity.Project;
import util.CallBack;
//�޸�
public class ModifyProjectView extends SuperProjectView {
	CallBack callBack;
	Project selectEmp;

	public ModifyProjectView(Project selectEmp, CallBack callBack) {
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

				// Project pro = new Project();
				selectEmp.setName(name);

				// list.add(pro);
				ProjectDao proDao = new ProjectDao();
				boolean flag = proDao.update(selectEmp);
				if (flag) {
					JOptionPane.showMessageDialog(null, "����ɹ���");
				} else {
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				}

				frame.dispose();
				callBack.call();

			}
		});

		frame.setVisible(true);
	}

}
