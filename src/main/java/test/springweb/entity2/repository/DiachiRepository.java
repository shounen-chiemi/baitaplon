package test.springweb.entity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.Diachi;

@Repository
public interface DiachiRepository extends JpaRepository<Diachi,Integer> {
}
