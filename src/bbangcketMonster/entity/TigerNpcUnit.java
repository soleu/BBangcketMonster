package bbangcketMonster.entity;

import bbangcketMonster.PokemonType;

public class TigerNpcUnit extends NpcUnit {
	public TigerNpcUnit(){
		name="가디";
		HP=90;
		Max_HP=90;
		ACK=50;
		DEF=70;
		type= PokemonType.FIRE;
	}

	@Override
	public void normalAttack(Pokemon pokemon) {
		pokemon.getHP()-=ACK;
		System.out.println(pokemon.getName()+"에게 "+ACK+"타격");
		if(pokemon.getHP()<=0) {pokemon.isDead()=true; pokemon.getHP()=0;}
	}

	@Override
	public void weakAttack() {

	}

	@Override
	public void strongAttack() {

	}
}
