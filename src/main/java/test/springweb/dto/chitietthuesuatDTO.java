package test.springweb.dto;

import test.springweb.entity2.baocaothue;
import test.springweb.entity2.thuetncn;

import java.util.ArrayList;
import java.util.List;

public class chitietthuesuatDTO {
    private int id;
    private String tenmuc;
    private float thuesuat;
    private thuetncn thuetncn;
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
