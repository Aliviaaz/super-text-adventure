import java.util.Scanner;

public class TriviaGame
{
    public static String answer = "";
    public static int score = 0;
    public static String namestart = "";
            
    //Used often in code; stored in variables/methods
    public static String lineBreak = "==============================\n";
    public static void printScore()
    {
        System.out.println("Your score is: " + score);
    }

    public static Scanner read = new Scanner(System.in);
    public static String readLine(String prompt)
    {
        System.out.println(prompt);
        return read.nextLine();
    }


    public static void aliviaTrivia()
    {
        //Instructions for game
        Main.clear();
        Draw.delay(500);
        System.out.println("\"HEY YOU!\", Danny Devito's voice blasts into your ear");
        Draw.delay(3000);
        System.out.println("\"Answer a few questions for me will ya? and if you do good I might spare ya life\"\nSurprised by the appearance of Danny Devito, you take a few moments to process his request.");
        Draw.delay(3000);
        System.out.println("You nod in agreement.");
        Draw.delay(3000);
        System.out.println("Danny Devito smiles and then the lights in the room go out.");
        Draw.delay(3000);
        Main.clear();
        System.out.println(lineBreak + "HOW TO PLAY: \nThis is a trivia game. You have 10 seconds to answer each question. Input \"a\", \"b\", \"c\", \"d\", or \"e\". If you answer all questions correctly, you will win an important advantage...");
        System.out.println(lineBreak + "FAILING THIS TEST WILL RESULT IN DEATH\n" + lineBreak);
        namestart = readLine(lineBreak + "\nReady? Let's begin! Enter your name to start the game: \n > ");
                
        //Question 1
        answer = readLine(lineBreak + "When is my birthday? \na) November 17, 1944\nb) October 16, 1945\nc) March 2, 1951\nd) July 17, 1963\ne) November 16, 1954\n > " );
        if (answer.equals("a"))        
        {
            System.out.println("Correct! Was that a lucky guess???");
            score += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! My birthday is on November 17, 1944.");
            printScore();
        }
        //Question 2 
        answer = readLine(lineBreak + "Where is my hometown? \na) Kansas \nb) California \nc) Pennsylvania \nd) New Jersey \ne) Florida \n >");
        if (answer.equals("d"))
        {
            System.out.println("Correct! You know your stuff, buddy.");
            score += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! I'm from New Jersey you idiot!!");
            printScore();
        }
        //Question 3
        answer = readLine(lineBreak + "Which film have I not appeared in? \na) Twins \nb) Daddy's Home 2 \nc) The Lorax \nd) Matilda \ne) Space Jam \n > ");
        if (answer.equals("b"))
        {
            System.out.println("Correct! Did you know I directed the movie Matilda?");
            score += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! Seriously?");
            printScore();
        }
        //Question 4
        answer = readLine(lineBreak + "What is the name of the film production company I founded in 1991? \na) Happy Danny Productions\nb) Searchlight Pictures \nc) Jersey Films\nd) Miramax Films\ne) Devito Studios \n > ");
        if (answer.equals("c"))
        {
            System.out.println("Correct! We could be in a turtle's dream in outer space.");
            score += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! Use your brain next time.");
            printScore();
        }

        //Question 5
        answer = readLine(lineBreak + "Final question, how tall am I? \na) 4 feet 10 inches \nb) 5 feet 4 inches \nc) 5 feet 6 inches \nd) 4 feet 6 inches \ne) None of the above\n > ");
        if (answer.equals("a"))
        {
            score += 1;
            System.out.println("Correct! Your final score is: " + score);
        }
        else
        {
            System.out.println("Wrong! Your final score is: " + score);
        }

        //Endscene
        Main.clear();
        Draw.delay(500);
        if (score < 4)
        {
            System.out.println("The lights in the room turn back on. \n\n\nThe room is eerily silent.");
            Draw.delay(3000);
            System.out.println("A chill runs down your spine.");
            Draw.delay(3000);
            System.out.println("\"You did not answer enough questions correctly, " + namestart + "\" echoes Danny Devito behind you...");
            Draw.delay(3000);
            System.out.println("\"Do you know what this means?\"");
            Draw.delay(3000);
            System.out.println("You open your mouth to respond but as you turn to look at Danny...");
            Draw.delay(3000);
            System.out.println("You are blinded by his striking beauty");
            Draw.delay(3000);
            System.out.println(lineBreak + "YOU DIED. GAME OVER." + lineBreak);
            //insert game over here
        }
        else if (score == 4)
        {
            System.out.println("The lights in the room turn back on. \n\n\nThe room is eerily silent.");
            Draw.delay(3000);
            System.out.println("A chill runs down your spine.");
            Draw.delay(3000);
            System.out.println("\"You answered four questions correctly, " + namestart + "\" echoes Danny Devito behind you...");
            Draw.delay(3000);
            System.out.println("\"I will let you live...for now.\"");
            Draw.delay(3000);
            System.out.println("You open your mouth to respond but as you turn around to look at Danny...");
            Draw.delay(3000);
            System.out.println("he had already disappeared.");
            //insert game continues here
        }
        else if (score == 5)
        {
            System.out.println("The lights in the room turn back on.");
            Draw.delay(3000);
            System.out.println("\"Congratulations! You answered all five questions correctly, " + namestart + "!\" exclaims Danny Devito behind you...");
            Draw.delay(3000);
            System.out.println("\"I will let you live...until we meet again.\"");
            Draw.delay(3000);
            System.out.println("You open your mouth to respond but as you turn around to look at Danny...");
            Draw.delay(3000);
            System.out.println("he had already disappeared.");
            //insert advantage conversation here
        }
    }
}