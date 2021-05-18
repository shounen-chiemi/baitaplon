package test.springweb.entity2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;

import java.util.List;
@Repository

public interface BaocaothueRepository extends JpaRepository<Baocaothue,Integer> {
    @Query(value = "select * from baocaothue", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothue(Pageable pageable);

    @Query(value = "select baocaothue.* from baocaothue,thuetncn,chitietthuesuat where baocaothue.chitietthuesuatid = chitietthuesuat.id and chitietthuesuat.thuetncnid = thuetncn.id and thuetncn.id=?1", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoIdThueTNCN(Pageable pageable, int id);

    @Query(value = "select * from baocaothue", nativeQuery = true)
    List<Baocaothue> getDsBaocaothue();

    @Query(value = "select * from baocaothue where year(ngaynop)=?1", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoNam(Pageable pageable, String nam);

    @Query(value = "select baocaothue.* from baocaothue,chitietthuesuat where baocaothue.chitietthuesuatid = chitietthuesuat.id and chitietthuesuat.thuetncnid = ?1 and year(baocaothue.ngaynop)=?2", nativeQuery = true)
    List<Baocaothue> getDsBaocaothueTheoNamvaLoaithueTNCN(int idthuetncn, String nam);

    @Query(value = "select * from baocaothue where month(ngaynop)=?1 and year(ngaynop) =?2", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoThang(Pageable pageable, int thang, int nam);

    @Query(value = "select baocaothue.* from baocaothue,chitietthuesuat where baocaothue.chitietthuesuatid = chitietthuesuat.id and chitietthuesuat.thuetncnid = ?1 and month(baocaothue.ngaynop)=?2 and year(baocaothue.ngaynop)=?3", nativeQuery = true)
    List<Baocaothue> getDsBaocaothueTheoThangvaLoaithueTNCN(int idthuetncn, int thang, int nam);

    @Query(value = "select * from baocaothue where ngaynop = ?1", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoNgay(Pageable pageable, String ngay);

    @Query(value = "select baocaothue.* from baocaothue,nguoidongthue,diachi where baocaothue.nguoidongthueid = nguoidongthue.id and nguoidongthue.diachiid = diachi.id and diachi.thanhpho = ?1", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoTP(Pageable pageable, String tp);

    @Query(value = "select * from baocaothue where id = ?1", nativeQuery = true)
    Baocaothue getBaocaothueTheoId(int id);

    @Query(value = "select baocaothue.* from baocaothue,nguoidongthue where nguoidongthue.id = baocaothue.nguoidongthueid and nguoidongthue.ten like %?1%", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoTen(Pageable pageable, String ten);

    @Query(value = "select baocaothue.* from baocaothue,nguoidongthue where nguoidongthue.id = baocaothue.nguoidongthueid and nguoidongthue.cmnd = ?1", nativeQuery = true)
    Page<Baocaothue> getDsBaocaothueTheoCMND(Pageable pageable, String cmnd);

}
