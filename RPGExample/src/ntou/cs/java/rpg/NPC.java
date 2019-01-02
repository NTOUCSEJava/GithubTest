package ntou.cs.java.rpg;

public class NPC extends Character {

	public static int DEFAULT_ATK = 50;

	public NPC(int hp) {
		super(hp);
		getEquipments().add(new NormalWeapon(DEFAULT_ATK));
	}
}
