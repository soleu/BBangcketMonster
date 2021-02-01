package RPG_Final.src.RPG_final;

import java.util.Scanner;

public class Shopping {
	Scanner scan=new Scanner(System.in);
	
	User user=User.getuser();
	Guild guild=Guild.getguild();
	
	void run() {
		System.out.println("[1]Equip [2]Resell");
		int choice = scan.nextInt();
		if (choice == 1) {
			// ĳ���� ���� ���� Ȯ��
			equip();
		} else if (choice == 2) {
			// ������ 50����
			resell();
		}

	}

	void showState() {
		int i = 0;
		for (Item wi : user.Total_Inven) {
			if (user.chara_map.get(wi) != null) {
				// ������
				System.out.println("[" + (i + 1) + "] name : " + wi.name + " price: " + wi.price + " stat: " + wi.stat
						+ " Party : " + user.chara_map.get(wi));
			} else {
				// ��������
				System.out.println(
						"[" + (i + 1) + "] name : " + wi.name + " price: " + wi.price + " stat: " + wi.stat + " Party : N");
			}
			i++;
		}
	}

	// ����
	void equip() {
		showState();
		System.out.println("[msg]  Choose an Item: ");
		int choice = scan.nextInt();
		choice--;
		if (user.chara_map.get(user.Total_Inven.get(choice)) != null) {
			System.out.println("This item already be equipped by other.");
			return;
		}

		System.out.println("Choose a member :");
		guild.memberList();
		int choiceMem = scan.nextInt();
		choiceMem--;
		String name = guild.guildMember.get(choiceMem).name;
		user.chara_map.put(user.Total_Inven.get(choice), name);
	}

	// �Ǹ�
	void resell() {
		showState();
		System.out.println("[msg] buyprice*0.5");
		System.out.println("[msg] Choose a number : ");
		int choice = scan.nextInt();
		choice--;
		if (user.chara_map.get(user.Total_Inven.get(choice)) != null) {
			System.out.println("This item already be equipped by other.");
			return;
		}
		double resellMoney = (user.Total_Inven.get(choice).price) * 0.5;
		user.money += resellMoney;
		System.out.println("Resell price +" + resellMoney);
		System.out.println("User Money : " + user.money);

		user.chara_map.remove(user.Total_Inven.get(choice));
		user.Total_map.remove(user.Total_Inven.get(choice));
		user.Total_Inven.remove(choice);

	}

}
