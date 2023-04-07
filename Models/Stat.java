package Models;

public class Stat {
    private int base;
    private int mod;
    private int current;

    public Stat(Stats stat, int base) {
        this.base = base;
        this.mod = 0;
        updateCurrent();
    }

    public void setBase(int value) {
        this.base = value;
    }
    public void setMod(int mod) {
        this.mod = mod;
        updateCurrent();
    }
    public void updateCurrent() {
        this.current = this.base + this.mod;
    }

    public int getBase() {
        return base;
    }
    public int getMod() {
        return mod;
    }
    public int getCurrent() {
        return current;
    }
}
