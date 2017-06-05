package me.xhsun.guildwars2wrapper.model.util.itemDetail;

import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfixUpgrade;
import me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject.InfusionSlot;

/**
 * For more info on Item detail API go <a href="https://wiki.guildwars2.com/wiki/API:2/items#Armor">here</a><br/>
 * template for all item detail
 *
 * @author xhsun
 * @since 2017-02-07
 */

public class ItemDetail {
	public enum Weight {Heavy, Medium, Light, Clothing}

	public enum Damage {Fire, Ice, Lightning, Physical, Choking}

	public enum Infusion {Defense, Offense, Utility, Agony}

	public enum Unlock {
		BagSlot, BankTab, CollectibleCapacity, Content, CraftingRecipe, Dye, Outfit,
		GliderSkin, Champion
	}

	public enum Attribute {
		BoonDuration, ConditionDamage, ConditionDuration, CritDamage, Healing,
		Power, Precision, Toughness, Vitality
	}

	public enum Flag {
		//Upgrade component flag
		Axe, Dagger, Mace, Pistol, Scepter, Sword, Focus, Shield, Torch, Warhorn, Greatsword, Hammer,
		LongBow, Rifle, ShortBow, Staff, Harpoon, Speargun, Trident, HeavyArmor, MediumArmor,
		LightArmor, Trinket,
		//Infusion slot flag
		Enrichment, Infusion
	}

	public enum Type {
		//Armor type
		Boots, Coat, Gloves, Helm, HelmAquatic, Leggings, Shoulders,
		//universal
		Default,
		//Container type
		GiftBox, OpenUI,
		//Consumable type
		AppearanceChange, Booze, ContractNpc, Food, Generic, Halloween, Immediate, Transmutation, Unlock,
		UpgradeRemoval, Utility, TeleportToFriend,
		//Gathering tool type
		Foraging, Logging, Mining,
		//Gizmo type
		ContainerKey, RentableContractNpc, UnlimitedConsumable,
		//Salvage kits type
		Salvage,
		//Tinket type
		Accessory, Amulet, Ring,
		//Upgrade component type
		Gem, Rune, Sigil,
		//Weapon type
		Axe, Dagger, Mace, Pistol, Scepter, Sword, Focus, Shield, Torch, Warhorn, Greatsword, Hammer,
		LongBow, Rifle, ShortBow, Staff, Harpoon, Speargun, Trident, LargeBundle, SmallBundle, Toy, TwoHandedToy
	}

	//Common
	Type type;
	int defense;
	InfusionSlot[] infusion_slots;
	InfixUpgrade infix_upgrade;
	long suffix_item_id;
	String secondary_suffix_item_id;
	String[] stat_choices;
	//Armor
	Weight weight_class;
	//Bag
	int size;
	boolean no_sell_or_sort;//invisible/safe
	//Consumable
	String description;
	long duration_ms;
	Unlock unlock_type;
	long color_id;
	long recipe_id;//TODO /v2/recipes
	String name;
	String icon;
	//Mini
	long minipet_id;//TODO /v2/minis
	//Salvage kit
	int charges;
	//Upgrade component
	Flag[] flags;
	Infusion[] infusion_upgrade_flags;
	String suffix;
	String[] bonuses;//for runes only
	//Weapon
	Damage damage_type;
	int min_power;
	int max_power;
}
