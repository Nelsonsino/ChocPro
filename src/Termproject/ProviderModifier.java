package Termproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProviderModifier {

	//function of adding new provider
		public static void addProvider() throws ClassNotFoundException{
			Connection connection = null;
			Statement statement = null;
			Class.forName("org.sqlite.JDBC");
			
			try{
				connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(10);
				
				Scanner in = new Scanner(System.in);
				System.out.println("Input provider name: ");
				String pName = in.nextLine();
				System.out.println("Input provider number: ");
				int pNumber = in.nextInt();
				System.out.println("Input provider address: ");
				String pAddress= in.nextLine();
				System.out.println("Input provider city: ");
				String pCity = in.nextLine();
				System.out.println("Input provider ZIP： ");
				String pZip = in.nextLine();
				System.out.println("Input provider state: ");
				String pState = in.nextLine();
				
				statement.executeUpdate("INSERT INTO Provider (pro_name, pro_num, pro_address, "
						+ "pro_city, pro_state, pro_zip) " + "VALUES ('"+pName+"', "
						+ "'"+pNumber+"', '"+pAddress+"', '"+pCity+"', '"+pState+"', '"+pZip+"')");
				
				in.close();
				statement.close();
			}catch(SQLException e){
				System.err.println(e);
			}
		}
		
		//function of editing member
		public static void editProvider() throws ClassNotFoundException{
			Connection connection = null;
			Statement statement = null;
			Class.forName("org.sqlite.JDBC");
			
			try{
				connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(10);
				
				Scanner in2 = new Scanner(System.in);
				System.out.println("Input provider number to update provider info");
				int proNumber = in2.nextInt();
				System.out.println("Input the number to select the info to update:\n1. Name\r\n"
					+ "2. Address\r\n3. City\r\n4. ZIP\r\n5. State\r\n6. Status");
				int infoNum = in2.nextInt();
				switch(infoNum){
					case 1:		
						System.out.println("Input new name: ");
						Scanner in3 = new Scanner(System.in);
						String newName = in3.nextLine();
						statement.executeUpdate("UPDATE provider SET pro_name =  '"+newName+"' WHERE mem_num = '"+proNumber+"'");
						break;
					case 2:
						System.out.println("Input new address: ");
						Scanner in3a = new Scanner(System.in);
						String newAddress = in3a.nextLine();
						statement.executeUpdate("UPDATE provider SET pro_address =  '"+newAddress+"' WHERE mem_num = '"+proNumber+"'");
						break;
					case 3:
						System.out.println("Input new city: ");
						Scanner in3b = new Scanner(System.in);
						String pCity = in3b.nextLine();
						statement.executeUpdate("UPDATE provider SET pro_city =  '"+pCity+"' WHERE mem_num = '"+proNumber+"'");
						break;
					case 4:
						System.out.println("Input new ZIP: ");
						Scanner in3c = new Scanner(System.in);
						String pZip = in3c.nextLine();
						statement.executeUpdate("UPDATE provider SET pro_zip =  '"+pZip+"' WHERE mem_num = '"+proNumber+"'");
						break;
					case 5:
						System.out.println("Input new state: ");
						Scanner in3d = new Scanner(System.in);
						String pState = in3d.nextLine();
						statement.executeUpdate("UPDATE provider SET pro_state =  '"+pState+"' WHERE mem_num = '"+proNumber+"'");
						break;
				}
			}catch(SQLException e){
				System.err.println(e);
			}
		}
		
		
		//function of deleting member
		public static void deleteProvider() throws ClassNotFoundException, SQLException{
			Connection connection = null;
			Statement statement = null;
			Class.forName("org.sqlite.JDBC");
			
			try{
				connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(10);
				
				Scanner in4 = new Scanner(System.in);
				System.out.println("Input the member number to delete the record");
				int proDel = in4.nextInt();
				
				statement.executeUpdate("DELETE FROM provider WHERE pro_num = '"+proDel+"'");
				
				}catch(SQLException e){
					System.out.println(e);
				}
			connection.close();
		}
		
		
		//function of displaying member according to member number
		public static void displayProvider() throws ClassNotFoundException{
			Connection connection = null;
			Statement statement = null;
			Class.forName("org.sqlite.JDBC");
			
			try{
				connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(10);
				
				Scanner in5 = new Scanner(System.in);
				System.out.println("Input the provider number to display the record");
				int memDis = in5.nextInt();
				
				ResultSet rs = statement.executeQuery("SELECT * FROM provider WHERE pro_num = '"+memDis+"'");
				  String pname = rs.getString("pro_name");
				  System.out.println("Provier name: "+ pname);
				 
				  int pnumber = rs.getInt("pro_num");
				  System.out.println("Provier number: "+ pnumber);
				  
				  String paddress = rs.getString("pro_address");
				  System.out.println("Provier name: "+ paddress);
				  
				  String pcity = rs.getString("pro_city");
				  System.out.println("Provier city: "+pcity);
				  
				  String pstate = rs.getString("pro_state");
				  System.out.println("Provier state: "+pstate);
				  
				  String pzip = rs.getString("pro_zip");
				  System.out.println("Provier ZIP: "+pzip + "\n");
				
				}catch(SQLException e){
					System.out.println(e);
				}
		}
		
		
		//function of showing all exiting members
		public static void showAll() throws ClassNotFoundException{
			Connection connection = null;
			Statement statement = null;
			Class.forName("org.sqlite.JDBC");
			
			try{
				connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(10);
				ResultSet rs = statement.executeQuery("SELECT * FROM provider");
				
				while (rs.next()) {
					  String pname = rs.getString("pro_name");
					  System.out.println("Provider name: "+ pname);
					 
					  int pid = rs.getInt("pro_id");
					  System.out.println("Provider number: "+ pid);
					  
					  String paddress = rs.getString("pro_address");
					  System.out.println("Provider name: "+ paddress);
					  
					  String pcity = rs.getString("pro_city");
					  System.out.println("Provider city: "+pcity);
					  
					  String pstate = rs.getString("pro_state");
					  System.out.println("Provider state: "+pstate);
					  
					  String pzip = rs.getString("pro_zip");
					  System.out.println("Provider zip: "+pzip + "\n");
	            }
				}catch(SQLException e){
					System.out.println(e);
				}
		}

}
