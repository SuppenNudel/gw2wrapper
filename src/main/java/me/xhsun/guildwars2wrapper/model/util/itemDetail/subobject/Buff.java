package me.xhsun.guildwars2wrapper.model.util.itemDetail.subobject;

/**
 * Infix Buff model class
 *
 * @author xhsun
 * @see InfixUpgrade infix upgrade
 * @since 2017-02-10
 */

public class Buff {
	private long skill_id;
	private String description;

	public String getDescription() {
		return description;
	}

	public long getSkillID() {
		return skill_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Buff buff = (Buff) o;

		return (skill_id == buff.skill_id) &&
				(description != null ? description.equals(buff.description) : buff.description == null);
	}

	@Override
	public int hashCode() {
		int result = (int) (skill_id ^ (skill_id >>> 32));
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Buff{" +
				"skill_id=" + skill_id +
				", description='" + description + '\'' +
				'}';
	}
}