package Termproject;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class serviceController {
	
	public static void getService() throws ClassNotFoundException, SQLException{
		
		
		
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			Scanner in = new Scanner(System.in);
			System.out.println("Input the member number:");
			int memDis = in.nextInt();
			
			in.nextLine();
			ResultSet rs1 = statement.executeQuery("SELECT * FROM Member WHERE mem_id = '"+memDis+"'");
			
			if(rs1.next()){
				String memValid = rs1.getString("mem_status");				
				if(memValid.equals(false)){
					System.out.println("The membership is suspended.");
				}else{										
					System.out.println("Input the provider number:");
					int reProId = in.nextInt();
					in.nextLine();
															
					System.out.println("Input date as MM-dd-yyyy");
					String date = in.nextLine();			
					String timestamp = new java.text.SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(new Date());			
							
					boolean reInput = true;
					while(reInput == true){
						System.out.println("Input service code:");
						int serCode = in.nextInt();
					
						ResultSet rs2 = statement.executeQuery("SELECT * FROM Service WHERE ser_num = '"+serCode+"'");
						
						int reSerNum = 0;
						String reSerName = null;
						while (rs2.next()) {
							System.out.println("Service name: " + rs2.getString("ser_name"));
							reSerNum = rs2.getInt("ser_num");
							reSerName = rs2.getString("ser_name");
							}
						
						System.out.println("Is this the right service? 1 for yes, 2 for no: ");
						int confirmNum = in.nextInt();
						
						
						if(confirmNum == 1){					
							reInput = false;
							System.out.println("Do you have any comment? 1 for yes, 2 for no: ");
							int confirmNum2 = in.nextInt();
							String mComment = null;
							if(confirmNum2 == 1){
								Scanner in2 = new Scanner(System.in);
								System.out.println("Enter your comment: ");
								mComment = in2.nextLine();
								
								}
							statement.executeUpdate("INSERT INTO Record (ser_comment, ser_num, "
									+ "ser_name, ser_sys_date, ser_date, mem_id, pro_id) VALUES "
									+ "('"+mComment+"', '"+reSerNum+"', '"+reSerName+"', '"+timestamp+"', "
									+ "'"+date+"', '"+memDis+"', '"+reProId+"')");
							}
						}
						
					}
				}else{
					System.out.println("There is no data for this number.");
				}			
			}catch(SQLException e){
				System.err.print(e);
		}
		connection.close();
	}
	
	
	
	
}
