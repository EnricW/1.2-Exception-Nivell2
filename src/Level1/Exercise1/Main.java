package Level1.Exercise1;

public class Main {
    public static void main(String[] args) {
        Sale firstSale = new Sale();
        try {
            firstSale.calculateTotalPrice();
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        Sale secondSale = new Sale();
        secondSale.addProduct(new Product("Tomato", 0.70));
        secondSale.addProduct(new Product("Potato", 1.20));

        try {
            secondSale.calculateTotalPrice();
            System.out.println("Total price: " + secondSale.getTotalPrice() + " €");
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        try {
            for (Product p : secondSale.products) {
                System.out.println("Item: " + p.getName());
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            System.out.println("Item in the shopping cart: " + secondSale.products.get(2).getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
