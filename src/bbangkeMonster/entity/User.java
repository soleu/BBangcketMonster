package bbangkeMonster.entity;

//인벤토리, 골드 담당

public class User {
    private User() {
    }

    private static User user = new User();

    public static User getuser() {
        return user;
    }

    int money = 50000;// 기본급
    // 인벤
//    Vector<Item> Total_Inven = new Vector<>();
//
//    Map<Item, String> Total_map = new HashMap<Item, String>();// 카테고리 매치
//    Map<Item, String> chara_map = new HashMap<Item, String>();// 캐릭터와 매치

    void init() {

    }


}