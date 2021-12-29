public class Interaction extends Main
{
    private static boolean triviaPlayed = false;
    private static boolean subGamePlayed = false;
    public static void reset()
    {
        triviaPlayed = false;
        subGamePlayed = false;
    }

    public static void interact(String in)
    {
        //Handles all special interactions, mini games, or interactable items in game
        if (in.startsWith("$"))
        {
            clear();
            Draw.art(in);
            readLine("\nPress Enter");
        }
        else if (in.equals("door"))
        {
            if (scene.doors[direction] == -2)
            {
                boolean codeCorrect = true;
                int[] correctCode = {1,1,2,3,5};
                int[] temp = new int[5];
                for (int i = 0; i < 5; i++)
                {
                    clear();
                    Draw.keyPad(temp);
                    temp[i] = readInt("\n\n      Enter Digit " + (i + 1) + ": ");
                }

                for (int i = 0; i < temp.length; i++)
                {
                    if (temp[i] != correctCode[i])
                    {
                        codeCorrect = false;
                        break;
                    }
                }

                if (codeCorrect)
                {
                    scene.doors[direction] *= 4;
                    dialouge = "You typed the correct code, Type walk to open the door a bit";
                }
                else
                {
                    dialouge = "The keypad buzzes and you realize you have entered the wrong password, try looking for help like the math poster in the room";
                }
                readLine("Press Enter");
            }
            else if (scene.doors[direction] == -1)
            {
                if (inventoryContains("key"))
                {
                    scene.doors[direction] *= 4;
                    dialouge = "You unlocked the door, Type walk to push it open a bit";
                }
                else
                {
                    dialouge = "You look at the door and realize you cannot open it without using a key.";
                }
            }
        }
        else if (in.equals("convo"))
        {
            Convo.conversation();
        }
        else if (in.equals("@trivia") && !triviaPlayed)
        {
            triviaPlayed = true;
            if (TriviaGame.aliviaTrivia())
            {
                win = false;
            }
        }
        else if (in.equals("@subGame") && !subGamePlayed)
        {
            subGamePlayed = true;
            if (SubGame.floatingPointGame())
            {
                win = false;
            }
        }
    }
}
