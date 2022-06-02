package bbangkeMonster.service;

import bbangkeMonster.entity.NpcUnit;
import bbangkeMonster.entity.Pokemon;
import bbangkeMonster.entity.PokemonType;
import bbangkeMonster.entity.Skill;
import bbangkeMonster.entity.Superior;

import static bbangkeMonster.data.PokemonSetting.superiorList;

public class PokemonService {
    private static PokemonService pokemonService = new PokemonService();

    private PokemonService() {
    }

    public static PokemonService getInstance() {
        return pokemonService;
    }

    public void showSkills(Pokemon pokemon) {
        System.out.println("[1] " + pokemon.getSkills().get(0).getName());
        System.out.println("[2] " + pokemon.getSkills().get(1).getName());
        if (pokemon.getLevel() == 2) {
            System.out.println("[3] " + pokemon.getSkills().get(2).getName());
        } else if (pokemon.getLevel() > 3) {
            System.out.println("[4] " + pokemon.getSkills().get(3).getName());
        } else {
        }
    }

    public void earnExp(Pokemon pokemon) {
        if (!pokemon.isDead()) pokemon.earnExpPoint();
        else pokemon.rebirth();
    }

    public void attack(Pokemon pokemon, NpcUnit npc, int choice) {
        String superior = computeSuperior(pokemon.getType(), npc.getType());
        if (superior.equals("user")) strongAttack(pokemon, npc, choice);
        else if (superior.equals("rival")) weakAttack(pokemon, npc, choice);
        else normalAttack(pokemon, npc, choice);
    }

    public void strongAttack(Pokemon pokemon, NpcUnit npc, int choice) {
        if (choice > 4) System.out.println("[공격 실패] 숫자를 잘못 입력하셨습니다.");

        Skill skill = pokemon.getSkills().get(choice);
        System.out.println(pokemon.getName() + "의 " + skill.getName() + " 공격!");
        npc.minusHP(skill.getAck() * 2);
        System.out.println(npc.getName() + "에게 " + skill.getAck() * 2 + " 타격");
        System.out.println("효과는 굉장했다..!");
        if (npc.getHP() <= 0) {
            npc.checkDead();
        }
    }

    public void weakAttack(Pokemon pokemon, NpcUnit npc, int choice) {
        if (choice > 4) System.out.println("[공격 실패] 숫자를 잘못 입력하셨습니다.");

        Skill skill = pokemon.getSkills().get(choice);
        System.out.println(pokemon.getName() + "의 " + skill.getName() + " 공격!");
        npc.minusHP(skill.getAck() / 2);
        System.out.println(npc.getName() + "에게 " + skill.getAck() / 2 + " 타격");
        System.out.println("효과가 별로인 듯하다...");
        if (npc.getHP() <= 0) {
            npc.checkDead();
        }
    }

    public void normalAttack(Pokemon pokemon, NpcUnit npc, int choice) {
        if (choice > 4) System.out.println("[공격 실패] 숫자를 잘못 입력하셨습니다.");

        Skill skill = pokemon.getSkills().get(choice);
        System.out.println(pokemon.getName() + "의 " + skill.getName() + " 공격!");
        npc.minusHP(skill.getAck());
        System.out.println(npc.getName() + "에게 " + skill.getAck() + " 타격");
        if (npc.getHP() <= 0) {
            npc.checkDead();
        }
    }

    public String computeSuperior(PokemonType myType, PokemonType rivalType) {
        String superior = "none";
        for (int i = 0; i < superiorList.size(); i++) {
            Superior superiorInfo = superiorList.get(i);
            if (myType == superiorInfo.getType()) {
                for (int j = 0; j < superiorInfo.getStrong().size(); j++) {
                    if (rivalType == superiorInfo.getStrong().get(j)) superior = "user";
                }
                for (int j = 0; j < superiorInfo.getWeak().size(); j++) {
                    if (rivalType == superiorInfo.getWeak().get(j)) superior = "rival";
                }
            }
        }
        return superior;
    }
}
