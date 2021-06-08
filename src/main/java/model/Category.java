package model;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Product> list;

    public Category() {
    }

    public Category(String name, List<Product> list) {
        this.name = name;
        this.list = list;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name, List<Product> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
