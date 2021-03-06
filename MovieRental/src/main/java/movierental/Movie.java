package movierental;

public class Movie {
    public static final int CHILDRENS = 1;
    public static final int REGULAR = 2;
    public static final int NEW_RELEASE = 3;
    
    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }
    
    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Illegal price code");
		}
    }
    
    public String getTitle() {
        return title;
    }

	double getCharge(int numberOfDaysRented) {
		return price.getCharge(numberOfDaysRented);
	}

	int getFrequentRenterPoints(int numberOfDaysRented) {
		return price.getFrequentRenterPoints(numberOfDaysRented);
	}


}
