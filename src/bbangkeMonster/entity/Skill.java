package bbangkeMonster.entity;

public class Skill {
    private String name;
    private int ack;

    public Skill(String name, int ack) {
        this.name = name;
        this.ack = ack;
    }

    public String getName() {
        return name;
    }

    public int getAck() {
        return ack;
    }

}
