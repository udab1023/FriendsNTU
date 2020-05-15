package vn.edu.ntu.nguyenngoctien.model;

public class Friends {
    String Name;
    int Sdt;
    String Date;

    public Friends(){

    }

    public Friends(String name, int sdt, String date) {
        this.Name = name;
        this.Sdt = sdt;
        this.Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int sdt) {
        Sdt = sdt;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
