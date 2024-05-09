package Building;

public abstract class Mine extends Building{

    public static final int INITIAL_RESOURCE_PER_SECOND = 10;

    private int resourcePerSecond;

    public Mine(int level, int resourcePerSecond) {
        super(level);
        this.resourcePerSecond = resourcePerSecond;
    }

    public Mine(int resourcePerSecond) {
        this.resourcePerSecond = resourcePerSecond;
    }

    public int getResourcePerSecond() {
        return resourcePerSecond;
    }

    public void setResourcePerSecond(int resourcePerSecond) {
        this.resourcePerSecond = resourcePerSecond;
    }
    public abstract String getType();
    public abstract String getReport();
}
