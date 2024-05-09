package Building;

import Army.Archer;
import Army.Barbarian;
import Army.Giant;

import java.util.List;

public class Camp extends Building{
    List<Barbarian> barbarians;
    List<Archer> archers;
    List<Giant> giants;
    public String getType() {
        return "Camp";
    }

    public String getReport() {
        return "Camp: lv" + this.getLevel();
    }

    public void addBarbarian() {
        barbarians.add(new Barbarian());
    }
    public void addArcher() {
        archers.add(new Archer());
    }

    public void addGiant() {
        giants.add(new Giant());
    }
}
