package movierental;

public class ChildrenPrice extends Price{
	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}
	
	@Override
	double getCharge(int numberOfDaysRented) {
		// TODO Auto-generated method stub
		double result = 1.5;
        if (numberOfDaysRented > 3){
            result += (numberOfDaysRented - 3) * 1.5;
        }   
		return result;
	}
}