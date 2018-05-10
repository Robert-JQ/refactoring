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
     * @return java.lang.String
     * @desc 对于一个这样的小程序, 随意的实现功能无可厚非。但试想这是一个复杂系统中具有代表性的一段,
     * 那这个系统该多难以维护。statement方法做了太多原本该由其他类完成的事情,而且代码不好看,
     * 它可以正常工作,编译器才不会在乎代码好不好看。但是在需要修改系统的时候,就涉及人了,而人
     * 在乎这些,糟糕的系统很难找到修改点,这就很有可能导致程序员写出bug
     * @author Robert-JQ
     * @date 2018/5/8 23:47
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "chapterone.Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();

            //用查询代替临时变量(Replace Temp With Query)
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
            totalAmount += rental.getCharge();
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }


    /**
     * @param aRental 租赁对象
     * @return double
     * @desc 将statement方法中的switch部分(逻辑泥团)提炼到独立函数中。变量rental不会被修改,
     * 可以被当作参数传入。变量thisAmount会且只有这一个变量会被修改,可以把它当做返回值
     * @author Robert-JQ
     * @date 2018/5/9 22:51
     */
    private double amountFor(Rental aRental) {
        //amountFor函数可以去除了,也可以让它调用新函数。
        // 如果它是一个public的函数,而我们又不想修改其他类的接口,这便是一种有用的手法
        return aRental.getCharge();
    }
}
