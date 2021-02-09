package e4;

public enum LightColor {
    VERDE("GREEN",16), AMBAR("AMBER",6), ROJO("RED", 22);
    private String name;
    private int time;

    LightColor(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

}
