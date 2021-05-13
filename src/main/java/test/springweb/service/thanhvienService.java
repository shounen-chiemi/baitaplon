package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.repository.thanhvienRepository;
import test.springweb.entity2.thanhvien;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class thanhvienService {
    @Autowired
    thanhvienRepository tvres;

    public thanhvien login(String taikhoan,String matkhau)
    {
        thanhvien thanhvien = tvres.getUsertheoTKvaMK(taikhoan,matkhau);
        return thanhvien;
    }
    public boolean checklogin(String taikhoan,String matkhau)
    {
        thanhvien thanhvien = tvres.getUsertheoTKvaMK(taikhoan,matkhau);
        if(Objects.nonNull(thanhvien))
        {
            return true;
        }
        return false;
    }

    public thanhvien getThanhvien(int id)
    {
        return tvres.getThanhvientheoId(id);
    }
    public thanhvien getThanhvien(String tk,String mk)
    {
        thanhvien tv = tvres.getUsertheoTKvaMK(tk,mk);
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

    public String pheduyetdangnhap(HttpServletRequest request, String trang)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        return trang;
    }
}
