package bbangkeMonster.data;

import bbangkeMonster.entity.FishNpcUnit;
import bbangkeMonster.entity.NpcUnit;
import bbangkeMonster.entity.PlantNpcUnit;
import bbangkeMonster.entity.TigerNpcUnit;

import java.util.Random;
import java.util.Vector;

public class BattleSetting {
    private static BattleSetting battleSetting = new BattleSetting();
    public static Vector<NpcUnit> currentNpcList;

    Random random = new Random();

    private BattleSetting() {
    }

    public static BattleSetting getInstance() {
        return battleSetting;
    }

    public void initBattle() {
        try {
            System.out.println("====[포켓몬 빵 사러 편의점 가는 길]====");
            System.out.println("...");
            System.out.println("...");
            Thread.sleep(1000);
            randomLine();
            initNpc();
            System.out.println("전투를 시작합니다.\n");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void randomLine() {
        String[] lines = {"\"포켓몬빵... 있나요?\"", "\"승자만이 뮤를 갖는다..\"", "\"제가.. 먼저 왔을 걸요?\""};
        System.out.println("야생의 포켓몬빵 헌터 조무래기가 나타났다..!");
        System.out.println(lines[random.nextInt(lines.length)]);
    }

    public void initNpc() {
        currentNpcList = new Vector<>();// 시작전 초기화
        int rNum = random.nextInt(4) + 1;// 1~4
        for (int i = 0; i < 2; i++) {
            int rNum2 = random.nextInt(3);
            if (rNum2 == 1) currentNpcList.add(new TigerNpcUnit());
            else if (rNum2 == 2) currentNpcList.add(new FishNpcUnit());
            else currentNpcList.add(new PlantNpcUnit());
        }
    }
}

