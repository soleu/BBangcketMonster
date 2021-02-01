package RPG_Final.src.RPG_final;
public class TitleStage extends Stage {

	@Override
	void init() {

	}

	@Override
	boolean update() {
		System.out.println("=== TEXT RPG ===");
		System.out.println("[PRESS ANY BUTTON]");
		String txt = GameManager.gm.scan.next();
		if (txt != null) {
			GameManager.gm.nextStageName = "LOBBY";
			return true;
		}
		return false;
	}
}