import java.util.Scanner;
import Characters.*;
import Config.Description;

public class Start {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Description d = new Description();
        boolean reset = true, reset4;
        System.out.println("\n---SKILL COMBAT---");
        while (reset) {
            System.out.println("\n1 - Play\n2 - Character Description\n3 - Settings\n4 - Credits\n5 - Exit");
            int option = in.nextInt();
            switch (option) {
                case 1:

                    break;
                case 2:
                    System.out.println("\n---Character Description---");
                    System.out.println("1 - Kaique\n2 - Nicolly\n3 - João Victor");
                    option = in.nextInt();
                    switch (option) {
                        case 1:
                            Kaique k = new Kaique();
                            d.status(k);
                            break;
                        case 2:
                            Nicolly n = new Nicolly();
                            d.status(n);
                            break;
                        case 3:
                            JoaoVictor j = new JoaoVictor();
                            d.status(j);
                            break;
                        default:
                            System.out.println("\nInvalid Value");
                            break;
                    }
                    break;
                case 3:

                    break;
                case 4:
                    reset4 = true;
                    while (reset4) {
                        System.out.println("\nAuthor: Kaique Santos\nGithub Account: KJSS3012\n");
                        System.out.println("\n 1 - Back\n");
                        option = in.nextInt();
                        switch (option) {
                            case 1:
                                reset4 = false;
                                break;
                            default:
                                System.out.println("\nInvalid Value");
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thanks for play");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid Value");
                    break;
            }
        }
        in.close();
    }
}
