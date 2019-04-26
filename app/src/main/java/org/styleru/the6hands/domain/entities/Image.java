package org.styleru.the6hands.domain.entities;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;


@Parcel(Parcel.Serialization.BEAN)
public class Image {
    private int id;
    private int idUser;
    private int idApartment;
    private String path;

    @ParcelConstructor
    public Image(int id, int idUser, int idApartment, String path){

        this.id = id;
        this.idUser = idUser;
        this.idApartment = idApartment;
        this.path = path;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
