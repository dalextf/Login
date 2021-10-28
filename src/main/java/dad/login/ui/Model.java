package dad.login.ui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private StringProperty user = new SimpleStringProperty();
    private StringProperty pass = new SimpleStringProperty();
    private BooleanProperty Ldap = new SimpleBooleanProperty();

    public final StringProperty UserProperty() {
        return this.user;
    }

    public final String getUser() {
        return this.UserProperty().get();
    }

    public final void setUser(final String User) {
        this.UserProperty().set(User);
    }

    public final StringProperty PassProperty() {
        return this.pass;
    }

    public final String getPass() {
        return this.PassProperty().get();
    }

    public final void setPass(final String pass) {
        this.PassProperty().set(pass);
    }

    public boolean getLdap() {
        return Ldap.get();
    }

    public BooleanProperty ldapProperty() {
        return Ldap;
    }

    public void setLdap(boolean ldap) {
        this.Ldap.set(ldap);
    }
}
