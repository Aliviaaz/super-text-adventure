public class SubGame extends Main
{
    /*
    Small Puzzle for Text Adventure project that can be implemented
    as a method through the main() method
    By: Rowan Clinch
    */
    private final static String INDENT = "                                  ";
    private static char[] bar = {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'};
    private static boolean flip = true;
    private static int i = 0;
    private static boolean flag = false;
    private static int score = 30;
    private static int tries = 3;

    public static Thread t = new Thread()
    {
        public void run()
        {
            while (tries > 0)
            {
                try
                {
                    Thread.sleep(50);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                clear();
                display();
                while (flag)
                {
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public static void floatingPointGame()
    {
        clear();
        delay(2000);
        System.out.println(Font.format("italic-red", "Danny DeVito emerges..."));
        delay(2000);
        System.out.println(Font.format("italic-red", "You are shocked to finally see him in his true form"));
        delay(2000);
        System.out.println(Font.format("italic-red", "He is skinny and pasty, however you realize that..."));
        delay(2000);
        for (int i  = 0; i < 6; i++)
        {
            clear();
            if (i % 2 == 0)
            {
                Draw.art("dannyFight");
            }
            delay(1000);
        }

        t.start();
        while (tries > 0)
        {
            while (true)
            {
                if (read.nextLine().equals(""))
                {
                    flag = true;
                    break;
                }
            }
            score -= ((Math.abs(9 - i)) * -1) + 15;
            read.nextLine();
            tries--;
            flag = false;
        }
        
        if (score <= 0)
        {
            System.out.println("YOU WON");
        }
        else
        {
            System.out.println("YOU LOST");
        }
    }

    private static void display()
    {
        if (i == 0)
        {
            flip = true;
        }
        else if (i == 16)
        {
            flip = false;
        }
            
        if (flip)
        {
            i++;
        }
        else if (!flip)
        {
            i--;
        }
        
        bar[i] = '▀';
        System.out.println(INDENT + "Enemy Health: " + score + " Tries: " + tries);
        System.out.print(INDENT + " ________˅________\n" + INDENT + "|");
        System.out.print(bar);
        System.out.print("|\n\n" + INDENT + "Press Enter > ");
        bar[i] = '_';
    }
}