package servlet;

import dao.UserDAO;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户信息添加Servlet
 * @公司 青软实训
 * @作者 fengjj
 */
@WebServlet(name = "UserAddServlet",value = "/UserAddServlet",displayName = "UserAddServlet")
public class UserAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserAddServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求字符编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取用户添加信息
        long telNumber = Long.parseLong(request.getParameter("telNumber"));
        String userPwd = request.getParameter("userPwd");
        String userEmail = request.getParameter("userAddress");
        int userRole = (request.getParameter("userRole") == null) ? 3 : Integer.parseInt(request.getParameter("userRole"));

        // 定义一个用来封装用户信息的JavaBean
        User user =
                new User(telNumber,userPwd,userRole,userEmail);
        // 用户信息添加
        UserDAO dao = new UserDAO();
        dao.register(user);
        // 添加成功，重定向到响应页面
        out.print("<script type='text/javascript'>");
        out.print("alert('注册成功！');");
        out.print("window.location='./login.html';");
        out.print("</script>");

    }
}

