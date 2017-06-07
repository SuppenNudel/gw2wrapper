package me.xhsun.guildwars2wrapper.model;

import com.google.gson.annotations.Expose;

import java.util.Arrays;
import java.util.List;

/**
 * For more info on Colors API go <a href="https://wiki.guildwars2.com/wiki/API:2/colors">here</a><br/>
 * Model class for color
 *
 * @author xhsun
 * @since 2017-06-05
 */
public class Color {
	public enum Categories {
		Gray, Brown, Red, Orange, Yellow, Green, Blue, Purple,
		Vibrant, Leather, Metal,
		Starter, Common, Uncommon, Rare
	}

	private int id;
	private String name;
	private int[] base_rgb;
	private ColorDetail cloth;
	private ColorDetail leather;
	private ColorDetail metal;
	private int item;//item id for the dye
	private List<Categories> categories;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int[] getBaseRgb() {
		return base_rgb;
	}

	public ColorDetail getCloth() {
		return cloth;
	}

	public ColorDetail getLeather() {
		return leather;
	}

	public ColorDetail getMetal() {
		return metal;
	}

	/**
	 * @return id for {@link me.xhsun.guildwars2wrapper.model.Item}
	 */
	public int getItem() {
		return item;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Color color = (Color) o;

		return id == color.id && item == color.item;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + item;
		return result;
	}

	@Override
	public String toString() {
		return "Color{" +
				"id=" + id +
				", name='" + name + '\'' +
				", base_rgb=" + Arrays.toString(base_rgb) +
				", cloth=" + cloth +
				", leather=" + leather +
				", metal=" + metal +
				", item=" + item +
				", categories=" + categories +
				'}';
	}

	/**
	 * color details
	 */
	public class ColorDetail {
		@Expose
		private int brightness;
		@Expose
		private double contrast;
		@Expose
		private int hue;
		@Expose
		private double saturation;
		@Expose
		private double lightness;
		@Expose
		private int[] rgb;

		public int getBrightness() {
			return brightness;
		}

		public double getContrast() {
			return contrast;
		}

		public int getHue() {
			return hue;
		}

		public double getSaturation() {
			return saturation;
		}

		public double getLightness() {
			return lightness;
		}

		public int[] getRgb() {
			return rgb;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			ColorDetail that = (ColorDetail) o;

			return brightness == that.brightness &&
					Double.compare(that.contrast, contrast) == 0 &&
					hue == that.hue &&
					Double.compare(that.saturation, saturation) == 0 &&
					Double.compare(that.lightness, lightness) == 0 &&
					Arrays.equals(rgb, that.rgb);
		}

		@Override
		public int hashCode() {
			int result;
			long temp;
			result = brightness;
			temp = Double.doubleToLongBits(contrast);
			result = 31 * result + (int) (temp ^ (temp >>> 32));
			result = 31 * result + hue;
			temp = Double.doubleToLongBits(saturation);
			result = 31 * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(lightness);
			result = 31 * result + (int) (temp ^ (temp >>> 32));
			result = 31 * result + Arrays.hashCode(rgb);
			return result;
		}

		@Override
		public String toString() {
			return "ColorDetail{" +
					"brightness=" + brightness +
					", contrast=" + contrast +
					", hue=" + hue +
					", saturation=" + saturation +
					", lightness=" + lightness +
					", rgb=" + Arrays.toString(rgb) +
					'}';
		}
	}
}