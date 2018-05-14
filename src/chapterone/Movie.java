package chapterone;

/**
 * @author Robert-JQ
 * @desc 影片, 纯数据类
 * @date 2018/05/08 23:09
 */
public class Movie {

    /**
     * 儿童片
     */
    public static final int CHILDREN = 2;

    /**
     * 普通片
     */
    public static final int REGULAR = 0;

    /**
     * 新片
     */
    public static final int NEW_RELEASE = 1;

    /**
     * 片名
     */
    private String title;

    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    /**
     * @desc 由于计算费用方法中使用了movie类中的属性,所以将计算费用的方法移动到movie类中,
     * 将影片租借天数作为参数传递过来
     * @author Robert-JQ
     * @date 2018/5/14 23:13
     * @param daysRented 影片租借天数
     * @return double
     */
    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * @desc 以同样的手法,将计算常客积分方法移动到movie类中
     * @author Robert-JQ
     * @date 2018/5/14 0014 23:17
     * @param daysRented 影片租借天数
     * @return int
     */
    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 1;
        } else {
            return 2;
        }
    }
}
