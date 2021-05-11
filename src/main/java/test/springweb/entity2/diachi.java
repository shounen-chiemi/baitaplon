package test.springweb.entity2;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diachi")
public class diachi {
    @Id
    private int id;
    @Column(name = "sonha")
    private String sonha;
    @Column(name = "phuong")
    private String phuong;
    @Column(name = "quan")
    private String quan;
    @Column(name = "thanhpho")
    private String thanhpho;

    @OneToMany(mappedBy = "diachi")
    private List<nhanvien> list_nhanvien = new ArrayList<>();

    @OneToMany(mappedBy = "diachi")
    private List<nguoidongthue> list_nguoidongthue = new ArrayList<>();

    public List<nhanvien> getList_nhanvien() {
        return list_nhanvien;
    }

    public void setList_nhanvien(List<nhanvien> list_nhanvien) {
        this.list_nhanvien = list_nhanvien;
    }

    public List<nguoidongthue> getList_nguoidongthue() {
        return list_nguoidongthue;
    }

    public void setList_nguoidongthue(List<nguoidongthue> list_nguoidongthue) {
        this.list_nguoidongthue = list_nguoidongthue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSonha() {
        return sonha;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }
}
