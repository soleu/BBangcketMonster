package bbangkeMonster.entity;

public class TigerNpcUnit extends NpcUnit {
    public TigerNpcUnit() {
        name = "가디";
        HP = 90;
        Max_HP = 90;
        ACK = 50;
        DEF = 70;
        type = PokemonType.FIRE;
    }

    @Override
    public void normalAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK);
        System.out.println(name + "의 불꽃 튀기기 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK + "타격");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }

    @Override
    public void weakAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK);
        System.out.println(name + "의 불꽃 세례 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK / 2 + "타격");
        System.out.println("효과가 별로인 듯하다...");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }

    @Override
    public void strongAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK);
        System.out.println(name + "의 불꽃 엄니 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK * 2 + "타격");
        System.out.println("효과는 굉장했다..!");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }
}
