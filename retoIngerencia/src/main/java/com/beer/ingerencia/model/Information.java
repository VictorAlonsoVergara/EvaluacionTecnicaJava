package com.beer.ingerencia.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Information {
    private String name;
    private Data amount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String add;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String attribute;

    public Information() {
    }

    public Information(String name, Data amount, String add, String attribute) {
        this.name = name;
        this.amount = amount;
        this.add = add;
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getAmount() {
        return amount;
    }

    public void setAmount(Data amount) {
        this.amount = amount;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
