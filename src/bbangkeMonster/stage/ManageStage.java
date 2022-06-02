package bbangkeMonster.stage;

import bbangkeMonster.GameManager;
import bbangkeMonster.GuildManager;

public class ManageStage implements Stage {
    GameManager gm = GameManager.getInstance();
    GuildManager guild = GuildManager.getInstance();

    @Override
    public void init() {
    }

    public void showMenu() {
        System.out.println("====[포켓몬 관리]====");
        System.out.println("[1] 포켓몬 확인\t [2] 포켓몬 뽑기\t[3] 포켓몬 퇴출\t");
        System.out.println("[4] 소지한 포켓몬 교체\t [5] 포켓몬 정렬\t [6] 뒤로가기\t");

    }

    @Override
    public boolean update() {
        while (true) {
            showMenu();
            int choice = gm.scan.nextInt();
            if (choice == 1) {
                guild.memberList();
            } else if (choice == 2) {
                guild.addMember();
            } else if (choice == 3) {
                guild.deleteMember();
            } else if (choice == 4) {
                guild.switchMember();
            } else if (choice == 5) {
                guild.arrayMember();
            } else if (choice == 6) {
                break;
            }
        }
        gm.nextStageName = "LOBBY";
        return true;
    }
}