package bbangcketMonster;

import bbangcketMonster.stage.BattleStage;
import bbangcketMonster.stage.LobbyStage;
import bbangcketMonster.stage.ShopStage;
import bbangcketMonster.stage.ShopStageTemp;
import bbangcketMonster.stage.Stage;
import bbangcketMonster.stage.TitleStage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
    public Random ran = new Random();
    Map<String, Stage> StageList = new HashMap<String, Stage>();
    GuildManager guildM = GuildManager.getGuildM();

    public static String curStageName = "";
    public static String nextStageName = "";

    public void init() {
        guildM.guild.initMember();
        StageList.put("TITLE", new TitleStage());
        StageList.put("LOBBY", new LobbyStage());
        StageList.put("SETTING", new SettingStage());
        StageList.put("BATTLE", new BattleStage());
        StageList.put("SHOP", new ShopStage());

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
