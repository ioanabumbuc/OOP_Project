package comPostgres;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import java.util.*;

import view.Login;

import java.sql.*;


public class ConnPostgres {

	private final String url = "jdbc:postgresql://localhost:5432/postgres";
	private final String user = "postgres";
	private final String password = "postgres";
	
	
	public String findCategory(String u) {
		String bog1 = "SELECT category FROM questions WHERE question = '"+u+"'";
		String s = "";
		
		try(Connection conn = this.connect()){
			Statement st4 = conn.createStatement();
			ResultSet rse4 = st4.executeQuery(bog1);
			
			while(rse4.next()) {
				
				s = rse4.getString("category");
			}
			
		}catch(SQLException ex4) {
			System.out.println(ex4.getMessage());
		}
		
		return s;
		
	}
	
	public boolean checkForCategory(String u) {
		
		boolean b = false;
		String bog = "SELECT category FROM questions WHERE question = '"+u+"'";
		
		try(Connection conn = this.connect()){
			Statement st3 = conn.createStatement();
			ResultSet rse3 = st3.executeQuery(bog);
			
			while(rse3.next()) {
				
				if(rse3.getString("category").equals(u)) {
				
					b = true;
				}
			
			}
			
		}catch(SQLException ex3) {
			System.out.println(ex3.getMessage());
		}
		return b;
	}
	
	public String[] getAllQuestions() {
		
		String[] array = new String[100];
		
		String ques = "SELECT question FROM questions";
		try(Connection conn = this.connect()){
			
			int i = 0;
			
			Statement st4 = conn.createStatement();
			ResultSet rs4 = st4.executeQuery(ques);
			
			while(rs4.next()) {
				array[i] = rs4.getString("question");
				i++;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return array;
				
	}
	
	public void getInfo() {

        String SQL = "SELECT * FROM date";
        try (Connection conn = this.connect()) {
        	
        	Statement pstmt = conn.createStatement();
        	ResultSet rs = pstmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("username") + "\t" +
                        rs.getString("parola"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void insertInfo(String u, String v) 
	{
		try(Connection conn = this.connect()){
			Statement pstmt1 = conn.createStatement();
			pstmt1.executeUpdate("INSERT INTO date " 
					+ "VALUES('"+u+"', '"+v+"')");
		conn.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public boolean checkForPassword(String u, String v) {
		
		boolean b = false;
		String qaz = "SELECT parola FROM date WHERE username = '"+u+"'";
		
		try(Connection conn = this.connect()){
			
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(qaz);
			while(rs1.next()) {
				
				if(rs1.getString("parola").equals(v)) {
				
					b = true;
				}
			
			}
		}catch(SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return b;
	}
	
	public void insertQuestion(String u, String v) {
		
		try(Connection conn = this.connect()){
			
			Statement st2 = conn.createStatement();
			st2.executeUpdate("INSERT INTO questions VALUES('"+u+"', '"+v+"')");
			
			//conn.close();
		}catch(SQLException ex1) {
			System.out.println(ex1.getMessage());
		}
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
}
