package service.category;

import model.Category;
import service.IService;

import java.util.List;

public interface ICategory extends IService<Category> {
    List<Category> findListById(int id_product);
}
