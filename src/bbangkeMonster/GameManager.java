package bbangkeMonster;

import bbangkeMonster.stage.BattleStage;
import bbangkeMonster.stage.InventoryStage;
import bbangkeMonster.stage.LobbyStage;
import bbangkeMonster.stage.ManageStage;
import bbangkeMonster.stage.Stage;
import bbangkeMonster.stage.TitleStage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
    //singleton
    private static GameManager gameManager;

    private GameManager() {
    }

    public static GameManager getInstance() {
        return gameManager;
    }

    public Scanner scan = new Scanner(System.in);
    Map<String, Stage> StageList = new HashMap<String, Stage>();

    public static String curStageName = "";
    public static String nextStageName = "";

    public void init() {
//        guildM.guild.initMember();
        StageList.put("TITLE", new TitleStage());
        StageList.put("LOBBY", new LobbyStage());
        StageList.put("BATTLE", new BattleStage());
        StageList.put("MANAGE", new ManageStage());
        StageList.put("INVENTORY", new InventoryStage());

        nextStageName = "TITLE";
    }

    public void update() {
        boolean run = true;
        while (run) {
            if (curStageName.equals(nextStageName)) {
                run = false;
            }
            if (nextStageName.equals("")) {
                System.out.println("시스템을 종료합니다.");
                run = false;
                return;
            }

            curStageName = nextStageName;
            Stage curStage = StageList.get(curStageName);

            curStage.init();
            while (true) {
                if (curStage.update()) {
                    break;
                }
            }
            run = true;
        }
    }

    void run() {
        init();
        update();
    }
}
