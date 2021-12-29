public class SubGame extends Main
{
    /*
    Small Puzzle for Text Adventure project that can be implemented
    as a function through the main() function
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
                    t.sleep(50);
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
                        t.sleep(10);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public static boolean floatingPointGame()
    {
        cutscene();

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
            clear();
            Draw.art("KO");
            System.out.println(Font.format("italic-bold-red", "DANNY DEVITO LOOSES"));
            readLine("Press Enter");
            Main.score += score * -1;
            return false;
        }
        else
        {
            clear();
            Draw.art("KO");
            System.out.println(Font.format("italic-bold-red", "YOU LOOSE"));
            readLine("Press Enter");
            return true;
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
        Draw.art("dannyFightScreen");
        System.out.println(INDENT + "Devito Health: " + score + " Your Energy: " + (tries * 10));
        System.out.print(INDENT + " ________˅________\n" + INDENT + "|");
        System.out.print(bar);
        System.out.print("|\n\n" + INDENT + "Press Enter > ");
        bar[i] = '_';
    }

    private static void cutscene()
    {
        clear();
        delay(2000);
        System.out.println(Font.format("italic-red", "Danny DeVito emerges..."));
        delay(2000);
        System.out.println(Font.format("italic-red", "You are shocked to finally see him in his true form"));
        delay(2000);
        System.out.println(Font.format("italic-red", "He is skinny and pasty, however you realize that..."));
        delay(2000);
        Draw.art("dannyFight");
        delay(5000);
        clear();
        for (int a  = 0; a < 6; a++)
        {
            clear();
            if (a % 2 == 0)
            {
                Draw.art("dannyFight");
            }
            delay(1000);
        }

        clear();
        System.out.println("YOU DARE TRY AND ESCAPE!" + Font.format("italic-default", "says danny") + "\nYou must now fight me to earn your freedom\n\n" + Font.format("italic-bold-default", "============== How to Fight ==============\n") + "Try and press enter when the moving icon is in the center of\nthe bar this will cause the most damage to Danny\nEvery time you press enter you will loose 10 energy points");
        if (inventoryContains("_advantage"))
        {
            System.out.println("Good thing you did good on the questions earlier ill go easy on ya");
            score -= 10;
        }
        else if (inventoryContains("weapon"))
        {
            System.out.println("Good thing you picked up that club from earlier you have something to give you an upper hand");
        }
        else
        {
            System.out.println("You have nothing to defend yourself and so the battle will be difficult");
            score += 20;
        }
        readLine("Press Enter");
    }
}