package Building;

public class ElixirDistill extends Mine{
    public ElixirDistill(int level, int resourcePerSecond) {
        super(level, resourcePerSecond);
    }

    public String getType() {
        return "Elixir";
    }
    public ElixirDistill() {
        super(1, 10);
    }

    @Override
    public String upgrade(int hallLevel) {
        if (this.getLevel() < 3) this.setResourcePerSecond(this.getResourcePerSecond() + 10);
        return super.upgrade(hallLevel);
    }
    public String getReport() {
        return "Elixir Distill: lv" + this.getLevel();
    }


}
