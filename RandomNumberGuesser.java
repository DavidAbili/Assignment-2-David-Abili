import java.util.Scanner;
/*Class: CMSC203
 * Instructor: Dr.Alexander
 * Due 9/30/21
 * Platform compiler:
 * I pledge that I have completed the programming assignment independently
 * I have not copied the code from a student or any source
 * I have not given my code to any student
 * David Abili
 */
public class RandomNumberGuesser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		//calls method
		RNG.getCount();
		RNG.rand();
		//create and inializes variables
		int random = RNG.rand();
		int max = 100;
		int min = 0;
		String answer = "y";
		//prompt user
		System.out.println("Enter your first guess:");
		//stores variable
		int num = input.nextInt();
		//determines what to print based on user
		if(RNG.inputValidation(num,0,100)) {
			System.out.println("Number of guesses " + RNG.getCount());
			if(num > random) {
				System.out.println("Your guess is to high");
				max = num;
			} else {
				System.out.println("Your guess is to low");
				min = num;
			}
		}
		// loops until false
		do {
			//prompts user and shows range
			System.out.println("Enter your next guess between " + min +" and " + max);
		    // store variable
			num = input.nextInt();
			//determines what to proint based on user 
			if(RNG.inputValidation(num,min,max)) {
				System.out.println("Number of guesses " + RNG.getCount());
				if(num > random) {
					System.out.println("Your guess is to high");
					max = num;
				} else if(num < random) {
					System.out.println("Your guess is to low");
					min = num;
				} else if(num==random) {
					System.out.println("Congrats");
					//prompts user for another round
					System.out.println("Do you want to play again?(y or n)");
					answer = input.nextLine();
					answer = input.nextLine();
				    // if true resets game and prompts user again
					if(answer.equals("y")) {
						min = 0;
						max = 100;
						RNG.resetCount();
						random = RNG.rand();
						System.out.println("Enter your first guess:");
						num = input.nextInt();
						if(num > random) {
							System.out.println("Your guess is to high");
							max = num;
						} else if(num < random) {
							System.out.println("Your guess is to low");
							min = num;
						}
                         // if false ends the game
					} else if(answer.equals("n")) {
						System.out.println("Thanks For Playing");
					}
				}
			}
		}while(num != random || answer.equals("y"));



	}

}
