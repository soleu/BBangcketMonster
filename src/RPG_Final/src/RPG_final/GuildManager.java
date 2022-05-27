package RPG_Final.src.RPG_final;
import java.util.Scanner;

class GuildManager {
	private GuildManager() {
	};

	private static GuildManager guildM = new GuildManager();

	public static GuildManager getGuildM() {
		return guildM;
	}

	Guild guild=Guild.getguild();
	Scanner scan = new Scanner(System.in);

	void run() {
		while (true) {
			System.out.println("[1] 길드원 확인\t [2] 길드원 추가\t[3] 길드원 삭제\t");
			System.out.println("[4] 뒤로 가기\t");
			int choice = scan.nextInt();
			if (choice == 1) {
				guild.memberList();
			} else if (choice == 2) {
				guild.addMember();
			} else if (choice == 3) {
				guild.deleteMember();
			} else if (choice == 4) {
				break;
			}
		}

	}

}
