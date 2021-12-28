import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
IMPORTANT:
Save class is too complicated to finish now and we decided to leave it as is.
In its current state it can write files and store the names of the save files in a file called "dir".
However reading files is still not done and we never had time to get it finished.
*/
public class Save extends Main
{
    private static String[] directory = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    private static String rawDirData = "";
    private static boolean directoryOverflow = false;

    public static void saveGame(boolean loadingGame)
    {
        clear();
        System.out.println(Font.format("bold-italic-default", "==================== Save Games ====================\n"));
        for (int i = 0; i < directory.length; i++)
        {
            System.out.println(Font.format("bold-blue", (i + 1) + ". ") + directory[i] + "\n");
        }

        if (loadingGame)
        {
            String rawData = "";
            String saveName = directory[readInt(Font.format("bold-default", "TYPE NUMBER OF FILE TO LOAD $") + Font.INPUT_GREEN + " > ") - 1];
            Font.reset();
            try
            {
                File saveFile = new File("saveGames/" + saveName + ".txt");
                Scanner fileRead = new Scanner(saveFile);
                while (fileRead.hasNextLine())
                {
                    rawData += fileRead.nextLine();
                }
                fileRead.close();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            String saveName = readLine(Font.format("bold-default", "New Save File:") + "\nType " + Font.format("italic-defualt", "\'EDIT\'") + " to delete a save file\n" + Font.format("bold-default", "Name of Save: " + Font.INPUT_GREEN));
            Font.reset();
            if (saveName.equals("EDIT"))
            {
                deleteFile();
            }
            else if (directoryOverflow)
            {
                System.out.println("Maximum Number of Save Files Exceeded - please delete saves");
                deleteFile();
            }
            else
            {
                try
                {
                    File save = new File("saveGames/" + saveName + ".txt");
                    if(save.createNewFile())
                    {
                        String out = "Super Text Adventure Save File\n>\nroomNum: " + roomNum + ";\ndirection: " + direction + ";\nscore: " + score + ";\ndialouge: " + dialouge + ";\ninventory: ";
                        for (String i : inventory)
                        {
                            if (i == null)
                            {
                                out += ";";
                                break;
                            }
                            else
                            {
                                out += i + ", ";
                            }
                        }
                        out += "\ninventorySlotAssign: " + inventorySlotAssign;
    
                        for (RoomData.Room r : sceneCollection)
                        {
                            for (int i = 0; i < 4; i++)
                            {
                                if (r.doors[i] != 0)
                                {
                                    out += "\n" + r.name + ":doors:" + i + ": " + r.doors[i] + ";";
                                }
                
                                if (r.states[i] != 0)
                                {
                                    out += "\n" + r.name + ":states:" + i + ": " + r.states[i] + ";";
                                }
                            }
                        }
    
                        addItemToDir(saveName);
                        FileWriter doc = new FileWriter("saveGames/" + saveName + ".txt");
                        doc.write(out);
                        doc.close();
                        System.out.println("Save Complete\n" + saveName);
                    }
                    else
                    {
                        System.out.println("Save " + saveName + " Already Exists");
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                readLine("Press Enter");
            }
        }
    }

    public static void deleteFile()
    {
        System.out.println("==================== Save Games ====================\n");
        for (int i = 0; i < directory.length; i++)
        {
            System.out.println((i + 1) + ". " + directory[i] + "\n");
        }

        int indexOfFile = readInt("Type File Number to Delete: ") - 1;
        String fileName = directory[indexOfFile] + ".txt";
        File doc = new File("saveGames/" + fileName);
        if (doc.delete())
        {
            System.out.println("Save File " + fileName + " deleted");
            directory[indexOfFile] = "Empty";
        }
        else
        {
            System.out.println("An Error Occured Deleting the Save");
        }
        readLine("Press Enter to Continue");
    }

    public static void loadDir()
    {
        try
        {
            Scanner dirRead = new Scanner(new File("saveGames/dir.txt"));
            while (dirRead.hasNextLine())
            {
                rawDirData += dirRead.nextLine();
            }
            dirRead.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        int arrayIndex = 0;
        String temp = "";
        for (int i = 0; i < rawDirData.length(); i++)
        {
            if (rawDirData.charAt(i) == ';')
            {
                try
                {
                    directory[arrayIndex] = temp;
                }
                catch (IndexOutOfBoundsException e)
                {
                    directoryOverflow = true;
                    break;
                }
                arrayIndex++;
                temp = "";
            }
            else
            {
                temp += rawDirData.charAt(i);
            }
        }
    }

    private static void addItemToDir(String fileName)
    {
        loadDir();
        try
        {
            for (int i = 0; i < directory.length; i++)
            {
                directory[i] = "Empty";
            }

            FileWriter dirWrite = new FileWriter("saveGames/dir.txt");
            dirWrite.write(rawDirData + "\n" + fileName + ";");
            dirWrite.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}