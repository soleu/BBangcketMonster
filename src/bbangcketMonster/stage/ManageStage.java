

package bbangcketMonster.stage;

import bbangcketMonster.GameManager;
import bbangcketMonster.Guild;

public class ManageStage implements Stage {
    GameManager gm = GameManager.getInstance();
    Guild guild = Guild.getInstance();

    @Override
    public void init() {
        System.out.println("====[포켓몬 관리]====");
        System.out.println("[1] 길드원 확인\t [2] 길드원 추가\t[3] 길드원 삭제\t");
        System.out.println("[4] 뒤로 가기\t");
    }

    @Override
    public boolean update() {
        while (true) {
            int choice = gm.scan.nextInt();
            if (choice == 1) {
                guild.memberList();
            } else if (choice == 2) {
                guild.addMember();
            } else if (choice == 3) {
                guild.deleteMember();
            } else if (choice == 4) {
                break;
            }
        }
        return true;
    }
}