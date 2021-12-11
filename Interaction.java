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
        else if (in == "keyDoor")
        {
            if (inventoryContains("key"))
            {
                RoomData.room3.doors[0] = -4;
            }
            else
            {
                dialouge = ("You look at the door and realize you cant open it without a key");
            }
        }
        else if (in == "tivia")
        {
            win = TriviaGame.aliviaTrivia();
        }
    }
}
