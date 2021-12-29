package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dao.RiderDao;
import javabean.Order;

@WebServlet(name = "RiderServlet", value = "/RiderServlet")
public class RiderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> list = (List<Order>) request.getAttribute("list");
        List<Order> work = new ArrayList();
        RiderDao dao = new RiderDao();
        String type = request.getParameter("type");
        if ("list".equals(type))
        {
          List<Order> orders =  dao.selectAll();
          request.setAttribute("list",orders);
          request.getRequestDispatcher("ridermenu.jsp").forward(request,response);
        }
        else if ("showmenu".equals(type)) {
            for (Order order :
                    list) {
                String id = request.getParameter(order.getId() + "clean");
                if (id != null) {
                    order.setStatus(2);
                    work.add(order);
                    list.remove(list.indexOf(order));
                }
            }
            request.setAttribute("work", work);
            request.getRequestDispatcher("ridermenu.jsp").forward(request, response);
        }
    }
}
