package org.styleru.the6hands.domain.entities;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.List;

import io.reactivex.annotations.Nullable;


@Parcel(Parcel.Serialization.BEAN)
public class Apartment {
    private int  id;
    private int price;
    private int numberOfMeters;
    private int livingSpace;
    private int numberOfRooms;
    private int kitchen;
    private int ceilingHeight;
    private int floor;
    private int numberOfFloorsInBuilding;
    private int numberOfBalconies;
    private int numberOfLoggias;
    private int idUser;
    private int metroBranch;
    private String metroStation;
    private String address;
    private List<Image> images;
    private List<Facilities> facilities;


    @ParcelConstructor
    public Apartment(int id, String address, int numberOfRooms, int numberOfMeters, int livingSpace,
                     int kitchen, int ceilingHeight, int floor, int numberOfFloorsInBuilding,
                     int numberOfBalconies, int numberOfLoggias, int price, int idUser,
                     @Nullable List<Image> images, @Nullable List<Facilities> facilities,
                     int metroBranch,
                     String metroStation){
        this.id = id;
        this.address = address;
        this.facilities = facilities;
        this.metroBranch = metroBranch;
        this.metroStation = metroStation;
        this.numberOfRooms = numberOfRooms;
        this.numberOfMeters = numberOfMeters;
        this.livingSpace = livingSpace;
        this.kitchen = kitchen;
        this.ceilingHeight = ceilingHeight;
        this.floor = floor;
        this.numberOfFloorsInBuilding = numberOfFloorsInBuilding;
        this.numberOfBalconies = numberOfBalconies;
        this.numberOfLoggias = numberOfLoggias;
        this.price = price;
        this.idUser = idUser;
        this.images = images;
    }


    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfMeters() {
        return numberOfMeters;
    }

    public void setNumberOfMeters(int numberOfMeters) {
        this.numberOfMeters = numberOfMeters;
    }

    public int getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(int livingSpace) {
        this.livingSpace = livingSpace;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getCeilingHeight() {
        return ceilingHeight;
    }

    public void setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfFloorsInBuilding() {
        return numberOfFloorsInBuilding;
    }

    public void setNumberOfFloorsInBuilding(int numberOfFloorsInBuilding) {
        this.numberOfFloorsInBuilding = numberOfFloorsInBuilding;
    }

    public int getNumberOfBalconies() {
        return numberOfBalconies;
    }

    public void setNumberOfBalconies(int numberOfBalconies) {
        this.numberOfBalconies = numberOfBalconies;
    }

    public int getNumberOfLoggias() {
        return numberOfLoggias;
    }

    public void setNumberOfLoggias(int numberOfLoggias) {
        this.numberOfLoggias = numberOfLoggias;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getMetroBranch() {
        return metroBranch;
    }

    public void setMetroBranch(int metroBranch) {
        this.metroBranch = metroBranch;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public List<Facilities> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facilities> facilities) {
        this.facilities = facilities;
    }
}
