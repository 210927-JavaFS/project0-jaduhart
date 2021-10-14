package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.Connectionp0;

public class UserDAOImp implements UserDAO {

	@Override
	public List<User> findAll() {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT * FROM IDNames;";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<User> list = new ArrayList<>();
			
			while(result.next()) {
				User User = new User();
				User.setFirstName(result.getString("first_name"));
				User.setLastName(result.getString("last_name"));
				User.setUserId(result.getInt("userID"));
				User.setAccId(result.getInt("accountID"));
				User.setAccLevel(result.getInt("acc_level"));
				list.add(User);
				
			}
			return list;	
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUser(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT * FROM IDNames WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery(sql);
			User user = new User();
			
			if(result.next()) {
				user.setFirstName(result.getString("first_name"));
				user.setLastName(result.getString("last_name"));
				user.setUserId(result.getInt("userID"));
				user.setAccId(result.getInt("accountID"));
				user.setAccLevel(result.getInt("acc_level"));

				
			}
			return user;	
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User findUserPass(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT passwd FROM IDNames WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery(sql);
			User user = new User();
			
			if(result.next()) {
				user.setPassword(result.getString("passwd"));

				
			}
			return user;	
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

	@Override
	public boolean addUser(User user) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "INSERT INTO IDNames (first_name, last_name, userID, accountID, acc_level)" + "VALUES (?,?,?,?,?);";
			
			int count = 0;
			PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(++count, user.getFirstName());
				statement.setString(++count, user.getLastName());
				statement.setInt(++count, user.getUserId());
				statement.setInt(++count, user.getAccId());
				statement.setInt(++count, user.getAccLevel());
				statement.execute();
				
			
			return true;	
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getRole(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT acc_level FROM IDNames WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery(sql);
			User User = new User();
			
			if(result.next()) {
				User.setAccLevel(result.getInt("acc_level"));

				
			}
			return User;	
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean makeRole(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "INSERT INTO acc_level FROM IDNames WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery(sql);
			User User = new User();
			
			if(result.next()) {
				User.setAccLevel(result.getInt("acc_level"));

				
			}
			return true;	
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User passwd(String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userActive(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserID(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT * FROM IDNames WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			User user = new User();
			
			if(result.next()) {
				user.setFirstName(result.getString("first_name"));
				user.setLastName(result.getString("last_name"));
				user.setUserId(result.getInt("userID"));
				user.setAccId(result.getInt("accountID"));
				user.setAccLevel(result.getInt("acc_level"));
				user.setPassword(result.getString("passwd"));

				
			}
			sql = "SELECT balance FROM BalAcc WHERE accountID = ?;";
			
			statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getAccId());
			if (result.next()) {
				user.setBalance(result.getDouble("balance"));
			}
			
			return user;	
			
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int onlyAccID(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT accountID FROM BalAcc WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			int curI = 0;
			
			if(result.next()) {
				curI = result.getInt("accountID");


				
			}
						
			return curI;	
			
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
