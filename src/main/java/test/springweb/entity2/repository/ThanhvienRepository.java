package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;
@Repository
public interface ThanhvienRepository extends JpaRepository<Thanhvien,Integer> {

    @Query(value = "select * from thanhvien where taikhoan = ?1 and matkhau = ?2", nativeQuery = true)
    public Thanhvien getThanhvienTheoTaiKhoanVaMatKhau(String tk, String mk);

//    thanhvien findthanhvienByTaikhoanAndMatkhau(String taikhoan,String matkhau);

    @Query(value = "select * from thanhvien tv where tv.id = ?1", nativeQuery = true)
    public Thanhvien getThanhvientheoId(int id);
}
