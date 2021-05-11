package test.springweb.entity2;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class nhanvien {
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
    private diachi diachi;

    @OneToOne(mappedBy = "nhanvien")
    private thanhvien thanhvien;

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

    public test.springweb.entity2.diachi getDiachi() {
        return diachi;
    }

    public void setDiachi(test.springweb.entity2.diachi diachi) {
        this.diachi = diachi;
    }

    public test.springweb.entity2.thanhvien getThanhvien() {
        return thanhvien;
    }

    public void setThanhvien(test.springweb.entity2.thanhvien thanhvien) {
        this.thanhvien = thanhvien;
    }
}
