package bbangkeMonster.data;

import bbangkeMonster.entity.PokemonType;
import bbangkeMonster.entity.Superior;
import bbangkeMonster.entity.Pokemon;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PokemonSetting {

    private static PokemonSetting cm = new PokemonSetting();
    public static PokemonSetting getCm() {
        return cm;
    }

    private Map<Integer, String> noname = new HashMap<Integer, String>();
    private Vector<Pokemon> allPokemon = new Vector<>();
    public static List<Superior> superiorList;

    public void initPokemon() {
        String[][] names = {
                {"피츄", "이상해씨", "파이리", "구구", "모다피", "꼬부기", "캐터피", "고오스", "야돈", "캐이시"},
                {"피카츄", "이상해풀", "리자드", "피죤", "우츠동", "어니부기", "단데기", "고우스트", "야도란", "윤겔라"},
                {"라이츄", "이상해꽃", "리자몽", "피죤투", "우츠보트", "거북왕", "버터풀", "팬텀", "야도킹", "후딘"}};

        PokemonType[] type = {PokemonType.ELECTR, PokemonType.GRASS, PokemonType.FIRE, PokemonType.FLYING, PokemonType.GRASS, PokemonType.WATER, PokemonType.BUG,
                PokemonType.GHOST, PokemonType.PSYCHC, PokemonType.PSYCHC};

        int[] HP = {100, 120, 80, 85, 90, 110, 130, 105, 70, 80};
        int[] ACK = {30, 20, 35, 35, 38, 25, 23, 25, 40, 30};
        int[] DEF = {30, 35, 25, 20, 36, 56, 36, 27, 58, 60};

        for (int i = 0; i < names.length; i++) {
            allPokemon.add(new Pokemon(names[i][0], HP[i], ACK[i], DEF[i], type[i]));
            noname.put(i, names[i][0]);
        }
    }

    public void initSuperior() {
        superiorList.add(new Superior(PokemonType.WATER, List.of(PokemonType.ROCK, PokemonType.FIRE), List.of(PokemonType.WATER, PokemonType.GRASS)));
        superiorList.add(new Superior(PokemonType.FIRE, List.of(PokemonType.BUG, PokemonType.GRASS), List.of(PokemonType.ROCK, PokemonType.WATER)));
        superiorList.add(new Superior(PokemonType.GRASS, List.of(PokemonType.ROCK, PokemonType.WATER), List.of(PokemonType.BUG, PokemonType.FIRE)));
        superiorList.add(new Superior(PokemonType.FLYING, List.of(PokemonType.ROCK, PokemonType.ELECTR), List.of(PokemonType.BUG, PokemonType.GRASS)));
        superiorList.add(new Superior(PokemonType.PSYCHC, Collections.emptyList(), List.of(PokemonType.BUG, PokemonType.GHOST)));
        superiorList.add(new Superior(PokemonType.ELECTR, List.of(PokemonType.FLYING, PokemonType.WATER), List.of(PokemonType.GRASS, PokemonType.ELECTR)));
        superiorList.add(new Superior(PokemonType.ROCK, List.of(PokemonType.FLYING, PokemonType.FIRE), Collections.emptyList()));
        superiorList.add(new Superior(PokemonType.GHOST, List.of(PokemonType.GHOST, PokemonType.PSYCHC), Collections.emptyList()));
        superiorList.add(new Superior(PokemonType.BUG, List.of(PokemonType.GRASS, PokemonType.PSYCHC), List.of(PokemonType.FLYING, PokemonType.FIRE)));
    }

    public Map<Integer, String> getNoname() {
        return noname;
    }

    public Vector<Pokemon> getAllPokemon() {
        return allPokemon;
    }
}
