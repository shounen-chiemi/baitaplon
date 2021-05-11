package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.springweb.dto.baocaothueDTO;
import test.springweb.entity2.*;
import test.springweb.entity2.repository.baocaothueRepository;
import test.springweb.entity2.repository.chitietthuesuatRepository;
import test.springweb.entity2.repository.thuetncnRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class baocaothueService {
   @Autowired
   baocaothueRepository bctR;
   @Autowired
   khoangiamtruService kgS;
   @Autowired
   thuetncnRepository thueR;
   @Autowired
   chitietthuesuatRepository chitietR;

    public Page<baocaothue> getDs(Pageable pageable)
    {
        Page<baocaothue> page = bctR.getDsBaocaothue(pageable);
        return page;
    }

    public List<baocaothueDTO> getdsbaocaothueTheoID(Pageable pageable,int idThueTNCN)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoIdThueTNCN(pageable,idThueTNCN);
        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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


    public List<baocaothueDTO> getdsbaocaothue(Pageable pageable)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getDsbaocaothueTheoNam(Pageable pageable,String  nam)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoNam(pageable,nam);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getDsbaocaothueTheoThang(Pageable pageable,int thang,int nam)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoThang(pageable,thang,nam);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getDsbaocaothueTheoNgay(Pageable pageable,String ngay)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoNgay(pageable,ngay);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getDsbaocaothueTheoTP(Pageable pageable,String thanhpho)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoTP(pageable,thanhpho);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getdsbaocaothue(Pageable pageable,int IDThueTNCN)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            if(i.getChitietthuesuat().getThuetncn().getId()==IDThueTNCN)
            {
                baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public int tinhTiennop(baocaothue b)
    {
        int tong = 0;
        float thue = b.getTnct();
        b.setList_khoangiamtru(kgS.getDskhoanggiamtru(b.getId()));
        for(khoangiamtru j : b.getList_khoangiamtru())
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

    public baocaothueDTO getBaocaothueTheoId(int id)
    {
        baocaothueDTO baocaothueDTO = new baocaothueDTO();
        baocaothue baocaothue = bctR.getBaocaothueTheoId(id);
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

    public List<baocaothueDTO> getdsbaocaothueTheoTen(Pageable pageable,String ten)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<baocaothueDTO> dsbc = new ArrayList<>();
        ds = bctR.getDsBaocaothueTheoTen(pageable,ten);
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getdsbaocaothueTheoCMND(Pageable pageable,String cmnd)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);
        List<baocaothueDTO> dsbc = new ArrayList<>();
        ds = bctR.getDsBaocaothueTheoCMND(pageable,cmnd);
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public List<baocaothueDTO> getDsbaocaothueTheoThang(Pageable pageable,int thang,int nam,int thueTNCNid)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothueTheoThang(pageable,thang,nam);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
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

    public thongke getDsbaocaothueTheoNam(String  nam, int thuetncnid)
    {
        List<baocaothue> ds = bctR.getDsBaocaothueTheoNamvaLoaithueTNCN(thuetncnid,nam);
        thongke thongke = new thongke();
        int tongtien = 0;
        for(baocaothue i : ds)
        {
            int thue = tinhTiennop(i);
            tongtien = tongtien + (int)thue;
        }
        thongke.setTongtiennopthue(tongtien);
        thongke.setLoaithueTNCN(thueR.getthuetncnTheoID(thuetncnid).getLoaithuetncn());
        return thongke;
    }

    public thongke getDsbaocaothueTheoThang(int nam,int thang, int thuetncnid)
    {
        List<baocaothue> ds = bctR.getDsBaocaothueTheoThangvaLoaithueTNCN(thuetncnid,thang,nam);
        thongke thongke = new thongke();
        int tongtien = 0;
        for(baocaothue i : ds)
        {
            int thue = tinhTiennop(i);
            tongtien = tongtien + (int)thue;
        }
        thongke.setTongtiennopthue(tongtien);
        thongke.setLoaithueTNCN(thueR.getthuetncnTheoID(thuetncnid).getLoaithuetncn());
        return thongke;
    }


}
