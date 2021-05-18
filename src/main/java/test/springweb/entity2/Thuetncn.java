package test.springweb.entity2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="thuetncn")
public class Thuetncn {
    @Id
    private int id;
    @Column(name = "loaithuetncn")
    private String loaithuetncn;

    @OneToMany(mappedBy = "thuetncn")
    private List<Chitietthuesuat> list_chitietthuesuat = new ArrayList<>();

    public void setList_chitietthuesuat(List<Chitietthuesuat> list_chitietthuesuat) {
        this.list_chitietthuesuat = list_chitietthuesuat;
    }

    public List<Chitietthuesuat> getList_chitietthuesuat() {
        return list_chitietthuesuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaithuetncn() {
        return loaithuetncn;
    }

    public void setLoaithuetncn(String loaithuetncn) {
        this.loaithuetncn = loaithuetncn;
    }
}
