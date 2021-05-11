package test.springweb.controller.thueTNCNController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.springweb.entity2.chitietthuesuat;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.thuetncn;
import test.springweb.service.chitietthuesuatService;
import test.springweb.service.khoangiamtruService;
import test.springweb.service.thueTNCNService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class thueTNCNController {
    @Autowired
    private thueTNCNService tS;
    @Autowired
    private chitietthuesuatService chitietService;
    @Autowired
    private khoangiamtruService khoangiamtruS;
    @RequestMapping("/configuration")
    public String getCauhinhthue(HttpServletRequest request, Model model)
    {
        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách thuế TNCN
        List<thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập danh sách thuế suất
        List<chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);

        //thiết lập danh sách khoản giảm trừ
        List<khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);

        //thiết lập loại thuế TNCN đang chọn
        model.addAttribute("loaithuedangchon","");

        //thiết lập khoản giảm trừ đang chọn
        khoangiamtru khoangiamtru = new khoangiamtru();
        model.addAttribute("khoangiamtru",khoangiamtru);

        //thiết lập thuế suất đang chọn
        chitietthuesuat chitietthuesuat = new chitietthuesuat();
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        request.getSession().setAttribute("thueTNCNdangchon",null);
        request.getSession().setAttribute("thuesuatdangchon",null);
        request.getSession().setAttribute("khoangiamtrudangchon",null);


        return "admin/configuration";
    }

    @RequestMapping("/configuration/thueTNCNid={id}")
    public String getThueTNCN(@PathVariable int id,Model model,HttpServletRequest request)
    {
        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách thuế TNCN
        List<thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập danh sách thuế suất
        List<chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);

        //thiết lập danh sách khoản giảm trừ
        List<khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);

        //thiết lập thuế TNCN đang chọn
        model.addAttribute("loaithuedangchon",tS.getTenThueTNCNtheoID(id));

        //thiết lập khoản giảm trừ đang chọn
        khoangiamtru khoangiamtru = new khoangiamtru();
        model.addAttribute("khoangiamtru",khoangiamtru);

        //thiết lập thuế suất đang chọn
        chitietthuesuat chitietthuesuat = new chitietthuesuat();
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        //thiết lập danh sách thuế suất
        List<chitietthuesuat> ds = chitietService.getDsChitietthuesuatTheoThueTNCNid(id);
        model.addAttribute("dsThuesuat",ds);

        //lưu thuế TNCN đang chọn vào session
        request.getSession().setAttribute("thueTNCNdangchon",id);

        return "admin/configuration";
    }

    @RequestMapping("/configuration/thuesuatid={id}")
    public String getThuesuat(@PathVariable int id,Model model,HttpServletRequest request)
    {
        String name = (String) request.getSession().getAttribute("thanhvien");
        int idthueTNCN = (int) request.getSession().getAttribute("thueTNCNdangchon");
        model.addAttribute("thvien", name);
        List<thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);
        List<chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);
        List<khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);
        model.addAttribute("loaithuedangchon",tS.getTenThueTNCNtheoID(idthueTNCN));
        khoangiamtru khoangiamtru = new khoangiamtru();
        model.addAttribute("khoangiamtru",khoangiamtru);
        chitietthuesuat chitietthuesuat = chitietService.getChitietthuesuat(id);
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        List<chitietthuesuat> ds = chitietService.getDsChitietthuesuatTheoThueTNCNid(idthueTNCN);
        model.addAttribute("dsThuesuat",ds);

        request.getSession().setAttribute("thuesuatdangchon",chitietthuesuat);
        return "admin/configuration";
    }

    @RequestMapping("/configuration/khoangiamtruid={id}")
    public String getKhoangiamtru(@PathVariable int id,Model model,HttpServletRequest request)
    {
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        List<thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);
        List<chitietthuesuat> dsthuesuat = new ArrayList<>();
        model.addAttribute("dsThuesuat",dsthuesuat);
        List<khoangiamtru> dsgiamtru = new ArrayList<>();
        dsgiamtru = khoangiamtruS.getDskhoangiamtru();
        model.addAttribute("dsGiamtru",dsgiamtru);
        model.addAttribute("loaithuedangchon","");
        khoangiamtru khoangiamtru = khoangiamtruS.getKhoangiamtru(id);
        model.addAttribute("khoangiamtru",khoangiamtru);
        chitietthuesuat chitietthuesuat = new chitietthuesuat();
        model.addAttribute("chitietthuesuat",chitietthuesuat);

        request.getSession().setAttribute("khoangiamtrudangchon",khoangiamtru);

        return "admin/configuration";
    }

    @RequestMapping("/configuration/cauhinhThuesuat")
    public String cauhinhThuesuat(HttpServletRequest request, RedirectAttributes redirect, Model model)
    {
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
            chitietthuesuat chitietthuesuat = chitietService.getChitietthuesuat(Integer.parseInt(idThuesuat));
            chitietthuesuat.setThuesuat(f);
            chitietService.capnhatThuesuat(chitietthuesuat);
            return "redirect:/configuration";
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
            khoangiamtru khoangiamtru1 = khoangiamtruS.getKhoangiamtru(Integer.parseInt(idKhoangiamtru));
            khoangiamtru1.setMucgiamtru(i);
            khoangiamtruS.capnhatKhoangiamtru(khoangiamtru1);
            return "redirect:/configuration";
        }
        catch (NumberFormatException e)
        {
            model.addAttribute("thongbao","dữ liệu nhập không phải đúng định dạng int (ví dụ đúng : 10000)");
            return "thongbaoCauhinhthue";
        }
    }


}
