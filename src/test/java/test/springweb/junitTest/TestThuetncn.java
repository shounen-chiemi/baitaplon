package test.springweb.junitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.springweb.entity2.Thuetncn;
import test.springweb.service.ThueTNCNService;

import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TestThuetncn {
    @Autowired
    ThueTNCNService thueTNCNService;

    //kiểm tra số lượng thuế TNCN so với trong database
    @Test
    public void KiemtraSoLuongThueTNCN()
    {
        List<Thuetncn> ds = thueTNCNService.getDsTheloaiThueTNCN();
        int size = ds.size();
        Assert.assertEquals("test",9,size);
    }
    //kiểm tra danh sách thuế TNCN có tồn tại
    @Test
    public void KiemtraDanhsachThueTNCNCoTonTai()
    {
        List<Thuetncn> ds = thueTNCNService.getDsTheloaiThueTNCN();
        Assert.assertNotNull(ds);
    }
    //kiểm tra tên của thuế TNCN lấy theo id thuế TNCN có giống trong database không
    @Test
    public void KiemtraTenThueTNCN()
    {
        String ten = thueTNCNService.getTenThueTNCNtheoID(1);
        Assert.assertEquals("test","từ hoạt động kinh doanh",ten);
    }
    //kiểm tra tên của thuế TNCN lấy theo id thuế TNCN có tồn tại trong database
    @Test
    public void KiemtraTenThueTNCNLayTheoIDDung()
    {
        String ten = thueTNCNService.getTenThueTNCNtheoID(1);
        Assert.assertNotNull(ten);
    }
    //kiểm tra tên của thuế TNCN lấy theo id thuế TNCN không tồn tại trong database
    @Test
    public void KiemtraTenThueTNCNLayTheoIDSai()
    {
        String ten = thueTNCNService.getTenThueTNCNtheoID(0);
        Assert.assertNull(ten);
    }

}
