package net.iouhase.gilbert.model;

public class Product {
    int itemNumber;
    String model;
    String category;
    String image;
    double price;
    int size;

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String name) {
        this.model = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean setSize(int size) {
        if (size > 0) {
            this.size = size;
            return true;
        }
        return false;
    }
}
