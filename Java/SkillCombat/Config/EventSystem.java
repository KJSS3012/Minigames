package Config;

import java.util.Scanner;
import Players.Player;

public class EventSystem {

    Scanner in = new Scanner(System.in);
    InstanceCharacter instance = new InstanceCharacter();
    private int rounds = 1;
    private boolean isRound = rounds % 2 == 0, isContinue = false, isRepeat;

    public void gameStart(Player playerOne, Player playerTwo) {
        do {
            rounds = 1;
            choseCharacter(playerOne);
            choseCharacter(playerTwo);
            do {
                battle(playerOne, playerTwo);
                battle(playerTwo, playerOne);
                activePassiveStma(playerTwo, playerOne, 30);
            } while (playerOne.getCharacter().getLife() > 0 && playerTwo.getCharacter().getLife() > 0);
        } while (isContinue);
    }

    public void choseCharacter(Player player) {
        
        do {
            System.out.println("\n" + player.getName() + " choose your character");
            System.out.println("\n1 - Kaique\n2 - Nicolly\n3 - João Victor");
            System.out.print("\nChoice: ");
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
        } while (isContinue);
    }

    public void battle(Player attacker, Player defender) {
        do {
            menuGame(attacker);
            isRepeat = true;
            if (attacker.getCharacter().isStunned()) {
                System.out.println("\n-->" + attacker.getCharacter().getName() + " IS STUNNED<--");
                attacker.getCharacter().setStunned(false);
                isRepeat = false;
            } else {
                System.out.print("\nChoose your move: ");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        if ((attacker.getCharacter().getStamina() - attacker.getCharacter().getStaminaCost()[0]) < 0) {
                            System.out.println("\nInsufficient Stamina");
                            isRepeat = true;
                        } else {
                            attacker.getCharacter().skillOne(defender);
                            checkLife(attacker, defender);
                            rounds += 1;
                            isRepeat = false;
                        }
                        break;
                    case 2:
                        if ((attacker.getCharacter().getStamina() - attacker.getCharacter().getStaminaCost()[1]) < 0) {
                            System.out.println("\nInsufficient Stamina");
                            isRepeat = true;
                        } else {
                            attacker.getCharacter().skillTwo(defender);
                            checkLife(attacker, defender);
                            rounds += 1;
                            isRepeat = false;
                        }
                        break;
                    case 3:
                        if ((attacker.getCharacter().getStamina() - attacker.getCharacter().getStaminaCost()[2]) < 0) {
                            System.out.println("\nInsufficient Stamina");
                            isRepeat = true;
                        } else {
                            attacker.getCharacter().skillThree(defender);
                            checkLife(attacker, defender);
                            rounds += 1;
                            isRepeat = false;
                        }
                        break;
                    case 4:
                        if ((attacker.getCharacter().getStamina() - attacker.getCharacter().getStaminaCost()[3]) < 0) {
                            System.out.println("\nInsufficient Stamina");
                            isRepeat = true;
                        } else {
                            attacker.getCharacter().skillFour(defender);
                            checkLife(attacker, defender);
                            rounds += 1;
                            isRepeat = false;
                        }
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
            }
        } while (isRepeat);
    }

    public void checkLife(Player attacker, Player defender) {
        if (attacker.getCharacter().getLife() <= 0) {
            defender.setScore(defender.getScore() + 1);
            gameOver(defender,attacker);
        } else if (defender.getCharacter().getLife() <= 0) {
            attacker.setScore(attacker.getScore() + 1);
            gameOver(attacker,defender);
        }
    }

    public void gameOver(Player winner, Player loser) {
        int choice;
        System.out.println("\n" + winner.getName() + " win");
        System.out.println("\n"+winner.getName()+": "+winner.getScore());
        System.out.println("\n"+loser.getName()+": "+loser.getScore());
        do {
            System.out.println("\nContinue?\n1 - Yes\n2 - No");
            System.out.print("\nChoice: ");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    isContinue = true;
                    winner.getCharacter().reset();
                    loser.getCharacter().reset();
                    break;
                case 2:
                    isContinue = false;
                    break;
                default:

                    break;
            }
        } while (choice != 1 && choice != 2);
    }


    public void menuGame(Player player) {
        System.out.println("\n----------SKILL COMBAT----------");
        if (!isRepeat) {
            player.getCharacter().passive();
        }
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

    public void activePassiveStma(Player attacker, Player defender, int stamina) {
        attacker.getCharacter().setStamina(attacker.getCharacter().getStamina() + stamina);
        defender.getCharacter().setStamina(defender.getCharacter().getStamina() + stamina);
    }

    public boolean isRound() {
        return isRound;
    }
}
