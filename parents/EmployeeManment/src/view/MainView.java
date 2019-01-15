package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.department.DepartmentView;
import view.employee.EmployeeView;
import view.project.ProjectView;
import view.score.ScoreView;

//���
public class MainView {

	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(400, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new FlowLayout());
		JButton empBtn = new JButton();
		empBtn.setText("Ա������");
		empBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(empBtn);
		empBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EmployeeView().init();

			}
		});
		JButton depBtn = new JButton();
		depBtn.setText("���Ź���");
		depBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(depBtn);
		depBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DepartmentView().init();

			}
		});
		JButton proBtn = new JButton();
		proBtn.setText("��Ŀ����");
		proBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(proBtn);
		proBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ProjectView().init();

			}
		});
		JButton scBtn = new JButton();
		scBtn.setText("��Ч����");
		scBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(scBtn);
		scBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreView sv = new ScoreView();
				sv.init();
			}
		});
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new MainView().init();
	}
}
