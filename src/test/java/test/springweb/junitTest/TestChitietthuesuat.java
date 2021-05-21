package test.springweb.junitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.springweb.entity2.Chitietthuesuat;
import test.springweb.service.ChitietthuesuatService;

import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TestChitietthuesuat {
    @Autowired
    ChitietthuesuatService chitietthuesuatService;

        //kiểm tra danh sách thuế suất lấy theo id Thuế TNCN có tồn tại
    @Test
    public void KiemTraDanhSachThueSuatTheoIDThueTNCNCoTonTai()
    {
        List<Chitietthuesuat> ds = chitietthuesuatService.getDsChitietthuesuatTheoThueTNCNid(1);
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách thuế suất lấy theo id Thuế TNCN không tồn tại
    @Test
    public void KiemTraDanhSachThueSuatTheoIDThueTNCNKhongTonTai()
    {
        List<Chitietthuesuat> ds = chitietthuesuatService.getDsChitietthuesuatTheoThueTNCNid(0);
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra số lượng thuế suất lấy theo id Thuế TNCN
    @Test
    public void KiemTraSoLuongThueSuatTheoIDThueTNCN()
    {
        List<Chitietthuesuat> ds = chitietthuesuatService.getDsChitietthuesuatTheoThueTNCNid(1);
        Assert.assertEquals(4,ds.size());
    }
    //kiểm tra thuế suất lấy theo id có tồn tại
    @Test
    public void KiemTraThueSuatTheoIDCoTonTai()
    {
        Chitietthuesuat chitietthuesuat = chitietthuesuatService.getChitietthuesuat(1);
        Assert.assertNotNull(chitietthuesuat);
    }
    //kiểm tra thuế suất lấy theo id không tồn tại
    @Test
    public void KiemTraThueSuatTheoIDKhongTonTai()
    {
        Chitietthuesuat chitietthuesuat = chitietthuesuatService.getChitietthuesuat(0);
        Assert.assertNull(chitietthuesuat);
    }
    //kiểm tra dữ liệu có giống trong database không
    @Test
    public void KiemTraDuLieuThueSuat()
    {
        Chitietthuesuat chitietthuesuat = chitietthuesuatService.getChitietthuesuat(1);
        Assert.assertEquals("phân phối cung cấp hàng hóa",chitietthuesuat.getTenmuc());
    }

    //kiểm tra cập nhật thuế suất với mức thuế suất khác mức cũ
    @Test
    public void KiemTraCapNhatThueSuat1()
    {
        //lấy dữ liệu thuế suất
        Chitietthuesuat chitietthuesuat = chitietthuesuatService.getChitietthuesuat(1);
        //cố định mức thuế suất ban đầu
        float mucthuesuat = chitietthuesuat.getThuesuat();
        //tạo 1 mức thuế suất mới
        float mucthuesuatmoi = (float) 3;
        //cập nhật thuế suất mới
        chitietthuesuat.setThuesuat(mucthuesuatmoi);
        chitietthuesuatService.capnhatThuesuat(chitietthuesuat);
        Chitietthuesuat chitietthuesuat1 = chitietthuesuatService.getChitietthuesuat(1);
        //tiến hành thiết lập mức thuế suất mới và mức thuế suất đã được cập nhật trong database để so sánh
        String muc1 = "";
        String muc2 = "";
        muc1 = muc1 + mucthuesuatmoi;
        muc2 = muc2 + chitietthuesuat1.getThuesuat();

        //roll back lại dữ liệu
        chitietthuesuat.setThuesuat(mucthuesuat);
        chitietthuesuatService.capnhatThuesuat(chitietthuesuat);

        //so sánh 2 mức thuế suất đã được thiết lập ở trên
        Assert.assertEquals(muc1,muc2);
    }

    //kiểm tra cập nhật thuế suất với mức thuế suất giống mức cũ
    @Test
    public void KiemTraCapNhatThueSuat2()
    {
        //lấy dữ liệu thuế suất
        Chitietthuesuat chitietthuesuat = chitietthuesuatService.getChitietthuesuat(1);
        //cố định mức thuế suất ban đầu
        float mucthuesuat = chitietthuesuat.getThuesuat();
        //tạo 1 mức thuế suất mới
        float mucthuesuatmoi = mucthuesuat;
        //cập nhật thuế suất mới
        chitietthuesuat.setThuesuat(mucthuesuatmoi);
        chitietthuesuatService.capnhatThuesuat(chitietthuesuat);
        Chitietthuesuat chitietthuesuat1 = chitietthuesuatService.getChitietthuesuat(1);
        //tiến hành thiết lập mức thuế suất mới và mức thuế suất đã được cập nhật trong database để so sánh
        String muc1 = "";
        String muc2 = "";
        muc1 = muc1 + mucthuesuatmoi;
        muc2 = muc2 + chitietthuesuat1.getThuesuat();

        //roll back lại dữ liệu
        chitietthuesuat.setThuesuat(mucthuesuat);
        chitietthuesuatService.capnhatThuesuat(chitietthuesuat);

        //so sánh 2 mức thuế suất đã được thiết lập ở trên
        Assert.assertEquals(muc1,muc2);
    }
}
