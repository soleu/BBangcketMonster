package RPG_Final.src.RPG_final;

public class Zombie_Unit extends Unit {
	Zombie_Unit(){
		name="Zombie";
		HP=90;
		Max_HP=90;
		ACK=50;
		DEF=70;
	}
	
	@Override
	void attack(Character cha) {
		cha.HP-=ACK;
		System.out.println(cha.name+"에게 "+ACK+"타격");
		if(cha.HP<=0) {cha.isDead=true; cha.HP=0;}
	}

	@Override
	void critialAttck() {
		// TODO Auto-generated method stub
		
	}

}
