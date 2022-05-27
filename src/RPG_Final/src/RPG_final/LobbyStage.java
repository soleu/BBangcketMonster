package RPG_Final.src.RPG_final;

public class LobbyStage extends Stage {

    @Override
    void init() {
        System.out.println("====[Lobby]====");
        System.out.println("[1]Battle [2]Setting [3]Quit");
    }

    @Override
    boolean update() {
        int choice = GameManager.gm.scan.nextInt();
        if (choice == 1) {
            GameManager.gm.nextStageName = "BATTLE";
        } else if (choice == 2) {
            GameManager.gm.nextStageName = "SETTING";
        } else if (choice == 3) {
            GameManager.gm.nextStageName = "";
        }
        return true;
    }

}
