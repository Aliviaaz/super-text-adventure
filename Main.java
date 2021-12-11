public class Main extends Console
{
    //Position on map - default room 1
    public static int roomNum = 1;
    //sceneCollection array stores object references for each room
    public static RoomData.Room[] sceneCollection = {RoomData.room1, RoomData.room2, RoomData.room3};
    //Current scene to read from
    public static RoomData.Room scene = null;
    /*Direction - default north
                 1
                 |
            2----|----4
                 |
                 3
    */
    public static int direction = 1;
    /*Commands
        > left
        > right
        > walk
        > i
        > pick
        > inv
    */
    //Determines wether player won or lost
    public static boolean win = false;
    public static int score = 0;
    //Text assigned to 'dialouge' to be printed
    public static String dialouge = "";
    //Stores items in players inventory
    public static String[] inventory = new String[10];
    public static int inventorySlotAssign = 0;

    public static void main(String args[])
    {
        boolean menu = true;
        //Menu Loop
        while (menu)
        {
            //Initalize roomData to create rooms
            RoomData.init();
            //Initalize file save system
            Save.loadDir();
            //Reset Values for New Game
            direction = 1;
            roomNum = 1;
            score = 0;
            dialouge = "";
            for (int i = 0; i < inventory.length; i++)
            {
                inventory[i] = "";
            }
            inventorySlotAssign = 0;

            Draw.art("title");
            System.out.println("NOW WITH VISUALS\n\'Journey Through Danny Devito's Basement...\'\nCreated by: Alivia and Rowan\n\n ============== Instructions ==============\n > start - starts game\n > load - load a saved game\n > save - save progress\n > left - turn left\n > right - turn right\n > walk - move forward\n > i - interact with surroundings\n > pick - pick up items\n > inv - shows invintory\n > help - displays help message\n > quit - quit game\n\n");
            //Menu Command Handling
            String input = readLine(" > ");
            if (input.equals("start"))
            {
                //Starts game by flipping the win boolean
                win = true;
                Draw.startAnim();       
            }
            else if (input.equals("load"))
            {
                //Calls saveGame function to load a save file
                Save.saveGame(true);
            }
            else if (input.equals("quit"))
            {
                //Flips menu boolean breaking out of menu and killing program
                menu = false;
            }
            else
            {
                //Handle incorrect entry
                System.out.println("Error: You Might Have Entered the Wrong Command, Try start or quit");
            }
            
            //Main Game Loop
            while (win)
            {
                //Creates a reference for things by moving a Room object from sceneCollection array into the "scene" object
                scene = sceneCollection[roomNum - 1];

                //Main GUI Block
                System.out.println("Score: " + score);
                System.out.println(dialouge);
                Draw.miniMap(direction);
                dialouge = "";
                System.out.println("=================================================\n");
                Draw.art(scene.walls[direction - 1][scene.states[direction - 1]]);
                System.out.println("\n" + scene.messages[direction - 1][scene.states[direction - 1]]);
                System.out.println("\n=================================================\n");
                
                //Handle entered commands in game
                String com = readLine("\n > ");
                if (com.equals("left"))
                {
                    //Turns to wall to the right by adding 1 to direction or recursing to 1 if direction = 4
                    if (direction == 4)
                    {
                        direction = 1;
                    }
                    else 
                    {
                        direction += 1;
                    }
                }
                else if (com.equals("right"))
                {
                    //Turns to wall to the left by subtracting 1 from direction or recursing to 4 if direction = 1
                    if (direction == 1)
                    {
                        direction = 4;
                    }
                    else
                    {
                        direction -= 1;
                    }
                }
                else if (com.equals("walk"))
                {
                    if (scene.doors[direction - 1] <= 0)
                    {
                        if (scene.doors[direction - 1] % 4 == 0 && scene.doors[direction - 1] != 0)
                        {
                            //Set the door value to what room it leads to after being unlocked by converting the string at second index 1 to an int
                            scene.doors[direction - 1] = Integer.parseInt(RoomData.doorInfo[Math.abs((scene.doors[direction - 1]) / 4)][1]);
                            //Set the state to 0 to display the correct art
                            scene.states[direction - 1] = 0;
                            //Set the win boolean by converting the string at second index 2 to a boolean, this only gets set false if the player triggered a booby trap behind a door
                            win = Boolean.parseBoolean(RoomData.doorInfo[Math.abs((scene.doors[direction - 1]) / 4)][2]);
                        }
                        else
                        {
                            //Set the dialouge to the correct response depending on the door value
                            dialouge = RoomData.doorInfo[Math.abs((scene.doors[direction - 1]))][0];
                        }
                    }
                    else if (scene.doors[direction - 1] == 2)
                    {
                        //Special animation for first door
                        roomNum = scene.doors[direction - 1];
                        Draw.firstDoorAnim();
                    }
                    else
                    {
                        /*
                        If none of the previous conditions are met, it means there is regular door meaning door value represents room number it leads to
                        - roomNum is assigned the door value
                        */
                        roomNum = scene.doors[direction - 1];
                        Draw.doorAnim();
                    }
                }
                else if (com.equals("i"))
                {
                    //Calls interact method to trigger interactable based on the scene's special value
                    Interaction.interact(scene.specials[direction - 1]);
                }
                else if (com.equals("pick"))
                {
                    //Picks up an item if avaible
                    if (scene.items[direction - 1] == null)
                    {
                        //Handles when there is no item to pick up
                        dialouge = "There is no item here to pick up so you grab at the air stupidly\nIf you think you already picked something up type inv";
                    }
                    else
                    {
                        //Gets name of item that is avaible from item array
                        String currentItem = scene.items[direction - 1];
                        //Sets the state of the wall to be 0 and the item value to "null" to signal the player has taken the item and to change the display art
                        scene.states[direction - 1] = 0;
                        scene.items[direction - 1] = "null";
                        //Assigns item to inventory using inventorySlotAssign as index
                        inventory[inventorySlotAssign] = currentItem;
                        //Increment inventorySlotAssign to assign next item to a new inventory slot
                        inventorySlotAssign++;

                        //Display item that was picked up
                        clear();
                        System.out.println("NEW ITEM! =====================\nYou Picked Up: " + currentItem);
                        Draw.art(currentItem);
                        readLine("\nPress Enter");
                    }
                }
                else if (com.equals("inv"))
                {
                    //Displays all items in inventory by looping through inventory array and using each string as input for the art function to display the items in a graphical way
                    System.out.println("\nITEMS IN YOUR INVENTORY:");
                    for (String i : inventory)
                    {
                        if (i != null && !i.startsWith("_"))
                        {
                            System.out.println(i + ":");
                            Draw.art(i);
                        }
                    }
                    readLine("\nPress Enter");
                }
                else if (com.equals("save"))
                {
                    //Saves current state of game
                    Save.saveGame(false);
                    break;
                }
                else if (com.equals("load"))
                {
                    //Loads a save file
                    Save.saveGame(true);
                }
                else if (com.equals("quit"))
                {
                    //Flips win boolean to false to signal the player has quit
                    win = false;
                    endGame();
                }
                else if (com.equals("help"))
                {
                    //Displays help message
                    System.out.println(" ============== Instructions ==============\nExplore each room look for items to collect, interact with things around\nrooms, and open doors to travel between rooms.\n \n > left - turn left\n > right - turn right\n > walk - move forward\n > i - interact with surroundings\n > pick - pick up items\n > inv - shows invintory\n > help - displays help message\n > quit - quit game");
                    readLine("Press Enter");
                }
                else
                {
                    //Handles any incorrect entry
                    dialouge = "Error: You Might Have Entered an Incorrect Command Type help";
                }
                clear();
            }
            clear();
        }
    }

    private static void endGame()
    {
        //End of Game Screen
        Draw.art("lost");
        readLine("\n========================================================================\n \nScore: " + score + "\n" + dialouge + "\nPress Enter to Continue");
    }

    public static boolean inventoryContains(String item)
    {
        for (String i : inventory)
        {
            if (i != null && i.equals(item))
            {
                return true;
            }
        }
        return false;
    }
}