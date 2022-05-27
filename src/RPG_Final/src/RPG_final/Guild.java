package RPG_Final.src.RPG_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Guild {
    private Guild() {
    }

    ;

    private static Guild guild = new Guild();

    public static Guild getguild() {
        return guild;
    }

    CharacterManager cm = CharacterManager.getCm();
    Vector<Character> guildMember = new Vector<>();
    Map<String, Integer> nameno = new HashMap<String, Integer>();
    Random ran = new Random();
    Scanner scan = new Scanner(System.in);

    // 처음 길드 멤버 초기화 (순서대로 5명)
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

    // 길드 목록 : 현재 길드에 속해있는 멤버 출력
    void memberList() {
        System.out.println("=== [길드 목록] ===");
        for (int i = 0; i < guildMember.size(); i++) {
            Character temp = guildMember.get(i);
            String name = temp.name;
            int level = temp.level;
            boolean inparty = temp.inParty;
            System.out.println("[" + (i + 1) + "] 이름 : " + name + " 레벨 : " + level + " 파티 중 : " + inparty);
            System.out.println();
        }
    }

    // 길드원 추가 : 기존 캐릭터 매니저에서 랜덤으로 한 명 추가(없는 캐릭터 중에서)
    void addMember() {
        System.out.println("=== [길드원 추가] ===");
        System.out.println("[알림] 길드원 추가는 1000골드가 소모됩니다.");
        // userMoney>=1000

        boolean run = true;
        while (run) {
            int idx = -1;
            int rNum = ran.nextInt(cm.allCharacter.size());

            Character temp = new Character();
            temp = cm.allCharacter.get(rNum);
            for (int i = 0; i < guildMember.size(); i++) {
                if (temp.name.equals(guildMember.get(i).name)) {// 기존 길드원과 중복
                    idx = 0;
                }
            }
            if (idx == -1) {
                guildMember.add(temp);
                nameno.put(temp.name, nameno.size());
                System.out.println("[알림] 길드원이 추가 되었습니다.");
                run = false;
                // userMoney-=1000;
                // 소지금액
            }
        }

    }

    // 길드원 삭제 : 현재 길드에서 선택 삭제(레벨당 골드 지급)
    void deleteMember() {
        System.out.println("=== [길드원 삭제] ===");
        System.out.println("레벨 1 :500골드, 레벨 2 : 700골드, 레벨 3 : 900골드, 레벨4 : 1200골드, 레벨 5: 1500골드 지급");
        int num = 0;
        while (true) {
            memberList();
            System.out.println("삭제할 길드원을 선택하세요 : ");
            num = scan.nextInt();
            num -= 1;
            if (guildMember.get(num).inParty == true) {
                System.out.println("파티중인 멤버는 삭제할 수 없습니다.");
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
        System.out.println("[알림] 해당 길드원이 삭제되었습니다.");
        // 소지금액
        // 소지 아이템 먼저 버리기
    }

    // 파티원 선정(최대 4명)
    void switchMember() {
        int num1 = 0;
        int num2 = 0;
        while (true) {
            System.out.println("=== [파티원 교체] ===");
            memberList();
            System.out.println("휴식을 취할 캐릭터를 선정해주세요 : ");
            num1 = scan.nextInt();
            if (guildMember.get(num1).inParty == false) {
                System.out.println("해당 캐릭터는 파티에 참가중이지 않습니다.");
                continue;
            }
            System.out.println("파티에 참여할 캐릭터를 선정해주세요 : ");
            num2 = scan.nextInt();
            if (guildMember.get(num2).inParty == true) {
                System.out.println("해당 캐릭터는 이미 파티에 참가중입니다.");
                continue;
            }
            break;
        }
        Character inChara = guildMember.get(num1);
        Character outChara = guildMember.get(num2);
        inChara.printCharaInfo();
        System.out.println("이 나가고, ");
        outChara.printCharaInfo();
        System.out.println("이 들어왔습니다.");
        guildMember.get(num1).setOutParty();
        guildMember.get(num2).setInParty();
    }

    // 길드원 no순으로 오름차순 정렬
    void arrayMember() {
        System.out.println("=== [길드원 정렬] ===");
        System.out.println("지정된 순서대로 정렬합니다.");
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