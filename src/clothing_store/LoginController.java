package clothing_store;

import java.awt.event.*;
public class LoginController {
    LoginModel model;
    private LoginView view;


    LoginController(LoginModel model, LoginView view){
        this.model = model;
        this.view = view;

        class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ev) {
                view.setCurrentCustomer(model.getCustomer(view.getCustomerAction()));
//                view.setCurrentCustomer(model.loginCustomer(view.loginCustomerAction()));
            }
        }
        view.getCustomerButtonListener(new ButtonListener());
        view.getloginButtonListener(new ButtonListener());

    }
}
