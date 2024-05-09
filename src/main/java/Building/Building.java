package Building;

public abstract class Building {
    private int level;
    public Building() {
        this.level = 1;
    }
    public Building(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract String getType();
    public abstract String getReport();
    public String upgrade(int hallLevel) {
        if (this.level == 3) return "Da dat level toi da";
        if (this instanceof MainHall) {
            this.level++;
            if (this.level > 3) {
                this.level = 3;
                return "Maximum level";
            } else {
                return "Nang cap thanh cong: " + this.getType();
            }
        }
        else {
            if (this.level == hallLevel) {
                return "Hay nang cap Town Hall truoc";
            } else {
                this.level++;
                if (this.level > 3) this.level = 3;
                return "Nang cap thanh cong: " + this.getType();
            }
        }


    }
}
