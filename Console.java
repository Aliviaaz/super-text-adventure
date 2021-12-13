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

    public static class Font
    {
        /*
        Makes the Text Look Pretty
        IMPORTANT: Program is intended to run on CodeHS where colors look different
        */     
        public static void reset()
        {
            //Resets values
            System.out.print("\033[0m");
        }

        private static String[] basicColors = {"default", "red", "green", "yellow", "blue", "purple", "cyan", "gray", "lred", "lgreen", "lyellow", "lblue", "lpurple", "lcyan", "lgray"};

        /**<p>Styles the text to make it look pretty,
         * Call the method like this
         * <pre>
         * Font.format(formatString, str);
         * 
         *Font.format("bold-underline-default", "Whatever is inserted here is now bold underlined and defualt color usually black or white");
         * </pre>Whatever is in the second parameter is formated based on the {@code formatString} parameter
         * </p>
         * <p>Acceptable Formats:
         * <pre>
         * "default"
         * "bold"
         * "light"
         * "italic"
         * "underline"
         * </pre></p>
         * <p>Acceptable Colors:
         * <pre>
         * "default"
         * "red"
         * "green"
         * "yellow"
         * "blue"
         * "purple"
         * "cyan"
         * "gray"
         * "lred"
         * "lgreen"
         * "lyellow"
         * "lblue"
         * "lpurple"
         * "lcyan"
         * "lgray"
         * </pre></p>
         * 
         * @param formatString
         * - String to determine how to format text. Example of acceptable format string {@code"bold-underline-italic-blue"} Formats must always end in a color.
         * @param str
         * - String to be formated
         * @return
         * - ANSI Text format string. Example: {@code "\033[2;1;4;33m"}
         */
        public static String format(String formatString, String str)
        {
            String[] formats = {"def", "bold", "light", "italic", "underline"};
            String[] formatArguments = new String[5];
            int argumentsArrayPointer = 0;
            String temp = "";
            for (int i = 0; true; i++)
            {
                try
                {
                    formatString.charAt(i + 1);
                }
                catch (IndexOutOfBoundsException e)
                {
                    temp += formatString.charAt(i);
                    formatArguments[argumentsArrayPointer] = temp;
                    temp = "";
                    break;
                }

                if (formatString.charAt(i) == '-')
                {
                    formatArguments[argumentsArrayPointer] = temp;
                    temp = "";
                    argumentsArrayPointer++;
                }
                else
                {
                    temp += formatString.charAt(i);
                }
            }

            String out = "\033[";
            for (int i = 0; i < formatArguments.length + 1; i++)
            {
                for (int n = 0; n < formats.length; n++)
                {
                    if (formats[n].equals(formatArguments[i]))
                    {
                        out += n + ";";
                    }
                }

                if (formatArguments[i + 1] == null)
                {
                    out += getColorCode(formatArguments[i]) + "m";
                    break;
                }
            }
            return out + str + RESET;
        }

        private static int getColorCode(String color)
        {
            int out = 0;
            for (int i = 0; i < basicColors.length; i++)
            {
                if (basicColors[i].equals(color))
                {
                    out = i;
                    if (i == 0)
                    {
                        out = 10;
                    }
                    else if (i > 7)
                    {
                        out = (out - 7) + 90;
                    }
                    else
                    {
                        out += 30;
                    }
                }
            }
            return out;
        }

        //Reset Values but can be referenced as a variable instead
        public static final String RESET = "\033[0m";

        public static final String INPUT_BLUE = "\033[0;34m";
        public static final String INPUT_GREEN = "\033[0;32m";
    }
}
