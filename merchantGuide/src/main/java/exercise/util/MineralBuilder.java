package exercise.util;

import exercise.Mineral;

public class MineralBuilder {

	private String name;
	private float priceInCredits;

	public MineralBuilder setPriceInCredits(float priceInCredits) {
		this.priceInCredits = priceInCredits;
		return this;
	}

	public MineralBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public Mineral build() {
		Mineral mineral = new Mineral(name);
		mineral.setPriceInCredits(priceInCredits);
		return mineral;
	}

}
