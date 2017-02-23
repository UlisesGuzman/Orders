package mx.edu.utng.orders.model;

import java.util.Date;

/**
 * Created by ulises on 23/02/2017.
 */

public class Title {

    private  String idEmpNo;
    private  String title;
    private String fromDate;
    private  String toDate;

    public Title(String idEmpNo, String title, String fromDate, String toDate) {
        this.idEmpNo = idEmpNo;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Title(){
        this("","","","");
    }

    public void setIdEmpNo(String idEmpNo) {
        this.idEmpNo = idEmpNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getIdEmpNo() {

        return idEmpNo;
    }

    public String getTitle() {
        return title;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "idEmpNo='" + idEmpNo + '\'' +
                ", title='" + title + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
