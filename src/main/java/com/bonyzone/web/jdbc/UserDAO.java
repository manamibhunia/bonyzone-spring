package com.bonyzone.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bonyzone.web.model.UserTO;
import com.bonyzone.web.util.HashUtil;

public class UserDAO {

	public UserTO findUserByEmail(String email) throws IOException, SQLException {
		Datasource ds = Datasource.getInstance();
        Connection conn = ds.getConnection();
		Statement stmt = null;
		UserTO user =  null;
		try {
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM user WHERE email='"+email+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				user = new UserTO();
				user.setUserId(rs.getLong("user_id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAddress(rs.getString("address"));
				user.setLast4digitcc(rs.getString("last4digit"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int createUser(UserTO user) throws Exception {
		Datasource ds = Datasource.getInstance();
        Connection conn = ds.getConnection();
		Statement stmt = null;
		int rowUpdated = 0;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO user(email, firstName, lastName, password, address) values('"+user.getEmail()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+HashUtil.getSaltedHash(user.getPassword())+"','"+user.getAddress()+"')";
			rowUpdated = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

}
