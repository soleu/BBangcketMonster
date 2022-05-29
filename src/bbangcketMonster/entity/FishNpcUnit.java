package bbangcketMonster.entity;

public class FishNpcUnit extends NpcUnit {
	public FishNpcUnit(){
		name="Ork";
		HP=100;
		Max_HP=100;
		ACK=30;
		DEF=50;
	}

	@Override
	void normalAttack(Character cha) {
		cha.HP-=ACK;
		System.out.println(cha.name+"잉어킹"+ACK+"200");
		if(cha.HP<=0) {cha.isDead=true; cha.HP=0;}
	}

	@Override
	void weakAttack() {

	}

	@Override
	void strongAttack() {

	}

}
