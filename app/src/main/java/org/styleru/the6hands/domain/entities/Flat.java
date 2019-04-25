package org.styleru.the6hands.domain.entities;

import org.parceler.ParcelConstructor;

public class Flat {
    private int price;
    private int flatPhotoUrl;
    private int numberRooms;
    private int numberBrowsings;
    private int numberNewBrowsings;
    private int metroBranchColor;
    private String metroStation;

    @ParcelConstructor
    public Flat(int price, int numberRooms, int numberBrowsings, int numberNewBrowsings, String metroStation,
                int metroBranchColor, int flatPhotoUrl){
        this.price = price;
        this.numberRooms = numberRooms;
        this.numberBrowsings = numberBrowsings;
        this.numberNewBrowsings = numberNewBrowsings;
        this.metroBranchColor = metroBranchColor;
        this.metroStation = metroStation;
        this.flatPhotoUrl = flatPhotoUrl;
    }

    public void setFlatPhotoUrl(int flatPhotoUrl) {
        this.flatPhotoUrl = flatPhotoUrl;
    }

    public void setMetroBranchColor(int metroBranchColor) {
        this.metroBranchColor = metroBranchColor;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public void setNumberBrowsings(int numberBrowsings) {
        this.numberBrowsings = numberBrowsings;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumberNewBrowsings(int numberNewBrowsings) {
        this.numberNewBrowsings = numberNewBrowsings;
    }

    public int getNumberNewBrowsings() {
        return numberNewBrowsings;
    }

    public int getNumberBrowsings() {
        return numberBrowsings;
    }

    public int getFlatPhotoUrl() {
        return flatPhotoUrl;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public int getPrice() {
        return price;
    }

    public int getMetroBranchColor() {
        return metroBranchColor;
    }

    public String getMetroStation() {
        return metroStation;
    }
}
