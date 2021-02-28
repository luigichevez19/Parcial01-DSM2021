package com.local.ejercicio3;

import android.os.Parcel;
import android.os.Parcelable;

public class emp /*implements Parcelable*/ {
    public String nombre;
    public String apel;
    public String cargo;
    public int horas;

    public emp(String n, String a, String c, int h){
        nombre = n;
        apel = a;
        cargo = c;
        horas = h;
    }
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(horas);
//        dest.writeString(nombre);
//        dest.writeString(apel);
//        dest.writeString(cargo);
//    }
}
