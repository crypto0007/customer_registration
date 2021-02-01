package com.example.customer_registration;

public class Datamodelsrvhistory {

    String srvhiscust, srvhisdate, srvhisprtname, srvhissrvtype, srvhisreqrmt, srvhiscompdatetime, srvhistechname, srvhicahrge, srvhisremrk;
    int id_;

    public Datamodelsrvhistory(String srvhiscust, String srvhisdate, String srvhisprtname, String srvhissrvtype, String srvhisreqrmt, String srvhiscompdatetime, String srvhistechname, String srvhicahrge, String srvhisremrk, int id_) {
        this.srvhiscust = srvhiscust;
        this.srvhisdate = srvhisdate;
        this.srvhisprtname = srvhisprtname;
        this.srvhissrvtype = srvhissrvtype;
        this.srvhisreqrmt = srvhisreqrmt;
        this.srvhiscompdatetime = srvhiscompdatetime;
        this.srvhistechname = srvhistechname;
        this.srvhicahrge = srvhicahrge;
        this.srvhisremrk = srvhisremrk;
        this.id_ = id_;
    }

    public String getsrvhiscustj() {
        return srvhiscust;
    }

    public String getsrvhisdatej() {
        return srvhisdate;
    }

    public String getsrvhisprtnamej() { return srvhisprtname;
    }

    public String getsrvhissrvtypej() { return srvhissrvtype;
    }

    public String getsrvhisreqrmtj() { return srvhisreqrmt;
    }

    public String getsrvhiscompdatetimej() { return srvhiscompdatetime;
    }

    public String getsrvhistechnamej() { return srvhistechname;
    }

    public String getsrvhicahrgej() { return srvhicahrge;
    }

    public String getsrvhisremrkj() { return srvhisremrk;
    }
}
