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
        staminaCost[1] = 10;
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
        description[3] = "Nicolly take out of her bag a bunch of meds, healing herself in 40 heal points";
        description[4] = "Nicolly spawn a cat with germs and dealing damage 20% in the max heal points of enemy";
    }

    @Override
    protected void passive() {
        System.out.println("\nInstability activated, Nicolly got stronger");
        setAtkDamage(getAtkDamage() + 10);
    }

    @Override
    protected void skillOne(Player player) {
        System.out.println("Kaique attacked with " + skills[0]);
        int chance = rd.nextInt(2);
        if (chance == 0) {
            player.getCharacter().setStunned(true);
        }
        player.getCharacter().setLife(player.getCharacter().getLife() - 10 + (0.2 * getAtkDamage()));
    }

    @Override
    protected void skillTwo(Player player) {
        System.out.println("Kaique attacked with " + skills[1]);
        player.getCharacter().setLife(player.getCharacter().getLife() - (30 + (0.05 * getAtkDamage())));
    }

    @Override
    protected void skillThree(Player player) {
        System.out.println("Kaique attacked with " + skills[2]);
        setDefense(getDefense() + (getDefense() * 0.4));
        setStamina(getStamina() + (getStamina() * 0.5));
    }

    @Override
    protected void skillFour(Player player) {
        System.out.println("Kaique attacked with " + skills[3]);
        setDefense(getDefense() + 20);
        setStamina(getStamina() + 40);
        setAtkDamage(getAtkDamage() + 20);
    }
}
