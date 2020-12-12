
public class SetMeal {
    private String mealName;
    private double mealPrice;
    private String friedChickenName;
    private Drinks drink;

    public SetMeal(String mealName, double mealPrice, String friedChickenName, Drinks drink) {
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.friedChickenName = friedChickenName;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "\n"+"SetMeal{" +
                "mealName='" + mealName + '\'' +
                ", mealPrice=" + mealPrice +
                ", friedChickenName='" + friedChickenName + '\'' +
                ", drink=" + drink +
                '}';
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getFriedChickenName() {
        return friedChickenName;
    }

    public void setFriedChickenName(String friedChickenName) {
        this.friedChickenName = friedChickenName;
    }

    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }
}
