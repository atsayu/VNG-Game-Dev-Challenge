package Building;

public class ElixirStorage extends Storage{
    public ElixirStorage(int initialResource, int initialLimit) {
        super(initialResource, initialLimit);
    }
    public String getType() {
        return "ElixirStorage";
    }
    public String getReport() {
        return "ElixirStorage: lv" + this.getLevel();
    }

    public String getResourceReport() {
        return "Elixir: " + this.getResource() + "/" + this.getLimitResource();
    }
}
