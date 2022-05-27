package RPG_Final.src.RPG_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CharacterManager {

    private static CharacterManager cm = new CharacterManager();

    public static CharacterManager getCm() {
        return cm;
    }

    Map<Integer, String> noname = new HashMap<Integer, String>();

    Vector<Character> allCharacter = new Vector<>();

    void init() {
        String[][] names = {
                {"피츄", "이상해씨", "파이리", "구구", "모다피", "꼬부기", "캐터피", "고오스", "야돈", "캐이시"},
                {"피카츄", "이상해풀", "리자드", "피죤", "우츠동", "어니부기", "단데기", "고우스트", "야도란", "윤겔라"},
                {"라이츄", "이상해꽃", "리자몽", "피죤투", "우츠보트", "거북왕", "버터풀", "팬텀", "야도킹", "후딘"}};
        PocketmonType[] type = {PocketmonType.ELECTR, PocketmonType.GRASS, PocketmonType.FIRE, PocketmonType.FLYING, PocketmonType.GRASS, PocketmonType.WATER, PocketmonType.BUG,
                PocketmonType.GHOST, PocketmonType.PSYCHC, PocketmonType.PSYCHC};
        int[] HP = {100, 120, 80, 85, 90, 110, 130, 105, 70};
        int[] ACK = {30, 20, 35, 35, 38, 25, 23, 25, 40};
        int[] DEF = {30, 35, 25, 20, 36, 56, 36, 27, 58};
        int[] LEV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < names.length; i++) {
            allCharacter.add(new Character(names[i][0], HP[i], ACK[i], DEF[i]));
            noname.put(i, names[i][0]);
        }
    }

    // 레벨업 상황 생각하기


}
