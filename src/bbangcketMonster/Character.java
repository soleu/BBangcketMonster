package bbangcketMonster;

public class Character {
    String name = "";
    int level;
    int HP;
    int Max_HP;
    int ACK;
    int DEF;
    PocketmonType type;
    boolean inParty;
    String weapon;//
    String armor;//
    String ring;//
    boolean isDead = false;

    Character() {

    }

    Character(String name, int HP, int ACK, int DEF, PocketmonType type) {
        this.name = name;
        this.HP = HP;
        this.Max_HP = HP;
        this.ACK = ACK;
        this.DEF = DEF;
        this.level = 1;
        this.inParty = false;
        this.type = type;
        this.weapon = "";
        this.armor = "";
        this.ring = "";
    }

    void setInParty() {
        inParty = true;
    }

    void setOutParty() {
        inParty = false;
    }

    void printCharaInfo() {
        System.out.println("[" + name + "] name : " + level + " HP :" + HP + "/" + Max_HP + " ACK:" + ACK + " DEF :" + DEF + " Party : " + inParty);
    }

    void attack(RivalUnit monster) {
        monster.HP -= ACK;
        System.out.println(monster.name + "에게 " + ACK + "타격");
        if (monster.HP <= 0) {
            monster.isDead = true;
            monster.HP = 0;
        }
    }
}
