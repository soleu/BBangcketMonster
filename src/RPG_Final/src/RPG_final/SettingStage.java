package RPG_Final.src.RPG_final;
public class SettingStage extends Stage{
	GuildManager GuildM=GuildManager.getGuildM();
	Shop shop=Shop.getShop();
	Shopping shopping=new Shopping();
	@Override
	void init() {
		System.out.println("====[Lobby]====");
		System.out.println("[1]������\t[2]����\t[3]�κ�\t" );
		System.out.println("[4]����     \t[5] �ε�\t[6]�ڷΰ���\t");
	}

	@Override
	boolean update() {
		int choice = GameManager.gm.scan.nextInt();
		if(choice==1) {
			GuildM.run();
		}//guild
		else if(choice==2) {
			shop.run();
		}//shop
		else if(choice==3) {
			shopping.run();
		}//user.inven
		else if(choice==4) {}//file
		else if(choice==5) {}//file
		else if(choice==6) {GameManager.gm.nextStageName="LOBBY";}//back
		return true;
	}

}
