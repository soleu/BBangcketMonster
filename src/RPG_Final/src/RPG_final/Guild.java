package RPG_Final.src.RPG_final;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Guild {
	private Guild() {
	};

	private static Guild guild = new Guild();

	public static Guild getguild() {
		return guild;
	}

	CharacterManager cm = CharacterManager.getcm();
	Vector<Character> guildMember = new Vector<>();
	Map<String, Integer> nameno=new HashMap<String, Integer>();
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	// ó�� ��� ��� �ʱ�ȭ (������� 5��)
	void initMember() {
		cm.init();
		for (int i = 0; i < 5; i++) {
			guildMember.add(cm.allCharacter.get(i));
			if (i != 4) {
				guildMember.get(i).setInParty();
			}
			nameno.put(guildMember.get(i).name, i);
		}
	}

	// ��� ��� : ���� ��忡 �����ִ� ��� ���
	void memberList() {
		System.out.println("=== [��� ���] ===");
		for (int i = 0; i < guildMember.size(); i++) {
			Character temp = guildMember.get(i);
			String name = temp.name;
			int level = temp.level;
			boolean inparty = temp.inParty;
			System.out.println("[" + (i + 1) + "] �̸� : " + name + " ���� : " + level + " ��Ƽ �� : " + inparty);
			System.out.println();
		}
	}

	// ���� �߰� : ���� ĳ���� �Ŵ������� �������� �� �� �߰�(���� ĳ���� �߿���)
	void addMember() {
		System.out.println("=== [���� �߰�] ===");
		System.out.println("[�˸�] ���� �߰��� 1000��尡 �Ҹ�˴ϴ�.");
		// userMoney>=1000

		boolean run = true;
		while (run) {
			int idx = -1;
			int rNum = ran.nextInt(cm.allCharacter.size());

			Character temp = new Character();
			temp = cm.allCharacter.get(rNum);
			for (int i = 0; i < guildMember.size(); i++) {
				if (temp.name.equals(guildMember.get(i).name)) {// ���� ������ �ߺ�
					idx = 0;
				}
			}
			if (idx == -1) {
				guildMember.add(temp);
				nameno.put(temp.name, nameno.size());
				System.out.println("[�˸�] ������ �߰� �Ǿ����ϴ�.");
				run = false;
				// userMoney-=1000;
				// �����ݾ�
			}
		}

	}

	// ���� ���� : ���� ��忡�� ���� ����(������ ��� ����)
	void deleteMember() {
		System.out.println("=== [���� ����] ===");
		System.out.println("���� 1 :500���, ���� 2 : 700���, ���� 3 : 900���, ����4 : 1200���, ���� 5: 1500��� ����");
		int num = 0;
		while (true) {
			memberList();
			System.out.println("������ ������ �����ϼ��� : ");
			num = scan.nextInt();
			num -= 1;
			if (guildMember.get(num).inParty == true) {
				System.out.println("��Ƽ���� ����� ������ �� �����ϴ�.");
				continue;
			}
			break;
		}

		int lev = guildMember.get(num).level;
		if (lev == 1) {
			// userMoney+=500;
		} else if (lev == 2) {
			// userMoney+=700;
		} else if (lev == 3) {
			// userMoney+=900;
		} else if (lev == 4) {
			// userMoney+=1200;
		} else if (lev == 5) {
			// userMoney+=1500;
		}
		guildMember.remove(num);
		System.out.println("[�˸�] �ش� ������ �����Ǿ����ϴ�.");
		// �����ݾ�
		// ���� ������ ���� ������
	}

	// ��Ƽ�� ����(�ִ� 4��)
	void switchMember() {
		int num1 = 0;
		int num2 = 0;
		while (true) {
			System.out.println("=== [��Ƽ�� ��ü] ===");
			memberList();
			System.out.println("�޽��� ���� ĳ���͸� �������ּ��� : ");
			num1 = scan.nextInt();
			if (guildMember.get(num1).inParty == false) {
				System.out.println("�ش� ĳ���ʹ� ��Ƽ�� ���������� �ʽ��ϴ�.");
				continue;
			}
			System.out.println("��Ƽ�� ������ ĳ���͸� �������ּ��� : ");
			num2 = scan.nextInt();
			if (guildMember.get(num2).inParty == true) {
				System.out.println("�ش� ĳ���ʹ� �̹� ��Ƽ�� �������Դϴ�.");
				continue;
			}
			break;
		}
		Character inChara = guildMember.get(num1);
		Character outChara = guildMember.get(num2);
		inChara.printCharaInfo();
		System.out.println("�� ������, ");
		outChara.printCharaInfo();
		System.out.println("�� ���Խ��ϴ�.");
		guildMember.get(num1).setOutParty();
		guildMember.get(num2).setInParty();
	}

	// ���� no������ �������� ����
	void arrayMember() {
		System.out.println("=== [���� ����] ===");
		System.out.println("������ ������� �����մϴ�.");
		for (int i = 0; i < cm.allCharacter.size(); i++) {
			String name = cm.noname.get(i);
			for (int j = 0; j < guildMember.size(); j++) {
				if (name.equals(guildMember.get(j).name)) {
					Character temp = guildMember.get(i);
					guildMember.set(i, guildMember.get(j));
					guildMember.set(j, temp);
				}
			}
		}
	}

}
