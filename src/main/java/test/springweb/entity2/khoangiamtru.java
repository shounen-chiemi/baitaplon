package test.springweb.entity2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "khoangiamtru")
public class khoangiamtru {
    @Id
    private int id;
    @Column(name = "tenmucgiamtru")
    private String tenmucgiamtru;
    @Column(name = "mucgiamtru")
    private int mucgiamtru;
    @Column(name = "ngaycapnhat")
    private Date ngaycapnhat;

    @ManyToMany(mappedBy = "list_khoangiamtru")
//    @JoinTable(name = "baocaothue_khoangiamtru",
//            joinColumns = @JoinColumn(name = "KhoangiamtryID"),
//            inverseJoinColumns = @JoinColumn(name = "BaocaothueID")
//    )
    private List<baocaothue> list_baocaothue = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmucgiamtru() {
        return tenmucgiamtru;
    }

    public void setTenmucgiamtru(String tenmucgiamtru) {
        this.tenmucgiamtru = tenmucgiamtru;
    }

    public int getMucgiamtru() {
        return mucgiamtru;
    }

    public void setMucgiamtru(int mucgiamtru) {
        this.mucgiamtru = mucgiamtru;
    }

    public Date getNgaycapnhat() {
        return ngaycapnhat;
    }

    public void setNgaycapnhat(Date ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }

    public List<baocaothue> getList_baocaothue() {
        return list_baocaothue;
    }

    public void setList_baocaothue(List<baocaothue> list_baocaothue) {
        this.list_baocaothue = list_baocaothue;
    }
}
