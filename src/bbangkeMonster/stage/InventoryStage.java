package bbangkeMonster.stage;

import bbangkeMonster.GuildManager;
import bbangkeMonster.entity.User;

public class InventoryStage implements Stage {
    User user = User.getuser();
    GuildManager guild = GuildManager.getInstance();

    @Override
    public void init() {
        // 모은 스티커 확인
        // 골드 확인
    }

    @Override
    public boolean update() {
        return false;
    }
}
