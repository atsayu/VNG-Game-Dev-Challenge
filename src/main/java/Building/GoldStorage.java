package Building;

public class GoldStorage extends Storage{
    public GoldStorage(int initialResource, int initialLimit) {
        super(initialResource, initialLimit);
    }
    public String getType() {
        return "GoldStorage";
    }
    public String getReport() {
        return "GoldStorage: lv" + this.getLevel();
    }

    public String getResourceReport() {
        return "Gold: " + this.getResource() + "/" + this.getLimitResource();
    }

}
