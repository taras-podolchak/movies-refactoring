package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		//sin crear Iterator<Rental>, recorremos directamente el "List<Rental> rentals"
		String result = rentals.stream()
				//recorremos cada objeto Rental
				.map(rental -> "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n")
				//y usamos Collectors.joining()
				// este método devuelve un Collector que concatena los elementos de entrada en una sola string.
				.collect(Collectors.joining());
		result = "Rental Record for " + this.getName() + "\n" + result;
		result += "Amount owed is " + this.getTotalCharge() + "\n";
		result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		return rentals.stream()
				.mapToDouble(Rental::getCharge)
				.sum();
	}
	
	private int getTotalFrequentRenterPoints() {
		return rentals.stream()
				.mapToInt(Rental::getFrequentRenterPoints)
				.sum();
	}
}
