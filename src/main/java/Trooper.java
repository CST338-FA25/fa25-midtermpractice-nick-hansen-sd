import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author NickE
 * @version 0.1.0
 * @since 11/18/2025
 **/
public abstract class Trooper {

    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier;

    Trooper() {
        this("AA", 0);
    }

    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        marchSpeed = 5;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        if (t == null) {
            return;
        }
        if (!units.containsKey(t.getUnit())) {
            List<Trooper> list = new ArrayList<>();
            units.put(t.getUnit(), list);
        }
        units.get(t.getUnit()).add(t);
    }

    public abstract double march(double duration);

    public boolean attack(Trooper target, int roll) {
        if (target == this) {
            System.out.println(this + " is targeting itself.");
            System.out.println(this + " rolled a " + roll + " and hurt itself in the confusion");
            return true;
        }
        if (getTrooperKind().equals("StormTrooper")) {
            if (target.getTrooperKind().equals("RebelTrooper")) {
                System.out.println("rolled a " + roll + " against the rebel scum.");
                return roll > 10 && roll % 2 == 0;
            } else if (target.getTrooperKind().equals("StormTrooper")) {
                System.out.println("No treason in the ranks!");
                return false;
            } else  {
                System.out.println("Acceptable Collateral Damage!");
                return roll > 10 || roll % 2 == 0;
            }
        } else if (getTrooperKind().equals("RebelTrooper")) {
            if  (target.getTrooperKind().equals("RebelTrooper")) {
                System.out.println("Imperial Spy!");
                return false;
            } else if (target.getTrooperKind().equals("StormTrooper")) {
                System.out.println("Rolled a " + roll + " against the imperial scum.");
                return roll > 5 || roll % 2 == 0;
            } else {
                System.out.println("Rebels target an innocent bystander");
                return roll >= 18 && roll % 2 == 0;
            }
        }
        return false;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number && Double.compare(marchSpeed, trooper.marchSpeed) == 0 && Double.compare(marchModifier, trooper.marchModifier) == 0 && Objects.equals(unit, trooper.unit) && Objects.equals(trooperKind, trooper.trooperKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, number, trooperKind, marchSpeed, marchModifier);
    }

    @Override
    public String toString() {
        return getUnit() + getNumber() + ":";
    }
}
