package bbangkeMonster.data;

import bbangkeMonster.GuildManager;
import bbangkeMonster.entity.PlantNpcUnit;
import bbangkeMonster.entity.TigerNpcUnit;
import bbangkeMonster.entity.FishNpcUnit;
import bbangkeMonster.entity.NpcUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class BattleSetting {
    private static BattleSetting battleSetting;
    private Map<Integer, NpcUnit> npcList = new HashMap<Integer, NpcUnit>();
    public static Vector<NpcUnit> currentNpcList;
    GuildManager guild = GuildManager.getInstance();

    Random random = new Random();

    private BattleSetting() {
    }

    public static BattleSetting getInstance() {
        return battleSetting;
    }

    public void initBattle() {
        System.out.println("====[포켓몬 빵 사러 편의점 가는 길]====");
        System.out.println("...");
        System.out.println("...");
        randomLine();
        initNpc();
        initPlayer();
        System.out.println("전투를 시작합니다.");
    }

    public void randomLine() {
        String[] lines = {"포켓몬빵... 있나요?", "승자만이 뮤를 갖는다..", "제가.. 먼저 왔을 걸요?"};
        System.out.println("야생의 포켓몬빵 헌터 조무래기가 나타났다..!");
        System.out.println(lines[random.nextInt(lines.length)]);
    }

    public void initNpc() {
        npcList.put(0, new TigerNpcUnit());
        npcList.put(1, new FishNpcUnit());
        npcList.put(2, new PlantNpcUnit());

        randomNpc();
    }

    public void randomNpc() {
        currentNpcList = new Vector<>();// 시작전 초기화
        int rNum = random.nextInt(3) + 1;// 1~3
        for (int i = 0; i < rNum; i++) {
            int rNum2 = random.nextInt(npcList.size());
            currentNpcList.add(npcList.get(rNum2));
        }
    }

    public void initPlayer() {
        guild.initMember();
    }

}

