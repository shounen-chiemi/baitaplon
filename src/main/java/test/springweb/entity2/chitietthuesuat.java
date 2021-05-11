package test.springweb.entity2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chitietthuesuat")
public class chitietthuesuat {
    @Id
    private int id;
    @Column(name = "tenmuc")
    private String tenmuc;
    @Column(name = "thuesuat")
    private float thuesuat;

    @ManyToOne
    @JoinColumn(name = "ThueTNCNID")
    private thuetncn thuetncn;

    @OneToMany(mappedBy = "chitietthuesuat")
    private List<baocaothue> list_baocaothue = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmuc() {
        return tenmuc;
    }

    public void setTenmuc(String tenmuc) {
        this.tenmuc = tenmuc;
    }

    public float getThuesuat() {
        return thuesuat;
    }

    public void setThuesuat(float thuesuat) {
        this.thuesuat = thuesuat;
    }

    public test.springweb.entity2.thuetncn getThuetncn() {
        return thuetncn;
    }

    public void setThuetncn(test.springweb.entity2.thuetncn thuetncn) {
        this.thuetncn = thuetncn;
    }

    public List<baocaothue> getList_baocaothue() {
        return list_baocaothue;
    }

    public void setList_baocaothue(List<baocaothue> list_baocaothue) {
        this.list_baocaothue = list_baocaothue;
    }
}
