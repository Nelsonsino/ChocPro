package Termproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class reportCreater {
	public static void memREC() throws ClassNotFoundException, SQLException, IOException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
						
			Scanner in = new Scanner(System.in);
			System.out.println("Input member number to create report");
			int recID = in.nextInt();
			ResultSet rs = statement.executeQuery("SELECT * FROM Member WHERE mem_id = '"+recID+"'");
			
			Date date = new Date();
			String memRe1 = rs.getString("mem_name");
			SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			String memRe2 = df.format(date);
			
			String pathname = memRe1 + " " + memRe2 + ".txt";
			File filename = new File(pathname);
			
			String memAddress = rs.getString("mem_address");
			String memCity = rs.getString("mem_city");
			String memState = rs.getString("mem_state");
			String memZip = rs.getString("mem_zip");
			
			ResultSet rs2 =connection.createStatement().executeQuery("SELECT * FROM [Mem_report] WHERE mem_id = '"+recID+"'"); 
			
			FileWriter writer = new FileWriter(filename);
			
			writer.write("Member name: " + memRe1 + "\r\n");
			writer.write("Member number: " + recID + "\r\n");
			writer.write("Member street address: " + memAddress + "\r\n");
			writer.write("Member city: " + memCity + "\r\n");
			writer.write("Member state: " + memState + "\r\n");
			writer.write("Member ZIP code: " + memZip + "\r\n");
			
			while(rs2.next()){
				String serDate = "Service date: " + rs2.getString(1);
				String proName = "Provider name: " + rs2.getString(2);
				String serName = "Service name: " + rs2.getString(3);
				
				System.out.println(serDate);
				writer.write(serDate + "\r\n");
				System.out.println(proName);
				writer.write(proName + "\r\n");
				System.out.println(serName);
				writer.write(serName + "\r\n");
			}
			
			writer.close();
			
			}catch(SQLException e){
				System.out.println(e);
			}
		statement.close();
		connection.close();
	}

	public static void proREC() throws ClassNotFoundException, SQLException, IOException{
		Connection connection = null;
		Statement statement = null;
		Class.forName("org.sqlite.JDBC");
	
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:ChocoholicsAnonymous.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
		
			Scanner in2 = new Scanner(System.in);
			System.out.println("Input provider number to create report:");
			int recPID = in2.nextInt();
			ResultSet rs3 = statement.executeQuery("SELECT * FROM Provider WHERE pro_id = '"+recPID+"'");
		
			Date date2 = new Date();
			String proRe1 = rs3.getString("pro_name");
			SimpleDateFormat df2 = new SimpleDateFormat("MM-dd-yyyy");
			String proRe2 = df2.format(date2);
		
			String pathname2 = proRe1 + " " + proRe2 + ".txt";
			File filename2 = new File(pathname2);
			
			String proAddress = rs3.getString("pro_address");
			String proCity = rs3.getString("pro_city");
			String proState = rs3.getString("pro_state");
			String proZip = rs3.getString("pro_zip");
			
			ResultSet rs4 =connection.createStatement().executeQuery("SELECT * FROM [Pro_report] WHERE pro_id = '"+recPID+"'"); 
		
			FileWriter writer = new FileWriter(filename2);
			
			writer.write("Member name: " + proRe1 + "\r\n");
			writer.write("Member number: " + recPID + "\r\n");
			writer.write("Member street address: " + proAddress + "\r\n");
			writer.write("Member city: " + proCity + "\r\n");
			writer.write("Member state: " + proState + "\r\n");
			writer.write("Member ZIP code: " + proZip + "\r\n");
			
			int sum = 0;
			
			while(rs4.next()){
				String proDate = "Service date: " + rs4.getString(1);
				String proSysDate = "Date and time received by the computer: " + rs4.getString(2);
				String memName2 = "Member name: " + rs4.getString(3);
				String memNumber = "Member number: " + rs4.getString(4);
				String serCode = "Service code: " + rs4.getString(5);
				String serFee = "Fee to be paid: " + rs4.getString(6);
				
				System.out.println(proDate);
				writer.write(proDate + "\r\n");
				System.out.println(proSysDate);
				writer.write(proSysDate + "\r\n");
				System.out.println(memName2);
				writer.write(memName2 + "\r\n");
				System.out.println(memNumber);
				writer.write(memNumber + "\r\n");
				System.out.println(serCode);
				writer.write(serCode + "\r\n");
				System.out.println(serFee);
				writer.write(serFee + "\r\n");
				int temp = rs4.getInt(6);
				sum = sum + temp;
			}
			
			System.out.println("Total fee is: " + sum);
			writer.write("Total fee is: " + sum);
			writer.close();
			
			}catch(SQLException e){
				System.out.println(e);
			}
		statement.close();
		connection.close();
		
	}

public static void main(String [] args) throws ClassNotFoundException, SQLException, IOException{
	//addMember();
	//editMember();
	//deleteMember();
	//displayMember();
	//showAll();
	//getService();
	//memREC();
}
	
}
