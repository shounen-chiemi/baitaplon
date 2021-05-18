package test.springweb.dto;

import test.springweb.entity2.Baocaothue;
import test.springweb.entity2.Thuetncn;

import java.util.ArrayList;
import java.util.List;

public class ChitietthuesuatDTO {
    private int id;
    private String tenmuc;
    private float thuesuat;
    private Thuetncn thuetncn;
    private List<Baocaothue> list_baocaothue = new ArrayList<>();

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

    public Thuetncn getThuetncn() {
        return thuetncn;
    }

    public void setThuetncn(Thuetncn thuetncn) {
        this.thuetncn = thuetncn;
    }

    public List<Baocaothue> getList_baocaothue() {
        return list_baocaothue;
    }

    public void setList_baocaothue(List<Baocaothue> list_baocaothue) {
        this.list_baocaothue = list_baocaothue;
    }
}
