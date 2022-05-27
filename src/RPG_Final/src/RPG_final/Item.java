package RPG_Final.src.RPG_final;

public class Item {
    String name;//물품 이름
    int price;// 가격
    int stat;//능력

    Item() {
    }

    Item(String name, int price, int stat) {
        this.name = name;
        this.price = price;
        this.stat = stat;
    }

    void printItem() {
        System.out.println("이름 : " + name + " 가격 : " + price + "골드 능력 : +" + stat);
    }
}