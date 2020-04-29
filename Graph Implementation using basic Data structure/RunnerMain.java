import java.util.Scanner;

public class RunnerMain {

	public RunnerMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		String userCommand = "";
		Scanner userInput = new Scanner(System.in);

		HalifaxMap halifaxMap = new HalifaxMap();
	

		do { 
			// Find out what the user wants to do
			System.out.println("What kind of operation would you like to perform ?");
			userCommand = userInput.next();

			// Do what the user asked for.

			Boolean booleanOutcome =false;
			if (userCommand.equalsIgnoreCase("add")) {
				try {
					int x1, y1;
					
					// request user to input coordinates
					System.out.println("provide X  co-ordinates");
					x1 = Integer.parseInt(userInput.next().trim()); 
				
					System.out.println("provide Y  co-ordinates");
					y1 = Integer.parseInt(userInput.next()); 
					
					//Call newIntersection method
					booleanOutcome = halifaxMap.newIntersection(x1,y1);
					System.out.println("Add \"" + x1 + "," + y1 + "\" outcome " + booleanOutcome);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(booleanOutcome);
				}
				
			} else if (userCommand.equalsIgnoreCase("Define")) {
				try {
					int x1, y1, x2, y2;
					
					// request user to input coordinates
					System.out.println("provide Source Intersection  co-ordinates");
					
					System.out.println("provide X  co-ordinates");
					x1 = Integer.parseInt(userInput.next().trim());
					System.out.println("provide Y  co-ordinates");
					y1 = Integer.parseInt(userInput.next().trim());
	
					System.out.println("provide Destination Intersection  co-ordinates");
					
					System.out.println("provide X  co-ordinates");
					x2 = Integer.parseInt(userInput.next().trim());
					System.out.println("provide Y  co-ordinates");
					y2 = Integer.parseInt(userInput.next().trim());
	
					//Call defineRoad method
					booleanOutcome = halifaxMap.defineRoad(x1, y1, x2, y2);
					System.out.println(
							"Define \"" + x1 + "," + y1 + " to " + x2 + "," + y2 + " \" outcome " + booleanOutcome);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(booleanOutcome);
				}
				
			} else if (userCommand.equalsIgnoreCase("navigate")) {
				try {
					int x1, y1, x2, y2;
					
					// request user to input coordinates
					System.out.println("provide Source Intersection  co-ordinates");
					
					System.out.println("provide X  co-ordinates");
					x1 = Integer.parseInt(userInput.next().trim());
					System.out.println("provide Y  co-ordinates");
					y1 = Integer.parseInt(userInput.next().trim());
	
					System.out.println("provide Destination Intersection  co-ordinates");
					
					System.out.println("provide X  co-ordinates");
					x2 = Integer.parseInt(userInput.next().trim());
					System.out.println("provide Y  co-ordinates");
					y2 = Integer.parseInt(userInput.next().trim());
	
					//Call navigate method
					halifaxMap.navigate(x1, y1, x2, y2);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(booleanOutcome);
				}

			} else if (userCommand.equalsIgnoreCase("quit")) {
				System.out.println("Quit");
			} else {
				System.out.println("Bad command: " + userCommand);
			}
		} while (!userCommand.equalsIgnoreCase("quit"));

		// The user is done so close the stream of user input before ending.

		userInput.close();


	}

}
