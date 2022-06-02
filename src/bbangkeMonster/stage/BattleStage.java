package bbangkeMonster.stage;

import bbangkeMonster.GameManager;
import bbangkeMonster.GuildManager;
import bbangkeMonster.data.BattleSetting;
import bbangkeMonster.data.StickerSetting;
import bbangkeMonster.entity.NpcUnit;
import bbangkeMonster.entity.Pokemon;
import bbangkeMonster.entity.Sticker;
import bbangkeMonster.entity.User;
import bbangkeMonster.service.NpcService;
import bbangkeMonster.service.PokemonService;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import static bbangkeMonster.data.BattleSetting.currentNpcList;

public class BattleStage implements Stage {
    final GameManager gm = GameManager.getInstance();
    final BattleSetting battleSetting = BattleSetting.getInstance();
    final NpcService npcService = NpcService.getInstance();
    final PokemonService pokemonService = PokemonService.getInstance();
    final User user = User.getUser();
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
        try {
            boolean turn = false;
            boolean run = true;
            while (run) {
                Thread.sleep(1000);

                MonsterState();
                playerState();

                if (!turn) {
                    Vector<Pokemon> pokemons = guild.getPartyMember();
                    for (int i = 0; i < pokemons.size(); i++) {
                        Pokemon pokemon = pokemons.get(i);
                        if (pokemon.isDead() == true)
                            continue;
                        Thread.sleep(500);
                        System.out.println("\n" + pokemon.getName() + "의 턴");
                        //공격 몬스터 선택
                        System.out.println("공격할 몬스터 선택 : ");
                        for (int j = 0; j < currentNpcList.size(); j++) {
                            if (!currentNpcList.get(j).isDead()) {
                                System.out.println("[" + (j + 1) + "] " + currentNpcList.get(j).getName()
                                        + "[" + currentNpcList.get(j).getHP() + "/" + currentNpcList.get(j).getMax_HP() + "]");
                            } else {
                                System.out.println("[" + (j + 1) + "] " + currentNpcList.get(j).getName()
                                        + "[기절함]");
                            }
                        }
                        int target = scan.nextInt() - 1;
                        System.out.println("공격 선택 :");
                        pokemonService.showSkills(pokemon);
                        int choice = scan.nextInt();
                        pokemonService.attack(pokemon, currentNpcList.get(target), choice);
                        if (checkIfDeadMon()) {
                            win();
                            Thread.sleep(1000);
                            run = false;
                            break;
                        }
                    }
                    turn = true;
                } else {
                    System.out.println("[상대방 턴]");
                    for (int i = 0; i < currentNpcList.size(); i++) {
                        NpcUnit npcUnit = currentNpcList.get(i);
                        if (npcUnit.isDead() == true)
                            continue;
                        Thread.sleep(500);
                        int j = 0;
                        for (; j < guild.getGuildMember().size(); j++) {
                            if (guild.getGuildMember().get(j).getHP() != 0)
                                break;
                        }
                        npcService.attack(npcUnit, guild.getGuildMember().get(j));
                        if (checkIfDeadPokemon()) {
                            lose();
                            Thread.sleep(1000);
                            run = false;
                            break;
                        }
                    }
                    turn = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gm.nextStageName = "LOBBY";
        return true;
    }

    private void playerState() {
        System.out.println("====[플레이어]====");
        for (int i = 0; i < guild.getGuildMember().size(); i++) {
            guild.getGuildMember().get(i).printCharaInfo();
        }
        System.out.println();
    }

    private void MonsterState() {
        System.out.println("====[상대방]====");
        for (int i = 0; i < currentNpcList.size(); i++) {
            currentNpcList.get(i).printUnit();
        }
        System.out.println();
    }

    private boolean checkIfDeadMon() {
        npcDead = 0;
        for (int i = 0; i < currentNpcList.size(); i++) {
            if (currentNpcList.get(i).isDead()) npcDead++;
        }
        if (npcDead == currentNpcList.size()) {
            return true;
        }
        return false;
    }

    private boolean checkIfDeadPokemon() {
        playerDead = 0;
        for (int i = 0; i < guild.getGuildMember().size(); i++) {
            if (guild.getGuildMember().get(i).isDead() == true)
                playerDead++;
        }
        if (playerDead == guild.getGuildMember().size()) {
            return true;
        }
        return false;
    }

    private void openBread() {
        Random random = new Random();

        System.out.println("포켓몬 빵을 얻었습니다!");
        System.out.println("빵을 개봉합니다.");
        System.out.println("...");
        System.out.println("...");
        int rand = random.nextInt(5);//0~4
        StickerSetting stickerSetting = new StickerSetting();
        Sticker sticker = stickerSetting.stickers.get(rand);
        System.out.println(sticker.getName() + "스티커를 얻었습니다!");
        System.out.println("인벤토리에서 이미지를 확인할 수 있습니다.");
        user.earnSticker(sticker);
    }

    private void win() {
        System.out.println("승리! 결투에서 이겼습니다.");
        System.out.println("포켓몬 빵과 경험치를 얻었습니다.");
        for (Pokemon pokemon : guild.getPartyMember()) {
            pokemonService.earnExp(pokemon);
        }
        openBread();
    }

    private void lose() {
        System.out.println("패배! 소지한 포켓몬이 모두 기절하였습니다. 집으로 돌아갑니다.");
        for (Pokemon pokemon : guild.getPartyMember()) {
            pokemonService.earnExp(pokemon); //rebirth
        }
    }
}