package RPG_Final.src.RPG_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static GameManager gm = new GameManager();

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	Map<String, Stage> StageList = new HashMap<String, Stage>();
	GuildManager guildM=GuildManager.getGuildM();

	String curStageName = "";// ���� ��������
	String nextStageName = "";// ���� ��������

	void init() {
		guildM.guild.initMember();
		StageList.put("TITLE", new TitleStage());
		StageList.put("LOBBY", new LobbyStage());
		StageList.put("SETTING", new SettingStage());
		StageList.put("BATTLE", new BattleStage());

		nextStageName = "TITLE";
	}

	void update() {
		boolean run = true;
		while (run) {
			if (curStageName.equals(nextStageName)) {
				run = false;
			} // ��ȭ ����
			if (nextStageName.equals("")) {
				System.out.println("시스템을 종료합니다.");
				run = false;
				return;
			}

			curStageName = nextStageName;
			Stage curStage = StageList.get(curStageName);// �������� �̵�

			curStage.init();
			while (true) {
				if (curStage.update()) {// ��ȭ����
					break;// ������������ �̵�
				}
			}
			run = true;
		}
	}

	void run() {
		init();
		update();

	}

}
