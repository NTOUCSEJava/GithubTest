package ntou.cs.java.rpg;

import java.security.SecureRandom;
import java.util.Scanner;

public class Game {
	private static int END = 0;
	private static int ATTACK = 1;
	private static int DEFEND = 2;
	private static int BUY = 3;

	private Character player;
	private Character npc;
	private Shop gameShop;

	private SecureRandom random;

	public Game(Character player, Character npc, Shop gameShop) {
		this.npc = npc;
		this.player = player;
		this.gameShop = gameShop;
		random = new SecureRandom();
	}

	public void battle() {

		Scanner input = new Scanner(System.in);
		double npcDamage = 0;
		double currentNpcHp = 0;
		double newNpcHp = 0;
		double playerDamage = 0;
		double currentPlayerHp = 0;
		double newPlayerHp = 0;

		while (true) {
			currentNpcHp = npc.getHp();
			currentPlayerHp = player.getHp();
			String playerAttackStr = "";
			String npcAttackStr = "";

			System.out.print("\n請選擇: 0.結束 1.攻擊 2.防禦 3.買道具: ");
			int action = input.nextInt();

			if (action == ATTACK) {
				npcDamage = 0;
				for (ATK equipment : player.getEquipments()) {
					double attackPoint = equipment.attack();
					playerAttackStr += "[" + equipment.getClass().getSimpleName() + "造成 " + (int) attackPoint
							+ " 點的傷害]";
					npcDamage += attackPoint;
				}

				newNpcHp = currentNpcHp - npcDamage;
				npc.setHp(newNpcHp);

				ATK equipment = npc.getEquipments().get(0);
				playerDamage = equipment.attack();
				npcAttackStr += "[" + equipment.getClass().getSimpleName() + "造成 " + (int) playerDamage + " 點的傷害]";
				newPlayerHp = currentPlayerHp - playerDamage;
				player.setHp(newPlayerHp);

			} else if (action == DEFEND) {
				npcDamage = 0;
				newNpcHp = currentNpcHp - npcDamage;
				npc.setHp(newNpcHp);

				if (random.nextBoolean()) {
					System.out.println("自我療癒了!");
					playerDamage = 0 - npc.getEquipments().get(0).attack() * 0.5;
				} else {
					playerDamage = npc.getEquipments().get(0).attack() * 0.5;
				}
				newPlayerHp = currentPlayerHp - playerDamage;
				player.setHp(newPlayerHp);

			} else if (action == BUY) {
				if (player.getEquipments().size() < 3) {
					player.buyWeapon(gameShop);
				} else {
					System.out.println("武器太多，已經無法再裝新的！");
				}
				continue;
			} else if (action == END) {
				System.out.println("遊戲結束!");
				input.close();
				return;
			} else {
				System.out.println("您輸入無效指令");
				continue;
			}

			if (newNpcHp <= 0) {
				System.out.println("玩家攻擊對手 " + (int) npcDamage + " 點!");
				System.out.println(playerAttackStr);
				System.out.println("擊倒了對手！ ");
				input.close();
				return;
			} else if (newPlayerHp <= 0) {
				System.out.println("對手攻擊玩家 " + (int) playerDamage + " 點!");
				System.out.println(npcAttackStr);
				System.out.println("玩家被擊倒了！ ");
				input.close();
				return;
			} else {
				System.out.println("玩家攻擊對手 " + (int) npcDamage + " 點!");
				if (!playerAttackStr.equals(""))
					System.out.println(playerAttackStr);
				System.out.println("對手的血從 " + (int) currentNpcHp + " 變成 " + (int) newNpcHp);

				System.out.println("對手攻擊玩家 " + (int) playerDamage + " 點!");
				if (!playerAttackStr.equals(""))
					System.out.println(npcAttackStr);
				System.out.println("玩家的血從 " + (int) currentPlayerHp + " 變成 " + (int) newPlayerHp);
			}
		}
	}
}
