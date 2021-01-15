package com.binitasimbu.week6assignment.Model


import android.os.Parcel
import android.os.Parcelable
class students (

    val studentImg:String?=null,
    val coventryId:Int?=null,
    val studentName:String?= null,
    val studentAddress:String? =null,
    val studentGender: String? =null
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),

            )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(studentImg)
        parcel.writeValue(coventryId)
        parcel.writeValue(studentName)
        parcel.writeString(studentAddress)
        parcel.writeString(studentGender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<students> {
        override fun createFromParcel(parcel: Parcel): students {
            return students(parcel)
        }

        override fun newArray(size: Int): Array<students?> {
            return arrayOfNulls(size)
        }
    }

}