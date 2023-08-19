package clothing_store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignUpController {
    private SignUpModel model;
    private SignUpView view;

    SignUpController(SignUpModel model, SignUpView view) {
        this.model = model;
        this.view = view;
        // override of the Button Listener
        class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ev) {
                view.setCurrentCustomer(model.addCustomer(view.addCustomerAction()));
//                view.setCurrentCustomer(model.addCustomer(view.updateCustomerAction()));
            }
        }
//        view.getCustomerButtonListener(new ButtonListener());
        view.createCustomerButtonListener(new ButtonListener());
    }
}
