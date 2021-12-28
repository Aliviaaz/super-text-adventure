import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//IMPORTANT room data system has changed majorly since we made the explanation video all room data is now read from resource.txt file
public class RoomData
{
    //Basic structure of each room
    public static class Room
    {
        //Name of object only used when creating save files
        String name = "";
        //Constructor loads data into class
        public Room(String roomName, String[][] wall, String[][] message, int[] door, String[] special, int[] state, String[] item)
        {
            name = roomName;
            walls = wall;
            messages = message;
            doors = door;
            specials = special;
            states = state;
            items = item;
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

    //Room Objects
    public static Room room1 = loadResources(1);
    public static Room room2 = loadResources(2);
    public static Room room3 = loadResources(3);
    public static Room room4 = loadResources(4);  
    public static Room room5 = loadResources(5);
    public static Room room6 = loadResources(6);   
    public static Room room7 = loadResources(7);
    public static Room room8 = loadResources(8);


    private static String[][] declareArrayOfNull(int index1, int index2)
    {
        String[][] out = new String[index1][index2];
        for (int a = 0; a < out.length; a++)
        {
            for (int b = 0; b < out[a].length; b++)
            {
                out[a][b] = "";
            }
        }
        return out;
    }

    public static Room loadResources(int roomIdentifier)
    {
        System.out.println("DEBUG INFO:");

        String[][][] master = {declareArrayOfNull(4, 2), declareArrayOfNull(4, 2), declareArrayOfNull(4, 1), declareArrayOfNull(4, 1), declareArrayOfNull(4, 1), declareArrayOfNull(4, 1)};

        String resourceData = "";
        try
        {
            Scanner resourceRead = new Scanner(new File("resources.txt"));
            while (resourceRead.hasNextLine())
            {
                resourceData += resourceRead.nextLine();
            }
            resourceRead.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        int arrayCounter = 0;
        int dimension1 = 0;
        int dimension2 = 0;
        boolean countingDimension1 = false;
        boolean countingDimension2 = false;
        boolean reading = false;

        for (int i = 0; i < resourceData.length(); i++)
        {
            char c = resourceData.charAt(i);

            if (c == '>' && resourceData.charAt(i + 1) == Integer.toString(roomIdentifier).charAt(0))
            {
                reading = true;
                i++;
            }

            if (reading)
            {
                if (c == '~')
                {
                    break;
                }
                else if (c == '{')
                {
                    if (countingDimension1)
                    {
                        countingDimension2 = true;
                    }
                    else
                    {
                        countingDimension1 = true;
                    }
                }
                else if (c == '}')
                {
                    if (countingDimension2)
                    {
                        countingDimension2 = false;
                        dimension2 = 0;
                    }
                    else
                    {
                        countingDimension1 = false;
                        dimension1 = 0;
                    }
                }
                else if (c == ',')
                {
                    if (countingDimension1 && !countingDimension2)
                    {
                        dimension1++;
                    }
                    else
                    {
                        dimension2++;
                    }
                }
                else if (c == ';')
                {
                    arrayCounter++;
                }
                else
                {
                    if (c == '\\' && resourceData.charAt(i + 1) == 'n')
                    {
                        master[arrayCounter][dimension1][dimension2] += '\n';
                        i++;
                    }
                    else if (c == '\\' && resourceData.charAt(i + 1) == ',')
                    {
                        master[arrayCounter][dimension1][dimension2] += ',';
                        i++;
                    }
                    else if (c != '>')
                    {
                        master[arrayCounter][dimension1][dimension2] += c;
                    }
                }
                //DEV
                System.out.println("ROOM: " + roomIdentifier + " " + c + ": arrCount: " + arrayCounter + " d1: " + dimension1 + " d2: " + dimension2);      
            }
        }

        int[] d = new int[4];
        String[] sp = new String[4];
        int[] st = new int[4];
        String[] it = new String[4];

        //doors
        for (int i = 0; i < master[2].length; i++)
        {
            if (master[2][i][0].equals(""))
            {
                d[i] = 0;
            }
            else
            {
                d[i] = Integer.parseInt(master[2][i][0]);
            } 
        }

        //specials
        for (int i = 0; i < master[3].length; i++)
        {
            sp[i] = master[3][i][0];
        }

        //states
        for (int i = 0; i < master[4].length; i++)
        {
            if (master[4][i][0].equals(""))
            {
                d[i] = 0;
            }
            else
            {
                st[i] = Integer.parseInt(master[4][i][0]);
            }
        }

        //items
        for (int i = 0; i < master[5].length; i++)
        {
            it[i] = master[5][i][0];
        }

        return new Room("room" + Integer.toString(roomIdentifier), master[0], master[1], d, sp, st, it);
    }
}