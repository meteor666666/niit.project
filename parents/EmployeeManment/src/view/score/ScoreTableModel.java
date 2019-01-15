package view.score;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import entity.Score;

public class ScoreTableModel extends AbstractTableModel {
//绩效表
	private List<Score> list;
	private Set<Score> saveSet = new HashSet<>();

	private String[] columnNames = { "id", "姓名", "部门", "项目", "成绩", "等级" };

	public ScoreTableModel(List<Score> list) {
		this.list = list;
	}

	public void setList(List<Score> list) {
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

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 4) {

			if (list.get(rowIndex).getPro().getId() != 0) {
				return true;
			}
		}
		return false;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (!aValue.equals("")) {
			list.get(rowIndex).setValue(Integer.parseInt((String) aValue));
			saveSet.add(list.get(rowIndex));
		}

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return list.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return list.get(rowIndex).getEmp().getName();
		} else if (columnIndex == 2) {
			return list.get(rowIndex).getEmp().getDep().getName();
		} else if (columnIndex == 3) {
			return list.get(rowIndex).getPro().getName();
		} else if (columnIndex == 4) {
			return list.get(rowIndex).getValue();
		} else if (columnIndex == 5) {
			return list.get(rowIndex).getGrade();
		} else {
			return "";
		}

	}

	public Set<Score> getSaveSet() {
		return saveSet;
	}

}
