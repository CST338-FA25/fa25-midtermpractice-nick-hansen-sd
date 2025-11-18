/**
 * @author NickE
 * @version 0.1.0
 * @since 11/18/2025
 **/
public class RebelTrooper extends Trooper {

    private String name = "Rebel";
    private static int soldierCount = 0;

    public RebelTrooper(String unit, int number, String name) {
        super(unit, number);
        soldierCount++;
        setTrooperKind("pilot");
        marchModifier = 0.75;
        setName(name);
    }

    public double march(double duration) {
        return getMarchSpeed() * duration * marchModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public static void setSoldierCount(int soldierCount) {
        RebelTrooper.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return getName() + "(" + super.toString() + getTrooperKind() + ")";
    }

}
