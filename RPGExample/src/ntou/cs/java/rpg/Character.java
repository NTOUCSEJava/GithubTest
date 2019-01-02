package ntou.cs.java.rpg;

import java.util.ArrayList;

public class Character {
	public static double MAX_HP = 999;
	public static int DEFAULT_HP = 200;

	private double hp;
	private ArrayList<ATK> equipments = new ArrayList<ATK>();

	public Character() {
		this(DEFAULT_HP);
	}

	public Character(double hp) {
		setHp(hp);
	}

	public Character(double hp, ArrayList<ATK> equipments) {
		setHp(hp);
		this.equipments = equipments;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		if ((0 < hp) && (hp < MAX_HP))
			this.hp = hp;
		else
			this.hp = 0;
	}

	public ArrayList<ATK> getEquipments() {
		return equipments;
	}

	public void setEquipments(ArrayList<ATK> equipments) {
		this.equipments = equipments;
	}

	public void buyWeapon(Shop shop) {
		Weapon newWeapon = shop.sellWeapon();
		System.out.println("拿到了武器: " + newWeapon);
		getEquipments().add(newWeapon);
	}

	@Override
	public String toString() {
		return "Character [hp=" + hp + ", equipments=" + equipments + "]";
	}
}
