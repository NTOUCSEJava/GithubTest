package ntou.cs.java.rpg;

import java.security.SecureRandom;

public class Shop {

	private static final int NORMAL = 0;
	private static final int DOUBLE = 1;
	private static final int POWER = 2;

	private static final int BASE_ATTACK = 50;
	private static final int RANDOM_ATTACK = 50;	

	public Weapon sellWeapon() {
		SecureRandom random = new SecureRandom();
		Weapon weapon;		
		
		int type = random.nextInt(3);

		int attack = BASE_ATTACK + random.nextInt(RANDOM_ATTACK);

		switch (type) {
		case NORMAL:
			weapon = new NormalWeapon(attack);
			break;
		case DOUBLE:
			weapon = new DoubleWeapon(attack);
			break;
		case POWER:
			weapon = new PowerWeapon(attack);
			break;
		default:
			weapon = null;
			break;
		}

		return weapon;
	}

}
