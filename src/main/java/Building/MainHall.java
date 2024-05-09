package Building;

public class MainHall extends Building{
    public MainHall() {
        super();
    }

    public MainHall(int level) {
        super(level);
    }
    public String getType() {
        return "Townhall";
    }
    public String getReport() {
        return "Townhall: lv" + this.getLevel();
    }
}
