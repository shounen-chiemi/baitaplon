package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.repository.ThanhvienRepository;
import test.springweb.entity2.Thanhvien;

@Service
public class ThanhvienService {
    @Autowired
    ThanhvienRepository tvres;

    public Thanhvien login(String taikhoan, String matkhau)
    {
        Thanhvien thanhvien = tvres.getThanhvienTheoTaiKhoanVaMatKhau(taikhoan,matkhau);
        return thanhvien;
    }
//    public boolean checklogin(String taikhoan,String matkhau)
//    {
//        thanhvien thanhvien = tvres.getThanhvienTheoTaiKhoanVaMatKhau(taikhoan,matkhau);
//        if(Objects.nonNull(thanhvien))
//        {
//            return true;
//        }
//        return false;
//    }

    public Thanhvien getThanhvien(int id)
    {
        return tvres.getThanhvientheoId(id);
    }
    public Thanhvien getThanhvien(String tk, String mk)
    {
        Thanhvien tv = tvres.getThanhvienTheoTaiKhoanVaMatKhau(tk,mk);
        return tv;
    }

    public boolean checkadmin(String chucvu)
    {
        if(chucvu.equals("admin"))
        {
            return  true;
        }
        return false;
    }

}
