package bbangcketMonster.entity;

import bbangcketMonster.PokemonType;

public class PlantNpcUnit extends NpcUnit {
    public PlantNpcUnit() {
        name = "모다피";
        HP = 90;
        Max_HP = 90;
        ACK = 50;
        DEF = 70;
        type = PokemonType.GRASS;
    }

    @Override
    void normalAttack(Pokemon cha) {

    }

    @Override
    void weakAttack() {

    }

    @Override
    void strongAttack() {

    }
}
