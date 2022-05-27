package RPG_Final.src.RPG_final;

import java.util.Scanner;
import java.util.Vector;

public class Shop {
    private Shop() {
    }

    ;

    private static Shop shop = new Shop();

    public static Shop getShop() {
        return shop;
    }

    Scanner scan = new Scanner(System.in);
    User user = User.getuser();

    Vector<Item> WeaponList = new Vector<>();
    Vector<Item> ArmorList = new Vector<>();
    Vector<Item> RingList = new Vector<>();

    void init() {
        String[] names = {"나무 검", "돌 검", "강철 검", "돌 갑옷", "철 갑옷", "다이아 갑옷", "나무 반지", "금 반지", "에메랄드 반지"};
        int[] prices = {5000, 10000, 20000, 7000, 12000, 30000, 10000, 13000, 50000};
        int[] stats = {10, 15, 30, 15, 20, 50, 10, 20, 40};
        for (int i = 0; i < names.length; i++) {
            if (i < 3) {
                WeaponList.add(new Item(names[i], prices[i], stats[i]));
            } else if (i < 6) {
                ArmorList.add(new Item(names[i], prices[i], stats[i]));
            } else {
                RingList.add(new Item(names[i], prices[i], stats[i]));
            }
        }
    }

    void run() {
        init();
        while (true) {
            System.out.println("=== [SHOP] ===");
            System.out.println("[1]무기 [2]갑옷 [3]반지 [4]뒤로가기");
            int choice = scan.nextInt();
            if (choice == 1) {
                weaponMenu();
            } else if (choice == 2) {
                armorMenu();
            } else if (choice == 3) {
                ringMenu();
            } else {
                break;
            }
        }
    }

    void weaponMenu() {
        System.out.println("무기는 공격력을 영구 증가 시킵니다.");
        for (int i = 0; i < WeaponList.size(); i++) {
            Item temp = WeaponList.get(i);
            System.out.println(
                    "[" + (i + 1) + "]" + "이름 : " + temp.name + ", 가격 : " + temp.price + "골드, 능력 : +" + temp.stat);
        }
        System.out.println("[0] 뒤로가기");
        System.out.println("번호를 입력하세요 : ");
        int choice = scan.nextInt();
        if (choice == 0) {
            return;
        }
        choice--;
        Item buyTemp = WeaponList.get(choice);
        if (user.money < buyTemp.price) {
            System.out.println("소지금이 부족합니다.");
            return;
        }
        user.money -= buyTemp.price;
        System.out.println("현재 소지금 : " + user.money);
        user.Total_Inven.add(buyTemp);
        user.Total_map.put(buyTemp, "Weapon");

        System.out.println("아이템을 구입했습니다!");
    }

    void armorMenu() {
        System.out.println("갑옷은 방어력을 영구 증가 시킵니다.");
        for (int i = 0; i < ArmorList.size(); i++) {
            Item temp = ArmorList.get(i);
            System.out.println(
                    "[" + (i + 1) + "]" + "이름 : " + temp.name + ", 가격 : " + temp.price + "골드, 능력 : +" + temp.stat);
        }
        System.out.println("[0] 뒤로가기");
        System.out.println("번호를 입력하세요 : ");
        int choice = scan.nextInt();
        if (choice == 0) {
            return;
        }
        choice--;
        Item buyTemp = ArmorList.get(choice);
        if (user.money < buyTemp.price) {
            System.out.println("소지금이 부족합니다.");
            return;
        }
        user.money -= buyTemp.price;
        System.out.println("현재 소지금 : " + user.money);
        user.Total_Inven.add(buyTemp);
        user.Total_map.put(buyTemp, "Armor");
        System.out.println("아이템을 구입했습니다!");
    }

    void ringMenu() {
        System.out.println("반지는 최대 체력을 영구 증가 시킵니다.");
        for (int i = 0; i < RingList.size(); i++) {
            Item temp = RingList.get(i);
            System.out.println(
                    "[" + (i + 1) + "]" + "이름 : " + temp.name + ", 가격 : " + temp.price + "골드, 능력 : +" + temp.stat);
        }
        System.out.println("[0] 뒤로가기");
        System.out.println("번호를 입력하세요 : ");
        int choice = scan.nextInt();
        if (choice == 0) {
            return;
        }
        choice--;
        Item buyTemp = RingList.get(choice);
        if (user.money < buyTemp.price) {
            System.out.println("소지금이 부족합니다.");
            return;
        }
        user.money -= buyTemp.price;
        System.out.println("현재 소지금 : " + user.money);
        user.Total_Inven.add(buyTemp);
        user.Total_map.put(buyTemp, "Ring");
        System.out.println("아이템을 구입했습니다!");

    }
}