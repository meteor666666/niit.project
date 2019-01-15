package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Project;

public class Project2DepartmentDao extends BaseDao {

	public List<Project> searchByDepartment(int depId) {
		List<Project> list = new ArrayList<Project>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			rs = stat.executeQuery("select * from v_dep_pro where d_id=" + depId);
			// 6 �Խ�������д���
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("p_id"));
				pro.setName(rs.getString("p_name"));
				list.add(pro);
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

	public List<Project> searchByNotDepartment(int depId) {
		List<Project> list = new ArrayList<Project>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			String sql = "select *from project where id not in (select p_id from v_dep_pro where d_id=" + depId + ")";
			rs = stat.executeQuery(sql);
			// 6 �Խ�������д���
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				list.add(pro);
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

	public boolean add(int depId, int proId) {
		Connection conn = null;
		Statement stat = null;
		int rs = 0;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			String sql = "insert into r_dep_pro(d_id,p_id) values(" + depId + "," + proId + ")";
			rs = stat.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 �ر�
			closeAll(conn, stat, null);
		}

		return rs > 0;
	}

	public boolean delete(int depId, int proId) {
		Connection conn = null;
		Statement stat = null;
		int rs = 0;
		try {
			conn = getConnection();
			// 4 ����statement sql���ִ����
			//
			stat = conn.createStatement();
			// 5 ִ��sql��䲢�õ����
			String sql = "delete from r_dep_pro where d_id=" + depId + " and p_id=" + proId;
			rs = stat.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 �ر�
			closeAll(conn, stat, null);
		}

		return rs > 0;
	}
}
