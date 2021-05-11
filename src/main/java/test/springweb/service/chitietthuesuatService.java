package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.chitietthuesuat;
import test.springweb.entity2.repository.chitietthuesuatRepository;

import java.util.List;

@Service
public class chitietthuesuatService {
    @Autowired
    private chitietthuesuatRepository chitietRes;

    public List<chitietthuesuat> getDsChitietthuesuatTheoThueTNCNid(int id)
    {
        List<chitietthuesuat> ds = chitietRes.getDschitietthuesuatTheoIDThueTNCN(id);
        return ds;
    }

    public float getMucthuesuatTheoID(int id)
    {
        chitietthuesuat chitietthuesuat = chitietRes.getchitietthuesuatTheoIDT(id);
        return chitietthuesuat.getThuesuat();
    }

    public String getTenthuesuatTheoID(int id)
    {
        chitietthuesuat chitietthuesuat = chitietRes.getchitietthuesuatTheoIDT(id);
        return chitietthuesuat.getTenmuc();
    }

    public chitietthuesuat getChitietthuesuat(int id)
    {
        chitietthuesuat chitietthuesuat = chitietRes.getchitietthuesuatTheoIDT(id);
        return chitietthuesuat;
    }

    public void capnhatThuesuat(chitietthuesuat chitietthuesuat)
    {
        chitietRes.save(chitietthuesuat);
    }
}
