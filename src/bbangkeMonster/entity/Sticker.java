package bbangkeMonster.entity;

public class Sticker {
    int no;
    String name;
    String image;

    public Sticker(int no, String name, String image) {
        this.no = no;
        this.name = name;
        this.image = image;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void printImage() {
        System.out.println(image);
    }
}
