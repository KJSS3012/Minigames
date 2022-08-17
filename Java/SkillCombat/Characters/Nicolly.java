package Characters;

import Players.Player;

public class Nicolly extends Character {

    public Nicolly() {

        // Skills definition
        skills = new String[4];
        description = new String[5];
        setPassive("Instability");
        skills[0] = "Throw Book";
        skills[1] = "Privilegy";
        skills[2] = "Drugstore";
        skills[3] = "Spawn Cat";

        // StaminaCost definition *
        staminaCost = new int[4];
        staminaCost[0] = 50;
        staminaCost[1] = 0;
        staminaCost[2] = 150;
        staminaCost[3] = 100;

        // Status definition *
        setName("Nicolly");
        setLife(80);
        setAtkDamage(15);
        setStamina(200);
        setDefense(20);

        // Description definition
        description[0] = "Nicolly receive 20 armor and lose 10% ("+Math.round(0.1*getAtkDamage())+") atkdamage in the first round, but in the second round she receive 20 atkdamage and lose 20% ("+0.2*getDefense()+") armor";
        description[1] = "Nicolly throw the favorite book in the enemy dealing 20+15% ("+Math.round(20+(0.15*getAtkDamage()))+") atkdamage";
        description[2] = "Nicolly have your friend beatriz to do her job, receiving 50 stamina";
        description[3] = "Nicolly take out of her bag a bunch of meds, healing herself in 40 life points";
        description[4] = "Nicolly spawn a cat with germs and dealing damage 20% in the max life points of enemy";
    }

    @Override
    public void passive() {
        System.out.println("\nInstability activated, Nicolly got stronger");
        setAtkDamage(getAtkDamage() + 10);
    }

    @Override
    public void skillOne(Player player) {
        System.out.println("Nicolly attacked with " + skills[0]);
        player.getCharacter().setLife(player.getCharacter().getLife() - Math.round(20+(0.15*getAtkDamage())));
        setStamina(getStamina() - staminaCost[0]);
    }

    @Override
    public void skillTwo(Player player) {
        System.out.println("Nicolly attacked with " + skills[1]);
        setStamina(getStamina()+50);
        setStamina(getStamina() - staminaCost[1]);
    }

    @Override
    public void skillThree(Player player) {
        System.out.println("Nicolly attacked with " + skills[2]);
        setLife(getLife()+40);
        setStamina(getStamina() - staminaCost[2]);
    }

    @Override
    public void skillFour(Player player) {
        System.out.println("Nicolly attacked with " + skills[3]);
        player.getCharacter().setLife(player.getCharacter().getLife() - (0.2*player.getCharacter().getLife()));
        setStamina(getStamina() - staminaCost[3]);
    }

    public void reset(){
        setLife(80);
        setAtkDamage(15);
        setStamina(200);
        setDefense(20);
    }
}
