package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.Khoangiamtru;
import test.springweb.entity2.repository.KhoangiamtruRepository;

import java.util.List;

@Service
public class KhoanggiamtruService {
    @Autowired
    KhoangiamtruRepository kgtR;

    public List<Khoangiamtru> getDskhoanggiamtru(int id)
    {
        List<Khoangiamtru> ds = kgtR.getKhoangiamtruTheoID(id);
        return ds;
    }

    public List<Khoangiamtru> getDskhoangiamtru()
    {
        List<Khoangiamtru> ds = kgtR.getDsKhoangiamtru();
        return ds;
    }

    public Khoangiamtru getKhoangiamtru(int id)
    {
        Khoangiamtru khoangiamtru = kgtR.getKhoangiamtru(id);
        return khoangiamtru;
    }

    public void capnhatKhoangiamtru(Khoangiamtru khoangiamtru)
    {
        kgtR.save(khoangiamtru);
    }

}
