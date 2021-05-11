package test.springweb.entity2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nguoidongthue")
public class nguoidongthue {
    @Id
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "cmnd")
    private String cmnd;
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "DiachiID")
    private diachi diachi;

    @OneToMany(mappedBy = "nguoidongthue")
    private List<baocaothue> list_baocao = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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

    public List<baocaothue> getList_baocao() {
        return list_baocao;
    }

    public void setList_baocao(List<baocaothue> list_baocao) {
        this.list_baocao = list_baocao;
    }
}
