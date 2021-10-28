package dad.login.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class View extends GridPane {

    private Label userLabel, passLabel;
    private TextField userField;
    private PasswordField passField;
    private Button accessButton, cancelButton;
    private HBox buttonBox, checkBox;
    private Alert accessAllowed, accessDenied;
    private CheckBox ldapCheck;

    public View() {

        userLabel = new Label("Usuario: ");
        userLabel.setMaxWidth(Region.USE_PREF_SIZE);
        passLabel = new Label("Contraseña: ");
        passLabel.setMaxWidth(Region.USE_PREF_SIZE);
        userField = new TextField();
        userField.setPromptText("Usuario");
        passField = new PasswordField();
        passField.setPromptText("Contraseña");
        accessButton = new Button("Acceder");
        accessButton.setDefaultButton(true);
        cancelButton = new Button("Cancelar");
        ldapCheck = new CheckBox("Usar LDAP");

        checkBox = new HBox();
        //checkBox.setSpacing(10);
        checkBox.setAlignment(Pos.CENTER);
        //checkBox.setPadding(new Insets(5));
        checkBox.getChildren().addAll(ldapCheck);

        GridPane.setColumnSpan(checkBox, 5);

        buttonBox = new HBox();
        //buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        //buttonBox.setPadding(new Insets(5));
        buttonBox.getChildren().addAll(accessButton, cancelButton);

        GridPane.setColumnSpan(buttonBox, 4);



        this.setPadding(new Insets(15));
        this.setHgap(35);
        this.setVgap(15);
        this.setAlignment(Pos.CENTER);
        this.addRow(0, userLabel, userField);
        this.addRow(1, passLabel, passField);
        this.addRow(2, checkBox);
        this.addRow(3, buttonBox);

        //setGridLinesVisible(true);


        accessAllowed = new Alert(Alert.AlertType.INFORMATION);
        accessAllowed.setTitle("Iniciar Sesión");
        accessAllowed.setHeaderText("Acceso permitido");
        accessAllowed.setContentText("Las credenciales de acceso son válidas.");

        accessDenied = new Alert(Alert.AlertType.ERROR);
        accessDenied.setTitle("Iniciar Sesión");
        accessDenied.setHeaderText("Acceso denegado");
        accessDenied.setContentText("El usuario y/o la contraseña no son válidos.");
    }

    public TextField getUserField() {
        return userField;
    }

    public TextField getPassField() {
        return passField;
    }


    public Button getAccessButton() {
        return accessButton;
    }


    public Button getCancelButton() {
        return cancelButton;
    }


    public Alert getAccessAllowed() {
        return accessAllowed;
    }


    public Alert getAccessDenied() {
        return accessDenied;
    }


    public CheckBox getLdapCheck() {
        return ldapCheck;
    }
}
