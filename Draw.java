public class Draw extends Main
{
    /*
    Credits:
    asciiart.eu
    */
    public static void art(String i)
    {
        /*
        Method to store all game ASCII art in one place
        Prints art to the screen based on the input string
        */
        if (i.equals("title"))
        {
            System.out.println("███████╗██╗   ██╗██████╗ ███████╗██████╗\n██╔════╝██║   ██║██╔══██╗██╔════╝██╔══██╗\n███████╗██║   ██║██████╔╝█████╗  ██████╔╝\n╚════██║██║   ██║██╔═══╝ ██╔══╝  ██╔══██╗\n███████║╚██████╔╝██║     ███████╗██║  ██║\n╚══════╝ ╚═════╝ ╚═╝     ╚══════╝╚═╝  ╚═╝\n \n████████╗███████╗██╗  ██╗████████╗\n╚══██╔══╝██╔════╝╚██╗██╔╝╚══██╔══╝\n   ██║   █████╗   ╚███╔╝    ██║\n   ██║   ██╔══╝   ██╔██╗    ██║\n   ██║   ███████╗██╔╝ ██╗   ██║\n   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚═╝\n \n █████╗ ██████╗ ██╗   ██╗███████╗███╗   ██╗████████╗██╗   ██╗██████╗ ███████╗\n██╔══██╗██╔══██╗██║   ██║██╔════╝████╗  ██║╚══██╔══╝██║   ██║██╔══██╗██╔════╝\n███████║██║  ██║██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║██████╔╝█████╗\n██╔══██║██║  ██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║██╔══██╗██╔══╝\n██║  ██║██████╔╝ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝██║  ██║███████╗\n╚═╝  ╚═╝╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝ ");
        }
        else if (i.equals("lockedDoor"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │----│----│-------------------│----│-----│\n  │    │    │    ___________    │    │     │\n  │    │    │   │  _ _ _ _  │   │    │     │\n  │    │    │   │ │ │ │ │ │ │   │    │     │\n  │    │    │   │ │-+-+-+-│ │   │    │     │\n  │    │    │   │ │-+-+-+-│ │   │    │     │\n  │    │    │   │ │_│_│_│_│ │   │    │     │\n  │    │    │   │     ___   │   │    │     │\n  │    │    │   │    /__/   │   │    │     │\n  │    │    │   │   [%==] ()│   │    │     │\n  │    │    │   │         │││   │    │     │\n  │    │    │   │         ()│   │    │     │\n  │    │    │   │           │   │    │     │\n  │    │    │   │           │   │    │     │\n  │;\'\".│:\'\';│   │           │   │\':.!│::\'!││\n  │____│____│___│___________│___│____│_____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("openDoor"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │----│----│-------------------│----│-----│\n  │    │    │    ___________    │    │     │\n  │    │    │   │    ., │   │   │    │     │\n  │    │    │   │  /│,│ │   │   │    │     │\n  │    │    │   │ │,x,│ │   │   │    │     │\n  │    │    │   │ │,x,\' │   │   │    │     │\n  │    │    │   │ │,x   ,   │   │    │     │\n  │    │    │   │ │/    │%==│   │    │     │\n  │    │    │   │    /] ,   │   │    │     │\n  │    │    │   │   [/ ()   │   │    │     │\n  │    │    │   │       │   │   │    │     │\n  │    │    │   │       │   │   │    │     │\n  │    │    │   │       │   │   │    │     │\n  │    │    │   │      ,\'   │   │    │     │\n  │;\'\".│:\'\';│   │   ,\'      │   │\':.!│::\'!││\n  │____│____│___│,\'_________│___│____│_____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("spookyDoor"))
        {
            System.out.println("\\                                               /\n \\ ___________________________________________ /\n  │                                           │\n  ││;;==;:=;..=.===.=.=,;==;==-=.=--=.=--;-=-││\n  │                                           │\n  │                                           │\n  │                  ______                   │\n  │               ,-' ;  ! `-.                │\n  │              / :  !  :  . \\               │\n  │             │_ ;   __:  ;  │              │\n  │            {)│ .  :)(.  !  │              │\n  │             │\"    (##)  _  │              │\n  │             │  :  ;`\'  (_) (              │\n  │             │  :  :  .     │              │\n  │            {)_ !  ,  ;  ;  │              │\n  │             ││ .  .  :  :  │              │\n  │             │\" .  │  :  .  │              │\n  │_____________│_..__;----.___│______________│\n /                                             \\\n/                                               \\");
        }
        else if (i.equals("oakDoor"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   o-    _   -    ~      _   : o  _     │\n  │________.________.______________________│\n  │ _       -     _  ~ -     ~_      o:    │\n  │__.____________________________.________│\n  │   ~   _     : __________  -    _-      │\n  │______________│  __  __  │__________.___│\n  │        -  _ :│ │  ││  │ │ _. _   -     │\n  │____.________{│ │  ││  │ │__.___________│\n  │   o-    _    │ │__││__│ │   -   _.   ~ │\n  │____________._│  __  __()│______________│\n  │  _      o    │ │  ││  │ │    _   --    │\n  │______________│ │  ││  │ │___________.__│\n  │  ~o     :  .{│ │  ││  │ │ _    o--     │\n  │______.__.____│ │  ││  │ │______________│\n  │              │ │__││__│ │              │\n  │______________│__________│._____________│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("brickDoor"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │    │        │        │        │        │\n  │____│____.___│_____.__│________│________│\n  │        │        │        │        │    │\n  │__._____│________│________│_______.│____│\n  │    │        │   ______        │        │\n  │____│________│,-\' ;  ! `-._____│___.____│\n  │        │    / :  !  :  . \\        │    │\n  │____.___:___│_ ;   __:  ;  │.______│____│\n  │    │      {)│ .  :)(.  !  │   │        │\n  │____│_______│\"    (##)  _  │___:________│\n  │        │   │  :  ;`\'  (_) (       │    │\n  │________│___│  :  :  .     │_______│_.__│\n  │    │      {)_ !  ,  ;  ;  │   │        │\n  │____│_.__.__││ .  .  :  :  │___│________│\n  │        │   │\" .  │  :  .  │       │    │\n  │________│___│_..__;----.___│_______│____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("oakWall"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   o-    _   -    ~      _   : o  _     │\n  │________.________.______________________│\n  │ _       -     _  ~ -     ~_      o:    │\n  │__.____________________________.________│\n  │   ~   _     :  _.   -         _-       │\n  │_______________________:____________.___│\n  │        -  _ :   -  _ ~    _. _   -     │\n  │____.________________.______.___________│\n  │   o-    _    _  ~ .   :     -   _.   ~ │\n  │____________.__________.________________│\n  │  _      o     _   -     .    _   --    │\n  │_____________________________________.__│\n  │  ~o     :   .       -     _    o--     │\n  │______.__.______________________________│\n  │                                        │\n  │______________._________________________│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("brickWall"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │    │        │        │        │        │\n  │____│____.___│_____.__│________│________│\n  │        │        │        │        │    │\n  │__._____│________│________│_______.│____│\n  │    │        │        │        │        │\n  │____│________│________:________│___.____│\n  │        │        │        │        │    │\n  │____.___:________│___.____│_.______│____│\n  │    │        │        │        │        │\n  │____│_______.│________│._______:________│\n  │        │        │        │        │    │\n  │________│________│________│________│_.__│\n  │    │        │        │        │        │\n  │____│_.__.___│________│________│________│\n  │        │        │        │        │    │\n  │________│_____.__│________│________│____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("brickWallKey"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │    │        │        │        │        │\n  │____│____.___│_____.__│________│________│\n  │        │        │        │        │    │\n  │__._____│________│________│_______.│____│\n  │    │        │        │        │        │\n  │____│________│________:________│___.____│\n  │        │        │        │        │    │\n  │____.___:________│___.____│_.______│____│\n  │    │        │        │        │        │\n  │____│_______.│________│._______:________│\n  │        │        │        │        │    │\n  │________│________│________│________│_.__│\n  │    │        │        │        │        │\n  │____│_.__.___│___🗝️____│________│________│\n  │        │        │        │        │    │\n  │________│_____.__│________│________│____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("vertWall"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │----│----│----│----│----│----│----│-----│\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │    │    │    │    │    │    │    │     │\n  │;'\".│:\'\';││:\' │\":\'!│:\'.││:; \"│\':.!│::\'!││\n  │____│____│____│____│____│____│____│_____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("newspaper"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   ______    │  ________       │        │\n  │__│ TIME │.__│_│  ____  │______│________│\n  │  │A~~~~~│     │ │ :) │ │ │ REVENGE│    │\n  │__│~~~\\~~│_____│ │____│ │_│___/___.│____│\n  │  │____\\_│   │ │_/\\_____│    / │        │\n  │____│___\\____│_/___\\________/__│___.____│\n  │        _\\___/   │  \\______/       │    │\n  │____.__│  \\/ │___│__│\\NEWS/│.______│____│\n  │    │  │C~~~~│      │ \\ ~/ │   │        │\n  │____│__│~~~~~│______│ -\\/~-│___:________│\n  │       │_____│   │  │[]~-~-│       │    │\n  │________│________│__│______│_______│_.__│\n  │    │        │        │        │        │\n  │____│_.__.___│________│________│________│\n  │        │        │        │        │    │\n  │________│_____.__│________│________│____│\n /                                          \\\n/                                            \\");
        }
        else if (i.equals("poster"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   o-    _   -    ~      _   : o  _     │\n  │________.________.______________________│\n  │ _       -     ________   ~_      o:    │\n  │__.___________│'ESCAPE'│_______.________│\n  │   ~         :│--~~-~  │       _-       │\n  │______________│-~-~~~--│____________.___│\n  │        -  _  │~~-~--- │  _. _   -      │\n  │____._________│---~~-~~│____.___________│\n  │   o-    _    │________│     -   _.   ~ │\n  │____________.__________.________________│\n  │  _      o     _   -     .    _   --    │\n  │_____________________________________.__│\n  │  ~o     :   .       -     _    o--     │\n  │______.__.______________________________│\n  │                                        │\n  │______________._________________________│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("ripped"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   o-    _   -    ~      _   : o  _     │\n  │________.________.______________________│\n  │ _       -     _  ~ -     ~_      o:    │\n  │__.____________________________.________│\n  │   ~   _     :  ./\\/\\   -         _-    │\n  │______________│\\/    \\__________._______│\n  │        -  _ :│~~-~---\\  _. _   -      _│\n  │____._________│---~~-~~│____.___________│\n  │   o-    _    │________│   -  _ ~    _. │\n  │____.________________.______.___________│\n  │   --    _    _  ~ .   :     -   _.   ~ │\n  │____________.__________.________________│\n  │  _      o     _   -     .    _   --    │\n  │_____________________________________.__│\n  │  ~o     :   .       -     _    o--     │\n  │______.__.______________________________│\n  │                                        │\n  │______________._________________________│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("table"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   o-    _   -    ~      _   : o  _     │\n  │________.________.______________________│\n  │ _       -     _  ~ -     ~_      o:    │\n  │__.____________________________.________│\n  │   ~   _     :  _.   -         _-       │\n  │_______________________:____________.___│\n  │        -  _ :   -  _ ~    _. _   -     │\n  │____.________________.______.___________│\n  │   o-   _______________________  _.   ~ │\n  │_______/           📖     🕯️    \\________│\n  │  _   /_________________________\\  --   │\n  │______││_______________________││____.__│\n  │  ~o  ││   :   .       -     _ ││ o--   │\n  │______││__.____________________││____.__│\n  │      ││                       ││       │\n  │______││________.______________││_______│\n /       ││                       ││        \\\n/                                            \\");
        }
        else if (i.equals("tableNoLighter"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │   o-    _   -    ~      _   : o  _     │\n  │________.________.______________________│\n  │ _       -     _  ~ -     ~_      o:    │\n  │__.____________________________.________│\n  │   ~   _     :  _.   -         _-       │\n  │_______________________:____________.___│\n  │        -  _ :   -  _ ~    _. _   -     │\n  │____.________________.______.___________│\n  │   o-   _______________________  _.   ~ │\n  │_______/           📖          \\________│\n  │  _   /_________________________\\  --   │\n  │______││_______________________││____.__│\n  │  ~o  ││   :   .       -     _ ││ o--   │\n  │______││__.____________________││____.__│\n  │      ││                       ││       │\n  │______││________.______________││_______│\n /       ││                       ││        \\\n/                                            \\");
        }
        else if (i.equals("club"))
        {
            System.out.println("\\                                            /\n \\ ________________________________________ /\n  │    │        │        │        │        │\n  │____│____.___│_____.__│________│________│\n  │        │        │        │        │    │\n  │__._____│________│________│_______.│____│\n  │    │        │        │        │        │\n  │____│________│________:__ +-+ _│___.____│\n  │             =============│ │      │    │\n  │________│_____`__│_______`:_; _____│____│\n  │    │        │        │        │        │\n  │____│_______.│________│._______:________│\n  │        │        │        │        │    │\n  │________│________│________│________│_.__│\n  │    │        │        │        │        │\n  │____│_.__.___│________│________│________│\n  │        │        │        │        │    │\n  │________│_____.__│________│________│____│\n /                                          \\ \n/                                            \\");
        }
        else if (i.equals("paper"))
        {
            System.out.println("    -------------------------------------------------------\n   │ ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄  ▄▀▄▄▄▄   ▄▀▀█▄   ▄▀▀▄▀▀▀▄  ▄▀▀█▄▄▄▄ │\n   │▐  ▄▀   ▐ █ █   ▐ █ █    ▌ ▐ ▄▀ ▀▄ █   █   █ ▐  ▄▀   ▐ │\n   │  █▄▄▄▄▄     ▀▄   ▐ █        █▄▄▄█ ▐  █▀▀▀▀    █▄▄▄▄▄  │\n   │  █    ▌  ▀▄   █    █       ▄▀   █    █        █    ▌  │\n   │ ▄▀▄▄▄▄    █▀▀▀    ▄▀▄▄▄▄▀ █   ▄▀   ▄▀        ▄▀▄▄▄▄   │\n   │ █    ▐    ▐      █     ▐  ▐   ▐   █          █    ▐   │\n   │ ▐                ▐                ▐          ▐       /\n   │   /\\                                          /\\  /\\/\n   \\/  \\          /\\            /\\              /  \\/\n    \\/    \\  /\\    /  \\      /\\  /  \\/\\      /\\  /\n           \\/  \\  /    \\/\\  /  \\/      \\  /\\/  \\/\n                \\/        \\/            \\/");
        }
        else if (i.equals("candle"))
        {
            System.out.println("       (\n    )\\\n    {_}\n   .-;-.\n  |\'-=-\'|\n  |     |\n  |     |\n  |     |\n  |     |\n  \'.___.\'");
        }
        else if (i.equals("$newspapers"))
        {
            System.out.println("                                                          ____________________________________\n    __                                                 /|   December 15 2021                 |\n  .\'  `\"\"*****------------........________            / |                                    |\n /      _______...........______________  `\\         /  | ||\\  ||  ||\'\'\' \\\\        // |\'\'\'\'  |\n: .j\"\"\"\'                  ___  __  _    `T`*;       /___| || \\ ||  ||---  \\\\  /\\  //  `---,  |\n|/ :     |   |  /\\  |\\  |  |  |   | \\    |         |      ||  \\||  ||___   \\\\//\\\\//   ____|  |\n   `;    | ^ | :__: | \\ |  |  |-  |  ;   |         |                                         |\n    |    |/ \\| |  | |  \\|  |  |__ |_/ .-*\'         |    ================================     |\n    |      ____...MR. DEVITO...____   `\".          |  DANNY DEVITO CAUGHT! - Charges against |\n    |    .P\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"T.    |         |      famous actor Danny DeVito came out |\n     `-. T      ,\'           \\      T    |         |   yesterday saying he was responsible   |\n    .-\'  ;     :   ,*\'\"*v*\"*  ;     :    |         |   for the death of arch enemy Larry     |\n    |    |     |  / __     __ |     |    |         |   David. Many attribute this to his     |\n    |    |     ,-:-{o }-ˆ-{o };     |    |         |   recent downward spiral after the end  |\n    |    |     ;P   \'\'     \'\' |  :  |              |   of \"Its Always Sunny in Philidelphia\".|\n    ;    |     `-.      ,     |     |  .\'          |   Sources say he is in the wind and many|\n    ;    |       :   -____-  \'      |  `.          |   suspect he is hiding out in the cellar|\n    :    |       |`.    -   /       |    ;         |   of his upstate New York house.        |\n    `;   |     _.:  `-.__.\'         |    |         \\  /\\        /\\            /\\  /\\      /\\/\n     `-, ; ,-*\'   `-.__.-\'\'*-._     :    |          \\/  \\/\\    /  \\  /\\/\\  /\\/  \\/  \\  /\\/\n    ,-\': b:                    `.   d    |                 \\  /    \\/    \\/          \\/\n   :     `b________________________d\'   /,                  \\/\n   |       \"\"\"\"FOR MANSLAUGHTER\"\"\"\"     \"|\n   `;     _   __              _   _      |\n    `;   | \\ |   |   |   /\\  | \\ | \\     |\n   ._|   |_/ |-  | ^ |  :__: |_/ |  ;  ,\',\n   `.    | \\ |__ |/ \\|  |  | | \\ |_/    `|\n     ;        _     _     _     _    .|-,`,\nbug] |   /|  / \\   / \\   / \\   / \\  (_|_  :\n  __ :    | :   ; :   ; :   ; :   ;   | ) |    .\n  \\ `\'-._ |  \\_/   \\_/   \\_/   \\_/  `-|\"  |   /;\n   \\     `***-----...__     _____.....----+-*\'/\n    `-.__...-----...   `:,-\'               _.\'\n                `**--..____...----***\'\'");
        }
        else if (i.equals("$book"))
        {
            System.out.println("     __________________   __________________\n .-/│                  \\ /                  │\\-.\n ││││ You have been     │ left              ││││\n ││││ placed here to be │ right             ││││\n ││││ tested, to escape │ walk              ││││\n ││││ this ominous tomb.│ i                 ││││\n ││││ To earn your      │ pick              ││││\n ││││ escape you must   │                   ││││\n ││││ defeat and kill   │                   ││││\n ││││ the monster of    │                   ││││\n ││││ these parts known │                   ││││\n ││││ as, Danny Devito  │                   ││││\n ││││__________________ │ __________________││││\n ││/===================\\│/===================\\││\n `--------------------~___~-------------------\'\'");
        }
        else if (i.equals("win"))
        {
            System.out.println(" __  __   ______   __  __       __ __ __    ________  ___   __      \n/_/\\/_/\\ /_____/\\ /_/\\/_/\\     /_//_//_/\\  /_______/\\/__/\\ /__/\\    \n\\ \\ \\ \\ \\\\:::_ \\ \\\\:\\ \\:\\ \\    \\:\\\\:\\\\:\\ \\ \\__.::._\\/\\::\\_\\\\  \\ \\   \n \\:\\_\\ \\ \\\\:\\ \\ \\ \\\\:\\ \\:\\ \\    \\:\\\\:\\\\:\\ \\   \\::\\ \\  \\:. `-\\  \\ \\  \n  \\::::_\\/ \\:\\ \\ \\ \\\\:\\ \\:\\ \\    \\:\\\\:\\\\:\\ \\  _\\::\\ \\__\\:. _    \\ \\ \n    \\::\\ \\  \\:\\_\\ \\ \\\\:\\_\\:\\ \\    \\:\\\\:\\\\:\\ \\/__\\::\\__/\\\\. \\`-\\  \\ \\n     \\__\\/   \\_____\\/ \\_____\\/     \\_______\\/\\________\\/ \\__\\/ \\__\\/");
        }
        else if (i.equals("lost"))
        {
            System.out.println(" __  __    ______    __  __        __        ______    ______    _________  \n/_/\\/_/\\  /_____/\\  /_/\\/_/\\      /_/\\      /_____/\\  /_____/\\  /________/\\ \n\\ \\ \\ \\ \\ \\:::_ \\ \\ \\:\\ \\:\\ \\     \\:\\ \\     \\:::_ \\ \\ \\::::_\\/_ \\__.::.__\\/ \n \\:\\_\\ \\ \\ \\:\\ \\ \\ \\ \\:\\ \\:\\ \\     \\:\\ \\     \\:\\ \\ \\ \\ \\:\\/___/\\   \\::\\ \\   \n  \\::::_\\/  \\:\\ \\ \\ \\ \\:\\ \\:\\ \\     \\:\\ \\____ \\:\\ \\ \\ \\ \\_::._\\:\\   \\::\\ \\  \n    \\::\\ \\   \\:\\_\\ \\ \\ \\:\\_\\:\\ \\     \\:\\/___/\\ \\:\\_\\ \\ \\  /____\\:\\   \\::\\ \\ \n     \\__\\/    \\_____\\/  \\_____\\/      \\_____\\/  \\_____\\/  \\_____\\/    \\__\\/");
        }
        else if (i.equals("dannyFight"))
        {
            System.out.println(Font.format("red", " ____    _    _   _ _   ___   __  ____  _______     _____ _____ ___\n|  _ \\  / \\  | \\ | | \\ | \\ \\ / / |  _ \\| ____\\ \\   / /_ _|_   _/ _ \\\n| | | |/ _ \\ |  \\| |  \\| |\\ V /  | | | |  _|  \\ \\ / / | |  | || | | |\n| |_| / ___ \\| |\\  | |\\  | | |   | |_| | |___  \\ V /  | |  | || |_| |\n|____/_/ __\\_\\_|_\\_|_| \\_|_|_|__ |____/|_____| _\\_/_ |___|_|_|_\\___/_____ ___ _   _  ____\n   / \\  / ___/ ___|| | | |  \\/  | ____/ ___|  |  ___|_ _/ ___| | | |_   _|_ _| \\ | |/ ___|\n  / _ \\ \\___ \\___ \\| | | | |\\/| |  _| \\___ \\  | |_   | | |  _| |_| | | |  | ||  \\| | |  _\n / ___ \\ ___) |__) | |_| | |  | | |___ ___) | |  _|  | | |_| |  _  | | |  | || |\\  | |_| |\n/_/__ \\_\\____/____/ \\___/|_|_ |_|_____|____/  |_|   |___\\____|_| |_| |_| |___|_| \\_|\\____|__\n/ ___|_   _|/ \\  | \\ | |/ ___| ____|                                                      \\ \\\n\\___ \\ | | / _ \\ |  \\| | |   |  _|    _____ _____ _____ _____ _____ _____ _____ _____ _____\\ \\\n ___) || |/ ___ \\| |\\  | |___| |___  |_____|_____|_____|_____|_____|_____|_____|_____|_____/ /\n|____/ |_/_/   \\_\\_| \\_|\\____|_____|                                                      /_/\n" + Font.RESET + "\n                                  ______\n                               .\'        `.\n                             .\'            `.\n                            /   _________    \\                    ,-.\n                           .  /           \\   \\                  /  -\n           ,\'\'\'\'\'-._      /  |_ __ ___ __ _|   \\              _.\'  --\n          /         \'.  _|   | | o|   | o| |    \\         _.-\'\'      -\n          |           `/ |   |  \"\"     \"\"  |     |__._.-\'      ,/\'`-/\n          ]     \\    ,:  |___|       \\     |_____|           ,-\'  |\n           :     \\-_/        `.   _____     :              ,\'    /\n            `.    Y\'       ,_  \\ \'     \'  ,\'   _.--\'\'\'\'---\')     |\n              \\ .\'      _/\'  `._`.______,\'---.<...        /     |\n              .\'      ,\' \'-.._      ____...,\'   /\'     ,\'      /\n             /\'     ,/        \'`\'\'\'\'           /     ,\'       /\n            ,\'    /  :                        /    ,\'       ,-\'\'\'\'._\n            |    ()   :                      |    |      .-\'        \'\n            `.   :     ) __............____ .\'    |_ .--\'\n             `.   `.  ,\'                   `/       `\'-.__\n     _,....--\'>    : /                     |   __...-._   `\\\n  ,-\'       .\' |   `.                      \"--\'        ` ._/\'--._\n,\'        /\'    |   `.                                           \'akn\n         (.,   /|     :                                            \\.\n            `'' :     :\\\n                )     :.:\n                : ; . ; \'\n                \'_: . \'\n                  \'_:\'"));
        }
        else
        {
            System.out.println("ERROR ART NOT FOUND");
        }
        //Reset font values;
        Font.reset();
    }

    public static void miniMap(int dir)
    {
        final String INDENT = "                                     ";
        int cast = 8594;
        for (int i = 0; i < dir; i++)
        {
            cast--;
            if (cast == 8591)
            {
                cast = 8595;
            }
        }
        char arrow = (char) cast;
        System.out.println(Font.format("bold-default", INDENT + "    NORTH\n" + INDENT + "EAST  " + arrow + "  WEST\n" + INDENT + "    SOUTH"));
    }
    
    //Cutscenes and Animations:

    public static void doorAnim() 
    {
        //Plays every time player walks through a door
        delay(500);
        clear();
        System.out.println("\n\n\n                 ___________\n                │       │   │\n                │       │   │\n                │       │   │\n                │       │   │\n                │       ,   │\n                │       │%==│\n                │       │   │\n                │      ()   │\n                │       │   │\n                │       │   │\n                │       │   │\n                │      ,\'   │\n                │   ,\'      │\n                │,\'_________│");
        delay(500);
        clear();
        System.out.println("\n\n\n               _______________\n              │               │\n              │               │\n              │               │\n              │               │\n              │               │\n              │+=============+│\n              │               │\n              │               │\n              │               │\n              │               │\n              │               │\n              │               │\n              │               │\n              │               │\n              │               │\n              │_______________│");
        delay(500);
        clear();
        System.out.println("\n\n\n             ___________________\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │+=================+│\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │                   │\n            │___________________│");
        delay(500);
    }

    public static void firstDoorAnim()
    {
        clear();
        System.out.println("        │     .  o\n        │  o  │      │   \'      │  o  │      │\n    o   │     │      │   │   \\  .     │      │      │\n        │  .│`--...___   │ o    │     │   o  │ .    │ o  │   │    \n        │  ││o    o   `---...___│     │      │    o │    │   │   o │\n        │  │\'---...___   o      `---...___   │      │    │ . │     │\n     -  │  \'-`│     │ `--...___ o     o   `---...____  < │   │   / │\n        │    ││     │`--...___ `---...___   o      o │   │   │     │\n        │    ││ o   │         `---...___ `---..._____│   │   │ o   │\n    o   │ .  ││     │                   `---...__.\'││    │   │     │\n        │    ││     │                            │ ││  o │ . │     │\n        │ o  ││  _  │                            │ ││    │   │     │\n        │    ││     │                            │ ││    │   │   o \n    >   │    ││     │                            │ ││    │   │     │\n        │  . ││   o │                            │ │ o │ │   │     │\n        │    ││  .  │                            │ ││  < │   │     │\n        │    ││  │  │                            │.\'│   .│   │     │\n        │  \\ ││     │                            │ ││ .  │   │     │\n        │    ││o    \'                            │ ││    │   │     │\n        │    ││     │                            │ ││    │   │     │\n      o │    ││     │      And So You Venture    │ ││..\' │   │ o   │\n        │    ││     │                            │ ││  < │   │     │\n    /   │    ││     │       Into the Unknown     │ ││    │   │     │\n        │ o  ││ _   │                            │`││    │   │  .  │\n        │    ││    o│                            │ ││ -  │  -│     │\n        │    ││     │                            │\'││    │   │     │\n   o    │    ││     │                            :\' │    │   │   o │\n        │  - ││     │                            │ ││ o  │   [     │\n        │    ││     │                            │ ││    │   │     │\n        │  │ ││    o│                            │ ││    │   │  _  │\n   -    │  │ ││     │                            │ ││    │   │     │\n        │    ││     │                            │ ││o   │   │ o   │\n        │    ││     │                            │ ││    │   │     │\n        │    ││   . │                            │ ││    │   │     │\n        │   .││o    │                            │ ││    │   │    o│\n    o   │    ││     │                        ____│ ││    │ > │     │\n        │    ││     │        _____ ....--\'`      \'.││____│___│_____│\n   _____│____││     │ ..--\'`     .\'                __...\'         ___\n       _      │_____│       ____ __ ___,..  \'\'  `. ___....----\'\'\'\n    \'  _ _..`.  ___`-  --\'` _.\'   ___ ..    -._    .           ____`...\n   \'\'\'\'       \'\'___`...---     --\'       `..   \'.___   ---\'\'\'\'\'\n   ___`.. --\'\'\'\'                ___...----. \'\'");
        delay(5000);
    }

    public static void startAnim()
    {
        //Opening Cutscene
        clear();
        delay(500);
        System.out.println("You wake up and find yourself in an empty room...");
        delay(4000);
        System.out.println("The room is dark and wet and made of old oak wood...");
        delay(4000);
        System.out.println("You have one objective: to escape.");
        delay(4000);
        clear();
    }
}