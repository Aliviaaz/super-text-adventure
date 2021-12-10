import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Save
{
    private static String[] directory = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    private static String rawDirData = "";

    public static void saveGame(boolean loadingGame)
    {
        Main.clear();
        System.out.println("==================== Save Games ====================\n");
        for (int i = 0; i < directory.length; i++)
        {
            System.out.println((i + 1) + ". " + directory[i] + "\n");
        }

        if (loadingGame)
        {
            String saveName = directory[Integer.parseInt(Main.readLine("Type Number of File to Load > ")) - 1];
            try
            {
                String rawData = "";
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
            String saveName = Main.readLine("New Save File\nName of Save > ");
            try
            {
                File save = new File("saveGames/" + saveName + ".txt");
                if(save.createNewFile())
                {
                    addItemToDir(saveName);
                    FileWriter doc = new FileWriter("saveGames/" + saveName + ".txt");
                    doc.write(formatSave());
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
            Main.readLine("Press Enter");
        }
    }

    public static void loadDir()
    {
        try
        {
            File directoryFile = new File("saveGames/dir.txt");
            Scanner dirRead = new Scanner(directoryFile);
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
                directory[arrayIndex] = temp;
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
            for (String i : directory)
            {
                i = "Empty";
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

    private static String formatSave()
    {
        String out = "Super Text Adventure Save File\n>\nroomNum: " + Main.roomNum + ";\ndirection: " + Main.direction + ";\nscore: " + Main.score + ";\ndialouge: \"" + Main.dialouge + "\";\ninventory: ";
        for (String i : Main.inventory)
        {
            if (i == null)
            {
                out += ";";
                break;
            }
            else
            {
                out += "\"" + i + "\", ";
            }
        }
        out += "\ninventorySlotAssign: " + Main.inventorySlotAssign;
        for (RoomData.Room r : Main.sceneCollection)
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
        return out;
    }
}