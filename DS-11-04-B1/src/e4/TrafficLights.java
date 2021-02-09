package e4;

public class TrafficLights {
    private LightColor color;
    private String name;
    private int cont;
    private int firstCont;
    private boolean activated = true;
    private int numberTL;

    public TrafficLights() {
    }

    public TrafficLights(LightColor color, String name, int cont, int numberTL) {
        this.color = color;
        this.name = name;
        this.cont = cont;
        this.firstCont = cont;
        this.numberTL = numberTL;
    }

    public void resetTrafficLight(){
        this.cont = firstCont-1;
        this.activated = true;
        incrementar();
    }

    public LightColor getColor() {
        return color;
    }

    public void setColor(LightColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated() {
        this.activated = false;
        this.color = LightColor.AMBAR;

    }

    public void incrementar (){
        if (activated) {
            this.cont++;
            this.cont %= (LightColor.ROJO.getTime() * this.numberTL);


            if (this.cont < LightColor.VERDE.getTime()) {
                this.color = LightColor.VERDE;
            } else if (this.cont < (LightColor.VERDE.getTime() + LightColor.AMBAR.getTime())) {
                this.color = LightColor.AMBAR;
            } else {
                this.color = LightColor.ROJO;
            }
        }

    }

    @Override
    public String toString(){
        String finalStr = "[" + this.name + ": " + this.color.getName();
        if(this.color.getName().equals(LightColor.VERDE.getName())){
            finalStr += " " + cont;
        }
        else if (this.color.getName().equals(LightColor.AMBAR.getName()) && this.activated){
            finalStr += " OFF " + (cont - LightColor.VERDE.getTime());
        }
        else if (this.color.getName().equals(LightColor.AMBAR.getName())){
            finalStr += " ON";
        }
        finalStr += "]";

        return finalStr;
    }

}

