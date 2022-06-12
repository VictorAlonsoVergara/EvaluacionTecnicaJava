package com.beer.ingerencia.model;
import java.util.List;

public class Method {
    private List<Temp> mash_temp;
    private Temp fermentation;
    private String twist;

    public Method() {
    }

    public Method(List<Temp> mash_temp, Temp fermentation, String twist) {
        this.mash_temp = mash_temp;
        this.fermentation = fermentation;
        this.twist = twist;
    }

    public List<Temp> getMash_temp() {
        return mash_temp;
    }

    public void setMash_temp(List<Temp> mash_temp) {
        this.mash_temp = mash_temp;
    }

    public Temp getFermentation() {
        return fermentation;
    }

    public void setFermentation(Temp fermentation) {
        this.fermentation = fermentation;
    }

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }
}
