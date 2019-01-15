package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Project;

public class ProjectDao extends BaseDao {

	public List<Project> search() {
		List<Project> list = new ArrayList<Project>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			rs = stat.executeQuery("select * from project");
			// 6 �Խ�������д���
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//
			e.printStackTrace();
		} finally {
			// 7 �ر�
			closeAll(conn, stat, rs);
		}

		return list;
	}

	public List<Project> searchByCondition(Project condition) {
		List<Project> list = new ArrayList<Project>();
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
				where += " and name='" + condition.getName() + "'";
			}

			String sql = "select * from project " + where;
			rs = stat.executeQuery(sql);
			// 6 �Խ�������д���
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				list.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 �ر�
			closeAll(conn, stat, rs);
		}
		return list;
	}

	public boolean add(Project pro) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			int rs = stat.executeUpdate("insert into project(name) values('" + pro.getName() + "')");
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

	public boolean update(Project pro) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			// Statement stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			// String sql = "update project set name='" + selectEmp.getName() + "',sex='"
			// +
			// selectEmp.getSex() + "',age="
			// + selectEmp.getAge() + " where id=" + selectEmp.getId();
			// System.out.println(sql);
			// int rs = stat.executeUpdate(sql);
			String sql = "update project set name=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pro.getName());
			pstat.setInt(2, pro.getId());
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
			conn.setAutoCommit(false);
			String sql = "delete from project where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int rs = pstat.executeUpdate();
			pstat.close();
			sql = "delete from r_dep_pro where p_id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			rs = pstat.executeUpdate();
			conn.commit();
			// conn.setAutoCommit(true);
			// 6 �Խ�������д���
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			String sql = "delete from project where id in (" + ids + ")";
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
