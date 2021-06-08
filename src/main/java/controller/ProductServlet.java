package controller;

import model.Category;
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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "remove":
                removeForm(request, response);
                break;
            case "search":
                break;
            default:
                showAll(request, response);
                break;
        }
    }


    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "showlist.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        List<Product> product = productService.showAll();
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "create.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        List<Category> categories = categoryService.showAll();
        request.setAttribute("category", categories);
        requestDispatcher.forward(request, response);
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = "update.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Category> categories = categoryService.showAll();
        request.setAttribute("category", categories);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void removeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = "remove.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findListById(id);
        request.setAttribute("category", categories);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            case "search":
                break;
            default:
                showAll(request, response);
                break;
        }
    }


    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amout = Integer.parseInt(request.getParameter("quality"));
        String color = request.getParameter("color");
        String describes = request.getParameter("describes");

        Product product = new Product(name, price, amout, color, describes);

        String[] category1 = request.getParameterValues("category");
        int[] category = new int[category1.length];
        for (int i = 0; i < category.length; i++) {
            category[i] = Integer.parseInt(category1[i]);
        }
        productService.save(product, category);
        response.sendRedirect("/Product");
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quality = Integer.parseInt(request.getParameter("quality"));
        String color = request.getParameter("color");
        String describes = request.getParameter("describes");
        Product product = new Product(name, price, quality, color, describes);
        String[] category1 = request.getParameterValues("category");
        int[] category = new int[category1.length];
        for (int i = 0; i < category.length; i++) {
            category[i] = Integer.parseInt(category1[i]);
        }
        productService.update(id, product, category);
        response.sendRedirect("/Product");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        response.sendRedirect("/Product");
    }
}
