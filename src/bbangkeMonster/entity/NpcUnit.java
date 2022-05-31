package bbangkeMonster.entity;

import bbangkeMonster.PokemonType;

public abstract class NpcUnit {
    protected String name;
    protected int ACK;
    protected int DEF;
    protected int HP;
    protected int Max_HP;
    protected boolean isDead = false;
    protected PokemonType type;


    NpcUnit() {
        name = "";
        ACK = 10;
        DEF = 10;
        HP = 50;
        Max_HP = 50;
    }

    abstract void normalAttack(Pokemon cha);

    abstract void weakAttack();

    abstract void strongAttack();

    public String getName() {
        return name;
    }

    public int getACK() {
        return ACK;
    }

    public int getDEF() {
        return DEF;
    }

    public int getHP() {
        return HP;
    }

    public int getMax_HP() {
        return Max_HP;
    }

    public boolean isDead() {
        return isDead;
    }

    public PokemonType getType() {
        return type;
    }

    public void printUnit() {
        System.out.println("[" + name + "] HP : " + HP + "/" + Max_HP + " ACK : " + ACK + " DEF: " + DEF);
    }
}
