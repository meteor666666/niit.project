package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Employee;

public class EmployeeDao  extends BaseDao {

	public List<Employee> search() {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			String sql = "select e.*,d.name as dName,emp_count from employee as e left join "
					+ " department as d on e.d_id=d.id";
			rs = stat.executeQuery(sql);
			// 6 �Խ�������д���
			//
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				Department dep = new Department();
				dep.setId(rs.getInt("d_id"));
				dep.setName(rs.getString("dName"));
				dep.setEmpCount(rs.getInt("emp_count"));
				emp.setDep(dep);
				list.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 �ر�
			closeAll(conn, stat, rs);
		}

		return list;
	}

	public List<Employee> searchByCondition(Employee condition) {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			String where = " where 1=1 ";
			if (!condition.getName().equals("")) {
				where += " and e.name='" + condition.getName() + "'";
			}
			if (!condition.getSex().equals("")) {
				where += " and sex='" + condition.getSex() + "'";
			}
			if (condition.getAge() != -1) {
				where += " and age=" + condition.getAge();
			}
			if (condition.getDep().getId() != -1) {
				where += " and d_id=" + condition.getDep().getId();
			}
			String sql = "select e.*,d.name as dName,emp_count from employee as e left join  department as d on e.d_id=d.id "
					+ where;
			rs = stat.executeQuery(sql);

			// 6 �Խ�������д���
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				Department dep = new Department();
				dep.setId(rs.getInt("d_id"));
				dep.setName(rs.getString("dName"));
				dep.setEmpCount(rs.getInt("emp_count"));
				emp.setDep(dep);
				list.add(emp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 �ر�
			closeAll(conn, stat, rs);
		}

		return list;
	}

	public boolean add(Employee emp) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			int rs = stat.executeUpdate("insert into employee(name,sex,age,d_id) values('" + emp.getName() + "','"
					+ emp.getSex() + "'," + emp.getAge() + "," + emp.getDep().getId() + ")");
			// 6 �Խ�������д���
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return flag;
	}

	public boolean update(Employee emp) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			// Statement stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			// String sql = "update employee set name='" + selectEmp.getName() + "',sex='" +
			// selectEmp.getSex() + "',age="
			// + selectEmp.getAge() + " where id=" + selectEmp.getId();
			// System.out.println(sql);
			// int rs = stat.executeUpdate(sql);
			String sql = "update employee set name=?,sex=?,age=?,d_id=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, emp.getName());
			pstat.setString(2, emp.getSex());
			pstat.setInt(3, emp.getAge());
			pstat.setInt(4, emp.getDep().getId());
			pstat.setInt(5, emp.getId());
			int rs = pstat.executeUpdate();
			// 6 �Խ�������д���
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstat, null);
		}
		return flag;
	}

	public boolean delete(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			String sql = "delete from employee where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int rs = pstat.executeUpdate();
			// 6 �Խ�������д���
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstat, null);
		}
		return flag;
	}

	public boolean delete(String ids) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "delete from employee where id in (" + ids + ")";
			stat = conn.createStatement();

			int rs = stat.executeUpdate(sql);
			// 6 �Խ�������д���
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return flag;
	}

}
