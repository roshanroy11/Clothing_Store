package clothing_store;

public class ProductModel {
    public ProductModel(){} // Overloading:

    public  Product addProduct(Product prod){
        return ShoppingCartData.createCartProductSQL(prod);
//        return Prod_Data.createProductSQL(prod);
    }

//    public Product addToCartProduct(Product prod){
//
//    }
}
