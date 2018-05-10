package chapterone;

/**
 * @author Robert-JQ
 * @desc 租赁类, 表示某个租客租了一部影片
 * @date 2018/05/08 23:18
 */
public class Rental {

    /**
     * 租借的影片
     */
    private Movie movie;

    /**
     * 租借天数
     */
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    /**
     * @return double
     * @desc 原amountFor函数中只是用了Rental类的信息, 却没有使用Customer类的信息,
     * 将其移到Rental类中
     * @author Robert-JQ
     * @date 2018/5/9 23:20
     */
    double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * @return int
     * @desc 对常客积分计算组合使用提炼函数、搬移代码
     * @author Robert-JQ
     * @date 2018/5/9 23:51
     */
    int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 1;
        } else {
            return 2;
        }
    }
}
