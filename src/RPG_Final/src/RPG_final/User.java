package RPG_Final.src.RPG_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
//�κ��丮, ��� ���

public class User {
	private User() {
	};

	private static User user = new User();

	public static User getuser() {
		return user;
	}

	Scanner scan = new Scanner(System.in);
	Guild guild = Guild.getguild();
	
	int money = 50000;// �⺻��
	// �κ�
	Vector<Item> Total_Inven = new Vector<>();

	Map<Item, String> Total_map = new HashMap<Item, String>();// ī�װ� ��ġ
	Map<Item, String> chara_map = new HashMap<Item, String>();// ĳ���Ϳ� ��ġ

	void init() {

	}


}
