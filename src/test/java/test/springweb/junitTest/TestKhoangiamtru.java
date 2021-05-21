package test.springweb.junitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.springweb.entity2.Khoangiamtru;
import test.springweb.service.KhoanggiamtruService;

import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TestKhoangiamtru {
    @Autowired
    KhoanggiamtruService khoangiamtruService;

    //kiểm tra danh sách khoản giảm trừ có tồn tại khi lấy từ database
    @Test
    public void KiemTraDanhSachKhoanGiamTruTonTai()
    {
        List<Khoangiamtru> ds = khoangiamtruService.getDskhoangiamtru();
        Assert.assertNotNull(ds);
    }
    //kiểm tra số lượng khoản giảm trừ trong danh sách so với database
    @Test
    public void KiemTraSoLuongKhoanGiamTruTrongDanhSach()
    {
        List<Khoangiamtru> ds = khoangiamtruService.getDskhoangiamtru();
        Assert.assertEquals(2,ds.size());
    }
    //kiểm tra danh sách khoảng giảm trừ lấy theo id báo cáo thuế có tồn tại trong database
    @Test
    public void KiemTraDanhSachKhoanGiamTruCuaBaoCaoThueTonTai()
    {
        List<Khoangiamtru> ds = khoangiamtruService.getDskhoanggiamtru(1);
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách khoảng giảm trừ lấy theo id báo cáo thuế không tồn tại trong database
    @Test
    public void KiemTraDanhSachKhoanGiamTruCuaBaoCaoThueKhongTonTai()
    {
        List<Khoangiamtru> ds = khoangiamtruService.getDskhoanggiamtru(0);
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra số lượng khoản giảm trừ trong danh sách lấy theo id đúng của báo cáo thuế
    @Test
    public void KiemTraSoLuongKhoanGiamTruCuaBaoCaoThue()
    {
        List<Khoangiamtru> ds = khoangiamtruService.getDskhoanggiamtru(1);
        Assert.assertEquals(1,ds.size());
    }
    //kiểm tra khoản giảm trừ lấy theo id có tồn tại trong database
    @Test
    public void KiemTraKhoanGiamTruCoTonTai()
    {
        Khoangiamtru khoangiamtru = khoangiamtruService.getKhoangiamtru(1);
        Assert.assertNotNull(khoangiamtru);
    }
    //kiểm tra khoản giảm trừ lấy theo id không tồn tại trong database
    @Test
    public void KiemTraKhoanGiamTruKhongTonTai()
    {
        Khoangiamtru khoangiamtru = khoangiamtruService.getKhoangiamtru(0);
        Assert.assertNull(khoangiamtru);
    }
    //kiểm tra cập nhật mức giảm trừ với mức giảm trừ mới
    @Test
    public void KiemTraCapNhatMucGiamTruMoi()
    {
        //tạo khoản giảm trừ để test dữ liệu
        Khoangiamtru khoangiamtru1 = khoangiamtruService.getKhoangiamtru(1);
        //lấy dữ liệu ban đầu
        int mucgiamtru = khoangiamtru1.getMucgiamtru();
        khoangiamtru1.setMucgiamtru(30);
        //cập nhật
        khoangiamtruService.capnhatKhoangiamtru(khoangiamtru1);
        //tạo khoản giảm trừ để get dữ liệu từ db ra
        Khoangiamtru khoangiamtru2 = khoangiamtruService.getKhoangiamtru(1);
        Assert.assertEquals(khoangiamtru1.getMucgiamtru(),khoangiamtru2.getMucgiamtru());
        //roll back lại dữ liệu của khoản giảm trừ ban đầu
        khoangiamtru1.setMucgiamtru(mucgiamtru);
        khoangiamtruService.capnhatKhoangiamtru(khoangiamtru1);
    }

    //kiểm tra cập nhật mức giảm trừ với mức giảm trừ cũ
    @Test
    public void KiemTraCapNhatMucGiamTruCu()
    {
        //tạo khoản giảm trừ để test dữ liệu
        Khoangiamtru khoangiamtru1 = khoangiamtruService.getKhoangiamtru(1);
        //lấy dữ liệu ban đầu
        int mucgiamtru = khoangiamtru1.getMucgiamtru();
        int mucgiamtrutest = mucgiamtru;
        khoangiamtru1.setMucgiamtru(mucgiamtrutest);
        //cập nhật
        khoangiamtruService.capnhatKhoangiamtru(khoangiamtru1);
        //tạo khoản giảm trừ để get dữ liệu từ db ra
        Khoangiamtru khoangiamtru2 = khoangiamtruService.getKhoangiamtru(1);
        Assert.assertEquals(khoangiamtru1.getMucgiamtru(),khoangiamtru2.getMucgiamtru());
        //roll back lại dữ liệu của khoản giảm trừ ban đầu
        khoangiamtru1.setMucgiamtru(mucgiamtru);
        khoangiamtruService.capnhatKhoangiamtru(khoangiamtru1);
    }


}

