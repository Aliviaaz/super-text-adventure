public class RoomData
{ 
    //Stores constants for each special type of door
    public static final String[][] doorInfo = {{"There is no door here so you smack straight into the wall and look like an idiot.", "0", "true"}, {"The door is locked and you realize you need a key to open it.", "5", "true"}, {"The door is locked and you realize you need a code to open it.", "8", "true"}, {"You opened the door and fell into a trap set by Devito.", "-3", "false"}};
    //Basic structure of each room
    public static class Room
    {
        //Name of object only used when creating save files
        String name = "";
        public Room(String roomName)
        {
            name = roomName;
        }
        /*
        Stores the key to what wall should be printed - parent array stores which wall it is and 
        nested arrays store what to display depending on the state of the wall
        */
        String[][] walls = new String[4][2];
        /*
        Stores the key to what message should be printed - parent array stores which wall it is and 
        nested arrays store what to print depending on the state of the wall
        */
        String[][] messages = new String[4][2];
        /*
        Door array stores the wall it is on in the index and the room it leads to in the value
        Codes:
        1 to 8 rooms
        -1 door locked needs key
        -2 door locked needs code
        -3 booby trap
        -4 door unlocked
        -8 door unlocked
        */
        int[] doors = new int[4];
        /*
        Special information for interactions or misc
        if specials string starts with "$" then send special value to art function
        */
        String[] specials = new String[4];
        /*
        Stores the state of items on a wall or the state of interaction
        Codes:
        1 item present or interaction not taken place
        0 item taken, non item location, or interaction done
        */
        int[] states = new int[4];
        //Item that is avaible to be taken, "null" if no item or non item location
        String[] items = new String[4];
    }

    //Room 1
    //If posterOnWall = false, the player has seen the poster and taken it.
    public static Room room1 = new Room("room1");
    //Room 2
    //If clubOnGround = false, the player has the club in their inventory.
    public static Room room2 = new Room("room2");
    
    //Room 3 (does not have any items, key needed to get into room 4)
    public static Room room3 = new Room("room3");
    //Room 4
    //If keyPresent = false, the player has the key in their inventory
    
    //Room 5
    //If battleWon = false, it means the player won and got a medal as a prize.
    //boolean battleWon = false;
    
    //Room 6 (has a slot machine; will figure out later)
    
    //Room 7 (player has to enter in a code to a keypad)
    
    //Room 8 (devito final boss battle, player recieves trophy and game ends);
    //boolean devitoAlive = true;

    //Populates each room object with data
    public static void init()
    {
        //region ROOM 1
        room1.walls[0][1] = "table";
        room1.walls[0][0] = "tableNoLighter";
        room1.walls[1][1] = "poster";
        room1.walls[1][0] = "ripped";
        room1.walls[2][0] = "oakWall";
        room1.walls[3][0] = "oakDoor";
        room1.messages[0][1] = "There is a table in front of you with a book on it titled \'README\'\nand a small candle.\nType i to read the book and pick to take the candle...";
        room1.messages[0][0] = "There is a table in front of you with a book on it titled \'README\'.\nType i to read the book.";
        room1.messages[1][1] = "There is a poster on the wall in front of you.\nThere is 'ESCAPE' printed clearly on it and series of incoherent words and scribbles riten below.\nYou feel compelled to rip it off the wall and take it.\nType pick to take the poster.";
        room1.messages[1][0] = "You look back and notice the ripped remains of the poster on the wall.";
        room1.messages[2][0] = "This room feels so famillar and yet so out of this world.";
        room1.messages[3][0] = "There is a door in front of you.\nType walk to open it and proceed to the next room.";
        room1.doors[3] = 2;
        room1.specials[0] = "$book";
        room1.states[0] = 1;
        room1.states[1] = 1;
        room1.items[0] = "candle";
        room1.items[1] = "paper";
        //endregion
        //region ROOM 2
        room2.walls[0][0] = "newspaper";
        room2.walls[1][0] = "oakDoor";
        room2.walls[2][1] = "club";
        room2.walls[2][0] = "brickWall";
        room2.walls[3][0] = "brickDoor";
        room2.messages[0][0] = "You are startled by a wall of newspaper clippings and photos.\nYou notice articles describing the downfall of the career of cinema great\nDanny Devito...\nType i to take a closer look.";
        room2.messages[1][0] = "You look towards the door to the first room.\nPerhaps you could just hide in there and hope this is a dream.";
        room2.messages[2][1] = "There is a club on the wall in front of you.\nIt seems like it will come in useful later.\nType pick to take it.";
        room2.messages[2][0] = "You look at the cracks worn in the brick.\nThe club seems as it has been used before...\nbut by who?";
        room2.messages[3][0] = "There is a door in front of you worn by age.\nType walk to go through it...\nbut first, what really catches your attention\nis the club on the wall to your right.";
        room2.doors[1] = 1;
        room2.doors[3] = 3;
        room2.specials[0] = "$newspapers";
        room2.states[2] = 1;
        room2.items[2] = "weapon";
        //endregion
        //region ROOM 3
        room3.walls[0][1] = "lockedDoor";
        room3.walls[0][0] = "openDoor";
        room3.walls[1][0] = "brickDoor";
        room3.walls[2][0] = "vertWall";
        room3.walls[3][0] = "spookyDoor";
        room3.messages[0][1] = "You stare at the steel door.\nYou can hear strange noises coming from inside...\nType i to try and unlock the door.";
        room3.messages[0][0] = "The door hangs open a bit.\nYou hesitate to see what's inside,\nbut you realize it is your only way out.\nType walk to go through...";
        room3.messages[1][0] = "You look back at the door to the room with the club.";
        room3.messages[2][0] = "There is a wall in front of you with old peeling tan wall paper.";
        room3.messages[3][0] = "You are hit by the stench of mildew.\nA large steel door to your left has a padlock on it.\nIn front of you is another old door.\nType walk to see what is on the other side...";
        room3.doors[0] = -1;
        room3.doors[1] = 2;
        room3.doors[3] = 3;
        room3.states[0] = 1;
        room3.specials[0] = "door";
        //endregion
        //region ROOM 4
        //endregion
        //region ROOM 5
        //endregion
    }
}
