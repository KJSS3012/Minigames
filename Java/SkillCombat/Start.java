import java.util.Scanner;
import Config.*;
import Players.Player;

public class Start {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Description d = new Description();
        InstanceCharacter instance = new InstanceCharacter();
        boolean reset = true, reset4;
        System.out.println("\n---SKILL COMBAT---");
        while (reset) {
            System.out.println("\n1 - Play\n2 - Character Description\n3 - Settings\n4 - Credits\n5 - Exit");
            int option = in.nextInt();
            switch (option) {
                case 1:
                    Player playerOne = new Player();
                    Player playerTwo = new Player();
                    System.out.println("\nHello! Skill Combat is starting");
                    in.nextLine();
                    System.out.print("How should i call you, Player one? ");
                    playerOne.setName(in.nextLine());
                    System.out.print("\nHow should i call you, Player Two? ");
                    playerTwo.setName(in.nextLine());
                    EventSystem e = new EventSystem();
                    reset = false;
                    e.gameStart(playerOne,playerTwo);
                    break;
                case 2:
                    System.out.println("\n---Character Description---");
                    System.out.println("1 - Kaique\n2 - Nicolly\n3 - João Victor\n4 - Charlon");
                    option = in.nextInt();
                    switch (option) {
                        case 1:
                            d.status(instance.kaique());
                            break;
                        case 2:
                            d.status(instance.nicolly());
                            break;
                        case 3:
                            d.status(instance.joaoVictor());
                            break;
                        case 4:
                            d.status(instance.charlon());
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
