package test.springweb.junitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.springweb.entity2.Thanhvien;
import test.springweb.service.ThanhvienService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TestThanhvien {
    @Autowired
    ThanhvienService thanhvienService;

    //kiểm tra đăng nhập với tài khoản và mật khẩu đều đúng
    @Test
    public void DangNhapVoiTaiKhoanDungVaMatKhauDung()
    {
        Thanhvien thanhvien = null;
        thanhvien = thanhvienService.login("admin1","admin1");
        Assert.assertNotNull(thanhvien);
    }
    //kiểm tra đăng nhập với tài khoản sai và mật khẩu đúng
    @Test
    public void DangNhapVoiTaiKhoanSaiVaMatKhauDung()
    {
        Thanhvien thanhvien = null;
        thanhvien = thanhvienService.login("Taikhoansai","admin1");
        Assert.assertNull(thanhvien);
    }
    //kiểm tra đăng nhập với tài khoản đúng và mật khẩu sai
    @Test
    public void DangNhapVoiTaiKhoanDungVaMatKhauSai()
    {
        Thanhvien thanhvien = null;
        thanhvien = thanhvienService.login("admin1","Matkhausai");
        Assert.assertNull(thanhvien);
    }
    //kiểm tra đăng nhập với tài khoản và mật khẩu đều sai
    @Test
    public void DangNhapVoiTaiKhoanSaiVaMatKhauSai()
    {
        Thanhvien thanhvien = null;
        thanhvien = thanhvienService.login("Taikhoansai","Maukhausai");
        Assert.assertNull(thanhvien);
    }
    //kiểm tra thành viên được lấy theo id có trong database
    @Test
    public void LayThanhvienTheoIDDung()
    {
        Thanhvien thanhvien = null;
        thanhvien = thanhvienService.getThanhvien(1);
        Assert.assertNotNull(thanhvien);
    }
    //kiểm tra thành viên được lấy theo id không có trong cơ sở dữ liệu
    @Test
    public void LayThanhvienTheoIDSai()
    {
        Thanhvien thanhvien = null;
        thanhvien = thanhvienService.getThanhvien(0);
        Assert.assertNull(thanhvien);
    }
    //kiểm tra dữ liệu thành viên là đúng khi đăng nhập thành công
    @Test
    public void KiemtraTenThanhvienDungKhiDangnhap()
    {
        Thanhvien thanhvien = null;
        String ten = "";
        thanhvien = thanhvienService.getThanhvien("admin1","admin1");
        ten = ten + thanhvien.getNhanvien().getHo()+ " " + thanhvien.getNhanvien().getTendem() + " " + thanhvien.getNhanvien().getTen();
        Assert.assertEquals("test","Lê Sĩ Hiệp",ten);
    }

}
