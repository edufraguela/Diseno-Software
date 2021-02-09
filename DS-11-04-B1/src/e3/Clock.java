package e3;

import java.time.Period;

public class Clock {
    //Atributos
    private int h, m, s;

    //Enumerados
    public enum Period {AM, PM}

    public Period p;

    //Objetos
    public Clock(String s){
        String[] tiempo = s.split(":| ");

        this.h = Integer.parseInt(tiempo[0]);
        this.m = Integer.parseInt(tiempo[1]);
        this.s = Integer.parseInt(tiempo[2]);

        if(tiempo.length > 3){

            if(tiempo[3].equals(Period.AM.toString())){
                this.p = Period.AM;
            }

            if(tiempo[3].equals(Period.PM.toString())){
                this.p = Period.PM;
            }

            if(!tiempo[3].equals(Period.AM.toString()) && !tiempo[3].equals(Period.PM.toString())){
                throw new IllegalArgumentException(("Problema"));
            }
        }

        if(this.h > 23 || this.m > 59 || this.s > 59){
            throw new IllegalArgumentException("Problema1");
        }

    }

    public Clock(int hours, int minutes, int seconds){
        this.h = hours;
        this.m = minutes;
        this.s = seconds;

        if(this.h > 23 || this.m > 59 || this.s > 59){
            throw new IllegalArgumentException("Problema2");
        }
    }

    public Clock(int hours, int minutes, int seconds, Period period) {
        if(hours > 12 || minutes > 59 || seconds > 59){
            throw new IllegalArgumentException("Problema3");
        }
        if(!period.equals(Period.AM)  && !period.equals(Period.PM)){
            throw new IllegalArgumentException("Problema4");
        }

        if(hours == 12){
            this.h = 0;
        }

        this.h = hours;
        this.m = minutes;
        this.s = seconds;
        this.p = period;
    }

    public int getHours24(){

        if(this.p == Period.PM){
            this.h += 12;
        }
        if(this.p == Period.AM && this.h == 12){
            this.h = 0;
        }
        return this.h;
    }

    public int getHours12(){
        if(this.p == null){
            if(this.h >= 12){
                this.p = Period.PM;
                this.h -= 12;
            } else {
                this.p = Period.AM;
            }
        }
        return this.h;
    }

    public int getMinutes(){
        return this.m;
    }

    public int getSeconds(){
        return this.s;
    }

    public Period getPeriod(){
        if(this.p != null) return this.p;
        else {
            if (this.h > 12) {
                return Period.PM;
            } else return Period.AM;
        }
    }

    public String printHour24(){
        String tiempo;

        getHours24();
        tiempo = String.format("%02d:%02d:%02d", this.h, this.m, this.s);

        return tiempo;
    }

    public String printHour12(){
        String tiempo;

        getHours12();
        tiempo = String.format("%02d:%02d:%02d %s", this.h, this.m, this.s, this.p.toString());

        return tiempo;
    }

    @Override
    public boolean equals(Object o){
        Clock clk = (Clock) o;
        
        if (clk == null) {
            return false;
        } else {
            if (this.p == null && clk.p != null) {
                this.h = this.getHours12();
            }
            if(this.p != null && clk.p == null){
                clk.h = clk.getHours12();
            }
            return  this.h == clk.h && this.m == clk.m && this.s == clk.s && this.p == clk.p;
        }
    }

    @Override
    public int hashCode() {
        int resultado;

        this.h = this.getHours24();
        this.p = this.getPeriod();
        resultado = this.h * 31 + this.m * 31 + this.s * 31 + this.p.hashCode();

        return resultado;
    }
}