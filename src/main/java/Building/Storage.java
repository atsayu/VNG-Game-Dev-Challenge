package Building;

public abstract class Storage extends Building{
    public static final int INITIAL_LIMIT = 1000;
    public static final int LIMIT_INCREASE = 1000;
    public static final int INITIAL_INCREASE_AMOUNT = 10;

    private int resource;
    private int limitResource;
    public Storage(int initialResource, int limitResource) {
        super();
        this.resource = initialResource;
        this.limitResource = limitResource;
    }

    public int getLimitResource() {
        return limitResource;
    }

    public void setLimitResource(int limitResource) {
        this.limitResource = limitResource;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public void increaseResource(int increaseAmount) {

        resource += increaseAmount;
        if (resource >= limitResource) {
            resource = limitResource;
        }
    }

    public void decreaseResource(int decreaseAmount) {
        resource -= decreaseAmount;
        if (resource < 0) resource = 0;
    }

    public abstract String getResourceReport();



}
