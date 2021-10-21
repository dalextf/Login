package dad.login.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends GridPane {
    private Label UserLabel, PassLabel;
    private TextField UserField;
    private PasswordField PassField;
    private Button Access, Cancel;
    private HBox ButtonBox;
    private Alert accessAllowed, accessDenied;

    public View() {

        UserLabel = new Label("Usuario: ");
        PassLabel = new Label("Contraseña: ");
        UserField = new TextField();
        UserField.setPromptText("Usuario");
        PassField = new PasswordField();
        PassField.setPromptText("Contraseña");
        Access = new Button("Acceder");
        Access.setDefaultButton(true);
        Cancel = new Button("Cancelar");


        ButtonBox = new HBox();
        ButtonBox.setSpacing(10);
        ButtonBox.setAlignment(Pos.CENTER);
        ButtonBox.setPadding(new Insets(5));
        ButtonBox.getChildren().addAll(Access, Cancel);
        GridPane.setColumnSpan(ButtonBox, 3);


        this.setPadding(new Insets(15));
        this.setHgap(35);
        this.setVgap(15);
        this.setAlignment(Pos.CENTER);
        this.addRow(0, UserLabel, UserField);
        this.addRow(1, PassLabel, PassField);
        this.addRow(2, ButtonBox);


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
        return UserField;
    }

    public void setUserField(TextField UserField) {
        this.UserField = UserField;
    }


    public TextField getPassField() {
        return PassField;
    }

    public void setPassField(PasswordField PswdField) {
        this.PassField = PswdField;
    }


    public Button getAccess() {
        return Access;
    }

    public void setAccess(Button Access) {
        this.Access = Access;
    }


    public Button getCancel() {
        return Cancel;
    }

    public void setCancel(Button Cancel) {
        this.Cancel = Cancel;
    }


    public Alert getAccessAllowed() {
        return accessAllowed;
    }

    public void setAccessAllowed(Alert accessAllowed) {
        this.accessAllowed = accessAllowed;
    }


    public Alert getAccessDenied() {
        return accessDenied;
    }

    public void setAccessDenied(Alert accessDenied) {
        this.accessDenied = accessDenied;
    }
}
