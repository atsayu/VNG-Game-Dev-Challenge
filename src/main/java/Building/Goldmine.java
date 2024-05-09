package Building;

public class Goldmine extends Mine{
    public Goldmine(int level, int resourcePerSecond) {
        super(level, resourcePerSecond);
    }
    public Goldmine() {
        super(1, 10);
    }
    public String getType() {
        return "Goldmine";
    }

    public String getReport() {
        return "Goldmine: lv:" + this.getLevel();
    }

    @Override
    public String upgrade(int hallLevel) {
        if (this.getLevel() < 3) this.setResourcePerSecond(this.getResourcePerSecond() + 10);
        return super.upgrade(hallLevel);
    }
}
