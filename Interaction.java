public class Interaction extends Main
{
    public static void interact(String in)
    {
        //Handles all special interactions, mini games, or interactable items in game
        if (in == "book" || in == "newspapers")
        {
            clear();
            Draw.art(in);
            readLine("\nPress Enter");
        }
        else if (in == "door")
        {
            if (scene.doors[direction - 1] == -2)
            {
                if (inventoryContains("_code"))
                {
                    scene.doors[direction - 1] *= 4;
                }
                else
                {
                    dialouge = "You look at the door and realize you must enter something on the keypad to open the door";
                }
            }
            else if (scene.doors[direction - 1] == -1)
            {
                if (inventoryContains("key"))
                {
                    scene.doors[direction - 1] *= 4;
                }
                else
                {
                    dialouge = "You look at the door and realize you cant open it without a key";
                }
            }
        }
        else if (in == "tivia")
        {
            win = TriviaGame.aliviaTrivia();
        }
    }
}
