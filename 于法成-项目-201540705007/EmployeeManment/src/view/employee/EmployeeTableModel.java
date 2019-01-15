package view.employee;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Employee;
//员工展示表
public class EmployeeTableModel extends AbstractTableModel {

	private List<Employee> list;
	private String[] columnNames = { "id", "姓名", "性别", "年龄", "部门" };

	public EmployeeTableModel(List<Employee> list) {
		this.list = list;
	}

	public void setList(List<Employee> list) {
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
		return true;
	}
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    
    
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return list.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return list.get(rowIndex).getName();
		} else if (columnIndex == 2) {
			return list.get(rowIndex).getSex();
		} else if (columnIndex == 3) {
			return list.get(rowIndex).getAge();
		} else if (columnIndex == 4) {
			return list.get(rowIndex).getDep().getName();
		} else {
			return "";
		}

	}

}
