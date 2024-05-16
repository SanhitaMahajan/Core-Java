package com.app;

public class Pet {
    private int petId;
    private String name;
    private PetCategory category;
    private int unitPrice;
    private int stocks;

    private static int counter = 100;

    public Pet(String name, PetCategory category, int unitPrice, int stocks) {
        counter++;
        this.petId = counter;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", unitPrice=" + unitPrice +
                ", stocks=" + stocks +
                '}';
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
}
