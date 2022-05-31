package bbangkeMonster.service;

import bbangkeMonster.entity.NpcUnit;
import bbangkeMonster.entity.Pokemon;
import bbangkeMonster.entity.PokemonType;
import bbangkeMonster.entity.Superior;

import static bbangkeMonster.data.PokemonSetting.superiorList;

public class NpcService {
    private static NpcService npcService;

    private NpcService() {
    }

    public static NpcService getInstance() {
        return npcService;
    }

    public void attack(NpcUnit npcUnit, Pokemon pokemon){
        String superior = computeSuperior(npcUnit.getType(),pokemon.getType());
    if(superior.equals("user")) npcUnit.strongAttack(pokemon);
    else if(superior.equals("rival")) npcUnit.weakAttack(pokemon);
    else npcUnit.normalAttack(pokemon);
    }

    public String computeSuperior(PokemonType myType, PokemonType rivalType) {
        String superior = "none";
        for (int i = 0; i < superiorList.size(); i++) {
            Superior superiorInfo = superiorList.get(i);
            if (myType == superiorInfo.getType()) {
                for (int j = 0; j < superiorInfo.getStrong().size(); j++) {
                    if (rivalType == superiorInfo.getStrong().get(j)) superior = "rival";
                }
                for (int j = 0; j < superiorInfo.getWeak().size(); j++) {
                    if (rivalType == superiorInfo.getWeak().get(j)) superior = "user";
                }
            }
        }
        return superior;
    }
}
