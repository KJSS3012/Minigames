package Characters;

import Players.Player;

public abstract class Character {
    private String name, passive;
    protected String[] skills;
    protected int[] staminaCost;
    private float life, atkDamage, stamina, defense;
    private boolean isStunned, isSilenced;

    protected abstract void passive();

    protected abstract void skillOne(Player player);

    protected abstract void skillTwo(Player player);

    protected abstract void skillThree(Player player);

    protected abstract void skillFour(Player player);

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

    public int[] getStaminaCost() {
        return staminaCost;
    }

    public void setStaminaCost(int[] staminaCost) {
        this.staminaCost = staminaCost;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getAtkDamage() {
        return atkDamage;
    }

    public void setAtkDamage(float atkDamage) {
        this.atkDamage = atkDamage;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
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

}