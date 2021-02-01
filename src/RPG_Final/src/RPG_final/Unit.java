package RPG_Final.src.RPG_final;

public abstract class Unit {
	String name;
	int ACK;
	int DEF;
	int HP;
	int Max_HP;
	boolean isDead=false;
	
	Unit() {
		name = "";
		ACK = 10;
		DEF = 10;
		HP = 50;
		Max_HP = 50;
	}

	abstract void attack(Character cha);

	abstract void critialAttck();

	void printUnit() {
		System.out.println("[" + name + "] HP : " + HP + "/" + Max_HP + " ACK : " + ACK + " DEF: " + DEF);
	}
}
