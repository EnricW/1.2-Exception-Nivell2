package Level1.Exercise1;

import java.util.ArrayList;

public class Sale {
    public ArrayList<Product> products;
    public double totalPrice;

    public Sale() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void calculateTotalPrice() throws EmptySaleException{
       if(products.isEmpty()){
           throw new EmptySaleException("The shopping cart can't be empty!");
       }

        this.totalPrice = 0.0;
        for (Product product : products) {
            this.totalPrice += product.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
