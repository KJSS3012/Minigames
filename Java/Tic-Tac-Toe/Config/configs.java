import java.util.*;
import Players.Player;

public class configs {
    Scanner in = new Scanner(System.in);
    private Player playerOne;
    private Player playerTwo;
    private String[] mark = { "X", "O" };
    String[] p = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    String[] aux = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    Boolean[] isChecked = { false, false, false, false, false, false, false, false, false };
    Boolean gameOver = false;
    Boolean reset = false;
    int jogadas = 0;

    public void start() {
        playerOne = new Player();
        playerTwo = new Player();
        System.out.println("Seja Bem-Vindo ao Jogo da Velha!");
        System.out.print("Insira o nome do Jogador 1: ");
        playerOne.name = in.nextLine();
        System.out.print("\nInsira o nome do Jogador 2: ");
        playerTwo.name = in.nextLine();
        while (!gameOver) {
            showComplete();
            choice();
        }
    }

    public void show() {
        System.out.println("\n-----TABELA-----");
        System.out.println("|" + p[0] + "|" + p[1] + "|" + p[2] + "|");
        System.out.println("|" + p[3] + "|" + p[4] + "|" + p[5] + "|");
        System.out.println("|" + p[6] + "|" + p[7] + "|" + p[8] + "|");
    }

    public void showComplete() {
        System.out.println("\n-----PLACAR-----");
        System.out.println("JOGADOR 1: " + playerOne.getName() + "| " + playerOne.getScore());
        System.out.println("JOGADOR 2: " + playerTwo.getName() + "| " + playerTwo.getScore());
        System.out.println("\n-----TABELA-----");
        System.out.println("|" + p[0] + "|" + p[1] + "|" + p[2] + "|");
        System.out.println("|" + p[3] + "|" + p[4] + "|" + p[5] + "|");
        System.out.println("|" + p[6] + "|" + p[7] + "|" + p[8] + "|");
    }

    public void choice() {
        System.out.println("A partida começou");
        do {
            System.out.println("\nÉ a vez de " + playerOne.getName());
            String escolha = in.nextLine();

            for (int i = 0; i < p.length; i++) {
                if (escolha.equalsIgnoreCase(p[i])) {
                    if (isChecked[i] == false) {
                        p[i] = mark[0];
                        reset = false;
                        jogadas += 1;
                        check(p[1], playerOne);
                        isChecked[i] = true;
                        show();
                    } else {
                        System.out.println("Opção inválida");
                        reset = true;
                    }
                }
            }
        } while (reset);

        do {
            System.out.println("\nÉ a vez de " + playerTwo.getName());
            String escolha = in.nextLine();

            for (int i = 0; i < p.length; i++) {
                if (escolha.equalsIgnoreCase(p[i])) {
                    if (isChecked[i] == false) {
                        p[i] = mark[1];
                        reset = false;
                        jogadas += 1;
                        check(p[1], playerTwo);
                        show();
                    } else {
                        System.out.println("Opção inválida");
                        reset = true;

                    }
                }

            }
        } while (reset);
    }

    public void check(String valor, Player score) {
        if (p[0] == valor && p[4] == valor && p[8] == valor) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        } else if (p[2] == valor && p[4] == valor && p[6] == valor) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        } else if ((p[0] == valor && p[1] == valor && p[2] == valor)) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        } else if ((p[3] == valor && p[4] == valor && p[5] == valor)) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        } else if ((p[6] == valor && p[7] == valor && p[8] == valor)) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        }

        else if ((p[0] == valor && p[3] == valor && p[6] == valor)) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        } else if ((p[1] == valor && p[4] == valor && p[7] == valor)) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();
        } else if ((p[2] == valor && p[5] == valor && p[8] == valor)) {
            score.setScore(score.getScore() + 1);
            showComplete();
            end();

        } else if (jogadas == 9) {
            show();
            System.out.println("\n----VELHA----");
            end();
        }
    }

    public void turnChecked() {
        for (int i = 0; i < isChecked.length; i++) {
            isChecked[i] = false;
        }
    }

    public void end() {
        System.out.println("\nDeseja continuar?");
        System.out.println("1 - Sim\n2 - Não\n3 - Resetar placar");
        int escolha = in.nextInt();
        switch (escolha) {
            case 1:
                gameOver = false;
                in.nextLine();
                for (int i = 0; i < aux.length; i++) {
                    p[i] = aux[i];
                }
                reset = true;
                turnChecked();
                break;
            case 2:
                gameOver = true;
                break;
            case 3:
                playerOne.score = 0;
                playerTwo.score = 0;
                gameOver = false;
                turnChecked();
                break;
            default:
                gameOver = false;
                break;
        }

    }
}
