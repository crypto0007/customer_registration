package com.example.customer_registration;

public class DataMaodel {

    String custname, custtype, custcity, custcontact;
    int id_;

    public DataMaodel(String custname, String custtype, String custcity, String custcontact, Integer id_) {
        this.custname = custname;
        this.custtype = custtype;
        this.custcity = custcity;
        this.custcontact = custcontact;
        this.id_ = id_;
    }

    public String getcustnam(){
        return custname;
    }

    public String getcusttype(){
        return custtype;
    }

    public String getcity(){
        return custcity;
    }

    public String getcontact(){
        return custcontact;
    }
}
