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
}
