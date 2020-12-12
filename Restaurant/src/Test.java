
import java.time.LocalDate;
import java.time.Month;

public class Test {
    public static void main(String[] args) {
        //测试toString方法的重写和判别是否过期方法
        Drinks beerNotOverdue = new Beer("pj", 1, LocalDate.of(2020, Month.DECEMBER, 2), 10);
        System.out.println(beerNotOverdue.toString());
        System.out.println(beerNotOverdue.isOverdue());
        Drinks juiceOverdue = new Juice("cj", 1, LocalDate.of(2020, Month.NOVEMBER, 1));
        System.out.println(juiceOverdue.toString());
        System.out.println(juiceOverdue.isOverdue());
        System.out.println("----------------------------------------------------------------");

        West2FriedChickenRestaurant restaurant = new West2FriedChickenRestaurant();
        restaurant.setBalance(30);
        //套餐列表
        System.out.println(West2FriedChickenRestaurant.mealList);
        System.out.println("----------------------------------------------------------------");

        //测试售卖套餐方法
        System.out.println(West2FriedChickenRestaurant.juiceList);
        restaurant.sellMeal(West2FriedChickenRestaurant.mealOrange);
        restaurant.sellMeal(West2FriedChickenRestaurant.mealOrange);
        restaurant.sellMeal(West2FriedChickenRestaurant.mealOrange);
        System.out.println(West2FriedChickenRestaurant.juiceList);
        System.out.println("----------------------------------------------------------------");

        //测试批量进货方法
        System.out.println(West2FriedChickenRestaurant.beerList);
        restaurant.stockWithGoods(West2FriedChickenRestaurant.erGuoTou,2);
        System.out.println(West2FriedChickenRestaurant.beerList);
        restaurant.stockWithGoods(West2FriedChickenRestaurant.erGuoTou,6);
        System.out.println(West2FriedChickenRestaurant.beerList);
    }

}
