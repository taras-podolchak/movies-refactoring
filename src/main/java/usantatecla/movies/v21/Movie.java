package usantatecla.movies.v21;

public abstract class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

	public String getTitle() {
		return title;
	}
}