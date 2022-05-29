package bbangcketMonster.entity;

public abstract class NpcUnit {
	String name;
	int ACK;
	int DEF;
	int HP;
	int Max_HP;
	boolean isDead=false;
	
	NpcUnit() {
		name = "";
		ACK = 10;
		DEF = 10;
		HP = 50;
		Max_HP = 50;
	}

	abstract void normalAttack(Character cha);

	abstract void weakAttack();

	abstract  void strongAttack();

	void printUnit() {
		System.out.println("[" + name + "] HP : " + HP + "/" + Max_HP + " ACK : " + ACK + " DEF: " + DEF);
	}
}
