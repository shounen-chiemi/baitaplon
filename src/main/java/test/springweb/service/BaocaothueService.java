package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.springweb.dto.BaocaothueDTO;
import test.springweb.entity2.*;
import test.springweb.entity2.repository.BaocaothueRepository;
import test.springweb.entity2.repository.ChitietthuesuatRepository;
import test.springweb.entity2.repository.ThuetncnRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class BaocaothueService {
   @Autowired
   BaocaothueRepository bctR;
   @Autowired
   KhoanggiamtruService kgS;
   @Autowired
   ThuetncnRepository thueR;
   @Autowired
   ChitietthuesuatRepository chitietR;

    public Page<Baocaothue> getDs(Pageable pageable)
    {
        Page<Baocaothue> page = bctR.getDsBaocaothue(pageable);
        return page;
    }

    public List<BaocaothueDTO> getdsbaocaothueTheoID(Pageable pageable, int idThueTNCN)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothueTheoIdThueTNCN(pageable,idThueTNCN);
        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());

            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);

            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }


    public List<BaocaothueDTO> getdsbaocaothue(Pageable pageable)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());

            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);

            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<BaocaothueDTO> getDsbaocaothueTheoNam(Pageable pageable, String  nam)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothueTheoNam(pageable,nam);

        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());

            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);

            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<BaocaothueDTO> getDsbaocaothueTheoThang(Pageable pageable, int thang, int nam)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothueTheoThang(pageable,thang,nam);

        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());

            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);

            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<BaocaothueDTO> getDsbaocaothueTheoNgay(Pageable pageable, String ngay)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothueTheoNgay(pageable,ngay);

        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());

            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);

            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<BaocaothueDTO> getDsbaocaothueTheoTP(Pageable pageable, String thanhpho)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothueTheoTP(pageable,thanhpho);

        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());

            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);

            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<BaocaothueDTO> getdsbaocaothue(Pageable pageable, int IDThueTNCN)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<BaocaothueDTO> dsbc = new ArrayList<>();
        for(Baocaothue i : ds)
        {
            if(i.getChitietthuesuat().getThuetncn().getId()==IDThueTNCN)
            {
                BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
                baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
                baocaothueDTO.setLoaithue(i.getLoaithue());
                baocaothueDTO.setId(i.getId());
                baocaothueDTO.setNgaynop(i.getNgaynop());
                baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
                baocaothueDTO.setTnct(i.getTnct());
                baocaothueDTO.setTinhtrang(i.getTinhtrang());
                baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
                baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
                int thue = tinhTiennop(i);
                baocaothueDTO.setTongtien((int) thue);

                dsbc.add(baocaothueDTO);
            }
        }
        return dsbc;
    }

    public int tinhTiennop(Baocaothue b)
    {
        int tong = 0;
        float thue = b.getTnct();
        b.setList_khoangiamtru(kgS.getDskhoanggiamtru(b.getId()));
        for(Khoangiamtru j : b.getList_khoangiamtru())
        {
            float mucgiamtru = j.getMucgiamtru();
            if(j.getTenmucgiamtru().equals("giảm trừ với mỗi người phụ thuộc"))
            {
                mucgiamtru = (float)b.getSonguoiphuthuoc()*mucgiamtru;
            }
            thue = (float)(thue - mucgiamtru);
        }
        thue = (float)(thue*(b.getChitietthuesuat().getThuesuat()/100));
        if(thue<0) thue=0;
        tong = (int)thue;
        return tong;
    }

    public BaocaothueDTO getBaocaothueTheoId(int id)
    {
        BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
        Baocaothue baocaothue = bctR.getBaocaothueTheoId(id);
        baocaothueDTO.setChitietthuesuat(baocaothue.getChitietthuesuat());
        baocaothueDTO.setLoaithue(baocaothue.getLoaithue());
        baocaothueDTO.setId(baocaothue.getId());
        baocaothueDTO.setNgaynop(baocaothue.getNgaynop());
        baocaothueDTO.setSonguoiphuthuoc(baocaothue.getSonguoiphuthuoc());
        baocaothueDTO.setTnct(baocaothue.getTnct());
        baocaothueDTO.setTinhtrang(baocaothue.getTinhtrang());
        baocaothueDTO.setNguoidongthue(baocaothue.getNguoidongthue());
        baocaothue.setList_khoangiamtru(kgS.getDskhoanggiamtru(baocaothue.getId()));
        baocaothueDTO.setList_khoangiamtru(baocaothue.getList_khoangiamtru());

        int thue = tinhTiennop(baocaothue);

        baocaothueDTO.setTongtien((int) thue);
        return baocaothueDTO;
    }

    public List<BaocaothueDTO> getdsbaocaothueTheoTen(Pageable pageable, String ten)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<BaocaothueDTO> dsbc = new ArrayList<>();
        ds = bctR.getDsBaocaothueTheoTen(pageable,ten);
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);
            i.setList_khoangiamtru(kgS.getDskhoanggiamtru(i.getId()));
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }

    public List<BaocaothueDTO> getdsbaocaothueTheoCMND(Pageable pageable, String cmnd)
    {
        Page<Baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<BaocaothueDTO> dsbc = new ArrayList<>();
        ds = bctR.getDsBaocaothueTheoCMND(pageable,cmnd);
        for(Baocaothue i : ds)
        {
            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
            int thue = tinhTiennop(i);
            baocaothueDTO.setTongtien((int) thue);
            i.setList_khoangiamtru(kgS.getDskhoanggiamtru(i.getId()));
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }
//    public List<BaocaothueDTO> getDsbaocaothueTheoThang(Pageable pageable, int thang, int nam, int thueTNCNid)
//    {
//        Page<Baocaothue> ds = bctR.getDsBaocaothueTheoThang(pageable,thang,nam);
//
//        List<BaocaothueDTO> dsbc = new ArrayList<>();
//        for(Baocaothue i : ds)
//        {
//            BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
//            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
//            baocaothueDTO.setLoaithue(i.getLoaithue());
//            baocaothueDTO.setId(i.getId());
//            baocaothueDTO.setNgaynop(i.getNgaynop());
//            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
//            baocaothueDTO.setTnct(i.getTnct());
//            baocaothueDTO.setTinhtrang(i.getTinhtrang());
//            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
//            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
//
//            int thue = tinhTiennop(i);
//            baocaothueDTO.setTongtien((int) thue);
//
//            dsbc.add(baocaothueDTO);
//        }
//        return dsbc;
//    }

    public Thongke getDsbaocaothueTheoNam(String  nam, int thuetncnid)
    {
        List<Baocaothue> ds = bctR.getDsBaocaothueTheoNamvaLoaithueTNCN(thuetncnid,nam);
        Thongke thongke = new Thongke();
        int tongtien = 0;
        for(Baocaothue i : ds)
        {
            int thue = tinhTiennop(i);
            tongtien = tongtien + (int)thue;
        }
        thongke.setTongtiennopthue(tongtien);
        thongke.setLoaithueTNCN(thueR.getthuetncnTheoID(thuetncnid).getLoaithuetncn());
        return thongke;
    }

    public Thongke getDsbaocaothueTheoThang(int nam, int thang, int thuetncnid)
    {
        List<Baocaothue> ds = bctR.getDsBaocaothueTheoThangvaLoaithueTNCN(thuetncnid,thang,nam);
        Thongke thongke = new Thongke();
        int tongtien = 0;
        for(Baocaothue i : ds)
        {
            int thue = tinhTiennop(i);
            tongtien = tongtien + (int)thue;
        }
        thongke.setTongtiennopthue(tongtien);
        thongke.setLoaithueTNCN(thueR.getthuetncnTheoID(thuetncnid).getLoaithuetncn());
        return thongke;
    }

}
