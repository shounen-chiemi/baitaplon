package test.springweb.controller.thongkethueController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import test.springweb.entity2.Thongke;
import test.springweb.entity2.Thuetncn;
import test.springweb.service.BaocaothueService;
import test.springweb.service.ThueTNCNService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ThongkethueController {
    @Autowired
    private ThueTNCNService tS;
    @Autowired
    private BaocaothueService baocaothueS;
    @RequestMapping("/report")
    public String report(Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách loại thuế TNCN
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập loại thuế TNCN đang chọn
        model.addAttribute("thueTNCN",null);

        //thiết lập loại thuế TNCN đang chọn vào session
        request.getSession().setAttribute("thueTNCN",null);

        //thiết lập thống kê
        Thongke thongke = new Thongke();
        model.addAttribute("thongke",thongke);
        return "admin/report";
    }

    @RequestMapping("/report/thueTNCNid={id}")
    public String chonthuetncn(@PathVariable int id, Model model, HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách loại thuế TNCN
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập loại thuế TNCN đang chọn
        model.addAttribute("thueTNCN",tS.getTenThueTNCNtheoID(id));

        //thiết lập loại thuế TNCN đang chọn vào session
        request.getSession().setAttribute("thueTNCN",id);

        //thiết lập thống kê
        Thongke thongke = new Thongke();
        model.addAttribute("thongke",thongke);
        return "admin/report";
    }

    @RequestMapping("/report/thang")
    public String thongketheothang(Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        if(request.getSession().getAttribute("thueTNCN")==null)
        {
            model.addAttribute("thongbao","chưa chọn loại thuế TNCN");
            return "thongbaoBaocao";
        }


        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách loại thuế TNCN
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập loại thuế TNCN đang chọn
        int idthuetncn = (int) request.getSession().getAttribute("thueTNCN");
        model.addAttribute("thueTNCN", tS.getTenThueTNCNtheoID(idthuetncn));

        //thiết lập dữ liệu thống kê
        Thongke thongke = new Thongke();
        String thgian = request.getParameter("thang");
        //thiết lập thời gian đang chọn hiển thị trên web

        model.addAttribute("thang",thgian);
        if(!thgian.contains("-")) //kiểm tra xem chọn tháng chưa
        {
            model.addAttribute("thongbao","chưa chọn tháng");
            return "thongbaoBaocao";
        }
        StringTokenizer s = new StringTokenizer(thgian,"-");
        String namT = s.nextToken();
        String thangT = s.nextToken();

        int nam = Integer.parseInt(namT);
        int thang = Integer.parseInt(thangT);
        thongke = baocaothueS.getDsbaocaothueTheoThang(nam,thang,idthuetncn);
        model.addAttribute("thongke",thongke);
        model.addAttribute("thoigian","Tháng "+thang + " Năm " + nam );
        return "admin/report";
    }

    @RequestMapping("/report/nam")
    public String thongketheonam(Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("thanhvien")==null)
        {
            return "index";
        }
        if(request.getSession().getAttribute("thueTNCN")==null)
        {
            model.addAttribute("thongbao","chưa chọn loại thuế TNCN");
            return "thongbaoBaocao";
        }

        //thiết lập tên người đăng nhập từ session
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);

        //thiết lập danh sách loại thuế TNCN
        List<Thuetncn> dsThueTNCN = tS.getDsTheloaiThueTNCN();
        model.addAttribute("dsTheloai",dsThueTNCN);

        //thiết lập loại thuế TNCN đang chọn
        int idthuetncn = (int) request.getSession().getAttribute("thueTNCN");
        model.addAttribute("thueTNCN", tS.getTenThueTNCNtheoID(idthuetncn));

        Thongke thongke = new Thongke();
        String thgian = request.getParameter("nam");
        //thiết lập thời gian đang chọn hiển thị trên web
        model.addAttribute("nam",thgian);
        //thiết lập dữ liệu thời gian trên table
        String time = "Năm "+ thgian;
        model.addAttribute("thoigian",time);
        //kiểm tra năm nhập vào có hợp lệ không
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(thgian);
        if(m.find())
        {
            model.addAttribute("thongbao","dữ liệu không hợp lệ, có chứa kí tự khác ngoài số");
            return "thongbaoBaocao";
        }
        thongke = baocaothueS.getDsbaocaothueTheoNam(thgian,idthuetncn);
        model.addAttribute("thongke",thongke);
        return "admin/report";

    }


}
