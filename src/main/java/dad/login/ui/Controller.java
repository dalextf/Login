package dad.login.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;

public class Controller {

    private View view = new View();
    private Model model = new Model();
    private ArrayList<String> linesCSV = new ArrayList<>();

    public Controller() {

        readUsersFile();



        view.getAccess().setOnAction(e -> onAccessButtonAction(e));
        view.getCancel().setOnAction(f -> Platform.exit());
    }

    private void readUsersFile() {

        try {
            File file = new File ("users.csv");
            FileReader readFile = new FileReader(file, Charset.forName("UTF-8"));
            BufferedReader usersRead = new BufferedReader(readFile);
            String lines;


            while ((lines = usersRead.readLine()) != null) {
                linesCSV.add(lines);
            }
            usersRead.close();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }

    private void onAccessButtonAction(ActionEvent e) {

        Boolean verify = false;
        String md5Password = DigestUtils.md5Hex(view.getPassField().textProperty().get()).toUpperCase();
        String md5User = model.getUser();


        for (int i = 0; i < linesCSV.size(); i++) {
            String[] dataFile = linesCSV.get(i).split(";");
            String userEach = dataFile[0];
            String passEach = dataFile[1];

            if (userEach.equals(md5User) && passEach.equals(md5Password)) { verify = true; }
        }

        if (verify == true) { view.getAccessAllowed().showAndWait(); }

        else { view.getAccessDenied().showAndWait(); }
    }

    public View getView() {
        return this.view;
    }
}