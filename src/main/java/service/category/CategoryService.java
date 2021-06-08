package service.category;

import connection.ConnectionJDBC;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {
    Connection connection = ConnectionJDBC.getConnection();

    @Override
    public List<Category> showAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id,name);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;


    }

    @Override
    public void create(Category category) {

    }

    @Override
    public void update(int id, Category category) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public List<Category> findListById(int id_product) {
        List<Category> categories = new ArrayList<>();
        String sql = "select name from category join productcategory p on category.id = p.id_category\n" +
                "where id_product = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_product);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Category category = new Category(name);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categories;
    }
}
