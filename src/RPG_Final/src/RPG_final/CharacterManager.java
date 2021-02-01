package RPG_Final.src.RPG_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CharacterManager {
	//�̱���
	private CharacterManager() {};
	private static CharacterManager cm= new CharacterManager();
	public static CharacterManager getcm() {return cm;}
	//no-names mapping
	Map<Integer,String> noname=new HashMap<Integer,String>();
	
	 Vector<Character> allCharacter=new Vector<>();
	 void init() {
		 String [] names= {"라이언","어피치","네오","프로도","무지","제이지","튜브","콘","춘식"};
		 int[] HP= {100,120,80,85,90,110,130,105,70};
		 int[] ACK= {30,20,35,35,38,25,23,25,40};
		 int[] DEF= {30,35,25,20,36,56,36,27,58};
		 for(int i=0;i<names.length;i++) {
		 allCharacter.add(new Character(names[i],HP[i],ACK[i],DEF[i]));
		 noname.put(i,names[i]);
		 }
	 }

}
