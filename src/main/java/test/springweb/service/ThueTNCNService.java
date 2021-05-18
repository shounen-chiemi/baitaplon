package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.repository.ThuetncnRepository;
import test.springweb.entity2.Thuetncn;

import java.util.List;

@Service
public class ThueTNCNService {
    @Autowired
    ThuetncnRepository thueTNCNRes;

    public List<Thuetncn> getDsTheloaiThueTNCN()
    {

        List<Thuetncn> ds= thueTNCNRes.getLoaithueTNCN();
        return ds;
    }

    public String getTenThueTNCNtheoID(int id)
    {
        String ten = "";
        Thuetncn thuetncn = thueTNCNRes.getthuetncnTheoID(id);
        ten = thuetncn.getLoaithuetncn();
        return ten;
    }


}
