package usantatecla.movies.v21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void withoutRentalsTest() {
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName)
                .totalAmount(0).frequentRenterPoints(0).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental1DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental2DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental3DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
                .totalAmount(3.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental1DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental2DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental3DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental1DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental3DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental4DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
                .totalAmount(6).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void rentalTest() {
        String regularMovieName = "regularMovieName";
        Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
        Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();

        String newReleaseMovieName = "newReleaseMovieName";
        Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
        Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();

        String childrensMovieName = "childrensMovieName";
        Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
        Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();

        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName)
                .rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName)
                .movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
                .totalAmount(32).frequentRenterPoints(4).build();
        assertEquals(result, statement);
    }

    @Test
    public void getNameTest() {
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).build();
        String result = customer.getName();
        assertEquals(result, customerName);
    }

    @Test
    public void getTotalFrequentRenterPointsRegularSeveralDaysTest() {
        Customer customer1Day = getCustomerWithRegularRental(1);
        int result1Day = customer1Day.getTotalFrequentRenterPoints();
        assertEquals(1, result1Day);

        Customer customer2Day = getCustomerWithRegularRental(2);
        int result2Day = customer2Day.getTotalFrequentRenterPoints();
        assertEquals(1, result2Day);

        Customer customer3Day = getCustomerWithRegularRental(3);
        int result3Day = customer3Day.getTotalFrequentRenterPoints();
        assertEquals(1, result3Day);
    }

    private Customer getCustomerWithRegularRental(int days) {
        String movieName = "movieName";
        Movie regularMovie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(regularMovie).daysRented(days).build();
        return new CustomerBuilder().rental(rental).build();
    }

    @Test
    public void getTotalFrequentRenterPointsNewReleasesSeveralDaysTest() {
        Customer customer1Day = getCustomerWithNewReleaseRental(1);
        int result1Day = customer1Day.getTotalFrequentRenterPoints();
        assertEquals(1, result1Day);

        Customer customer2Day = getCustomerWithNewReleaseRental(2);
        int result2Day = customer2Day.getTotalFrequentRenterPoints();
        assertEquals(2, result2Day);

        Customer customer3Day = getCustomerWithNewReleaseRental(3);
        int result3Day = customer3Day.getTotalFrequentRenterPoints();
        assertEquals(2, result3Day);
    }
    private Customer getCustomerWithNewReleaseRental(int days) {
        String movieName = "movieName";
        Movie newRelease = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(newRelease).daysRented(days).build();
        return new CustomerBuilder().rental(rental).build();
    }

    @Test
    public void getTotalFrequentRenterPointsChildrensRentalSeveralDaysTest() {
        Customer customer1Day = getCustomerWithChildrensRental(1);
        int result1Day = customer1Day.getTotalFrequentRenterPoints();
        assertEquals(1, result1Day);

        Customer customer2Day = getCustomerWithChildrensRental(2);
        int result2Day = customer2Day.getTotalFrequentRenterPoints();
        assertEquals(1, result2Day);

        Customer customer4Day = getCustomerWithChildrensRental(4);
        int result4Day = customer4Day.getTotalFrequentRenterPoints();
        assertEquals(1, result4Day);
    }
    private Customer getCustomerWithChildrensRental(int days) {
        String movieName = "movieName";
        Movie newRelease = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(newRelease).daysRented(days).build();
        return new CustomerBuilder().rental(rental).build();
    }
    @Test
    public void getTotalChargeRegularRentalSeveralDaysTest() {
        Customer customer1Day = getCustomerWithRegularRental(1);
        double result1Day = customer1Day.getTotalCharge();
        assertEquals(result1Day, 2, 0);

        Customer customer2Day = getCustomerWithRegularRental(2);
        double result2Day = customer2Day.getTotalCharge();
        assertEquals(result2Day, 2, 0);

        Customer customer3Day = getCustomerWithRegularRental(3);
        double result3Day = customer3Day.getTotalCharge();
        assertEquals(result3Day, 3.5, 0);
    }

    @Test
    public void getTotalChargeNewReleaseRentalSeveralDaysTest() {
        Customer customer1Day = getCustomerWithNewReleaseRental(1);
        double result1Day = customer1Day.getTotalCharge();
        assertEquals(result1Day, 3, 0);

        Customer customer2Day = getCustomerWithNewReleaseRental(2);
        double result2Day = customer2Day.getTotalCharge();
        assertEquals(result2Day, 3, 0);

        Customer customer3Day = getCustomerWithNewReleaseRental(3);
        double result3Day = customer3Day.getTotalCharge();
        assertEquals(result3Day, 3, 0);
    }


    @Test
    public void getTotalChargeChildrensRentalSeveralDaysTest() {
        Customer customer1Day = getCustomerWithChildrensRental(1);
        double result1Day = customer1Day.getTotalCharge();
        assertEquals(result1Day, 1.5, 0);

        Customer customer2Day = getCustomerWithChildrensRental(2);
        double result2Day = customer2Day.getTotalCharge();
        assertEquals(result2Day, 1.5, 0);

        Customer customer4Day = getCustomerWithChildrensRental(4);
        double result4Day = customer4Day.getTotalCharge();
        assertEquals(result4Day, 6, 0);
    }

    @Test
    public void statementTest() {
        Customer customer1Day = getCustomerWithRegularRental(1);
        double result1Day = customer1Day.getTotalCharge();
        assertEquals(result1Day, 2, 0);

        String statement = customer1Day.statement();
        String result = new StatementBuilder().movie("movieName", 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }
}
