package model;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String describes;
    private List<Category> categorys;

    public Product(int id, String name, double price, int quantity, String color, String describes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
    }

    public Product(String name, double price, int quantity, String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Product(int id, String name, double price, int quantity, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Product(String name, double price, int quantity, String color, String describes) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
    }

    public Product(int id, double price, int quantity, String color, String describes, List<Category> categorys) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
        this.categorys = categorys;
    }

    public Product(int id, double price, int quantity, String color, String describes) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
    }

    public Product() {
    }

    public Product(double price, int quantity, String color, String describes) {
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    public Product(double price, int quantity, String color, String describes, List<Category> categorys) {
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
        this.categorys = categorys;
    }
}
