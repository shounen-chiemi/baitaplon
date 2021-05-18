package test.springweb.dto;

import test.springweb.entity2.Chitietthuesuat;
import test.springweb.entity2.Khoangiamtru;
import test.springweb.entity2.Nguoidongthue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaocaothueDTO {
    private int id;
    private String loaithue;
    private float tnct;
    private Date ngaynop;
    private String tinhtrang;
    private int songuoiphuthuoc;
    private Chitietthuesuat chitietthuesuat;
    private int tongtien;
    private Nguoidongthue nguoidongthue;
    private List<Khoangiamtru> list_khoangiamtru = new ArrayList<>();


    public BaocaothueDTO()
    {

    }

    public int getTNCT()
    {
        return (int)this.tnct;
    }

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

    public Chitietthuesuat getChitietthuesuat() {
        return chitietthuesuat;
    }

    public void setChitietthuesuat(Chitietthuesuat chitietthuesuat) {
        this.chitietthuesuat = chitietthuesuat;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public Nguoidongthue getNguoidongthue() {
        return nguoidongthue;
    }

    public void setNguoidongthue(Nguoidongthue nguoidongthue) {
        this.nguoidongthue = nguoidongthue;
    }

    public List<Khoangiamtru> getList_khoangiamtru() {
        return list_khoangiamtru;
    }

    public void setList_khoangiamtru(List<Khoangiamtru> list_khoangiamtru) {
        this.list_khoangiamtru = list_khoangiamtru;
    }

    public String getDiachi()
    {
        return this.getNguoidongthue().getDiachi().getSonha() + " " + this.getNguoidongthue().getDiachi().getPhuong() + " " + this.getNguoidongthue().getDiachi().getQuan() + " " + this.getNguoidongthue().getDiachi().getThanhpho();
    }
}
