package Termproject;

import java.sql.*;
import java.util.Scanner;

public class memberModifier {
	public static void addMember() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Scanner in = new Scanner(System.in);
			System.out.println("Input member name: ");
			String mName = in.nextLine();
			System.out.println("Input member address: ");
			String mAddress= in.nextLine();
			System.out.println("Input member city: ");
			String mCity = in.nextLine();
			System.out.println("Input member ZIP： ");
			String mZip = in.nextLine();
			System.out.println("Input member state: ");
			String mState = in.nextLine();
			System.out.println("Input member status: ");
			boolean mStatus = in.nextBoolean();
			
			statement.executeUpdate("UPDATE sqlite_sequence SET seq = 100000000 WHERE name='Member'");
			statement.executeUpdate("INSERT INTO Member (mem_name, mem_address, mem_city, mem_state, mem_zip, mem_status) VALUES ('"+mName+"', '"+mAddress+"', '"+mCity+"', '"+mState+"', '"+mZip+"', '"+mStatus+"')");
			
		}catch(SQLException e){
			System.err.println(e);
		}
		statement.close();
	}
	
	public static void editMember() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Scanner in2 = new Scanner(System.in);
			System.out.println("Input member number to update member info");
			int memNumber = in2.nextInt();
			System.out.println("Input the number to select the info to update:\n1. Name\r\n"
				+ "2. Address\r\n3. City\r\n4. ZIP\r\n5. State\r\n6. Status");
			int infoNum = in2.nextInt();
			switch(infoNum){
				case 1:		
					System.out.println("Input new name: ");
					Scanner in3 = new Scanner(System.in);
					String newName = in3.nextLine();
					statement.executeUpdate("UPDATE member SET mem_name =  '"+newName+"' WHERE mem_id = '"+memNumber+"'");
					break;
				case 2:
					System.out.println("Input new address: ");
					Scanner in3a = new Scanner(System.in);
					String newAddress = in3a.nextLine();
					statement.executeUpdate("UPDATE member SET mem_address =  '"+newAddress+"' WHERE mem_id = '"+memNumber+"'");
					break;
				case 3:
					System.out.println("Input new city: ");
					Scanner in3b = new Scanner(System.in);
					String mCity = in3b.nextLine();
					statement.executeUpdate("UPDATE member SET mem_city =  '"+mCity+"' WHERE mem_id = '"+memNumber+"'");
					break;
				case 4:
					System.out.println("Input new ZIP: ");
					Scanner in3c = new Scanner(System.in);
					String mZip = in3c.nextLine();
					statement.executeUpdate("UPDATE member SET mem_zip =  '"+mZip+"' WHERE mem_id = '"+memNumber+"'");
					break;
				case 5:
					System.out.println("Input new state: ");
					Scanner in3d = new Scanner(System.in);
					String mState = in3d.nextLine();
					statement.executeUpdate("UPDATE member SET mem_state =  '"+mState+"' WHERE mem_id = '"+memNumber+"'");
					break;
				case 6:
					System.out.println("Input new state: ");
					Scanner in3e = new Scanner(System.in);
					boolean mStatus = in3e.nextBoolean();
					statement.executeUpdate("UPDATE member SET mem_status =  '"+mStatus+"' WHERE mem_id = '"+memNumber+"'");
					break;
			}
		}catch(SQLException e){
			System.err.println(e);
		}
		statement.close();
	}
	
	public static void deleteMember() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Scanner in4 = new Scanner(System.in);
			System.out.println("Input the member number to delete the record");
			int memDel = in4.nextInt();
			
			statement.executeUpdate("DELETE FROM member WHERE mem_id = '"+memDel+"'");
						
			}catch(SQLException e){
				System.out.println(e);
			}
		connection.close();
		statement.close();
	}	
	
	public static void displayMember() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Scanner in5 = new Scanner(System.in);
			System.out.println("Input the member number to display the record");
			int memDis = in5.nextInt();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM member WHERE mem_id = '"+memDis+"'");
			  String mname = rs.getString("mem_name");
			  System.out.println("Member name: "+ mname);
			 
			  int mnumber = rs.getInt("mem_id");
			  System.out.println("Member number: "+ mnumber);
			  
			  String maddress = rs.getString("mem_address");
			  System.out.println("Member name: "+ maddress);
			  
			  String mcity = rs.getString("mem_city");
			  System.out.println("Member city: "+mcity);
			  
			  String mstate = rs.getString("mem_state");
			  System.out.println("Member state: "+mstate);
			  
			  String mzip = rs.getString("mem_zip");
			  System.out.println("Member state: "+mzip);
			  
			  boolean mstatus = rs.getBoolean("mem_status");
			  System.out.println("Member status: "+ mstatus + "\n");
			
			}catch(SQLException e){
				System.out.println(e);
			}
		statement.close();
	}
	
	public static void showAll() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM member");
			
			while (rs.next()) {
				  String mname = rs.getString("mem_name");
				  System.out.println("Member name: "+ mname);
				 
				  int mnumber = rs.getInt("mem_id");
				  System.out.println("Member number: "+ mnumber);
				  
				  String maddress = rs.getString("mem_address");
				  System.out.println("Member name: "+ maddress);
				  
				  String mcity = rs.getString("mem_city");
				  System.out.println("Member city: "+mcity);
				  
				  String mstate = rs.getString("mem_state");
				  System.out.println("Member state: "+mstate);
				  
				  String mzip = rs.getString("mem_zip");
				  System.out.println("Member ZIP: "+mzip);
				  
				  String mstatus = rs.getString("mem_status");
				  System.out.println("Member status: "+ mstatus + "\n");
            }
			}catch(SQLException e){
				System.out.println(e);
			}
		statement.close();
	}
}

