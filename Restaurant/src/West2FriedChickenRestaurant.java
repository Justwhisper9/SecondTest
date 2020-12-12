
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double balance ;
    public static List<Beer> beerList = new ArrayList<>();
    public static List<Juice> juiceList = new ArrayList<>();
    public static List<SetMeal> mealList = new ArrayList<>();

    //不太懂初始化套餐列表时套餐和饮料的对象怎么创建，只好定义成静态变量同时方便测试方法的调用
    public static Juice orangeJuice = new Juice("橙汁",3, LocalDate.now());
    public static Juice lemonJuice = new Juice("柠檬汁",5, LocalDate.now());
    public static Beer piJiuBeer = new Beer("啤酒", 7,LocalDate.of(2020, Month.DECEMBER, 1),7);
    public static Beer erGuoTou = new Beer("二锅头", 15,LocalDate.of(2020, Month.DECEMBER, 1),50);
    public static SetMeal mealOrange = new SetMeal("橙汁炸鸡", 20, "炸鸡一号", orangeJuice);
    public static SetMeal mealLemon = new SetMeal("柠檬炸鸡", 23, "炸鸡一号", lemonJuice);
    public static SetMeal mealPiJiu = new SetMeal("啤酒炸鸡", 25, "炸鸡二号", piJiuBeer);
    public static SetMeal mealErGuoTou = new SetMeal("二锅头炸鸡", 35, "炸鸡二号", erGuoTou);
    static{
        mealList.add(mealOrange);
        mealList.add(mealLemon);
        mealList.add(mealPiJiu);
        mealList.add(mealErGuoTou);
        mealList = Collections.unmodifiableList(mealList);   //套餐初始化后改为只读，不可更改
        for (int i=0; i<4; i++) {
            if (i<2) {
                beerList.add(piJiuBeer);
            }  else {
                beerList.add(erGuoTou);
            }
        }
        for (int i=0; i<4; i++) {
            if (i<2) {
                juiceList.add(orangeJuice);
            }  else{
                juiceList.add(lemonJuice);
            }
        }
    }

    private void use(Beer beer){
        boolean haveBeer = false;
        for(Beer b:beerList){
            if(b.equals(beer)){
                beerList.remove(beer);
                haveBeer = true;
                break;
            }
        }
        if(!haveBeer){                        //判别列表中是否有所需饮料对象，若无则抛出异常
            throw new IngredientSortOutException(beer.getName()+"已售空");
        }
    }
    private void use(Juice juice){
        boolean haveJuice = false;
        for(Juice j:juiceList){
            if(j.equals(juice)){
                juiceList.remove(juice);
                haveJuice = true;
                break;
            }
        }
        if(!haveJuice){
            throw new IngredientSortOutException(juice.getName()+"已售空");
        }

        //
    }

    @Override
    public void sellMeal(SetMeal meal) {
        try {
            if(meal.getDrink() instanceof Beer){
                use((Beer)meal.getDrink());
            }else{
                use((Juice)meal.getDrink());
            }
            balance += meal.getMealPrice();
            System.out.println("售出一份"+meal.getMealName());
        } catch (IngredientSortOutException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stockWithGoods(Drinks drinksStock, int stockNum) {
        double costSum = drinksStock.cost*stockNum;
        try {
            addGoods(costSum,drinksStock,stockNum);
            System.out.println("成功进货"+drinksStock.getName()+stockNum+"件");
        } catch (OverdraftBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
    private void addGoods(double cost, Drinks drinksGoods, int stockNum){
        if(cost <= balance){
            balance -=cost;
            if(drinksGoods instanceof Beer){
                for (int i=0; i<stockNum; i++) {
                    beerList.add((Beer)drinksGoods);
                }
            }else{
                for (int i=0; i<stockNum; i++) {
                    juiceList.add((Juice)drinksGoods);
                }
            }
        }else{
            throw new OverdraftBalanceException("余额不足，进货还需"+(cost-balance)+"元");         //
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static List<Beer> getBeerList() {
        return beerList;
    }

    public static List<Juice> getJuiceList() {
        return juiceList;
    }

    public static List<SetMeal> getMealList() {
        return mealList;
    }
}

