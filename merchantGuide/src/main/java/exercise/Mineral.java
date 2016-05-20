package exercise;

import java.util.Locale;

public class Mineral {

	private String name;
	private float priceInCredits;

	public Mineral(String name) {
		super();
		this.name = name.toLowerCase(Locale.getDefault());
	}

	public String getName() {
		return name;
	}

	public float getPriceInCredits() {
		return priceInCredits;
	}

	public void setPriceInCredits(float price) {
		this.priceInCredits = price;
	}

}
