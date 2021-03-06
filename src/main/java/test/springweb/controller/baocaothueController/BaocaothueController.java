package test.springweb.controller.baocaothueController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.springweb.dto.BaocaothueDTO;
import test.springweb.entity2.Thuetncn;
import test.springweb.service.BaocaothueService;
import test.springweb.service.KhoanggiamtruService;
import test.springweb.service.ThanhvienService;
import test.springweb.service.ThueTNCNService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class BaocaothueController {
    @Autowired
    private BaocaothueService bctS;
    @Autowired
    private KhoanggiamtruService kgS;
    @Autowired
    private ThueTNCNService tS;
    @Autowired
    private ThanhvienService thvienS;
    //load trang baocaothue
    @RequestMapping("/list-taxpayer")
    public String xemBaocaothueTNCN(Model model, HttpServletRequest request, RedirectAttributes redirect){
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        request.getSession().setAttribute("dsbaocaothue",null);
        request.getSession().setAttribute("tranghientai",1);
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        request.getSession().setAttribute("dsTheloai",dsThueTNCN);
        request.getSession().setAttribute("trangthaihientai",null);
        return "redirect:/list-taxpayer/page/1";
    }
    //load trang báo cáo thuế khi tìm kiếm
    @RequestMapping("/list-taxpayer/{thoigian}")
    public String TimkiemtheoThoigian(@PathVariable String thoigian, Model model, HttpServletRequest request, RedirectAttributes redirect){
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        request.getSession().setAttribute("dsbaocaothue",null);
        request.getSession().setAttribute("tranghientai",1);
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        request.getSession().setAttribute("dsTheloai",dsThueTNCN);
        request.getSession().setAttribute("trangthaihientai",thoigian);
        //nếu mục tìm kiếm là ngày
        if(thoigian.equals("ngay"))
        {
            String thgian = request.getParameter("ngay");
            if(thgian.equals(""))
            {
                model.addAttribute("thongbao","chưa chọn ngày");
                return "thongbaoTimkiem";
            }
            request.getSession().setAttribute("thoigian",thgian);
        }
        //nếu mục tìm kiếm là năm
        else if(thoigian.equals("nam"))
        {
            String thgian = request.getParameter("nam");
            Pattern p = Pattern.compile("[^0-9]");
            Matcher m = p.matcher(thgian.trim());
            if(m.find())
            {
                model.addAttribute("thongbao","dữ liệu không hợp lệ, có chứa kí tự khác ngoài số");
                return "thongbaoTimkiem";
            }
            request.getSession().setAttribute("thoigian",thgian);
        }
        //nếu mục tìm kiếm là tháng
        else if(thoigian.equals("thang"))
        {
            String thgian = request.getParameter("thang");
            if(!thgian.contains("-")) //kiểm tra xem chọn tháng chưa
            {
                model.addAttribute("thongbao","chưa chọn tháng");
                return "thongbaoTimkiem";
            }
            request.getSession().setAttribute("thoigian",thgian);
        }
        //nếu mục tìm kiếm là thành phố
        else if(thoigian.equals("thanhpho"))
        {
            String thanhpho = request.getParameter("thanhpho");
            if(thanhpho.equals(""))
            {
                model.addAttribute("thongbao","chưa chọn thành phố");
                return "thongbaoTimkiem";
            }
//            Pattern p = Pattern.compile("[\\u0A00-\\u0A7F]");
            StringTokenizer s = new StringTokenizer(thanhpho," ");
            String ten1 = "";
            String ten2 = "";
            while(s.hasMoreTokens())
            {
                String kitu = s.nextToken();
                ten1 = ten1 + kitu + " ";
                ten2 = ten2 + kitu;
            }
            request.getSession().setAttribute("thanhpho",ten1);
        }
        //nếu mục tìm kiếm là tên
        else if(thoigian.equals("nguoidongthue"))
        {
            String ten = request.getParameter("nguoidongthue");
            if(ten.trim().equals(""))
            {
                model.addAttribute("thongbao","chưa nhập tên");
                return "thongbaoTimkiem";
            }
            StringTokenizer s = new StringTokenizer(ten," ");
            String ten1 = "";
            String ten2 = "";
            while(s.hasMoreTokens())
            {
                String kitu = s.nextToken();
                ten1 = ten1 + kitu + " ";
                ten2 = ten2 + kitu;
            }
            for(int i = 0;i<ten2.length();i++)
            {
                if(!Character.isLetter(ten2.charAt(i)))
                {
                    model.addAttribute("thongbao","dữ liệu không hợp lệ, có chứa kí tự khác ngoài chữ cái");
                    return "thongbaoTimkiem";
                }
            }
            request.getSession().setAttribute("nguoidongthue",ten1.trim());
        }
        //nếu mục tìm kiếm là cmnd
        else if(thoigian.equals("cmnd"))
        {
            String cmnd = request.getParameter("cmnd");
            if(cmnd.trim().equals(""))
            {
                model.addAttribute("thongbao","chưa nhập chứng minh nhân dân");
                return "thongbaoTimkiem";
            }
            Pattern p = Pattern.compile("[^0-9]");
            Matcher m = p.matcher(cmnd.trim());
            if(m.find())
            {
                model.addAttribute("thongbao","dữ liệu không hợp lệ, có chứa kí tự khác ngoài số");
                return "thongbaoTimkiem";
            }
            request.getSession().setAttribute("cmnd",cmnd);
        }
        return "redirect:/list-taxpayer/"+thoigian+"/page/1";
    }
    @RequestMapping("/list-taxpayer/thueTNCNid={timkiem}")
    public String TimTheoThueTNCN(@PathVariable int timkiem, Model model, HttpServletRequest request, RedirectAttributes redirect){
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        request.getSession().setAttribute("dsbaocaothue",null);
        request.getSession().setAttribute("tranghientai",1);
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        request.getSession().setAttribute("dsTheloai",dsThueTNCN);
        return "redirect:/list-taxpayer/thueTNCNid="+timkiem+"/page/1";
    }


    //phân trang báo cáo thuế
    @RequestMapping("list-taxpayer/page/{pagenumber}")
    public String phanTrang(HttpServletRequest request,@PathVariable int pagenumber, Model model,RedirectAttributes redirect)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        if(request.getSession().getAttribute("dsTheloai")==null)
        {
            List<Thuetncn> dsThueTNCN = (List<Thuetncn>) request.getSession().getAttribute("dsTheloai");
            model.addAttribute("dsTheloai",dsThueTNCN);
        }
        else
        {
            List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
            model.addAttribute("dsTheloai",dsThueTNCN);
        }

        if(pagenumber<1)
            pagenumber = 1;

        int tranghientai;
        tranghientai = pagenumber-1;
        Pageable pageable = PageRequest.of(tranghientai,5);

        List<BaocaothueDTO> dsbc = bctS.getdsbaocaothue(pageable);

        request.getSession().setAttribute("tranghientai",(int)tranghientai+1);
        model.addAttribute("danhsachThue",dsbc);
        model.addAttribute("tranghientai",(int)tranghientai+1);

        return "admin/list-taxpayer";
    }

    //phân trang báo cáo thuế khi lọc theo loại thuế TNCN
    @RequestMapping("list-taxpayer/thueTNCNid={timkiem}/page/{pagenumber}")
    public String phanTrangThueTNCN(HttpServletRequest request,@PathVariable int timkiem, @PathVariable int pagenumber, Model model,RedirectAttributes redirect)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        if(request.getSession().getAttribute("dsTheloai")==null)
        {
            List<Thuetncn> dsThueTNCN = (List<Thuetncn>) request.getSession().getAttribute("dsTheloai");
            model.addAttribute("dsTheloai",dsThueTNCN);
        }
        else
        {
            List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
            model.addAttribute("dsTheloai",dsThueTNCN);
        }
        if(pagenumber<1)
            pagenumber = 1;
        int tranghientai;
        tranghientai = pagenumber-1;
        Pageable pageable = PageRequest.of(tranghientai,5);
//        List<baocaothueDTO> dsbc = bctS.getdsbaocaothue(pageable,timkiem);
        List<BaocaothueDTO> dsbc = bctS.getdsbaocaothueTheoID(pageable,timkiem);
        request.getSession().setAttribute("tranghientai",(int)tranghientai+1);
        model.addAttribute("danhsachThue",dsbc);
        model.addAttribute("tranghientai",(int)tranghientai+1);

        return "admin/list-taxpayer";
    }

    @RequestMapping("list-taxpayer/{thoigian}/page/{pagenumber}")
    public String phanTrangThueTNCN(HttpServletRequest request,@PathVariable String thoigian, @PathVariable int pagenumber, Model model,RedirectAttributes redirect)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        if(request.getSession().getAttribute("dsTheloai")==null)
        {
            List<Thuetncn> dsThueTNCN = (List<Thuetncn>) request.getSession().getAttribute("dsTheloai");
            model.addAttribute("dsTheloai",dsThueTNCN);
        }
        else
        {
            List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
            model.addAttribute("dsTheloai",dsThueTNCN);
        }
        if(pagenumber<1)
            pagenumber = 1;
        int tranghientai;
        tranghientai = pagenumber-1;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<BaocaothueDTO> dsbc = null;
        if(thoigian.equals("ngay"))
        {
            String thgian = (String) request.getSession().getAttribute("thoigian");
            dsbc = bctS.getDsbaocaothueTheoNgay(pageable,thgian);
            model.addAttribute("ngay",thgian);
        }
        else if(thoigian.equals("thang"))
        {
            String thgian = (String) request.getSession().getAttribute("thoigian");
            StringTokenizer s = new StringTokenizer(thgian,"-");
            String namT = s.nextToken();
            String thangT = s.nextToken();

            int nam = Integer.parseInt(namT);
            int thang = Integer.parseInt(thangT);

            dsbc = bctS.getDsbaocaothueTheoThang(pageable,thang,nam);
            model.addAttribute("thang",thgian);
        }
        else if(thoigian.equals("nam"))
        {
            String thgian = (String) request.getSession().getAttribute("thoigian");
            dsbc = bctS.getDsbaocaothueTheoNam(pageable,thgian);
            model.addAttribute("nam",thgian);
        }
        else if(thoigian.equals("thanhpho"))
        {
            String thanhpho = (String)request.getSession().getAttribute("thanhpho");
            dsbc = bctS.getDsbaocaothueTheoTP(pageable,thanhpho);

            model.addAttribute("thanhpho",thanhpho);
        }
        else if(thoigian.equals("nguoidongthue"))
        {
            String ten = (String)request.getSession().getAttribute("nguoidongthue");
            dsbc = bctS.getdsbaocaothueTheoTen(pageable,ten);
            model.addAttribute("nguoidongthue",ten);
        }
        else if(thoigian.equals("cmnd"))
        {
            String cmnd = (String)request.getSession().getAttribute("cmnd");
            dsbc = bctS.getdsbaocaothueTheoCMND(pageable,cmnd);
            model.addAttribute("cmnd",cmnd);
        }


        request.getSession().setAttribute("tranghientai",(int)tranghientai+1);
        model.addAttribute("danhsachThue",dsbc);
        model.addAttribute("tranghientai",(int)tranghientai+1);

        return "admin/list-taxpayer";
    }

    @RequestMapping("list-taxpayer/idBaocaothue={id}")
    public String getChitietthue(@PathVariable int id,HttpServletRequest request,Model model)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        BaocaothueDTO baocaothueDTO = new BaocaothueDTO();
        baocaothueDTO = bctS.getBaocaothueTheoId(id);
        model.addAttribute("baocaothuechitiet",baocaothueDTO);
        model.addAttribute("khoangiamtru","");
        return "admin/detail";
    }


}
