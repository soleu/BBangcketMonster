package bbangcketMonster.entity;

public class EggNpcUnit extends NpcUnit {
	public EggNpcUnit(){
		name="아라리";
		HP=90;
		Max_HP=90;
		ACK=50;
		DEF=70;
	}

	@Override
	public void normalAttack(Character cha) {
		cha.HP-=ACK;
		System.out.println(cha.name+"에게 "+ACK+"타격");
		if(cha.HP<=0) {cha.isDead=true; cha.HP=0;}
	}

	@Override
	public void weakAttack() {

	}

	@Override
	public void strongAttack() {

	}
}
