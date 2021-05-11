package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.repository.khoangiamtruRepository;

import java.util.List;

@Service
public class khoangiamtruService {
    @Autowired
    khoangiamtruRepository kgtR;

    public List<khoangiamtru> getDskhoanggiamtru(int id)
    {
        List<khoangiamtru> ds = kgtR.getKhoangiamtruTheoID(id);
        return ds;
    }

    public List<khoangiamtru> getDskhoangiamtru()
    {
        List<khoangiamtru> ds = kgtR.getDsKhoangiamtru();
        return ds;
    }

    public String getTenkhoangiamtruTheoID(int id)
    {
        String ten = "";
        khoangiamtru khoangiamtru = kgtR.getKhoangiamtru(id);
        ten = khoangiamtru.getTenmucgiamtru();
        return ten;
    }

    public int getKhoangiamtruTheoID(int id)
    {
        khoangiamtru khoangiamtru = kgtR.getKhoangiamtru(id);
        return khoangiamtru.getMucgiamtru();
    }

    public khoangiamtru getKhoangiamtru(int id)
    {
        khoangiamtru khoangiamtru = kgtR.getKhoangiamtru(id);
        return khoangiamtru;
    }

    public void capnhatKhoangiamtru(khoangiamtru khoangiamtru)
    {
        kgtR.save(khoangiamtru);
    }

}
