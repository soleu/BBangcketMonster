package bbangkeMonster.data;

import bbangkeMonster.entity.Pokemon;
import bbangkeMonster.entity.PokemonType;
import bbangkeMonster.entity.Skill;
import bbangkeMonster.entity.Superior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PokemonSetting {

    private static PokemonSetting cm = new PokemonSetting();

    private PokemonSetting() {
    }

    public static PokemonSetting getCm() {
        return cm;
    }

    private Map<Integer, String> noname = new HashMap<Integer, String>();
    public static Vector<Pokemon> allPokemon = new Vector<>();
    public static List<Superior> superiorList = new ArrayList<>();

    public void initPokemon() {
        String[][] names = {
                {"피츄", "이상해씨", "파이리", "구구", "모다피", "꼬부기", "캐터피", "고오스", "야돈", "캐이시"},
                {"피카츄", "이상해풀", "리자드", "피죤", "우츠동", "어니부기", "단데기", "고우스트", "야도란", "윤겔라"},
                {"라이츄", "이상해꽃", "리자몽", "피죤투", "우츠보트", "거북왕", "버터풀", "팬텀", "야도킹", "후딘"}};

        PokemonType[] type = {PokemonType.ELECTR, PokemonType.GRASS, PokemonType.FIRE, PokemonType.FLYING, PokemonType.GRASS, PokemonType.WATER, PokemonType.BUG,
                PokemonType.GHOST, PokemonType.PSYCHC, PokemonType.PSYCHC};

        int[] HP = {100, 120, 80, 85, 90, 110, 130, 105, 70, 80};
        ArrayList<Skill>[] skillList = initSkillList();
        int[] DEF = {30, 35, 25, 20, 36, 56, 36, 27, 58, 60};
        for (int i = 0; i < 10; i++) {
            allPokemon.add(new Pokemon(names[0][i], HP[i], skillList[i], DEF[i], type[i]));
            noname.put(i, names[0][i]);
        }
    }

    public ArrayList<Skill>[] initSkillList() {
        ArrayList<Skill>[] skillList = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            skillList[i] = new ArrayList<Skill>();
        }
        //피카츄
        skillList[0].add(new Skill("전기쇼크", 30));
        skillList[0].add(new Skill("일렉트릭볼", 40));
        skillList[0].add(new Skill("10만 볼트", 50));
        skillList[0].add(new Skill("100만 볼트", 60));
        //이상해풀
        skillList[1].add(new Skill("꽃보라", 30));
        skillList[1].add(new Skill("덩굴채찍", 40));
        skillList[1].add(new Skill("잎날가르기", 55));
        skillList[1].add(new Skill("솔라빔", 60));
        //리자드
        skillList[2].add(new Skill("불꽃 세례", 30));
        skillList[2].add(new Skill("화염 방사", 35));
        skillList[2].add(new Skill("회오리 불꽃", 50));
        skillList[2].add(new Skill("플레어드라이브", 80));
        //구구
        skillList[3].add(new Skill("바람일으키기", 40));
        skillList[3].add(new Skill("날개치기", 46));
        skillList[3].add(new Skill("제비반환", 50));
        skillList[3].add(new Skill("폭풍", 60));
        //모다피
        skillList[4].add(new Skill("덩굴 채찍", 35));
        skillList[4].add(new Skill("저리 가루", 40));
        skillList[4].add(new Skill("잎날 가르기", 50));
        skillList[4].add(new Skill("독 찌르기", 70));
        //꼬부기
        skillList[5].add(new Skill("물대포", 30));
        skillList[5].add(new Skill("물의 파동", 50));
        skillList[5].add(new Skill("아쿠아테일", 55));
        skillList[5].add(new Skill("하이드로펌프", 60));
        //캐터피
        skillList[6].add(new Skill("벌레먹음", 30));
        skillList[6].add(new Skill("실뿜기", 40));
        skillList[6].add(new Skill("에어슬래시", 50));
        skillList[6].add(new Skill("벌레의 야단법석", 90));
        //고오스
        skillList[7].add(new Skill("핥기", 30));
        skillList[7].add(new Skill("병상첨병", 50));
        skillList[7].add(new Skill("섀도볼", 60));
        skillList[7].add(new Skill("꿈먹기", 67));
        //야돈
        skillList[8].add(new Skill("물대포", 40));
        skillList[8].add(new Skill("염동력", 45));
        skillList[8].add(new Skill("사념의 박치기", 50));
        skillList[8].add(new Skill("사이코키네시스", 70));
        //케이시
        skillList[9].add(new Skill("염동력", 30));
        skillList[9].add(new Skill("환상빔", 50));
        skillList[9].add(new Skill("사이코쇼크", 60));
        skillList[9].add(new Skill("사이코키네시스", 70));

        return skillList;
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
