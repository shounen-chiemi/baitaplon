package test.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import test.springweb.entity2.repository.*;
import test.springweb.entity2.*;
import test.springweb.entity2.thanhvien;
import test.springweb.service.thanhvienService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class SpringwebApplication {

    private JdbcTemplate jdb;

    @Autowired
    private static thanhvienService tvs;
    @Autowired
    private static baocaothueRepository b;



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringwebApplication.class, args);

//        Pageable pageable = PageRequest.of(0,6);
//        baocaothueRepository bR = context.getBean(baocaothueRepository.class);
//        Page<baocaothue> ds = bR.getDsBaocaothue(pageable);
//        for(baocaothue i : ds)
//        {
//            System.out.println(i.getId() + " " + i.getNgaynop());
//        }
//
//        ds = bR.getDsBaocaothue(ds.nextPageable());
//        System.out.println("/////////////////");
//        for(baocaothue i : ds)
//        {
//            System.out.println(i.getId() + " " + i.getNgaynop());
//        }
//        ds = bR.getDsBaocaothue(ds.nextPageable());
//        System.out.println("/////////////////");
//
//        for(baocaothue i : ds)
//        {
//            System.out.println(i.getId() + " " + i.getNgaynop());
//        }
//        System.out.println(ds.getTotalPages());
//
//        Pageable p = PageRequest.of(0,5);
//        Page<baocaothue> dddd = b.getDsBaocaothueTheoIdThueTNCN(p,1);

    }
}
