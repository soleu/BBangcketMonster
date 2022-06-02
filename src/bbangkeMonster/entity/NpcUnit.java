package bbangkeMonster.entity;

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

    public abstract void normalAttack(Pokemon cha);

    public abstract void weakAttack(Pokemon pokemon);

    public abstract void strongAttack(Pokemon pokemon);

    public void minusHP(int ackPoint) {
        this.HP -= ackPoint;
    }

    public void setHP(int ackPoint) {
        this.HP = 0;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

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
        System.out.println("[" + name + "] HP :" + HP + "/" + Max_HP + " type [" + type.name() + "]");
    }

    public void checkDead() {
        setDead(true);
        setHP(0);
        System.out.println(name + "(이)가 기절했다.");
    }
}
