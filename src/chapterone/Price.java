package chapterone;

/**
 * @author Robert-JQ
 * @desc
 * @date 2018/05/15 22:56
 */
abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
