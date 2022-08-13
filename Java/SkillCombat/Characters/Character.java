package Characters;

import Players.Player;
import java.util.Random;

public abstract class Character {
    protected Random rd = new Random();
    private String name, passive;
    protected String[] skills, description;
    protected int[] staminaCost;
    private double life, atkDamage, stamina, defense, regeneration;
    private boolean isStunned = false, isSilenced = false;
    
    public abstract void passive();

    public abstract void skillOne(Player player);

    public abstract void skillTwo(Player player);

    public abstract void skillThree(Player player);

    public abstract void skillFour(Player player);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String[] getDescription() {
        return description;
    }   

    public void setDescription(String[] description) {
        this.description = description;
    }

    public int[] getStaminaCost() {
        return staminaCost;
    }

    public void setStaminaCost(int[] staminaCost) {
        this.staminaCost = staminaCost;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double getAtkDamage() {
        return atkDamage;
    }

    public void setAtkDamage(double atkDamage) {
        this.atkDamage = atkDamage;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }

    public boolean isSilenced() {
        return isSilenced;
    }

    public void setSilenced(boolean isSilenced) {
        this.isSilenced = isSilenced;
    }

    public double getRegeneration() {
        return regeneration;
    }

    public void setRegeneration(double regeneration) {
        this.regeneration = regeneration;
    }

}