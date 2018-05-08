package chapterone;

/**
 * @author Robert-JQ
 * @desc 租赁类,表示某个租客租了一部影片
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
}
