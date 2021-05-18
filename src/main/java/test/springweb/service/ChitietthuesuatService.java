package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.Chitietthuesuat;
import test.springweb.entity2.repository.ChitietthuesuatRepository;

import java.util.List;

@Service
public class ChitietthuesuatService {
    @Autowired
    private ChitietthuesuatRepository chitietRes;

    public List<Chitietthuesuat> getDsChitietthuesuatTheoThueTNCNid(int id)
    {
        List<Chitietthuesuat> ds = chitietRes.getDschitietthuesuatTheoIDThueTNCN(id);
        return ds;
    }

    public Chitietthuesuat getChitietthuesuat(int id)
    {
        Chitietthuesuat chitietthuesuat = chitietRes.getchitietthuesuatTheoIDT(id);
        return chitietthuesuat;
    }

    public void capnhatThuesuat(Chitietthuesuat chitietthuesuat)
    {
        chitietRes.save(chitietthuesuat);
    }
}
