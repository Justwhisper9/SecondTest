
import java.time.LocalDate;
import java.util.Objects;

public class Beer extends Drinks{
    private float alcoholContent;
    Beer(String name, double cost, LocalDate mfgDate, float alcoholContent){
        super(name, cost, mfgDate,30);
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", alcoholContent=" + alcoholContent +
                ", cost=" + cost +
                ", mfgDate=" + mfgDate +
                ", expDate=" + expDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Beer){
            Beer beer = (Beer)obj;
            return Objects.equals(this.name, beer.getName())&&Objects.equals(this.mfgDate, beer.getMfgDate())&&this.cost==beer.getCost()&&this.alcoholContent==beer.getAlcoholContent();
        }
        return false;
    }

    public float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }
}
