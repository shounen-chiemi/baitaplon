package test.springweb.entity2;

import javax.persistence.*;

@Entity
@Table(name = "thanhvien")
public class thanhvien {
    @Id
    private int id;
    @Column(name = "taikhoan")
    private String taikhoan;
    @Column(name = "matkhau")
    private String matkhau;
    @Column(name = "chucvu")
    private String chucvu;

    @OneToOne
    @JoinColumn(name="NhanvienID")
    private nhanvien nhanvien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public test.springweb.entity2.nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(test.springweb.entity2.nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }
}
