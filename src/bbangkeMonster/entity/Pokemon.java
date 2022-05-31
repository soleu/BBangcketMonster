package bbangkeMonster.entity;

import java.util.ArrayList;

public class Pokemon {
    private String name = "";
    private int HP;
    private int Max_HP;
    //    private int ACK;
    private ArrayList<Skill> skills = new ArrayList<>();
    private int DEF;
    private PokemonType type;
    private int level;
    private boolean inParty;
    private boolean isDead = false;


    public Pokemon() {
    }

    public Pokemon(String name, int HP, ArrayList<Skill> skills, int DEF, PokemonType type) {
        this.name = name;
        this.HP = HP;
        this.Max_HP = HP;
        this.skills.addAll(skills);
        this.DEF = DEF;
        this.level = 1;
        this.inParty = false;
        this.type = type;
    }

    public void checkDead() {
        this.isDead = true;
        this.HP = 0;
        System.out.println(name + "(이)가 기절했다.");
    }

    public void setInParty() {
        inParty = true;
    }

    public void setOutParty() {
        inParty = false;
    }

    public void printCharaInfo() {
        System.out.println("[" + name + "] name : " + level + " HP :" + HP + "/" + Max_HP + " Party : " + inParty);
    }

    public void attacked(int ack) {
        this.HP -= ack;
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

    public ArrayList<Skill> getSkills() {
        return skills;
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
