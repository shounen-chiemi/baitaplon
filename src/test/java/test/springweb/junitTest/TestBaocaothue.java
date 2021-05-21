package test.springweb.junitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import test.springweb.dto.BaocaothueDTO;
import test.springweb.entity2.Baocaothue;
import test.springweb.entity2.Thongke;
import test.springweb.entity2.repository.BaocaothueRepository;
import test.springweb.service.BaocaothueService;

import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class TestBaocaothue {
    @Autowired
    BaocaothueService baocaothueService;
    @Autowired
    BaocaothueRepository baocaothueRepository;
    //kiểm tra báo cáo thuế có tồn tại khi lấy theo id trong database
    @Test
    public void KiemTraBaoCaoThueLayTheoIDTonTai()
    {
        BaocaothueDTO baocaothueDTO = baocaothueService.getBaocaothueTheoId(1);
        Assert.assertNotNull(baocaothueDTO);
    }
    //kiểm tra báo cáo thuế không tồn tại khi lấy theo id không có trong database
    @Test
    public void KiemTraBaoCaoThueLayTheoIDKhongTonTai()
    {
        BaocaothueDTO baocaothueDTO = baocaothueService.getBaocaothueTheoId(0);
        Assert.assertNull(baocaothueDTO);
    }
    //kiểm tra tính tổng tiền nộp thuế trong 1 báo cáo thuế lấy trong database từ id báo cáo thuế
    @Test
    public void KiemTraTinhToanTongTienNopThueCuaMotBaoCaoThue()
    {
        Baocaothue baocaothue = baocaothueRepository.getBaocaothueTheoId(1);
        int tong = baocaothueService.tinhTiennop(baocaothue);
        //Áp dụng công thức tính tiền thu nhập báo cáo thuế, tính tay được tổng tiền của báo cáo thuế id 1 là 45000
        Assert.assertEquals(45000,tong);
    }
    //kiểm tra tính tổng tiền nộp thuế trong 1 báo cáo thuế không có trong database
    @Test
    public void KiemTraTinhToanTongTienNopThueCuaMotBaoCaoThueKhongTonTai()
    {
        Baocaothue baocaothue = baocaothueRepository.getBaocaothueTheoId(0);
        int tong = baocaothueService.tinhTiennop(baocaothue);
        //Áp dụng công thức tính tiền thu nhập báo cáo thuế, tính tay được tổng tiền của báo cáo thuế id 1 là 45000
        Assert.assertEquals(0,tong);
    }
    //kiểm tra lấy danh sách báo cáo thuế có tồn tại, trang hiện tại là 0 và số dữ liệu tại 1 trang là 5
    @Test
    public void KiemTraDanhSachBaoCaoThue1()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothue(pageable);
        Assert.assertNotNull(ds);
    }
    //kiểm tra lấy danh sách báo cáo thuế có tồn tại, trang hiện tại là -1 và số dữ liệu tại 1 trang là 5
    @Test
    public void KiemTraDanhSachBaoCaoThue2()
    {
        int tranghientai = -1;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothue(pageable);
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra lấy danh sách báo cáo thuế có tồn tại, trang hiện tại là 0 và số dữ liệu tại 1 trang là 0
    @Test
    public void KiemTraDanhSachBaoCaoThue3()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,0);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothue(pageable);
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra số lượng bản ghi tại 1 trang, ở đây là trang 1
    @Test
    public void KiemTraSoLuongBanGhiTaiTrang1()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothue(pageable);
        Assert.assertEquals(5,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo id Thuế TNCN có tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoIDThueTNCNCoTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothue(pageable,1);
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo id Thuế TNCN không tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoIDThueTNCNKhongTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothue(pageable,0);
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là năm có tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoNamCoTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoNam(pageable,"2020");
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là năm không tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoNamKhongTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoNam(pageable,"2050");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là năm sai định dạng
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoNamSaiDinhDang()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoNam(pageable,"2020abc");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là tháng + năm có tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoThangNamCoTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoThang(pageable,4,2020);
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là tháng + năm không tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoThangNamKhongTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoThang(pageable,13,2020);
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là ngày tháng năm có tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoNgayThangNamCoTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoNgay(pageable,"2020-04-03");
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thời gian là ngày tháng năm không tồn tại
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoNgayThangNamKhongTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoNgay(pageable,"2020-13-13");
        Assert.assertEquals(0,ds.size());
    }

    //kiểm tra danh sách báo cáo thuế lấy theo tên có tồn tại trong csdl
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoTenTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoTen(pageable,"Nguyễn Nhật Minh");
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo tên đệm, tên hoặc họ có tồn tại trong csdl
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoMotPhanTenTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoTen(pageable,"Nguyễn");
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo tên không có tồn tại trong csdl
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoTenKhongTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoTen(pageable,"Vũ Văn Vũ");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo tên có trong csdl có nhiều khoảng trống
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoTenCoKhoangTrong1()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoTen(pageable,"  Nguyễn   Nhật         Minh    ");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo tên không có trong csdl có nhiều khoảng trống
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoTenCoKhoangTrong2()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoTen(pageable,"  Nguyễn   Nhật         Vy    ");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy theo tên sai có chứa cả chữ số
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoTenSaiCuPhap()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoTen(pageable,"Nguyễn  Nhật Minh123");
        Assert.assertEquals(0,ds.size());
    }

    //kiểm tra danh sách báo cáo thuế lấy theo thành phố có tồn tại trong csdl
    @Test
    public void KiemTraDanhSachBaoCaoThueTheoThanhPhoCoTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoTP(pageable,"Hà Nội");
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy theo thành phố không tồn tại trong csdl
    @Test
    public void KiemTraDanhSachBaoCaoThueTheoThanhPhoKhongTonTai()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getDsbaocaothueTheoTP(pageable,"Hòa Bình");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy cmnd có trong csdl
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoCMND1()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoCMND(pageable,"0942216667");
        Assert.assertNotNull(ds);
    }
    //kiểm tra danh sách báo cáo thuế lấy cmnd không có trong csdl
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoCMND2()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoCMND(pageable,"0942216663");
        Assert.assertEquals(0,ds.size());
    }
    //kiểm tra danh sách báo cáo thuế lấy cmnd sai định dạng
    @Test
    public void KiemTraDanhsachBaoCaoThueTheoCMND3()
    {
        int tranghientai = 0;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> ds = baocaothueService.getdsbaocaothueTheoCMND(pageable,"0942216663abc");
        Assert.assertEquals(0,ds.size());
    }

    //kiểm tra thống kê theo tháng lấy theo id thuế TNCN
    @Test
    public void KiemTraThongKeTheoThangCoTonTai1()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoThang(2020,12,1);
        Assert.assertNotNull(thongke);
    }
    //kiểm tra thống kê theo tháng lấy theo id thuế TNCN, thời gian chưa xuất hiện trong db
    @Test
    public void KiemTraThongKeTheoThangCoTonTai2()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoThang(2025,12,1);
        Assert.assertNull(thongke);
    }
    //kiểm tra thống kê theo tháng lấy theo id thuế TNCN không tồn tại
    @Test
    public void KiemTraThongKeTheoThangKhongTonTai()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoThang(2020,12,0);
        Assert.assertNull(thongke);
    }
    //kiểm tra thống kê theo năm lấy theo id thuế TNCN
    @Test
    public void KiemTraThongKeTheoNamVoiIdCoTonTai1()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoNam("2020",1);
        Assert.assertNotNull(thongke);
    }
    //kiểm tra thống kê theo năm lấy theo id thuế TNCN, thời gian chưa xuất hiện trong db
    @Test
    public void KiemTraThongKeTheoNamVoiIdCoTonTai2()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoNam("2025",1);
        Assert.assertNull(thongke);
    }
    //kiểm tra thống kê theo năm lấy theo id thuế TNCN không tồn tại
    @Test
    public void KiemTraThongKeTheoNamVoiIdSai()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoNam("2020",0);
        Assert.assertNull(thongke);
    }
    //kiểm tra thống kê theo năm lấy theo năm sai định dạng
    @Test
    public void KiemTraThongKeTheoNamSaiDinhDang()
    {
        Thongke thongke = baocaothueService.getDsbaocaothueTheoNam("2020abc",1);
        Assert.assertNull(thongke.getTongtiennopthue());
    }

}
