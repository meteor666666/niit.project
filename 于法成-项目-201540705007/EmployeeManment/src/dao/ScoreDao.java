package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.sql.PreparedStatement;

import entity.Department;
import entity.Employee;
import entity.Project;
import entity.Score;

public class ScoreDao extends BaseDao {

	public List<Score> search() {
		List<Score> list = new ArrayList<Score>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "select * from v_emp_sc ";
			rs = stat.executeQuery(sql);
			// 6 对结果集进行处理
			while (rs.next()) {
				Score sc = new Score();
				sc.setId(rs.getInt("sc_id"));
				Employee emp = new Employee();
				emp.setId(rs.getInt("e_id"));
				emp.setName(rs.getString("e_name"));

				Department dep = new Department();
				dep.setId(rs.getInt("d_id"));
				dep.setName(rs.getString("d_Name"));

				emp.setDep(dep);
				sc.setEmp(emp);

				Project pro = new Project();
				pro.setId(rs.getInt("p_id"));
				pro.setName(rs.getString("p_name"));

				sc.setPro(pro);

				sc.setValue((Integer) rs.getObject("value"));
				sc.setGrade(rs.getString("grade"));

				list.add(sc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, rs);
		}

		return list;
	}

	public void save(Set<Score> set) {
		for (Score sc : set) {
			if (sc.getId() == 0) {
				add(sc);
			} else {
				update(sc);
			}
		}

	}

	public boolean add(Score sc) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();

			// 5 执行sql语句并得到结果
			String sql = "insert into score(e_id,p_id,value) values(?,?,?) ";
			// 4 建立statement sql语句执行器
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, sc.getEmp().getId());
			pstat.setInt(2, sc.getPro().getId());
			pstat.setInt(3, sc.getValue());
			rs = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, pstat, null);
		}

		return rs > 0;
	}

	public boolean update(Score sc) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();

			// 5 执行sql语句并得到结果
			String sql = "update score set value=? where id=?";
			// 4 建立statement sql语句执行器
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, sc.getValue());
			pstat.setInt(2, sc.getId());
			rs = pstat.executeUpdate();

		} catch (SQLException e) {
			//
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, pstat, null);
		}

		return rs > 0;
	}
}
