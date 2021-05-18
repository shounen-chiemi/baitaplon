package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;

import java.util.List;
@Repository
public interface ThuetncnRepository extends JpaRepository<Thuetncn,Integer> {

    @Query(value = "select * from thuetncn u where u.id = ?1", nativeQuery = true)
    public Thuetncn getthuetncnTheoID(int id);

    @Query(value = "select * from thuetncn", nativeQuery = true)
    public List<Thuetncn> getLoaithueTNCN();

}
