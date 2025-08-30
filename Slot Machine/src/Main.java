//Import utilities:
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
public class Main {
    public static void main(String[]Arg) {

        //begin the game:
        System.out.println("welcome to my slot machine game, created by onlyzaki!");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        HashMap<String, Boolean> stringToBoolean = new HashMap<>();

        //Outer variables:
        String knowRules;
        double bet;
        String answer;
        boolean otherValid = true;
        //First do-while (reset If lose):
        do {
            //Inner variables:
            double cash = 50;
            char currency = '$';
            String sp = " | ";
            boolean valid = false;
            String loss = "That was so close, go and try again";
            int smallWin = 3;
            int mediumWin =  5;
            int highWin = 10;
            //
            String rules = "The game starts with a total cash of " + cash + " and you could bet as much as you want\n"
                    + "(but not more then your cash), if u bet less than 10$ only middle line will count as win \n"
                    + "if you win you will get 3 times your bet, if <10 and >50 you will get 5 times and 2 lines will count`\n"
                    + "if more than 50$ bet you will get 10 times and all lines will get counted,If you use all money :\n"
                    +"You lose);\n"
                    ;

            //Introduce to the rules:
            System.out.print("Do you know the rules yes/no: ");
            knowRules = scanner.nextLine().toLowerCase();
            if (knowRules.equals("no")){
                System.out.println(rules);
            }

            //Make a timer (random):
            int timer = random.nextInt(1000, 7000);

            //Declare HashMap/s:
            stringToBoolean.put("yes", false);
            stringToBoolean.put("no", true);

            //Game logic:
            do {
                //Declare game variables:
                int num1 = random.nextInt(1, 5);
                int num2 = random.nextInt(1, 5);
                int num3 = random.nextInt(1, 5);
                int num4 = random.nextInt(1, 4);
                int num5 = random.nextInt(1, 4);
                int num6 = random.nextInt(1, 4);
                int num7 = random.nextInt(1, 5);
                int num8 = random.nextInt(1, 5);
                int num9 = random.nextInt(1, 5);
                //Introduce player:
                System.out.print("you have " + currency + cash + "\nHow much do you wanna bet(: ");
                bet = scanner.nextDouble();
                scanner.nextLine();

                //check bet
                if ( bet < 1) {
                    System.out.println("Sorry you gotta make a bigger bet(: ");
                    continue;
                } else if (bet > cash ) {
                    System.out.println("not enough cash(: ");
                    continue;
                }

                //Make sure of the bet:
                System.out.print("Are you sure you wanna bet " + currency + bet + " yes/no: ");
                answer = scanner.nextLine().toLowerCase();
                if (answer.equals("no")) {
                    continue;
                } else if (answer.equals("yes")) {
                    //start the game:
                    cash -= bet;
                    //Make a delay:
                    System.out.println("please wait, Still counting...");
                    //here I want to create an animation ...
                    try {
                        Thread.sleep(timer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //This is the result:
                    System.out.println("\uD83C\uDFB0 " + num1 + sp + num2 + sp + num3);
                    System.out.println("\uD83C\uDFB0 " + num4 + sp + num5 + sp + num6);
                    System.out.println("\uD83C\uDFB0 " + num7 + sp + num8 + sp + num9);

                    //this is where the game counts if you win/lose:
                    if (bet < 10) {
                        if (num4 == num5 && num5 == num6) {
                            System.out.println("gg, you have won, " + currency + (bet * smallWin) + " will be added to your wallet");
                            double temp = bet * smallWin;
                            cash += temp;

                        }else {
                            System.out.println(loss);
                        }
                    } else if (bet < 50 && bet >= 10) {
                        if (
                                num1 == num2 && num2 == num3 ||
                                num4 == num5 && num5 == num6
                        ) {
                            System.out.println("gg, you have won, " + currency + (bet * mediumWin) + " will be added to your wallet");
                            double temp = bet * mediumWin;
                            cash += temp;

                        }else {
                            System.out.println(loss);
                        }
                    } else if (bet >= 50) {
                        if (
                                num1 == num2 && num2 == num3 ||
                                num4 == num5 && num5 == num6 ||
                                num7 == num8 && num8 == num9
                        ) {
                            System.out.println("gg's, you have won, " + currency + (bet * highWin) + " will be added to your wallet");
                            double temp = bet * highWin;
                            cash += temp;

                        }else {
                            System.out.println(loss);
                        }


                    }
                } else {
                    System.out.println("Invalid input,, please  try again");
                    continue;
                }

                //Check if the player is out of Money:
                if (cash <= 1) {
                    System.out.print("you've lost, try again yes/no: ");
                    answer = scanner.nextLine().toLowerCase();
                    otherValid = stringToBoolean.getOrDefault(answer, false);
                    valid = true;
                }

                //Check if he will play again:
                else{
                    System.out.print("Do you wanna play again yes/no: ");
                    answer = scanner.nextLine().toLowerCase();
                    valid = stringToBoolean.getOrDefault(answer, false);
                }

            }

            while (!valid);
        }
        while (!otherValid);

        scanner.close();
    }
}

//You've reached the End of the program make Sure to contact onlyzaki for any tips(: