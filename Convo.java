public class Convo extends Main
{
    //Used often in code; stored in variables
    
    //String variable that stores player's input
    public static String reply = "";
        
    //Line break art called after each question
    public static String newLine = "=================================================\n";

    //Dialogue that asks the user to input a or b
    public static String askForInput = "Input \"a\" or \"b\" only. \n > ";
    public static void error(String a, String b)
    {
        System.out.println(a + "is not an option. " + b);
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
            System.out.println(" a) \"Hello sir, who are you?\" \n b) You wait for him to speak first.");
            reply = readLine(askForInput);
            if (reply.equals("a"))
            {
                System.out.println(newLine + "My name is Dan Harmon, the creator of Rick and \nMorty. Ever watch that show?");
                question ++;
            }
            else if (reply.equals("b"))
            {
                System.out.println(newLine + "The man doesn't speak and stares back at you.");
                System.out.println("Eventually he gives in and introduces himself.");
                System.out.println(newLine + "My name is Dan Harmon, the creator of Rick and \nMorty. Ever watch that show?");
                question ++;
            }
            else
            {
                error(reply, askForInput);
            }
        }

        //2) How Dan got here
        while(question == 2)
        {
            System.out.println(" a) \"Yes, I'm a big fan of your work!\" \n b) \"No, but how did you get here?\"");
            reply = readLine(askForInput);
            if (reply.equals("a"))
            {
                System.out.println(newLine + "Dan laughs and gives you a hug. \n\"What a relief! I've never met anyone here who has \nwatched my shows before.\"");
                System.out.println("Then Dan's eyes almost tear up. His left hand \nstrokes his beard as he says,");
                System.out.println("\"Boy do I miss those days. I was up late one rainy \nnight writing ideas for new episodes -using my \ngenius story circle method- when all of the sudden \nI heard a knock on my window.\"");
                System.out.println("\"Danny must've come in and used a tranquilizer on me \nbecause I can't remember anything after that.\"");
                System.out.println("\"The next day I woke up lying on the ground in \nthis room and... well I won't go into any more details \non what happened next...\"");
                question ++;
            }
            else if (reply.equals("b"))
            {
                System.out.println(newLine + "Dan sighs. \n\"Well, I'm not surprised. I've never met anyone \nhere who has watched my shows before.\"");
                System.out.println("Then his eyes begin to tear up. His right hand \nstrokes his beard as he says,");
                System.out.println("\"Boy do I miss those days. I was up late one rainy \nnight writing ideas for new episodes -using my \ngenius story circle method- when all of the sudden \nI heard a knock on my window.\"");
                System.out.println("\"Danny must've come in and used a tranquilizer on me \nbecause I can't remember anything after that.\"");
                System.out.println("\"The next day I woke up lying on the ground in \nthis room and... well I won't go into any more details \non what happened next...\"");
                question ++;
            }
            else
            {
                error(reply, askForInput);
            }
        }

        //3) Why?
        while(question == 3)
        {
            System.out.println(newLine + " a) Ask Dan to see if he knows why Danny Devito \ndecided to kidnap him.");
            System.out.println(" b) Ask Dan to see if he knows why Danny Devito \ndecided to kidnap you.");
            reply = readLine(askForInput);
            if (reply.equals("a"))
            {
                System.out.println(newLine + "\"You think I would know?? My theory is that \nafter the final episode of It's Always Sunny in \nPhiladelphia, Danny lost all hope in life.");
                System.out.println("Or maybe it's because we have similar names. \nHe told me once that there can only be one Danny.\"");
                question ++;
            }
            else if (reply.equals("b"))
            {
                System.out.println(newLine + "\"You think I would know?? I can't even \nfigure out how I got here.");
                System.out.println("My theory is that after the final episode of \nIt's Always Sunny in Philadelphia, Danny lost \nall hope in life.\"");
                question ++;
            }
            else
            {
                error(reply, askForInput);
            }
        }

        //4) What else
        while(question == 4)
        {
            System.out.println(" a) \"I wasn't expecting you to know, but, well, is \nthere anything else you can tell me?\" \n b) \"How long have you been here?\"");
            reply = readLine(askForInput);
            if (reply.equals("a"))
            {
                System.out.println("Dan shakes his head in defeat.\n\"I'm afraid not pal... I've been here for so \nlong that I've lost all track of time. I don't know \nanything about the outside world.\"");
                question ++;
            }
            else if (reply.equals("b"))
            {
                System.out.println("Dan looks up at the ceiling and squints his eyes. \n\"I've been here for so long that I've lost all \ntrack of time. It certainly has been more than \na week I can tell ya that for sure.\"");
                question ++;
            }
            else
            {
                error(reply, askForInput);
            }
        }

        while(question == 5)
        {
            System.out.println(newLine + "You nod your head in sympathy. \nYou tell Dan that you've lost track of time too.");
            System.out.println("Then you ask him one final question: \n\"Did you ever try escaping?\"");
            System.out.println("\n\"Nah, I was too scared. And to be honest, I \nthought this was all a dream... like maybe I \nwas living in a Rick and Morty episode.");
            System.out.println("But nope, it's definitely real. And I don't \nhave any hope left that I'll be able to escape.");
            System.out.println("Anyways, I'm sure you'll be able to escape soon pal...\"");
            reply = readLine("\nEnter \"a\" to tell Dan \"Thanks for chatting with me\" \nand end this interaction.");
            if (reply.equals("a"))
            {
                clear();
                question++;
            }
            else
            {
                error(reply, "Input \"a\" to end this interaction. \n > ");
            }
        }
    }        
}
