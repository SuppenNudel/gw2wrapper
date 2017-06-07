package me.xhsun.guildwars2wrapper.model.unlockable;

import me.xhsun.guildwars2wrapper.model.Item;
import me.xhsun.guildwars2wrapper.model.pvp.Hero.Skin;
/**
 * Super class for model classes that have unlock item field
 *
 * @author xhsun
 * @since 2017-06-06
 */
public class Unlockable {
	private int id;
	private int[] unlock_items;//item id
	private int order;
	private String icon;
	private String name;

	public int getId() {
		return id;
	}

	/**
	 * @return array of {@link Item} id(s)
	 */
	public int[] getUnlockItems() {
		return unlock_items;
	}

	/**
	 * not applicable to {@link Outfit}, {@link Skin}
	 *
	 * @return Order shown in game
	 */
	public int getOrder() {
		return order;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}
}