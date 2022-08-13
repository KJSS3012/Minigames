package Config;

import java.util.Scanner;
import Players.Player;

public class EventSystem {

    Scanner in = new Scanner(System.in);
    InstanceCharacter instance = new InstanceCharacter();
    private int rounds = 1;
    private boolean isRound = rounds % 2 == 0, isRepeat;

    public void gameStart(Player playerOne, Player playerTwo) {
        choseCharacter(playerOne);
        choseCharacter(playerTwo);
        battle(playerOne, playerTwo);
        battle(playerTwo, playerOne);
    }

    public void choseCharacter(Player player) {
        System.out.println(player.getName() + " choose your character");
        System.out.println("\n1 - Kaique\n2 - Nicolly\n3 - João Victor");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                player.setCharacter(instance.kaique());
                break;
            case 2:
                player.setCharacter(instance.nicolly());
                break;
            case 3:
                player.setCharacter(instance.joaoVictor());
                break;
            default:
                System.out.println("Invalid value");
                break;
        }
    }

    public void battle(Player attacker, Player defender) {
        menuGame(attacker);
        isRepeat = true;
        do {
            System.out.print("\nChoose your move");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    attacker.getCharacter().skillOne(defender);
                    checkLife(attacker, defender);
                    rounds += 1;
                    isRepeat = false;
                    break;
                case 2:
                    attacker.getCharacter().skillTwo(defender);
                    checkLife(attacker, defender);
                    rounds += 1;
                    isRepeat = false;
                    break;
                case 3:
                    attacker.getCharacter().skillThree(defender);
                    checkLife(attacker, defender);
                    rounds += 1;
                    isRepeat = false;
                    break;
                case 4:
                    attacker.getCharacter().skillFour(defender);
                    checkLife(attacker, defender);
                    rounds += 1;
                    isRepeat = false;
                    break;
                case 5:
                    rounds += 1;
                    isRepeat = false;
                    break;
                default:
                    System.out.println("\nInvalid value");
                    isRepeat = true;
                    break;
            }
        } while (isRepeat);
    }

    public void checkLife(Player attacker, Player defender) {
        if (attacker.getCharacter().getLife() <= 0) {
            defender.setScore(defender.getScore() + 1);
            gameOver(defender);
        } else if (defender.getCharacter().getLife() <= 0) {
            attacker.setScore(attacker.getScore() + 1);
            gameOver(attacker);
        }
    }

    public void gameOver(Player winner){
        
    }
    
    public void menuGame(Player player) {
        System.out.println("\n----------SKILL COMBAT----------");
        System.out.print("\n"+player.getName()+" turn");
        System.out.print(" |Round: "+rounds+"\n");
        System.out.print("\n|"+player.getCharacter().getName()+"|\n");
        System.out.print(" \nLife:"+player.getCharacter().getLife()+" |");
        System.out.print(" Atk:"+player.getCharacter().getAtkDamage()+" |");
        System.out.print(" Def:"+player.getCharacter().getDefense()+" |");
        System.out.print(" Stam"+player.getCharacter().getStamina()+"\n");
        System.out.print("1 - ["+player.getCharacter().getSkills()[0]+"] "+"["+player.getCharacter().getStaminaCost()[0]+"]  ");
        System.out.print("2 - ["+player.getCharacter().getSkills()[1]+"] "+"["+player.getCharacter().getStaminaCost()[1]+"]"+"\n");
        System.out.print("3 - ["+player.getCharacter().getSkills()[2]+"] "+"["+player.getCharacter().getStaminaCost()[2]+"]  ");
        System.out.print("4 - ["+player.getCharacter().getSkills()[3]+"] "+"["+player.getCharacter().getStaminaCost()[3]+"]\n");
        System.out.print("5 - Skip the round\n");
    }

    public boolean isRound() {
        return isRound;
    }
}
