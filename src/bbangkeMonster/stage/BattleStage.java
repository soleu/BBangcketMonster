package bbangkeMonster.stage;

import bbangkeMonster.data.BattleSetting;
import bbangkeMonster.entity.Pokemon;
import bbangkeMonster.GameManager;
import bbangkeMonster.GuildManager;
import bbangkeMonster.entity.NpcUnit;
import bbangkeMonster.service.NpcService;

import java.util.Scanner;

import static bbangkeMonster.data.BattleSetting.currentNpcList;

public class BattleStage implements Stage {
    final GameManager gm = GameManager.getInstance();
    final BattleSetting battleSetting = BattleSetting.getInstance();
    final NpcService npcService = NpcService.getInstance();
    GuildManager guild = GuildManager.getInstance();


    Scanner scan = new Scanner(System.in);

    int npcDead = 0;
    int playerDead = 0;

    @Override
    public void init() {
        battleSetting.initBattle();
    }


    @Override
    public boolean update() {
        boolean turn = false;
        while (true) {
            if (checkIfDeadMon() == true) {
                System.out.println("승리! 결투에서 이겼습니다.");
                System.out.println("포켓몬 빵과 경험치를 얻었습니다.");
                //경험치로 레벨업하기
                //포켓몬 빵 뜯기
                gm.nextStageName = "LOBBY";
                return true;
            }
            if (checkIfDeadPokemon() == true) {
                System.out.println("패배! 소지한 포켓몬이 모두 기절하였습니다. 집으로 돌아갑니다.");
                gm.nextStageName = "LOBBY";
                return true;
            }
            MonsterState();
            playerState();

            if (turn == false) {
                // player turn
                for (int i = 0; i < guild.getGuildMember().size(); i++) {
                    Pokemon pokemon = guild.getGuildMember().get(i);
                    if (pokemon.isDead() == true)
                        continue;
                    System.out.println(pokemon.getName() + "의 턴");
                    System.out.println("[1] 공격 [2] 물약");
                    System.out.println("번호 입력 : ");
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        int j = 0;
                        for (; j < currentNpcList.size(); j++) {
                            if (currentNpcList.get(j).getHP() != 0)
                                break;
                        }
                        pokemon.attack(currentNpcList.get(j));
                    } else if (choice == 2) {
                        System.out.println("체력을 회복합니다. +30");
                    }
                }
                turn = true;
            } else {
                System.out.println("[상대방 턴]");
                for (int i = 0; i < currentNpcList.size(); i++) {
                    NpcUnit npcUnit = currentNpcList.get(i);
                    if (npcUnit.isDead() == true)
                        continue;
                    int j = 0;
                    for (; j < guild.getGuildMember().size(); j++) {
                        if (guild.getGuildMember().get(j).getHP() != 0)
                            break;
                    }
                    npcService.attack(npcUnit, guild.getGuildMember().get(j));
                }
                turn = false;
            }
        }
    }

    void playerState() {
        System.out.println("====[플레이어]====");
        for (int i = 0; i < guild.getGuildMember().size(); i++) {
            guild.getGuildMember().get(i).printCharaInfo();
        }
        System.out.println();
    }

    void MonsterState() {
        System.out.println("====[상대방]====");
        for (int i = 0; i < currentNpcList.size(); i++) {
            currentNpcList.get(i).printUnit();
        }
        System.out.println();
    }

    boolean checkIfDeadMon() {
        for (int i = 0; i < currentNpcList.size(); i++) {
            if (currentNpcList.get(i).isDead() == true)
                npcDead++;
        }
        if (npcDead == currentNpcList.size()) {
            return true;
        }
        return false;
    }

    boolean checkIfDeadPokemon() {
        for (int i = 0; i < guild.getGuildMember().size(); i++) {
            if (guild.getGuildMember().get(i).isDead() == true)
                playerDead++;
        }
        if (playerDead == guild.getGuildMember().size()) {
            return true;
        }
        return false;
    }
}
