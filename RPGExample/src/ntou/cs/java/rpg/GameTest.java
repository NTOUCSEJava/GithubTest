package ntou.cs.java.rpg;

import java.security.SecureRandom;
import java.util.ArrayList;

public class GameTest {
	public static void main(String args[]) {

		SecureRandom random = new SecureRandom();

		Character player;
		Character npc;
		Shop gameShop;

		int playerHP = 150 + random.nextInt(50);

		int pokemonATK = 50 + random.nextInt(50);

		ArrayList<ATK> equipment = new ArrayList<ATK>();
		equipment.add(new Pet(pokemonATK));

		player = new Character(playerHP, equipment);

		npc = new NPC(1000 - playerHP);
		gameShop = new Shop();

		Game war = new Game(player, npc, gameShop);
		war.battle();
	}
}
