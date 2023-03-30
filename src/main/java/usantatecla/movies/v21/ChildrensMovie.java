package usantatecla.movies.v21;

public class ChildrensMovie extends Movie {

	private static final double CHARGE = 1.5;
	private static final double EXTRA_CHARGE = 1.5;
	private static final int DAYS_RENTED_THRESHOLD = 3;
	private static final int ONE_RENTED_DAY = 1;

	public ChildrensMovie(String title) {
		super(title);
	}

	@Override
	public double getCharge(int daysRented) {
		double charge = CHARGE;
		if (daysRented > DAYS_RENTED_THRESHOLD) {
			charge += (daysRented - ONE_RENTED_DAY) * EXTRA_CHARGE;
		}
		return charge;
	}
}