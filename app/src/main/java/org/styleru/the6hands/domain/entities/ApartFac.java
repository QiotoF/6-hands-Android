package org.styleru.the6hands.domain.entities;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;


@Parcel(Parcel.Serialization.BEAN)
public class ApartFac {
    private int id;
    private int idApatment;
    private int idFacility;

    @ParcelConstructor
    public ApartFac(int id, int idFacility, int idApatment){

        this.id = id;
        this.idFacility = idFacility;
        this.idApatment = idApatment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdApatment() {
        return idApatment;
    }

    public void setIdApatment(int idApatment) {
        this.idApatment = idApatment;
    }

    public int getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(int idFacility) {
        this.idFacility = idFacility;
    }
}
