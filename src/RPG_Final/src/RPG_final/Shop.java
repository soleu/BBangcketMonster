package RPG_Final.src.RPG_final;
import java.util.Scanner;
import java.util.Vector;

public class Shop {
	private Shop() {
	};

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
		String[] names = { "���� ��", "�� ��", "��ö ��", "�� ����", "ö ����", "���̾� ����", "���� ����", "�� ����", "���޶��� ����" };
		int[] prices = { 5000, 10000, 20000, 7000, 12000, 30000, 10000, 13000, 50000 };
		int[] stats = { 10, 15, 30, 15, 20, 50, 10, 20, 40 };
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
			System.out.println("[1]���� [2]���� [3]���� [4]�ڷΰ���");
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
		System.out.println("����� ���ݷ��� ���� ���� ��ŵ�ϴ�.");
		for (int i = 0; i < WeaponList.size(); i++) {
			Item temp = WeaponList.get(i);
			System.out.println(
					"[" + (i + 1) + "]" + "�̸� : " + temp.name + ", ���� : " + temp.price + "���, �ɷ� : +" + temp.stat);
		}
		System.out.println("[0] �ڷΰ���");
		System.out.println("��ȣ�� �Է��ϼ��� : ");
		int choice = scan.nextInt();
		if (choice == 0) {
			return;
		}
		choice--;
		Item buyTemp = WeaponList.get(choice);
		if (user.money < buyTemp.price) {
			System.out.println("�������� �����մϴ�.");
			return;
		}
		user.money -= buyTemp.price;
		System.out.println("���� ������ : " + user.money);
		user.Total_Inven.add(buyTemp);
		user.Total_map.put(buyTemp, "Weapon");
	
		System.out.println("�������� �����߽��ϴ�!");
	}

	void armorMenu() {
		System.out.println("������ ������ ���� ���� ��ŵ�ϴ�.");
		for (int i = 0; i < ArmorList.size(); i++) {
			Item temp = ArmorList.get(i);
			System.out.println(
					"[" + (i + 1) + "]" + "�̸� : " + temp.name + ", ���� : " + temp.price + "���, �ɷ� : +" + temp.stat);
		}
		System.out.println("[0] �ڷΰ���");
		System.out.println("��ȣ�� �Է��ϼ��� : ");
		int choice = scan.nextInt();
		if (choice == 0) {return;
		}
		choice--;
		Item buyTemp = ArmorList.get(choice);
		if (user.money < buyTemp.price) {
			System.out.println("�������� �����մϴ�.");
			return;
		}
		user.money -= buyTemp.price;
		System.out.println("���� ������ : " + user.money);
		user.Total_Inven.add(buyTemp);
		user.Total_map.put(buyTemp, "Armor");
		System.out.println("�������� �����߽��ϴ�!");
	}

	void ringMenu() {
		System.out.println("������ �ִ� ü���� ���� ���� ��ŵ�ϴ�.");
		for (int i = 0; i < RingList.size(); i++) {
			Item temp = RingList.get(i);
			System.out.println(
					"[" + (i + 1) + "]" + "�̸� : " + temp.name + ", ���� : " + temp.price + "���, �ɷ� : +" + temp.stat);
		}
		System.out.println("[0] �ڷΰ���");
		System.out.println("��ȣ�� �Է��ϼ��� : ");
		int choice = scan.nextInt();
		if (choice == 0) {return;
		}
		choice--;
		Item buyTemp = RingList.get(choice);
		if (user.money < buyTemp.price) {
			System.out.println("�������� �����մϴ�.");
			return;
		}
		user.money -= buyTemp.price;
		System.out.println("���� ������ : " + user.money);
		user.Total_Inven.add(buyTemp);
		user.Total_map.put(buyTemp, "Ring");
		System.out.println("�������� �����߽��ϴ�!");

	}
}
