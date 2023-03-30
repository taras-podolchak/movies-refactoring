package usantatecla.movies.v21;

public class ChildrensMovie extends Movie {

	private static final double CHARGE = 1.5;
	private static final double EXTRA_CHARGE = 1.5;
	private static final int DAYS_RENTED_THRESHOLD = 3;

	public ChildrensMovie(String title) {
		super(title);
	}

	@Override
	public double getCharge(int daysRented) {
		double result = ChildrensMovie.CHARGE;
		if (daysRented > ChildrensMovie.DAYS_RENTED_THRESHOLD) {
			result += (daysRented - 1) * ChildrensMovie.EXTRA_CHARGE;
		}
		return result;
	}
}