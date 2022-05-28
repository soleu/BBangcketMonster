package bbangcketMonster;

public class Ork_Rival_Unit extends RivalUnit {
	Ork_Rival_Unit(){
		name="Ork";
		HP=100;
		Max_HP=100;
		ACK=30;
		DEF=50;
	}
	@Override
	void attack(Character cha) {
		cha.HP-=ACK;
		System.out.println(cha.name+"�� "+ACK+"Ÿ��");
		if(cha.HP<=0) {cha.isDead=true; cha.HP=0;}
	}

	@Override
	void critialAttck() {
		// TODO Auto-generated method stub
		
	}

}
