package test.springweb.entity2.repository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface thuetncnRepository extends JpaRepository<thuetncn,Integer> {

    @Query(value = "select * from thuetncn u where u.id = ?1", nativeQuery = true)
    public thuetncn getthuetncnTheoID(int id);

    @Query(value = "select * from thuetncn", nativeQuery = true)
    public List<thuetncn> getLoaithueTNCN();

}
