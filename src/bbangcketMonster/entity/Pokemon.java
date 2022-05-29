package bbangcketMonster.entity;

import bbangcketMonster.PokemonType;

public class Pokemon {
    private String name = "";
    private int HP;
    private int Max_HP;
    private int ACK;
    private int DEF;
    private PokemonType type;
    private int level;
    private boolean inParty;
    private boolean isDead = false;

    public Pokemon() {
    }

    public Pokemon(String name, int HP, int ACK, int DEF, PokemonType type) {
        this.name = name;
        this.HP = HP;
        this.Max_HP = HP;
        this.ACK = ACK;
        this.DEF = DEF;
        this.level = 1;
        this.inParty = false;
        this.type = type;
    }

    public void setInParty() {
        inParty = true;
    }

    public void setOutParty() {
        inParty = false;
    }

    public void printCharaInfo() {
        System.out.println("[" + name + "] name : " + level + " HP :" + HP + "/" + Max_HP + " ACK:" + ACK + " DEF :" + DEF + " Party : " + inParty);
    }

    public void attack(NpcUnit monster) {
        monster.HP -= ACK;
        System.out.println(monster.name + "에게 " + ACK + "타격");
        if (monster.HP <= 0) {
            monster.isDead = true;
            monster.HP = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getMax_HP() {
        return Max_HP;
    }

    public int getACK() {
        return ACK;
    }

    public int getDEF() {
        return DEF;
    }

    public PokemonType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public boolean isInParty() {
        return inParty;
    }

    public boolean isDead() {
        return isDead;
    }
}
