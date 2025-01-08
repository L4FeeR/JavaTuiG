import java.util.Scanner;
import java.util.Random;

public class RPS { 
    public void splashScreen(){
        System.out.println("How to play this game?");
        System.out.println("""
            You can choose three objects namely rock paper scissor with their index number,
            Rock breaks scissor,
            Scissor cuts paper,
            paper obsorbs rock.
            These are the things to be noted in the game.
            Points are allocated depending upon how many wins, loses and draws occurs.
            

                                        Warning:

            This game is purely based on random chose from system, so its completely not a intelligent based one
            as you cannot predict systems (most especially java's) random function. 
            You can crack this game only if u understand and have a well knowledge about the random functions in programming languages.

            \"If you want to crack the system, learn the system first\"


            Press [Enter] to start the game...
        """);
        Scanner tempScanner = new Scanner(System.in);
        tempScanner.nextLine();
        System.out.print("\033[H\033[2J"); //to clear the screen <my new findings, how is it?>
        
    }
    public void mainScreen() {
        int points = 0;
        int loses = 0;
        int draws = 0;
        int rock=0;
        int paper=0;
        int scissor=0;
        int max=0;
        String cup="having maximum occurrence";
        int x = 1;
        Scanner inputScanner = new Scanner(System.in); // Create Scanner outside the loop

        while (x != 0) {
            System.out.println("\t\t----------------------------");
            System.out.println("\t\t1. Rock\n\t\t2. Paper\n\t\t3. Scissor\n\t\t4. Exit");
            System.out.println("\t\t----------------------------");
            System.out.println("\t\tCurrent Points: " + points);
            System.out.print("\n\t[+]Give your choice: ");
            int choice = inputScanner.nextInt(); 
            System.out.println("\n\n");   

            if (choice == 4) {
                x = 0;
                break; // Exit the loop if user chooses to
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please try again.");
                continue; // Continue to next iteration if input is invalid
            }

            String[] choices = {"rock", "paper", "scissor"};
            Random robot = new Random();//randomizer
            int randomIndex = robot.nextInt(choices.length); //getting random number for using it as random index
            String chosen = choices[randomIndex]; //system chose <random choice>
            System.out.println("System chose " + chosen);

            if (choice == 1) { // rock
                if (chosen.equals("paper")) {
                    paper++;
                    System.out.println("Paper absorbs Rock! You Lose!");
                    loses++;
                } else if (chosen.equals("scissor")) {
                    points++;
                    scissor++;
                    System.out.println("Rock breaks Scissor! You Won!");
                } else {
                    System.out.println("Match Draw!");
                    draws++;
                    rock++;
                }
            } else if (choice == 2) { // paper
                if (chosen.equals("scissor")) {
                    scissor++;
                    System.out.println("Scissor cuts Paper! You Lose!");
                    loses++;
                } else if (chosen.equals("rock")) {
                    points++;
                    rock++;
                    System.out.println("Paper absorbs Rock! You Won!");
                } else {
                    System.out.println("Match Draw!");
                    draws++;
                    scissor++;
                }
            } else if (choice == 3) { // scissor
                if (chosen.equals("rock")) {
                    System.out.println("Rock breaks Scissor! You Lose!");
                    loses++;
                    rock++;
                } else if (chosen.equals("paper")) {
                    points++;
                    paper++;
                    System.out.println("Scissor cuts Paper! You Won!");
                } else {
                    System.out.println("Match Draw!");
                    draws++;
                    scissor++;
                }
            }
            //getting maximum number of system choses
            if (rock >= paper && rock >= scissor) {
                max = rock;
                cup="rock";
            } else if (paper >= rock && paper >= scissor) {
                max = paper;
                cup="paper";
            } else {
                max = scissor;
                cup="scissor";
            }
        }
        

        inputScanner.close(); // Close the scanner once done
        
        //game result observation
        System.out.println("\t\t----------------------------");
        System.out.println("\t\t\tGame over!");
        System.out.println("\t\t----------------------------");
        System.out.println("\t\t\tGame statistics:");
        System.out.println("\n\t\tTotal games played : "+(((int)points+(int)loses+(int)draws)));
        System.out.println("\t\tTotal wins: " + points);
        System.out.println("\t\tTotal loses: " + loses);
        System.out.println("\t\tTotal draws: " + draws);
        System.out.println("\t\tOverall Points : "+((points*2)-loses-draws));
        if(max>1){
        System.out.println("\t\tSystem choses "+cup+" "+max+" times");
        }
        System.out.println("\t\t----------------------------");
    }

    public static void main(String[] args) { //main thread starts here!

        System.out.println("Game starts!");
        RPS m = new RPS(); //self object <RockPaperScissor>
        m.splashScreen(); //game message
        m.mainScreen(); //calling the method inside the RPS public class
    }
}
