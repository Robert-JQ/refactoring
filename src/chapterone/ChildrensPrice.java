package chapterone;

/**
 * @author Robert-JQ
 * @desc
 * @date 2018/05/15 22:57
 */
class ChildrensPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
