package Termproject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainInterface {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
		//do while begin
		do{
			
			System.out.println("Intert 1 for Member.");
			System.out.println("Intert 2 for Provider.");
			System.out.println("Intert 3 for Service.");
			System.out.println("Intert 4 for Report.");
		Scanner in1 = new Scanner(System.in);
		int input1 = in1.nextInt();
		
		switch(input1){
		
		//case 1 begin
		case 1:
			memberModifier mm = new memberModifier();
			System.out.println("Intert 1 to add member.");
			System.out.println("Intert 2 to edit member.");
			System.out.println("Intert 3 to delete member.");
			System.out.println("Intert 4 to display member.");
			System.out.println("Intert 5 to show all members.");
			System.out.println("Intert 6 to main interface.");
			
			Scanner in2 = new Scanner(System.in);
			int input2 = in2.nextInt();
			switch(input2){
			case 1:
				mm.addMember();
				break;
			case 2:
				mm.editMember();
				break;
			case 3:
				mm.deleteMember();
				break;
			case 4:
				mm.displayMember();
				break;
			case 5:
				mm.showAll();
				break;
			case 6:
				break;
			}
			break;
		//case 1 end
			
			
		//case 2 begin
		case 2:
			ProviderModifier pm = new ProviderModifier();
			System.out.println("Intert 1 to add provider.");
			System.out.println("Intert 2 to edit provider.");
			System.out.println("Intert 3 to delete provider.");
			System.out.println("Intert 4 to display provider.");
			System.out.println("Intert 5 to show all providers.");
			System.out.println("Intert 6 to main interface.");
						
			Scanner in3 = new Scanner(System.in);
			int input3 = in3.nextInt();
			switch(input3){
			case 1:
				pm.addProvider();
				break;
			case 2:
				pm.editProvider();
				break;
			case 3:
				pm.deleteProvider();
				break;
			case 4:
				pm.displayProvider();
				break;
			case 5:
				pm.showAll();
				break;
			case 6:
				break;
			}
			break;
			//case 2 end
			
			//case 3 begin
			case 3:
				serviceController sc = new serviceController();
				System.out.println("Intert 1 to create service.");
				System.out.println("Intert 2 to main interface.");
							
				Scanner in4 = new Scanner(System.in);
				int input4 = in4.nextInt();
				switch(input4){
			case 1:
				sc.getService();
				break;
			case 2:
				break;
				}
				break;
			//case 3 end
			
			//case 4 begin
			case 4:
				reportCreater rc = new reportCreater();
				System.out.println("Intert 1 to get member report.");
				System.out.println("Intert 2 to get provider report.");
				System.out.println("Intert 3 to main interface.");
							
				Scanner in5 = new Scanner(System.in);
				int input5 = in5.nextInt();
				switch(input5){
			case 1:
				rc.memREC();
				break;
			case 2:
				rc.proREC();
				break;
				}
				break;
			//case 4 end
		}
		
		
		}while(true);//do while end
	}

}
