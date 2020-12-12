
import java.time.LocalDate;
import java.util.Objects;

public class Juice extends Drinks{
    Juice(String name, double cost, LocalDate mfgDate){
        super(name, cost, mfgDate,2);
    }

    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", mfgDate=" + mfgDate +
                ", expDate=" + expDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Juice){
            Juice juice = (Juice)obj;
            return Objects.equals(this.name, juice.getName())&&Objects.equals(this.mfgDate, juice.getMfgDate())&&this.cost==juice.getCost();
        }
        return false;
    }
}
