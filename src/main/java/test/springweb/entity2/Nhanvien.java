package test.springweb.entity2;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class Nhanvien {
    @Id
    private int id;
    @Column(name = "ho")
    private String ho;
    @Column(name = "tendem")
    private String tendem;
    @Column(name = "ten")
    private String ten;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "DiachiID")
    private Diachi diachi;

    @OneToOne(mappedBy = "nhanvien")
    private Thanhvien thanhvien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTendem() {
        return tendem;
    }

    public void setTendem(String tendem) {
        this.tendem = tendem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Diachi getDiachi() {
        return diachi;
    }

    public void setDiachi(Diachi diachi) {
        this.diachi = diachi;
    }

    public Thanhvien getThanhvien() {
        return thanhvien;
    }

    public void setThanhvien(Thanhvien thanhvien) {
        this.thanhvien = thanhvien;
    }
}
