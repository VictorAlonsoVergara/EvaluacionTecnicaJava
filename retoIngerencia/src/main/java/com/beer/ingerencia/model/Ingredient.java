package com.beer.ingerencia.model;
import java.util.List;

public class Ingredient {
    private List<Information> malt;
    private List<Information> hops;
    private String yeast;

    public Ingredient() {
    }

    public Ingredient(List<Information> malt, List<Information> hops, String yeast) {
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
    }

    public List<Information> getMalt() {
        return malt;
    }

    public void setMalt(List<Information> malt) {
        this.malt = malt;
    }

    public List<Information> getHops() {
        return hops;
    }

    public void setHops(List<Information> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
}
