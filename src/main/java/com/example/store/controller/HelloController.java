package com.example.store.controller;

import com.example.store.model.EmployeeModel;
import com.example.store.service.AuthService;
import com.example.store.service.ServiceProvider;
import com.example.store.service.impl.AuthServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText;

    @FXML
    protected void authorisation() {
        String login = loginText.getText();
        String password = passwordText.getText();

        try {
            ServiceProvider provider = ServiceProvider.getInstance();
            AuthService authService = provider.getAuthService();

            EmployeeModel employeeModel = authService.authorise(login, password);

            if(employeeModel.getPosition().equals("Администратор")) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.fxml"));
                Parent registration = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(registration));
                AdminController adminController = fxmlLoader.getController();
                adminController.init(employeeModel);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}