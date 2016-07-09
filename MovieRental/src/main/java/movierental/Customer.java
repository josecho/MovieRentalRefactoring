package movierental;
import java.util.ArrayList;
import java.util.List;


public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each: rentals) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }
    
    public String htmlStatement() {
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>";
        result += "<table><tbody>";
        for (Rental each: rentals) {
            // show figures for this rental
            result += "<tr><td>" + each.getMovie().getTitle() + "</td><td>" + each.getCharge() + "</td><td>";
        }
        result += "</tbody></table>";
        // add footer lines
        result += "<p>Amount owed is <em>" + getTotalCharge() + "</em></p>";
        result += "<p>You earned <em>"  + getTotalFrequentRenterPoints() + " </em> frequent renter points</p>";
        return result;
    }

	private double getTotalCharge() {
		double totalCharge = 0;
        for (Rental each: rentals) {
            totalCharge += each.getCharge();
        }
		return totalCharge;
	}
	
	private int getTotalFrequentRenterPoints() {
		int totalFrequentRenterPoints = 0;
        for (Rental each: rentals) {
            totalFrequentRenterPoints+= each.getFrequentRenterPoints();
        }
		return totalFrequentRenterPoints;
	}
}
