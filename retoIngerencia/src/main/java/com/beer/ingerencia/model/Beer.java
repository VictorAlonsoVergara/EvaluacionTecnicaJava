package com.beer.ingerencia.model;

import java.util.List;

public class Beer {
    private Integer idBeer;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private Double abv;
    private Double ibu;
    private Double target_fg;
    private Double target_og;
    private Double ebc;
    private Double srm;
    private Double ph;
    private Double attenuation_level;
    private Data volume;
    private Data boil_volume;
    private Method method;
    private Ingredient ingredients;
    private List<String> food_pairing;
    private String brewers_tips;
    private String contributed_by;

    public Beer() {
    }

    public Beer(Integer idBeer, String name, String tagline, String first_brewed, String description, String image_url, Double abv, Double ibu, Double target_fg, Double target_og, Double ebc, Double srm, Double ph, Double attenuation_level, Data volume, Data boil_volume, Method method, Ingredient ingredients, List<String> food_pairing, String brewers_tips, String contributed_by) {
        this.idBeer = idBeer;
        this.name = name;
        this.tagline = tagline;
        this.first_brewed = first_brewed;
        this.description = description;
        this.image_url = image_url;
        this.abv = abv;
        this.ibu = ibu;
        this.target_fg = target_fg;
        this.target_og = target_og;
        this.ebc = ebc;
        this.srm = srm;
        this.ph = ph;
        this.attenuation_level = attenuation_level;
        this.volume = volume;
        this.boil_volume = boil_volume;
        this.method = method;
        this.ingredients = ingredients;
        this.food_pairing = food_pairing;
        this.brewers_tips = brewers_tips;
        this.contributed_by = contributed_by;
    }

    public Integer getIdBeer() {
        return idBeer;
    }

    public void setIdBeer(Integer idBeer) {
        this.idBeer = idBeer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getTarget_fg() {
        return target_fg;
    }

    public void setTarget_fg(Double target_fg) {
        this.target_fg = target_fg;
    }

    public Double getTarget_og() {
        return target_og;
    }

    public void setTarget_og(Double target_og) {
        this.target_og = target_og;
    }

    public Double getEbc() {
        return ebc;
    }

    public void setEbc(Double ebc) {
        this.ebc = ebc;
    }

    public Double getSrm() {
        return srm;
    }

    public void setSrm(Double srm) {
        this.srm = srm;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getAttenuation_level() {
        return attenuation_level;
    }

    public void setAttenuation_level(Double attenuation_level) {
        this.attenuation_level = attenuation_level;
    }

    public Data getVolume() {
        return volume;
    }

    public void setVolume(Data volume) {
        this.volume = volume;
    }

    public Data getBoil_volume() {
        return boil_volume;
    }

    public void setBoil_volume(Data boil_volume) {
        this.boil_volume = boil_volume;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(List<String> food_pairing) {
        this.food_pairing = food_pairing;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    public String getContributed_by() {
        return contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }
}
