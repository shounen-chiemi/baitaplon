package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.springweb.entity2.*;
public interface thanhvienRepository  extends JpaRepository<thanhvien,Integer> {

    @Query(value = "select * from thanhvien where taikhoan = ?1 and matkhau = ?2", nativeQuery = true)
    public thanhvien getUsertheoTKvaMK(String tk,String mk);

//    thanhvien findthanhvienByTaikhoanAndMatkhau(String taikhoan,String matkhau);

    @Query(value = "select * from thanhvien tv where tv.id = ?1", nativeQuery = true)
    public thanhvien getThanhvientheoId(int id);
}
