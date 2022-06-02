package bbangkeMonster.entity;

import java.util.ArrayList;
import java.util.Random;

import static bbangkeMonster.data.PokemonSetting.names;

public class Pokemon {
    private int no;
    private String name = "";
    private int HP;
    private int Max_HP;
    private ArrayList<Skill> skills = new ArrayList<>();
    private int DEF;
    private PokemonType type;
    private int level;
    private int exp;
    private boolean inParty;
    private boolean isDead = false;

    public Pokemon() {
    }

    public Pokemon(int no, String name, int HP, ArrayList<Skill> skills, int DEF, PokemonType type) {
        this.no = no;
        this.name = name;
        this.HP = HP;
        this.Max_HP = HP;
        this.skills.addAll(skills);
        this.DEF = DEF;
        this.level = 1;
        this.inParty = false;
        this.type = type;
        this.exp = 0;
    }

    public void checkDead() {
        this.isDead = true;
        this.HP = 0;
        System.out.println(name + "(이)가 기절했다.");
    }

    public void earnExpPoint() {
        Random rand = new Random();
        int num = rand.nextInt(3) + 1;//1~3
        this.exp += 50 / (level * 0.9 * num); //레벨마다 차등효과, 랜덤
        if (exp > 100) levelUp();
    }

    public void levelUp() {
        System.out.println(name + "의 상태가 이상하다...");
        if (level < 3) {
            name = names[level][no];
            System.out.println(name + "(으)로 " + "진화합니다.");
        }
        level++;
        exp = 0;
        System.out.println(name + "(이)가 새로운 스킬을 배웠습니다.");
    }

    public void rebirth() {
        this.HP = Max_HP;
        this.isDead = false;
    }

    public void setInParty() {
        inParty = true;
    }

    public void setOutParty() {
        inParty = false;
    }

    public void printCharaInfo() {
        System.out.println("[" + name + "] level : " + level + " HP :" + HP + "/" + Max_HP + " type [" + type.name() + "]");
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
