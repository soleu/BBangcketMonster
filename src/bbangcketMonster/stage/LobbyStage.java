package bbangcketMonster.stage;


import bbangcketMonster.GameManager;

public class LobbyStage extends Stage {
    final GameManager gm = GameManager.getInstance();

    @Override
    void init() {
        System.out.println("====[Lobby]====");
        System.out.println("[1]포켓몬 빵 사러가기 [2] 인벤토리/포켓몬 관리  [3] 아이템샵 [4] 끝내기");
    }

    @Override
    boolean update() {
        int choice = gm.scan.nextInt();
        if (choice == 1) {
            gm.nextStageName = "BATTLE";
        } else if (choice == 2) {
           gm.nextStageName = "SETTING";
        } else if (choice == 3) {
            gm.nextStageName = "SHOP";
        } else if (choice == 4) {
            gm.nextStageName = "";
        }
        return true;
    }

}
