package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;

import java.util.List;
@Repository

public interface KhoangiamtruRepository extends JpaRepository<Khoangiamtru,Integer> {
    @Query(value = "select * from khoangiamtru,baocaothue,baocaothue_khoangiamtru where khoangiamtru.id = baocaothue_khoangiamtru.KhoangiamtruID and baocaothue_khoangiamtru.BaocaothueID = baocaothue.id and baocaothue.id = ?1", nativeQuery = true)
    public List<Khoangiamtru> getKhoangiamtruTheoID(int id);

    @Query(value = "select * from khoangiamtru", nativeQuery = true)
    public List<Khoangiamtru> getDsKhoangiamtru();

    @Query(value = "select * from khoangiamtru where id = ?1", nativeQuery = true)
    public Khoangiamtru getKhoangiamtru(int id);



}
