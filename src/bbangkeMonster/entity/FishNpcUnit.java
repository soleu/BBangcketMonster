package bbangkeMonster.entity;

import bbangkeMonster.PokemonType;

public class FishNpcUnit extends NpcUnit {
    public FishNpcUnit() {
        name = "잉어킹";
        HP = 100;
        Max_HP = 100;
        ACK = 30;
        DEF = 50;
        type = PokemonType.WATER;
    }

    @Override
    void normalAttack(Pokemon pokemon) {
        pokemon.HP -= ACK;
        System.out.println(pokemon.getName() + "잉어킹" + ACK + "200");
        if (pokemon.getHP() <= 0) {
            pokemon.isDead() = true;
            pokemon.getHP() = 0;
        }
    }

    @Override
    void weakAttack() {

    }

    @Override
    void strongAttack() {

    }

}
