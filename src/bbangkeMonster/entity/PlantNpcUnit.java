package bbangkeMonster.entity;

public class PlantNpcUnit extends NpcUnit {
    public PlantNpcUnit() {
        name = "모다피";
        HP = 150;
        Max_HP = 150;
        ACK = 50;
        DEF = 70;
        type = PokemonType.GRASS;
    }

    @Override
    public void normalAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK);
        System.out.println("\n" + name + "의 잎날가르기 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK + " 타격");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }

    @Override
    public void weakAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK / 2);
        System.out.println("\n" + name + "의 덩굴채찍 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK / 2 + " 타격");
        System.out.println("효과가 별로인 듯하다...");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }

    @Override
    public void strongAttack(Pokemon pokemon) {
        pokemon.attacked(this.ACK * 2);
        System.out.println("\n" + name + "의 에너지볼 공격..!");
        System.out.println(pokemon.getName() + "에게 " + ACK * 2 + " 타격");
        System.out.println("효과는 굉장했다..!");
        if (pokemon.getHP() <= 0) {
            pokemon.checkDead();
        }
    }
}
