package Config;

import java.util.Scanner;
import Characters.*;
import Players.Player;

public class EventSystem {
    
    Scanner in = new Scanner(System.in);
    private int rounds = 1;
    private boolean isRound = false;

    public void gameStart(Player playerOne, Player playerTwo) {
        choseCharacter(playerOne);
        choseCharacter(playerTwo);
        menuGame(playerOne);
        menuGame(playerTwo);
    }

    public void battle() {

    }

    public void choseCharacter(Player player) {
        System.out.println(player.getName() + " choose your character");
        System.out.println("\n1 - Kaique\n2 - Nicolly\n3 - João Victor");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                Kaique k = new Kaique();
                player.setCharacter(k);
                break;
            case 2:
                Nicolly n = new Nicolly();
                player.setCharacter(n);
                break;
            case 3:
                JoaoVictor j = new JoaoVictor();
                player.setCharacter(j);
                break;
            default:
                System.out.println("Invalid value");
                break;
        }
    }

    public void menuGame(Player player) {
        System.out.print("\n"+player.getName()+" turn");
        System.out.print(" |Round: "+rounds);
        System.out.print("\n|"+player.getCharacter().getName()+" |");
        System.out.print(" Life:"+player.getCharacter().getLife()+" |");
        System.out.print(" Atk:"+player.getCharacter().getAtkDamage()+" |");
        System.out.print(" Def:"+player.getCharacter().getDefense()+" |");
        System.out.print(" Stam"+player.getCharacter().getStamina()+" |\n");
        System.out.print("1 - ["+player.getCharacter().getSkills()[0]+"] "+"["+player.getCharacter().getStaminaCost()[0]+"]  ");
        System.out.print("2 - ["+player.getCharacter().getSkills()[1]+"] "+"["+player.getCharacter().getStaminaCost()[1]+"]"+"\n");
        System.out.print("3 - ["+player.getCharacter().getSkills()[2]+"] "+"["+player.getCharacter().getStaminaCost()[2]+"]  ");
        System.out.print("4 - ["+player.getCharacter().getSkills()[3]+"] "+"["+player.getCharacter().getStaminaCost()[3]+"]\n");
    }
}
