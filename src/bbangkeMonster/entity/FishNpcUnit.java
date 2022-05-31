package bbangkeMonster.entity;

public class FishNpcUnit extends NpcUnit {
    public FishNpcUnit() {
        name = "쏘드라";
        HP = 100;
        Max_HP = 100;
        ACK = 30;
        DEF = 50;
        type = PokemonType.WATER;
    }

    @Override
    public void normalAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK);
        System.out.println(name + "의 물대포 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK + "타격");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }

    @Override
    public void weakAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK / 2);
        System.out.println(name + "의 거품광선 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK / 2 + "타격");
        System.out.println("효과가 별로인 듯하다...");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }

    @Override
    public void strongAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK * 2);
        System.out.println(name + "의 하이드로펌프 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK * 2 + "타격");
        System.out.println("효과는 굉장했다..!");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }
}

