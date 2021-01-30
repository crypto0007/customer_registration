package com.example.customer_registration;

public class DatamodelSrvRequst {

    String srvrqustcust, srvrqustdate, srvrqustcall, srvrqustAdd, srvrqustInvono, srvrqustserlno, srvrqustserttype, srvrqustsertstat;
    private boolean isShrink = true;
    int id_;

    public DatamodelSrvRequst(String srvrqustcust, String srvrqustdate, String srvrqustcall, String srvrqustAdd, String srvrqustInvono, String srvrqustserlno, String srvrqustserttype, String srvrqustsertstat, Integer id_) {
        this.srvrqustcust = srvrqustcust;
        this.srvrqustdate = srvrqustdate;
        this.srvrqustcall = srvrqustcall;
        this.srvrqustAdd = srvrqustAdd;
        this.srvrqustInvono = srvrqustInvono;
        this.srvrqustserlno = srvrqustserlno;
        this.srvrqustserttype = srvrqustserttype;
        this.srvrqustsertstat = srvrqustsertstat;
        this.id_ = id_;
    }

    public String getsrvrqustcust() {
        return srvrqustcust;
    }

    public String getsrvrqustdate() {
        return srvrqustdate;
    }

    public String getsrvrqustcall() {
        return srvrqustcall;
    }

    public String getsrvrqustAdd() {
        return srvrqustAdd;
    }

    public String getsrvrqustInvono() {
        return srvrqustInvono;
    }

    public String getsrvrqustserlno() {
        return srvrqustserlno;
    }

    public String getsrvrqustserttype() {
        return srvrqustserttype;
    }

    public String getsrvrqustsertstat() {
        return srvrqustsertstat;
    }

    public boolean isShrink() {
        return isShrink;
    }

    public void setShrink(boolean shrink) {
        isShrink = shrink;
    }
}
