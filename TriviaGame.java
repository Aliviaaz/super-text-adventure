public class TriviaGame extends Main
{
    public static String answer = "";
    public static int triviaScore = 0;
    public static String namestart = "";
            
    //Used often in code; stored in variables/methods
    public static String lineBreak = "=================================================\n";
    public static void printScore()
    {
        System.out.println("Your score is: " + triviaScore);
    }

    public static boolean aliviaTrivia()
    {
        //Method returns wether player won or not
        //Instructions for game
        clear();
        delay(500);
        System.out.println("\"HEY YOU!\", Danny Devito's voice blasts into your ear.");
        delay(3000);
        System.out.println("\"Answer a few questions for me will ya? \nand if you do good I might spare ya life\"\nSurprised by the appearance of Danny Devito, you \ntake a few moments to process his request.");
        delay(3000);
        System.out.println("You nod in agreement.");
        delay(3000);
        System.out.println("Danny Devito smiles and then the lights in the room go out.");
        delay(3000);
        clear();
        System.out.println(lineBreak + Font.format("bold-default", "HOW TO PLAY: ") + "\nThis is a trivia game. Input \"a\", \"b\", \"c\", \"d\", or \"e\". \nIf you answer all questions correctly, you will \nwin an important advantage...");
        System.out.println(lineBreak + "FAILING THIS TEST WILL RESULT IN DEATH\n" + lineBreak);
        namestart = readLine(lineBreak + "\nReady? Let's begin! Enter your name to start the game: \n > ");
                
        //Question 1
        answer = readLine(lineBreak + "When is my birthday? \na) November 17, 1944\nb) October 16, 1945\nc) March 2, 1951\nd) July 17, 1963\ne) November 16, 1954\n > ");
        if (answer.equals("a"))        
        {
            System.out.println("Correct! Was that a lucky guess???");
            triviaScore += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! My birthday is on November 17, 1944.");
            printScore();
        }
        clear();
        //Question 2 
        answer = readLine(lineBreak + "Where is my hometown? \na) Kansas \nb) California \nc) Pennsylvania \nd) New Jersey \ne) Florida \n > ");
        if (answer.equals("d"))
        {
            System.out.println("Correct! You know your stuff, buddy.");
            triviaScore += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! I'm from New Jersey you idiot!!");
            printScore();
        }
        clear();
        //Question 3
        answer = readLine(lineBreak + "Which film have I NOT appeared in? \na) Twins \nb) Daddy's Home 2 \nc) The Lorax \nd) Matilda \ne) Space Jam \n > ");
        if (answer.equals("b"))
        {
            System.out.println("Correct! Did you know I directed the movie Matilda?");
            triviaScore += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! Seriously?");
            printScore();
        }
        clear();
        //Question 4
        answer = readLine(lineBreak + "What is the name of the film production company \nI founded in 1991? \na) Happy Danny Productions\nb) Searchlight Pictures \nc) Jersey Films\nd) Miramax Films\ne) Devito Studios \n > ");
        if (answer.equals("c"))
        {
            System.out.println("Correct! We could be in a turtle's dream in outer space.");
            triviaScore += 1;
            printScore();
        }
        else
        {
            System.out.println("Wrong! Use your brain next time.");
            printScore();
        }
        clear();
        //Question 5
        answer = readLine(lineBreak + "Final question, how tall am I? \na) 4 feet 10 inches \nb) 5 feet 4 inches \nc) 5 feet 6 inches \nd) 4 feet 6 inches \ne) None of the above\n > ");
        if (answer.equals("a"))
        {
            triviaScore += 1;
            System.out.println("Correct! Your final score is: " + triviaScore);
        }
        else
        {
            System.out.println("Wrong! Your final score is: " + triviaScore);
        }
        clear();
        //Endscene
        clear();
        delay(500);
        if (triviaScore < 4)
        {
            System.out.println("The lights in the room turn back on. \n\n\nThe room is eerily silent.");
            delay(3000);
            System.out.println("A chill runs down your spine.");
            delay(3000);
            System.out.println("\"You did not answer enough questions correctly, " + namestart + "\" \nechoes Danny Devito behind you...");
            delay(3000);
            System.out.println("\"Do you know what this means?\"");
            delay(3000);
            System.out.println("You open your mouth to respond \nbut as you turn to look at Danny...");
            delay(3000);
            System.out.println("You are BLINDED by his striking beauty.");
            delay(3000);
            dialouge = "Danny devito has killed you because you couldn't answer enough questions right showing you were not a true fan";
            return false;
        }
        else if (triviaScore == 4)
        {
            System.out.println("The lights in the room turn back on. \n\n\nThe room is eerily silent.");
            delay(3000);
            System.out.println("A chill runs down your spine.");
            delay(3000);
            System.out.println("\"You answered four questions correctly, " + namestart + "\" \nechoes Danny Devito behind you...");
            delay(3000);
            System.out.println("\"I will let you live...for now.\"");
            delay(3000);
            System.out.println("You open your mouth to respond \nbut as you turn around to look at Danny...\n");
            delay(3000);
            System.out.println("he had already disappeared.");
            score += 10;
            return true;
        }
        else if (triviaScore == 5)
        {
            System.out.println("The lights in the room turn back on.\n\n\n");
            delay(3000);
            System.out.println("\"Congratulations! You answered all five questions \ncorrectly, " + namestart + "!\" exclaims Danny Devito behind you...");
            delay(3000);
            System.out.println("\"I will let you live...until we meet again.\"");
            delay(3000);
            System.out.println("You open your mouth to respond \nbut as you turn around to look at Danny...");
            delay(3000);
            System.out.println("he had already disappeared.");
            inventory[inventorySlotAssign] = "_advantage";
            inventorySlotAssign++;
            score += 20;
            return true;
        }
        return false;
    }
}