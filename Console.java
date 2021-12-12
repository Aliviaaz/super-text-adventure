import java.util.InputMismatchException;
import java.util.Scanner;

public class Console
{
    //Collection of methods that help with certain operations with flow and GUI

    public static void delay(int time)
    {
        //Pauses the CPU thread the program is executing on to give the feeling of time delay
        try
        {
            Thread.sleep(time);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void clear()
    {
        //Clears console using ASCII command characters
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Scanner read = new Scanner(System.in);

    public static String readLine(String prompt)
    {
        //Reads input from console
        System.out.print(prompt);
        return read.nextLine();
    }

    public static int readInt(String prompt)
    {
        //Reads integer from console
        System.out.print(prompt);
        try
        {
            return read.nextInt();
        }
        catch (InputMismatchException e)
        {
            readInt(prompt);
        }
        return 0;
    }
}
