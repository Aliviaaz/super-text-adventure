public class Convo extends Main
{
    //Used often in code; stored in variables
    
    //String variable that stores player's input
    public static String reply = "";
        
    //Line break art called after each question
    public static String newLine = "=================================================\n";

    //Dialogue that asks the user to input a or b
    public static String askForInput = "Input \"a\" or \"b\" only. \n > ";
    public static void error(String a)
    {
        System.out.println(a + "is not an option. " + askForInput);
    }
    
    //Integer representing which question the player is on (will increment by one after the player chooses a or b)
    public static int question = 0;

    //Main method containing user dialogue for conversation with Dan Harmon
    public static void conversation()
    {
        System.out.println(newLine + "You approach the bearded man with a crazed look in his eyes.");
        question = 1;

        //1) Introduction
        while(question == 1)
        {
            System.out.println("a) \"Hello sir, who are you?\" \n b) You wait for him to speak first.");
            reply = readLine(askForInput);
            if (reply.equals("a"))
            {
                //printDanHarmon(1a);
                question ++;
            }
            else if (reply.equals("b"))
            {
                //printDanHarmon(1b);
                question ++;
            }
            else
            {
                error(reply);
            }
        }

        //2) How Dan got here
        while(question == 2)
        {
            System.out.println("a) \"Yes, I'm a big fan of your work!\" \n b) \"No, but how did you get here?\"");
            reply = readLine(askForInput);
            if (reply.equals("a"))
            {
                //printDanHarmon(2a);
                question ++;
            }
            else if (reply.equals("b"))
            {
                //printDanHarmon(2b);
                question ++;
            }
            else
            {
                error(reply);
            }
        }

        

        //Outro something like thanks for chatting with me
    }

    //Secondary method containing Dan's responses to the user. Takes in user's response as parameter "question number + a or b".
    //Example: User chooses option a for question one, then response = 1a.
    public static void printDanHarmon(String response)
    {
        //dont forget to print new line
    }
        
}
