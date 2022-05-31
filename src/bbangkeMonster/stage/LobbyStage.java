package bbangkeMonster.stage;


import bbangkeMonster.GameManager;

public class LobbyStage implements Stage {
    final GameManager gm = GameManager.getInstance();

    @Override
    public void init() {
        System.out.println("====[메인]====");
        System.out.println("[1]포켓몬 빵 사러가기 [2] 포켓몬 관리 [3] 인벤토리 확인 [4] 끝내기 ");
    }

    @Override
    public boolean update() {
        int choice = gm.scan.nextInt();
        if (choice == 1) {
            gm.nextStageName = "BATTLE";
        } else if (choice == 2) {
            gm.nextStageName = "MANAGE";
        } else if (choice == 3) {
            gm.nextStageName = "INVENTORY";
        } else if (choice == 4) {
            gm.nextStageName = "";
        }
        return true;
    }
}