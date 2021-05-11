package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springweb.entity2.repository.thuetncnRepository;
import test.springweb.entity2.thuetncn;

import java.util.List;

@Service
public class thueTNCNService {
    @Autowired
    thuetncnRepository thueTNCNRes;

    public List<thuetncn> getDsTheloaiThueTNCN()
    {

        List<thuetncn> ds= thueTNCNRes.getLoaithueTNCN();
        return ds;
    }

    public String getTenThueTNCNtheoID(int id)
    {
        String ten = "";
        thuetncn thuetncn = thueTNCNRes.getthuetncnTheoID(id);
        ten = thuetncn.getLoaithuetncn();
        return ten;
    }


}
