package bbangkeMonster.entity;

import static bbangkeMonster.data.PokemonSetting.superiorList;

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

    public void attacked(int ack) {
        this.HP -= ack;
    }

    public void attack(NpcUnit npc) {
        String superior = computeSuperior(type, npc.getType());
        if (superior.equals("user")) strongAttack(npc);
        else if (superior.equals("rival")) weakAttack(npc);
        else normalAttack(npc);
    }

    public void strongAttack(NpcUnit npc) {
        npc.minusHP(this.ACK);
        System.out.println(npc.name + "에게 " + ACK * 2 + "타격");
        System.out.println("효과는 굉장했다..!");
        if (npc.HP <= 0) {
            checkDead(npc);
        }
    }

    public void checkDead() {
        this.isDead = true;
        this.HP = 0;
        System.out.println(name + "(이)가 기절했다.");
    }

    public void weakAttack(NpcUnit npc) {
        npc.minusHP(this.ACK);
        System.out.println(npc.name + "에게 " + ACK / 2 + "타격");
        System.out.println("효과가 별로인 듯하다...");
        if (npc.HP <= 0) {
            checkDead(npc);
        }
    }

    public void normalAttack(NpcUnit npc) {
        npc.minusHP(this.ACK);
        System.out.println(npc.name + "에게 " + ACK + "타격");
        if (npc.HP <= 0) {
            checkDead(npc);
        }
    }

    public String computeSuperior(PokemonType myType, PokemonType rivalType) {
        String superior = "none";
        for (int i = 0; i < superiorList.size(); i++) {
            Superior superiorInfo = superiorList.get(i);
            if (myType == superiorInfo.getType()) {
                for (int j = 0; j < superiorInfo.getStrong().size(); j++) {
                    if (rivalType == superiorInfo.getStrong().get(j)) superior = "rival";
                }
                for (int j = 0; j < superiorInfo.getWeak().size(); j++) {
                    if (rivalType == superiorInfo.getWeak().get(j)) superior = "user";
                }
            }
        }
        return superior;
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
