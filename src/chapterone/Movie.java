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

    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
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
        return price.getCharge(daysRented);
    }

    /**
     * @desc 以同样的手法,将计算常客积分方法移动到movie类中
     * @author Robert-JQ
     * @date 2018/5/14 0014 23:17
     * @param daysRented 影片租借天数
     * @return int
     */
    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
