package clothing_store;
import java.awt.event.*;
public class ProductController {
    private ProductModel model;
    private ProductView view;


    ProductController(ProductModel model, ProductView view) {
        this.model = model; // encapsulation
        this.view = view;  // encapsulation

        class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ev) {
                // Abstraction:The view object calls the methods to retrieve user input
                // the model object calls its methods to update the data.
//                view.setCurrentProduct(model.getProduct(view.getProductAction()));
                view.setCurrentProduct(model.addProduct(view.addProductAction()));

//                view.setCurrentProduct(model.addToCartProduct(view.addProductAction()));
            }
        }
        // Interfaces/Polymorphism: The view object adds an instance of the ButtonListener class
        // as an action listener to each button
        view.addToCartButtonListener(new ButtonListener());

    }
}
