package bbangkeMonster.stage;

import bbangkeMonster.GameManager;
import bbangkeMonster.data.StickerSetting;
import bbangkeMonster.entity.Sticker;
import bbangkeMonster.entity.User;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryStage implements Stage {
    User user = User.getUser();
    StickerSetting stickerSetting = new StickerSetting();
    GameManager gm = GameManager.getInstance();

    @Override
    public void init() {
        System.out.println("====[인벤토리]====");
        System.out.println("= 모은 스티커 확인 =");
    }

    @Override
    public boolean update() {
        int[] userSticker = user.getStickers();
        ArrayList<Sticker> stickers = stickerSetting.stickers;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < stickers.size(); i++) {
            Sticker sticker = stickers.get(i);
            if (userSticker[i] != 0) {
                System.out.println("no." + sticker.getNo() + " name: " + sticker.getName() + " " + userSticker[i] + "장");
            } else {
                System.out.println("no." + sticker.getNo() + " name: ???");
            }
        }
        while (true) {
            System.out.println("no.를 입력하면 포켓몬 이미지를 볼 수 있습니다.");
            System.out.println("뒤로가기 : 0 입력");
            int num = sc.nextInt();
            if (num == 0) break;
            else {
                stickers.get(num - 1).printImage();
            }
        }
        gm.nextStageName = "LOBBY";
        return true;
    }
}
