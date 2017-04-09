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
	 * @param sql sql���
	 * ��ɾ�Ĳ���
	 * @return �Ƿ�ɹ�
	 */
	public boolean dmlOperate(String sql){
		Statement st = null;
		try {
			st = conn.createStatement();
			boolean isQuery = st.execute(sql);
			if(isQuery){
				throw new Exception("�ǲ�ѯ���");
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
	 * ִ�в�ѯ����
	 * @return �����
	 */
	public ResultSet queryOperate(String sql){
		Statement st = null;
		try {
			st = conn.createStatement();
			boolean isQuery = st.execute(sql);
			if(!isQuery){
				st.cancel();
				throw new Exception("���ǲ�ѯ���");
			}
			return st.getResultSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
	}
}
