package chapterone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robert-JQ
 * @desc 顾客
 * @date 2018/05/08 23:23
 */
public class Customer {

    /**
     * 名字
     */
    private String name;

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    /**
     * @desc 对于一个这样的小程序,随意的实现功能无可厚非。但试想这是一个复杂系统中具有代表性的一段,
     *        那这个系统该多难以维护。statement方法做了太多原本该由其他类完成的事情,而且代码不好看,
     *        它可以正常工作,编译器才不会在乎代码好不好看。但是在需要修改系统的时候,就涉及人了,而人
     *        在乎这些,糟糕的系统很难找到修改点,这就很有可能导致程序员写出bug
     *
     * @author Robert-JQ
     * @date 2018/5/8 23:47
     * @return java.lang.String
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "chapterone.Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double thisAmount;

            thisAmount = amountFor(rental);

            frequentRenterPoints++;

            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    /**
     * @desc 将statement方法中的switch部分(逻辑泥团)提炼到独立函数中。变量rental不会被修改,
     *        可以被当作参数传入。变量thisAmount会且只有这一个变量会被修改,可以把它当做返回值
     * @author Robert-JQ
     * @date 2018/5/9 22:51
     * @param rental 租赁对象
     * @return double
     */
    private double amountFor(Rental rental) {
        double thisAmount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount +=2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return thisAmount;
    }
}
