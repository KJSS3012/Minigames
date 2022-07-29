import java.util.Scanner;
import Characters.*;
import Config.Description;

public class Start {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n---SKILL COMBAT---");
        boolean reset = false, reset4 = false;
        while (reset) {
            reset = false;
            System.out.println("\n1 - Play\n2 - Character Description\n3 - Setings\n4 - Credit\n5 - Exit");
            int option = in.nextInt();
            switch (option) {
                case 1:

                    break;
                case 2:
                    System.out.println("\n---Character Description---");
                    System.out.println("1 - Kaique");
                    option = in.nextInt();
                    switch (option) {
                        case 1:
                            Description d = new Description();
                            Kaique k = new Kaique();
                            d.status(k);
                            break;
                        default:
                            System.out.println("\nInvalid Value");
                            break;
                    }
                    break;
                case 3:

                    break;
                case 4:
                    while (reset4) {
                        System.out.println("\nAuthor: Kaique Santos\nGithub Account: KJSS3012\n");
                        System.out.println("\n 1 - Back");
                        option = in.nextInt();
                        switch (option) {
                            case 1:
                                reset = true;
                                reset4 = false;
                                break;
                            default:
                                System.out.println("\nInvalid Value");
                                reset4 = true;
                                break;
                        }
                        break;
                    }
                case 5:
                    System.out.println("Thanks for play");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid Value");
                    reset = true;
                    break;
            }
        }
        in.close();
    }
}
