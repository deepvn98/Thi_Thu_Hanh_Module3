package service;

import model.Product;

public interface IProductService extends IService<Product> {
    void save(Product product, int[] category);
    void update(int id, Product product, int [] category);

}
