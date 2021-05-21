package test.springweb.controller.thanhvienController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.springweb.entity2.Thanhvien;
import test.springweb.service.ThanhvienService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class ThanhvienController {
    @Autowired
    private ThanhvienService tvs;

    @RequestMapping("loginuser")
    public String Dangnhap(HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirect){
        String taikhoan = request.getParameter("txtU");
        String matkhau = request.getParameter("txtP");

        if(taikhoan.trim().equals(""))
        {
            model.addAttribute("thongbao","Tài khoản không được chứa khoảng trắng");
            return "thongbaoDangnhap";
        }
        if(matkhau.trim().equals(""))
        {
            model.addAttribute("thongbao","Mật khẩu không được chứa khoảng trắng");
            return "thongbaoDangnhap";
        }

        Thanhvien thanhvien = tvs.login(taikhoan,matkhau);
        if(Objects.nonNull(thanhvien)) {
            String name = thanhvien.getNhanvien().getHo() + " " + thanhvien.getNhanvien().getTendem() + " " + thanhvien.getNhanvien().getTen();
            model.addAttribute("thvien", name);
            request.getSession().setAttribute("thanhvien",name);
            return "redirect:/list-taxpayer";
        }
        else
        {
            model.addAttribute("thongbao","Đăng nhập thất bại, tài khoản hoặc mật khẩu không chính xác");
            return "thongbaoDangnhap";
        }


    }

    @RequestMapping("logout")
    public String Dangxuat(HttpServletRequest request, RedirectAttributes redirect)
    {
        request.getSession().setAttribute("thanhvien",null);
        return "redirect:/index";
    }
}
