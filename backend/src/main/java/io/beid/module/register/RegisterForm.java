package io.beid.module.register;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterForm {

    public final String citizenId;
    public final String name;
    public final String surName;
    public final String dob;
    public final String laserCode;
    public final Long income;
    public final String email;
    public final String mobileNo;
    public final String lineId;
    public final Integer receiveFrom;

    public final String contactHomeno;
    public final String contactMoo;
    public final String contactBuilding;
    public final String contactSoi;
    public final String contactRoad;
    public final String contactZipcode;
    public final String contactTumbon;
    public final String contactAumphur;
    public final String contactCity;

    public final String docHomeno;
    public final String docMoo;
    public final String docBuilding;
    public final String docSoi;
    public final String docRoad;
    public final String docZipcode;
    public final String docTumbon;
    public final String docAumphur;
    public final String docCity;

    public String contactAddress() {
        return String.join("|"
                , contactHomeno
                , contactMoo
                , contactBuilding
                , contactSoi
                , contactRoad
                , contactZipcode
                , contactTumbon
                , contactAumphur
                , contactCity);
    }

    public String docAddress() {
        return String.join("|"
                , docHomeno
                , docMoo
                , docBuilding
                , docSoi
                , docRoad
                , docZipcode
                , docTumbon
                , docAumphur
                , docCity);
    }

}
