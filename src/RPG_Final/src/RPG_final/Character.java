package RPG_Final.src.RPG_final;

public class Character {
	String name = "";//
	int level;//
	int HP;//
	int Max_HP;//
	int ACK;//
	int DEF;//
	boolean inParty;//
	String weapon;//
	String armor;//
	String ring;//
	boolean isDead=false;

	Character(){
		
	}
	Character(String name, int HP, int ACK, int DEF) {
		this.name = name;
		this.HP = HP;
		this.Max_HP = HP;
		this.ACK = ACK;
		this.DEF = DEF;
		this.level = 1;
		this.inParty = false;
		this.weapon = "";
		this.armor = "";
		this.ring = "";
	}
	Character(Character cha){
		this.name=cha.name;
		this.HP=cha.HP;
		this.Max_HP=cha.Max_HP;
		this.ACK=cha.ACK;
		this.DEF=cha.DEF;
		this.level=cha.level;
		this.inParty=cha.inParty;
		this.weapon=cha.weapon;
		this.armor=cha.armor;
		this.ring=cha.ring;
	}

	void setInParty() {
		inParty = true;
	}

	void setOutParty() {
		inParty = false;
	}
	
	void printCharaInfo(){
		System.out.println("["+name+"] name : "+level+" HP :"+HP+"/"+Max_HP+" ACK:"+ACK+" DEF :"+DEF+" Party : "+inParty);
	}
	
	void attack(Unit monster) {
		monster.HP-=ACK;
		System.out.println(monster.name+"에게 "+ACK+"타격");
		if(monster.HP<=0) {monster.isDead=true; monster.HP=0;}
	}
}
