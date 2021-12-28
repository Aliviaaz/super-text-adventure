public class Main extends Console
{
    //Position on map - default room 1
    public static int roomNum = 1;
    //sceneCollection array stores object references for each room
    public static RoomData.Room[] sceneCollection = {RoomData.room1, RoomData.room2, RoomData.room3, RoomData.room4, RoomData.room5};
    //Current scene to read from
    public static RoomData.Room scene = null;
    /*Direction - default north
                 0
                 |
            1----|----3
                 |
                 2
    */
    public static int direction = 0;
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

    //START POINT OF PROGRAM
    public static void main(String args[])
    {
        boolean menu = true;
        //Menu Loop
        while (menu)
        {
            //Initalize file save system
            Save.loadDir();
            //Reset Values for New Game
            direction = 0;
            roomNum = 1;
            score = 0;
            dialouge = "";
            for (int i = 0; i < inventory.length; i++)
            {
                inventory[i] = "";
            }
            inventorySlotAssign = 0;

            Draw.art("title");
            System.out.println("NOW WITH VISUALS " + Font.format("red", "A") + Font.format("green", "N") + Font.format("yellow", "D ") + Font.format("blue", "I") + Font.format("purple", "N ") + Font.format("cyan", "C") + Font.format("lred", "O") + Font.format("lgreen", "L") + Font.format("lyellow", "O") + Font.format("lblue", "R") + Font.format("italic-default", "\n\'Journey Through Danny Devito's Basement...\'") + "\nCreated by: Alivia and Rowan\n\n" + Font.format("bold-italic-default" ," ============== Commands ==============\n\n") + Font.RESET + Font.format("green", " GREEN ") + "Start Menu Only Commands\n" + Font.format("blue", " BLUE ") + "In Game Commands Only\n" + Font.format("cyan", " CYAN ") + "Both in Game and Start Menu Commands\n >" + Font.format("green", " start") + " - starts game\n >" + Font.format("cyan", " load") + " - load a saved game ~UNFINISHED~\n >" + Font.format("green", " edit") + " - delete save files ~UNSTABLE~\n >" + Font.format("blue", " save") + " - save progress ~UNSTABLE~\n >" + Font.format("blue", " left") + " - turn left\n >" + Font.format("blue", " right") + " - turn right\n >" + Font.format("blue", " walk") + " - move forward\n >" + Font.format("blue", " i") + " - interact with surroundings\n >" + Font.format("blue",  " pick") + " - pick up items\n >" + Font.format("blue", " inv") + " - shows invintory\n >" +  Font.format("yellow", " color") + " - displays color test DEV ONLY\n >" + Font.format("green", " credits")+ " - its in the name" + Font.format("blue", " help") + " - displays help message\n >" + Font.format("cyan", " quit") + " - quit game\n\n");
            //Menu Command Handling
            String input = readLine(Font.format("bold-default", "ENTER-COMMAND $") + Font.INPUT_GREEN + " > ");
            Font.reset();
            if (input.equals("start"))
            {
                //Starts game by flipping the win boolean
                win = true;
                Draw.startAnim();       
            }
            else if (input.equals("load"))
            {
                //Calls saveGame method to load a save file and then starts game
                Save.saveGame(true);
                win = true;
            }
            else if (input.equals("edit"))
            {
                //Calls deleteFile method to display the file managment screen
                Save.deleteFile();
            }
            else if (input.equals("color"))
            {
                //Prints out color test
                for (int r = 0; r < 5; r++)
                {
                    for (int i = 0; i < 107; i++)
                    {
                        if (i % 10 != 0)
                        {
                            System.out.print("\033[" + r + ";" + i + "m#" + i + "-" + r);
                        }
                        else
                        {
                            System.out.println("\033[" + r + ";" + i + "m#" + i + "-" + r);
                        }
                        Font.reset();
                    }
                    Font.reset();
                }
                Font.reset();
                readLine("\nColor Test Complete - Press Enter");
            }
            else if (input.equals("quit"))
            {
                //Flips menu boolean breaking out of menu and killing program
                menu = false;
            }
            else if (input.equals("credits"))
            {
                System.out.println("Programmed in vanilla Java without extending CodeHS ConsoleProgram class\nCreated by: Rowan and Alivia\nWith help from: Stack Overflow and w3schools.com\nOur Github Repository: https://github.com/Aliviaaz/super-text-adventure \nASCII Art sources:\nhttps://asciiart.eu \nhttps://asciiart.club/ \nhttps://patorjk.com/software/taag/ \nDesign Document: https://docs.google.com/spreadsheets/d/17BfPbQF8DGfT0UR8KVZENnbKVPCTLqlaxsWFzzFS-Kc/edit?usp=sharing \n");
                readLine("\nPress Enter");
            }
            else
            {
                //Handle incorrect entry
                System.out.println(Font.format("bold-red", "Error:") + " You Might Have Entered the Wrong Command, Try start or quit");
            }
            
            //Main Game Loop
            while (true)
            {
                //Creates a reference for things by moving a Room object from sceneCollection array into the "scene" object
                scene = sceneCollection[roomNum - 1];

                //Handles specials starting with @ which are situations where the player has no control over if they interact or not
                if (scene.specials[direction].startsWith("@"))
                {
                    Interaction.interact(scene.specials[direction]);
                }

                //Main GUI Block
                System.out.println(Font.format("yellow", "Score: " + score) + "\n" + Font.format("italic-red", dialouge));
                Draw.miniMap(direction);
                dialouge = "";
                System.out.println("=================================================\n");
                Draw.art(scene.walls[direction][scene.states[direction]]);
                System.out.println("\n" + scene.messages[direction][scene.states[direction]]);
                System.out.println("\n=================================================\n");
                
                //Handle entered commands in game
                String com = readLine(Font.format("italic-bold-default", "What Do You Do $") + Font.INPUT_BLUE + " > ");
                Font.reset();
                if (com.equals("left"))
                {
                    //Turns to wall to the right by adding 1 to direction or recursing to 1 if direction = 4
                    if (direction == 3)
                    {
                        direction = 0;
                    }
                    else 
                    {
                        direction += 1;
                    }
                }
                else if (com.equals("right"))
                {
                    //Turns to wall to the left by subtracting 1 from direction or recursing to 4 if direction = 1
                    if (direction == 0)
                    {
                        direction = 3;
                    }
                    else
                    {
                        direction -= 1;
                    }
                }
                else if (com.equals("walk"))
                {
                    //Constant information and responses for each door
                    final String[][] DOOR_INFO = {{"There is no door here so you smack straight into the wall and look like an idiot.", "0", "true"}, {"The door is locked and you realize you need a key to open it.", "5", "true"}, {"The door is locked and you realize you need a code to open it.", "8", "true"}, {"You opened the door and fell into a trap set by Devito.", "-3", "false"}};

                    if (scene.doors[direction] <= 0)
                    {
                        //If door value is negative it means the door is locked or was once locked
                        if (scene.doors[direction] % 4 == 0 && scene.doors[direction] != 0)
                        {
                            //If the door value is divisible by 4 or is not 0 then the door is unlocked
                            //Set the door value to what room it leads to after being unlocked by converting the string at second index 1 to an int
                            scene.doors[direction] = Integer.parseInt(DOOR_INFO[Math.abs((scene.doors[direction]) / 4)][1]);
                            //Set the state to 0 to display the correct art
                            scene.states[direction] = 0;
                            //Set the win boolean by converting the string at second index 2 to a boolean, this only gets set false if the player triggered a booby trap behind a door
                            win = Boolean.parseBoolean(DOOR_INFO[Math.abs((scene.doors[direction]) / 4)][2]);
                            //Special animation
                            Draw.lockedDoorAnim();
                        }
                        else
                        {
                            //If the door value is not divisible by 
                            //Set the dialouge to the correct response depending on the door value
                            dialouge = DOOR_INFO[Math.abs((scene.doors[direction]))][0];
                        }
                    }
                    else if (scene.doors[direction] == 2)
                    {
                        //Special animation for first door
                        roomNum = scene.doors[direction];
                        Draw.firstDoorAnim();
                    }
                    else if (scene.doors[direction] == 100)
                    {
                        endGame();
                        break;
                    }
                    else
                    {
                        /*
                        If none of the previous conditions are met, it means there is regular door meaning door value represents room number it leads to
                        - roomNum is assigned the door value
                        */
                        roomNum = scene.doors[direction];
                        Draw.doorAnim();
                    }
                }
                else if (com.equals("i"))
                {
                    //Calls interact method to trigger interactable based on the scene's special value
                    Interaction.interact(scene.specials[direction]);
                }
                else if (com.equals("pick"))
                {
                    //Picks up an item if avaible
                    if (scene.items[direction] == "null")
                    {
                        //Handles when there is no item to pick up
                        dialouge = "There is no item here to pick up, so you grab at the air stupidly.\nIf you think you already picked something up type inv.";
                    }
                    else
                    {
                        //Gets name of item that is avaible from item array
                        String currentItem = scene.items[direction];
                        //Sets the state of the wall to be 0 and the item value to "null" to signal the player has taken the item and to change the display art
                        scene.states[direction] = 0;
                        scene.items[direction] = "null";
                        //Assigns item to inventory using inventorySlotAssign as index
                        inventory[inventorySlotAssign] = currentItem;
                        //Increment inventorySlotAssign to assign next item to a new inventory slot
                        inventorySlotAssign++;
                        //Give the player a better score
                        score += 5;

                        //Display item that was picked up
                        clear();
                        System.out.println(Font.format("italic-bold-default", "NEW ITEM! =====================") + "\nYou Picked Up: " + Font.format("italic-blue", currentItem));
                        Draw.art(currentItem);
                        readLine("\nPress Enter");
                    }
                }
                else if (com.equals("inv"))
                {
                    //Displays all items in inventory by looping through inventory array and using each string as input for the art method to display the items in a graphical way
                    System.out.println(Font.format("bold-italic-default", "\nITEMS IN YOUR INVENTORY:"));
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
                    finale();
                }
                else if (com.equals("help"))
                {
                    //Displays help message
                    System.out.println(" ============== Instructions ==============\nExplore each room to look for items to collect, interact with things around\nrooms, and open doors to travel between rooms.\n \n > left - turn left\n > right - turn right\n > walk - move forward\n > i - interact with surroundings\n > pick - pick up items\n > inv - shows inventory\n > help - displays help message\n > quit - quit game");
                    readLine("Press Enter");
                }
                else
                {
                    //Handles any incorrect entry
                    dialouge = Font.format("bold-red", "Error:") + " You Might Have Entered an Incorrect Command Type help";
                }
                clear();
                if (!win)
                {
                    endGame();
                    break;
                }
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

    private static void finale()
    {
        clear();
        delay(500);
        System.out.println("You walk up the stairs but you hear something following you...");
        delay(4000);
        System.out.println("You turn back and see it is Dan Harmon limping after you");
        delay(4000);
        System.out.println("\'DeVito was a good man, just led down the wrong path, kinda like the joker\' he says,\n\'atleast give him the respect he deserves by giving him a proper burial and then we can get out of here\'");
        delay(4000);
        if (inventoryContains("candle") && readLine("Type yes to give danny DeVito a viking funeral").equals("yes"))
        {
            System.out.println("You and Harmon Give Danny Devito a viking funeral and burn his body");
            delay(4000);
            clear();
            for (int i = 0; i < 31; i++)
            {
                for (int a = 0; a < 4; a++)
                {
                    String[] frames = {"▓███████████████████████████████████████████████████████████████████████████████\n████████████████████████████████████████████████████████████████████████████████\n████████████████████████████████████████████████████████████████████████████████\n████████████████████████████████████████████████████████████████████████████████\n████████████████████████████████████████████████████████████████████████████████\n███████████████████████████████████████████████████████████████████████████████\n████████████████████████████████████████████████████████████████████████████████\n▓███████████████████████████████████████████████████████████████████████████████\n▓███████████████████████████████████████████████████████████████████████████████\n╫███████████████████▓██████████████████▓╬╣██████████████████████████████████████\n╟█▓╬▓▓╟▓████▓████████▓▓▓██████████▓▓███▓▒░▓██████████████████████████████████▓╬▒\n╠▓▓╣▓╬╠╣▓██▓╣█████████▓▓▓██████▓▓╬╬▓███▓▒░╣███████████████████████████▓█▓▓▓▓╬╬╠░\n╠╬▓▓▓╬╠╬███▓╬▓▓╬▓██████▓╣██████▓╬╬╣▓███▓╬▒╬▓████████████████████████╬╩╚╬╬╬╬╬╠▒░░\n╠╠╣▓▓▓╬╣██▓╬╬╬╠╬╣██████▓╣██████▓▓▓▓▓████╬╠╬▓███▓███████████████████╬░░░╬╬╣▓╬▒░░░\nφ╚╬▓██▓▓▓▓╬╙╙╠╠╟▓█████▓╬╟▓██████▓▓██████▓╬╣▓███▓██████████████████╬░░░╚╠╬╣▓╬▒░░░\n░╠▒╫▓█▓╬▓╬▒░░░╙╠██████╬▒╠╬▓████▓▓████████▓█████╬▓╬╣█████████████▓╬▒░░░░╙╠╣╣╬▒░░░\n░╠╬╟▓▓▓╠╣▓╬░░░░░╫▓▓██▓╬╠╟╬▓███▓╬╣██████████████▓╬╩╠▓╬▓████████╬╬▒╠░░░░░░░╟▓╬╬▒φ∩\n╠╠▒╠╠╣▓╬▓▓▓▒░░░φ╣▓╣▓▓╬╬╬╬╬╣▓██▓╠╬▓██████▓▓█████╬╬▒╬╬╬╬▓██████▓▓╬╬░▒░░░░░░╠╣╬╬╠╠▒\n╠▒░╠╠╬▓▓▓▓▓╬░░░╠╣╬╬╬╬╠╬╬▓╣╬╬╣▓▓╬╣▓█▓▓██▓▓╣╬▓▓▓╬╩╠╬╬╠░╚╬╬▓▓▓▓╣╬▓▓╬φ░░░░░░φ╫▓▓╬╠╠░\n╠╠φ╠╠╬▓▓▓██╬▒░░░╠▒╠╩╠░╠╠╬╬╬▓▓▓▓▓▓▓▓╣╬╣╣╬╬╣▓▓▓╬▒╚╚╠╩▒░░╠╠╬╬╣╬╬╣╬╬╬▒░░░░░░╠╣▓▓▓╬╬░\n║╬╬╚╠╠╣▓▓▓▓╬╬░░░░▒╠▒░░░╙╬╠╟▓▓▓▓▓█▓▓╬╠╬╠╣▓▓▓╬╬╬▒░░╬▒░░░░╚╬╬╬╬▒╬╬╠╙░░░░░░░╠▓▓▓╬╬╠╠\n╠╩▒▒▒░╟▓▓▓▓▓▒░░░░╠░▒░░░░╠▒╠▓▓▓▓▓██▓╠╠▒╠╣▓╬╬╬╠╩░░░╠▒░░░░φ╬▓▓▓╬╬░░░φ░░╠░░░░╫▓╬╬╬╬▒\n╠▒╠╬▒░╠╣▓▓▓╬▒░░░░╠▒▒▒φ╠░╠▒╠╬╬╠╩╠╬▓╩╚╩╠╠╬╬╬╬▒░░░░░▒▒░░╚░╠╬▓▓▓╬╚░░░╠▒╠▒░░░░░╠▒╩╠╟╬\n║╬╣╬╬░╠▓▓▓╬╬▒░░░░░░╠╬╬╠▒╠╠▒Γ╙░░░╚Γ░░░░╠╬╠▒░░░╠░░░╠▒░░φ░╠▓▓▓╬▒░░░░╠╚╠╠░░░░░░░▒╠╢╬\n║╬╬▓╬░░╠▓╬╬╬▒░░░░Γ░╠╬╬▒╠░╙░░░░░░░░░░░░╙╚╚░░░░╚░░░╩░░░╚░╠╣▓▓▓░░░░░░░╠╬▒φ░░░░▒▒╠╠▌\n╠╣╣▓╬░░╠╩╠╠╬╠░░░░░░░╬▒░╠░░░░░░░░░░░░░░░░░░░░φ╠░░░░░░░░░╚╬╬╬╠▒░░░░░░╠╬╬╠╠░░╠▒▒╠╬╬\n╠╠╠╬▒░░╚░▒╠╠▒░░░░░░░╚▒▒░░░░░░░░░░░░░░░░░░░░░φ╠▒▒░░░░░░░░░░╠╬░░░░░░φ╠╬╬╠╬▒░▒░▒╠╠╬",};
                    System.out.println("\033[43m" + frames[a]);
                    Font.reset();
                    delay(500);
                }
            }
        }
        else
        {
            System.out.println("You never picked up the candle so you have nothing to cremate devito with.\nForget that noise you say to Harmon");
            delay(4000);
        }
        System.out.println("You and Harmon walk off into the sunset shaken by the day you have experienced");
        delay(4000);
        clear();
        Draw.art("win");
        readLine("\n========================================================================\n \nScore: " + score + "       " + Font.format("italic-defualt", "You Survived Danny Devito's Basement") + "\nPress Enter to Continue");
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