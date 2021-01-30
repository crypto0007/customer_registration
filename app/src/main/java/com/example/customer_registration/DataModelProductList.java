package com.example.customer_registration;

public class DataModelProductList {

    String tvprtlitnamej, tvprtlitdatej, prtlitmodelj, prtlitinnoj, prtlitsrlnoj;
    int id_;

    public DataModelProductList(String tvprtlitnamej, String tvprtlitdatej, String prtlitmodelj, String prtlitinnoj, String prtlitsrlnoj, Integer id_) {
        this.tvprtlitnamej = tvprtlitnamej;
        this.tvprtlitdatej = tvprtlitdatej;
        this.prtlitmodelj = prtlitmodelj;
        this.prtlitinnoj = prtlitinnoj;
        this.prtlitsrlnoj = prtlitsrlnoj;
        this.id_ = id_;
    }

    public String getprtlitname() {
        return tvprtlitnamej;
    }

    public String getprtlitdate() {
        return tvprtlitdatej;
    }

    public String getprtlitmodel() {
        return prtlitmodelj;
    }

    public String getprtlitinno() {
        return prtlitinnoj;
    }

    public String getprtlitsrlno() {
        return prtlitsrlnoj;
    }
}
