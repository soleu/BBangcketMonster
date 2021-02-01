package RPG_Final.src.RPG_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class BattleStage extends Stage {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	Map<Integer, Unit> MonsterList = new HashMap<Integer, Unit>();
	Vector<Unit> currentMonster;
	Vector<Character> currentGuild;
	Guild guild = Guild.getguild();

	int monDead = 0;
	int playerDead = 0;

	@Override
	void init() {
		System.out.println("====[Battle]====");
		System.out.println("전투를 시작합니다.");
		initMonster();
		randomMonster();
		initPlayer();
	}

	@Override
	boolean update() {
		boolean turn = false;
		while(true) {
		if (checkIfDeadMon() == true) {
			System.out.println("승리! 몬스터를 모두 처치하였습니다. 로비로 돌아갑니다.");
			GameManager.gm.nextStageName = "LOBBY";
			return true;
		}
		if (checkIfDeadcha() == true) {
			System.out.println("패배! 플레이어가 모두 기절하였습니다. 로비로 돌아갑니다.");
			GameManager.gm.nextStageName = "LOBBY";
			return true;
		}
		MonsterState();
		playerState();
		
		if (turn==false) {
			// player turn
			for (int i = 0; i < currentGuild.size(); i++) {
				Character temp = currentGuild.get(i);
				if (temp.isDead == true)
					continue;
				System.out.println(temp.name + "의 턴");
				System.out.println("[1] 공격 [2] 물약");
				System.out.println("번호 입력 : ");
				int choice = scan.nextInt();
				if (choice == 1) {
					int j = 0;
					for (; j < currentMonster.size(); j++) {
						if (currentMonster.get(j).HP != 0)
							break;
					}
					temp.attack(currentMonster.get(j));
				} else if (choice == 2) {
					System.out.println("체력을 회복합니다. +30");
				}
			}
			turn = true;
		} else {
			// monster turn
			System.out.println("[몬스터 턴]");
			for (int i = 0; i < currentMonster.size(); i++) {
				Unit temp = currentMonster.get(i);
				if (temp.isDead == true)
					continue;
				int j = 0;
				for (; j < currentGuild.size(); j++) {
					if (currentGuild.get(j).HP != 0)
						break;
				}
				temp.attack(currentGuild.get(j));
			}
			turn = false;
		}
		}
	}

	void playerState() {
		System.out.println("====[Player]====");
		for (int i = 0; i < currentGuild.size(); i++) {
			currentGuild.get(i).printCharaInfo();
		}
		System.out.println();
	}

	void MonsterState() {
		System.out.println("====[Monster]====");
		for (int i = 0; i < currentMonster.size(); i++) {
			currentMonster.get(i).printUnit();
		}
		System.out.println();
	}

	void initPlayer() {
		currentGuild = new Vector<>();
		for (int i = 0; i < guild.guildMember.size(); i++) {
			if (guild.guildMember.get(i).inParty == true) {
//				System.out.println(guild.guildMember.get(i).name);
				Character temp = guild.guildMember.get(i);
				currentGuild.add(new Character(temp));
			}
		}
	}

	void initMonster() {
		MonsterList.put(0, new Zombie_Unit());
		MonsterList.put(1, new Ork_Unit());
	}

	void randomMonster() {
		currentMonster = new Vector<>();// 시작전 초기화
		int rNum = ran.nextInt(3) + 1;// 1~3
		for (int i = 0; i < rNum; i++) {
			int rNum2 = ran.nextInt(MonsterList.size());
			currentMonster.add(MonsterList.get(rNum2));
		}
	}

	boolean checkIfDeadMon() {
		for (int i = 0; i < currentMonster.size(); i++) {
			if (currentMonster.get(i).isDead == true)
				monDead++;
		}
		if (monDead == currentMonster.size()) {
			return true;
		}
		return false;
	}

	boolean checkIfDeadcha() {
		for (int i = 0; i < currentGuild.size(); i++) {
			if (currentGuild.get(i).isDead == true)
				playerDead++;
		}
		if (playerDead == currentGuild.size()) {
			return true;
		}
		return false;
	}
}
