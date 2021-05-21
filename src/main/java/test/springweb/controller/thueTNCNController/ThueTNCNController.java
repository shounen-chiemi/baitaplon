package test.springweb.controller.thueTNCNController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.springweb.entity2.Chitietthuesuat;
import test.springweb.entity2.Khoangiamtru;
import test.springweb.entity2.Thuetncn;
import test.springweb.service.ChitietthuesuatService;
import test.springweb.service.KhoanggiamtruService;
import test.springweb.service.ThueTNCNService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThueTNCNController {
    @Autowired
    private ThueTNCNService tS;
    @Autowired
    private ChitietthuesuatService chitietService;
    @Autowired
    private KhoanggiamtruService khoangiamtruS;
    @RequestMapping("/configuration")
    public String getCauhinhthue(HttpServletRequest request, Model model)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách thuế TNCN
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập danh sách thuế suất
        List<Chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);

        //thiết lập danh sách khoản giảm trừ
        List<Khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);

        //thiết lập loại thuế TNCN đang chọn
        model.addAttribute("loaithuedangchon","");

        //thiết lập khoản giảm trừ đang chọn
        Khoangiamtru khoangiamtru = new Khoangiamtru();
        model.addAttribute("khoangiamtru",khoangiamtru);

        //thiết lập thuế suất đang chọn
        Chitietthuesuat chitietthuesuat = new Chitietthuesuat();
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        request.getSession().setAttribute("thueTNCNdangchon",null);
        request.getSession().setAttribute("thuesuatdangchon",null);
        request.getSession().setAttribute("khoangiamtrudangchon",null);


        return "admin/configuration";
    }

    @RequestMapping("/configuration/thueTNCNid={id}")
    public String getThueTNCN(@PathVariable int id,Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách thuế TNCN
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập danh sách thuế suất
        List<Chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);

        //thiết lập danh sách khoản giảm trừ
        List<Khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);

        //thiết lập thuế TNCN đang chọn
        model.addAttribute("loaithuedangchon",tS.getTenThueTNCNtheoID(id));

        //thiết lập khoản giảm trừ đang chọn
        Khoangiamtru khoangiamtru = new Khoangiamtru();
        model.addAttribute("khoangiamtru",khoangiamtru);

        //thiết lập thuế suất đang chọn
        Chitietthuesuat chitietthuesuat = new Chitietthuesuat();
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        //thiết lập danh sách thuế suất
        List<Chitietthuesuat> ds = chitietService.getDsChitietthuesuatTheoThueTNCNid(id);
        model.addAttribute("dsThuesuat",ds);

        //lưu thuế TNCN đang chọn vào session
        request.getSession().setAttribute("thueTNCNdangchon",id);

        return "admin/configuration";
    }

    @RequestMapping("/configuration/thuesuatid={id}")
    public String getThuesuat(@PathVariable int id,Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        int idthueTNCN = (int) request.getSession().getAttribute("thueTNCNdangchon");
        model.addAttribute("thvien", name);
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);
        List<Chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);
        List<Khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);
        model.addAttribute("loaithuedangchon",tS.getTenThueTNCNtheoID(idthueTNCN));
        Khoangiamtru khoangiamtru = new Khoangiamtru();
        model.addAttribute("khoangiamtru",khoangiamtru);
        Chitietthuesuat chitietthuesuat = chitietService.getChitietthuesuat(id);
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        List<Chitietthuesuat> ds = chitietService.getDsChitietthuesuatTheoThueTNCNid(idthueTNCN);
        model.addAttribute("dsThuesuat",ds);

        request.getSession().setAttribute("thuesuatdangchon",chitietthuesuat);
        return "admin/configuration";
    }

    @RequestMapping("/configuration/khoangiamtruid={id}")
    public String getKhoangiamtru(@PathVariable int id,Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);
        List<Chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);
        List<Khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);
        model.addAttribute("loaithuedangchon","");
        Khoangiamtru khoangiamtru = khoangiamtruS.getKhoangiamtru(id);
        model.addAttribute("khoangiamtru",khoangiamtru);
        Chitietthuesuat chitietthuesuat = new Chitietthuesuat();
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        request.getSession().setAttribute("khoangiamtrudangchon",khoangiamtru);

        return "admin/configuration";
    }

    @RequestMapping("/configuration/cauhinhThuesuat")
    public String cauhinhThuesuat(HttpServletRequest request, RedirectAttributes redirect, Model model)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        //lấy dữ liệu từ form
        String idThuesuat = request.getParameter("chitietthuesuatid");
        String mucthuesuat = request.getParameter("mucthuesuat");

        //kiểm tra đã chọn thuế TNCN chưa
        if(request.getSession().getAttribute("thueTNCNdangchon")==null)
        {
            model.addAttribute("thongbao","chưa chọn thuế TNCN");
            return "thongbaoCauhinhthue";
        }
        //kiểm tra đã chọn thuế suất chưa
        if(request.getSession().getAttribute("thuesuatdangchon")==null)
        {
            model.addAttribute("thongbao","chưa chọn thuế suất");
            return "thongbaoCauhinhthue";
        }
        //cập nhật dữ liệu
        try{
            float f =  Float.parseFloat(mucthuesuat);
            Chitietthuesuat chitietthuesuat = chitietService.getChitietthuesuat(Integer.parseInt(idThuesuat));
            chitietthuesuat.setThuesuat(f);
            chitietService.capnhatThuesuat(chitietthuesuat);
            model.addAttribute("thongbao","cập nhật mức thuế suất thành công");
            return "thongbaoCauhinhthue";
        }
        catch (NumberFormatException e)
        {
            model.addAttribute("thongbao","dữ liệu nhập không phải đúng định dạng float (ví dụ đúng : 0.5)");
            return "thongbaoCauhinhthue";
        }
    }

    @RequestMapping("/configuration/cauhinhGiamtru")
    public String cauhinhGiamtru(HttpServletRequest request, RedirectAttributes redirect, Model model)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        //lấy dữ liệu từ form
        String idKhoangiamtru = request.getParameter("khoangiamtruid");
        String khoangiamtru = request.getParameter("khoangiamtru");

        //kiểm tra đã chọn khoản giảm trừ chưa
        if(request.getSession().getAttribute("khoangiamtrudangchon")==null)
        {
            model.addAttribute("thongbao","chưa chọn khoản giảm trừ");
            return "thongbaoCauhinhthue";
        }
        //cập nhật dữ liệu
        try{
            int i = Integer.parseInt(khoangiamtru);
            Khoangiamtru khoangiamtru1 = khoangiamtruS.getKhoangiamtru(Integer.parseInt(idKhoangiamtru));
            khoangiamtru1.setMucgiamtru(i);
            khoangiamtruS.capnhatKhoangiamtru(khoangiamtru1);
            model.addAttribute("thongbao","cập nhật mức giảm trừ thành công");
            return "thongbaoCauhinhthue";
        }
        catch (NumberFormatException e)
        {
            model.addAttribute("thongbao","dữ liệu nhập không phải đúng định dạng int (ví dụ đúng : 10000)");
            return "thongbaoCauhinhthue";
        }
    }


}
