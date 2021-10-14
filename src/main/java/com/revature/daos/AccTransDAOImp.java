package com.revature.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.Connectionp0;
public class AccTransDAOImp implements AccTransDAO {

	@Override
	public boolean withdraw(int id, double amount) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "UPDATE BalAcc SET balance = balance - ? WHERE accountID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, amount);
			statement.setInt(2, id);
			statement.execute();
			return true;		
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deposit(int id, double amount) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "UPDATE BalAcc SET balance = balance + ? WHERE accountID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, amount);
			statement.setInt(2, id);
			statement.execute();
			
			
			return true;		
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean transfer(int id, double amount, int id2) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "UPDATE BalAcc SET balance = balance + ? WHERE accountID = ?; UPDATE BalAcc SET balance = balance + ? WHERE accountID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, amount);
			statement.setInt(2, id);
			statement.setDouble(3, amount);
			statement.setInt(4, id2);
			statement.execute();
			
			
			return true;		
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

		


		
	
	public Account getAccID(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT * FROM BalAcc WHERE accountID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Account acc = new Account();
			
			if(result.next()) {
				
				acc.setAccID(result.getInt("accountID"));
				acc.setBalance(result.getDouble("balance"));

				
			}
			
			return acc;	
			
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getbal(int id) {
		try(Connection conn = Connectionp0.getConnection()){
			String sql = "SELECT balance FROM BalAcc WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Account acc = new Account();
			
			if(result.next()) {
				
				acc.setBalance(result.getDouble("balance"));

				
			}
			
			return acc;	
			
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
