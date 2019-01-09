package view.department.mangeProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Project;

public class Project2DepartmentTableModel extends AbstractTableModel {

	private List<Project> list;
	private String[] columnNames = { "id", "Ãû³Æ" };

	public Project2DepartmentTableModel(List<Project> list) {
		this.list = list;
	}

	public void setList(List<Project> list) {
		this.list = list;
	}

	public String getColumnName(int column) {

		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return list.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return list.get(rowIndex).getName();
		} else {
			return "";
		}

	}

}
