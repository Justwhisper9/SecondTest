
import java.time.LocalDate;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate mfgDate;
    protected long expDate;
    public Drinks(String name, double cost, LocalDate mfgDate, int expDate) {
        this.name = name;
        this.cost = cost;
        this.mfgDate = mfgDate;
        this.expDate = expDate;
    }
    public String isOverdue(){
        String overdue = "未过期";
        if (mfgDate.plusDays(expDate).isBefore(LocalDate.now())) {
            overdue = "过期";
        }
        return overdue;
    }
    public abstract String toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getMfgDate() {
        return mfgDate;
    }

    public long getExpDate() {
        return expDate;
    }
}
