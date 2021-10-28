package dad.login.ui;


import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;

public class Controller {

    private View view = new View();
    private Model model = new Model();

    public Controller() {

        Bindings.bindBidirectional(view.getUserField().textProperty(), model.UserProperty());
        Bindings.bindBidirectional(view.getPassField().textProperty(), model.PassProperty());

        view.getAccessButton().setOnAction(e -> {
            try {
                onAccessButtonAction(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        view.getCancelButton().setOnAction(f -> Platform.exit());
    }


    private void onAccessButtonAction(ActionEvent e) throws Exception {

        AuthService auth = model.getLdap() ? new LdapAuthService() : new FileAuthService();

        if (auth.login(model.getUser(), model.getPass()) == true) {
            view.getAccessAllowed().showAndWait();
        } else {
            view.getAccessDenied().showAndWait();
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return this.view;
    }

}