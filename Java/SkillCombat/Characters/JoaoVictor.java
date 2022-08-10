package Characters;

import Players.Player;

public class JoaoVictor extends Character {

    public JoaoVictor() {

        // Skills definition
        skills = new String[4];
        description = new String[5];
        setPassive("Anarchy");
        skills[0] = "Xenofobic";
        skills[1] = "Whash Dish";
        skills[2] = "Words of Truth";
        skills[3] = "God Vult";

        // StaminaCost definition *
        staminaCost = new int[4];
        staminaCost[0] = 30;
        staminaCost[1] = 40;
        staminaCost[2] = 30;
        staminaCost[3] = 100;

        // Description definition
        description[0] = "Nicolly receive 20 armor and lose 10% atkdamage in the first round, but in the second round she receive 20 atkdamage and lose 20% armor";
        description[1] = "Nicolly throw the favorite book in the enemy dealing 20+15% atkdamage";
        description[2] = "Nicolly have your friend beatriz to do her job, receiving 30 stamina";
        description[3] = "Jv speaks the hards truths and deal 5+60% atkdamage of true damage";
        description[4] = "God Vult bless Jv and give divine regeneration, Anarchy buffed in the 15%";

        // Status definition *
        setName("João Victor");
        setLife(130);
        setAtkDamage(6);
        setStamina(100);
        setDefense(40);
    }

    @Override
    protected void passive() {
        System.out.println("\nGym mouse passive activated, kaique got stronger");
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
