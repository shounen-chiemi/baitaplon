package test.springweb.entity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.diachi;

@Repository
public interface diachiRepository extends JpaRepository<diachi,Integer> {
}
