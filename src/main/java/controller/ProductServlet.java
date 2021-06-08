package controller;

import model.Product;
import service.IProductService;
import service.ProductService;
import service.category.CategoryService;
import service.category.ICategory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/Product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategory categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":

                break;
            case "update":

                break;
            case "remove":

                break;
            case "search":
                break;
            default:
                    showAll(request,response);
                break;
        }
    }


    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "student/list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        List<Product> students = productService.showAll();
        request.setAttribute("students",students);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
