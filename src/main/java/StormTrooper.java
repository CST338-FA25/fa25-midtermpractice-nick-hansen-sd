/**
 * @author NickE
 * @version 0.1.0
 * @since 11/18/2025
 **/
public class StormTrooper extends Trooper {

    private String name = "";
    private static int soldierCount = 0;

    public StormTrooper(String unit, int number) {
        super(unit, number);
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
        StormTrooper.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return getName() + "(" + super.toString() + getTrooperKind() + ")";
    }

}
