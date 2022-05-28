package bbangcketMonster.stage;

import bbangcketMonster.GameManager;

public class TitleStage extends Stage {

	GameManager gameManager =
	@Override
	void init() {

	}

	@Override
	boolean update() {
		System.out.println("______ ______                             _           _    ___  ___                    _               \n" +
				"| ___ \\| ___ \\                           | |         | |   |  \\/  |                   | |              \n" +
				"| |_/ /| |_/ /  __ _  _ __    __ _   ___ | | __  ___ | |_  | .  . |  ___   _ __   ___ | |_   ___  _ __ \n" +
				"| ___ \\| ___ \\ / _` || '_ \\  / _` | / __|| |/ / / _ \\| __| | |\\/| | / _ \\ | '_ \\ / __|| __| / _ \\| '__|\n" +
				"| |_/ /| |_/ /| (_| || | | || (_| || (__ |   < |  __/| |_  | |  | || (_) || | | |\\__ \\| |_ |  __/| |   \n" +
				"\\____/ \\____/  \\__,_||_| |_| \\__, | \\___||_|\\_\\ \\___| \\__| \\_|  |_/ \\___/ |_| |_||___/ \\__| \\___||_|   \n" +
				"                              __/ |                                                                    \n" +
				"                             |___/                                                                   ");
		System.out.println("[PRESS ANY BUTTON]");
		String txt = GameManager.gm.scan.next();
		if (txt != null) {
			GameManager.gm.nextStageName = "LOBBY";
			return true;
		}
		return false;
	}
}