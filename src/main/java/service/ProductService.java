package service;

import connection.ConnectionJDBC;
import model.Category;
import model.Product;
import service.category.CategoryService;
import service.category.ICategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    Connection connection = ConnectionJDBC.getConnection();
    ICategory categoryService = new CategoryService();

    @Override
    public void save(Product product, int[] category) {
        int idProduct = 0;
        String sql = "insert into product(name_product, price, quantity, color, describes) value (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescribes());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                idProduct = resultSet.getInt(1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql1 ="insert into productcategory(id_product,id_category) value (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            for (int id:category) {
                preparedStatement.setInt(2,id);
                preparedStatement.setInt(1,idProduct);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(int id, Product product, int[] category) {

    }

    @Override
    public List<Product> showAll() {
        List<Product> productList = new ArrayList<>();
        String sql ="select d.id,d.name_product,d.price,d.quantity,d.color,c.name from product d join productcategory p on d.id = p.id_product\n" +
                "join category c on c.id = p.id_category";

        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("d.id");
                String name = resultSet.getString("d.name_product");
                double price = resultSet.getDouble("d.price");
                int quanlity = resultSet.getInt("d.quantity");
                String color = resultSet.getString("d.color");
                Product product = new Product(id,name,price,quanlity,color);
                List<Category> categories = categoryService.findListById(id);
                product.setCategorys(categories);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productList;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(int id, Product product) {


    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findListById(int id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
