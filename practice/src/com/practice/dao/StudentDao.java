package com.practice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.db.DBOperate;
import com.practice.entity.Student;

public class StudentDao implements Dao<Student> {
	private DBOperate dbo = new DBOperate();

	@Override
	public Student findByProperty(String property, String name) {
		String sql = "select * from student where " + property + "=" + name;
		ResultSet rs = dbo.queryOperate(sql);
		try {
			Student stu = rsToStudent(rs);
			rs.close();
			return stu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Student rsToStudent(ResultSet rs) throws SQLException {
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			Student stu = new Student();
			stu.setId(id);
			stu.setName(name);
			stu.setAge(age);
			return stu;
		} else {
			return null;
		}

	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student";
		List<Student> list = new ArrayList<Student>();
		ResultSet rs = dbo.queryOperate(sql);
		try {
			while (true) {
				Student stu = rsToStudent(rs);
				if (stu == null) {
					break;
				}
				list.add(stu);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
