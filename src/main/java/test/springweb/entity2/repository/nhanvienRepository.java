package test.springweb.entity2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import test.springweb.entity2.*;
@Repository
public interface nhanvienRepository extends JpaRepository<nhanvien,Integer> {
}
