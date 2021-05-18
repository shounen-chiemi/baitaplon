package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository

public interface ChitietthuesuatRepository extends JpaRepository<Chitietthuesuat,Integer> {
//    @Query("select * from chitietthuesuat where chitietthuesuat .thuetncnid = ?1")
//    public ArrayList<chitietthuesuat> getDsthuesuattheoId(int id);
    @Query(value = "select * from chitietthuesuat u where u.ThueTNCNID = ?1", nativeQuery = true)
    public List<Chitietthuesuat> getDschitietthuesuatTheoIDThueTNCN(int id);

    @Query(value = "select * from chitietthuesuat where  id= ?1", nativeQuery = true)
    public Chitietthuesuat getchitietthuesuatTheoIDT(int id);

}
