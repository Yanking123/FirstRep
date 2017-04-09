package com.practice.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperate {
	private Connection conn;
	public DBOperate() {
		ConnectionManager cm = ConnectionManager.getInstance();
		conn = cm.getConnection();
	}
	
	/**
	 * @param sql sql语句
	 * 增删改操作
	 * @return 是否成功
	 */
	public boolean dmlOperate(String sql){
		Statement st = null;
		try {
			st = conn.createStatement();
			boolean isQuery = st.execute(sql);
			if(isQuery){
				throw new Exception("是查询语句");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 执行查询操作
	 * @return 结果集
	 */
	public ResultSet queryOperate(String sql){
		Statement st = null;
		try {
			st = conn.createStatement();
			boolean isQuery = st.execute(sql);
			if(!isQuery){
				st.cancel();
				throw new Exception("不是查询语句");
			}
			return st.getResultSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
	}
}
