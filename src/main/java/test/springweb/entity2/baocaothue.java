package test.springweb.entity2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "baocaothue")
public class baocaothue {
    @Id
    private int id;

    @Column(name = "loaithue")
    private String loaithue;
    @Column(name = "tnct")
    private float tnct;
    @Column(name = "ngaynop")
    private Date ngaynop;
    @Column(name = "tinhtrang")
    private String tinhtrang;
    @Column(name = "songuoiphuthuoc")
    private int songuoiphuthuoc;
    @ManyToOne
    @JoinColumn(name = "ChitietthuesuatID")
    private chitietthuesuat chitietthuesuat;

    @ManyToOne
    @JoinColumn(name = "NguoidongthueID")
    private nguoidongthue nguoidongthue;

    @ManyToMany
    @JoinTable(name = "baocaothue_khoangiamtru",
            joinColumns = @JoinColumn(name = "BaocaothueID"),
            inverseJoinColumns = @JoinColumn(name = "KhoangiamtryID")
    )
    private List<khoangiamtru> list_khoangiamtru = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaithue() {
        return loaithue;
    }

    public void setLoaithue(String loaithue) {
        this.loaithue = loaithue;
    }

    public float getTnct() {
        return tnct;
    }

    public void setTnct(float tnct) {
        this.tnct = tnct;
    }

    public Date getNgaynop() {
        return ngaynop;
    }

    public void setNgaynop(Date ngaynop) {
        this.ngaynop = ngaynop;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getSonguoiphuthuoc() {
        return songuoiphuthuoc;
    }

    public void setSonguoiphuthuoc(int songuoiphuthuoc) {
        this.songuoiphuthuoc = songuoiphuthuoc;
    }

    public test.springweb.entity2.chitietthuesuat getChitietthuesuat() {
        return chitietthuesuat;
    }

    public void setChitietthuesuat(test.springweb.entity2.chitietthuesuat chitietthuesuat) {
        this.chitietthuesuat = chitietthuesuat;
    }

    public test.springweb.entity2.nguoidongthue getNguoidongthue() {
        return nguoidongthue;
    }

    public void setNguoidongthue(test.springweb.entity2.nguoidongthue nguoidongthue) {
        this.nguoidongthue = nguoidongthue;
    }

    public List<khoangiamtru> getList_khoangiamtru() {
        return list_khoangiamtru;
    }

    public void setList_khoangiamtru(List<khoangiamtru> list_khoangiamtru) {
        this.list_khoangiamtru = list_khoangiamtru;
    }
}
