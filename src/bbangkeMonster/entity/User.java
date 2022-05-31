package bbangkeMonster.entity;

//인벤토리, 골드 담당

public class User {
    private User() {
    }

    private static User user = new User();

    public static User getUser() {
        return user;
    }

    private int[] stickers = new int[10];

    public void initUser() {
        for (int i = 0; i < stickers.length; i++) {
            stickers[i] = 0;
        }
    }

    public void earnSticker(Sticker sticker) {
        stickers[sticker.no - 1]++;
    }

    public int[] getStickers() {
        return stickers;
    }
}