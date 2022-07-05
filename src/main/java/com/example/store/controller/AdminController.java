package com.example.store.controller;

import com.example.store.entity.Employee;
import com.example.store.entity.Position;
import com.example.store.model.EmployeeModel;
import com.example.store.service.AuthService;
import com.example.store.service.EmployeeService;
import com.example.store.service.PositionService;
import com.example.store.service.ServiceProvider;
import com.example.store.service.impl.AuthServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminController {
    private EmployeeModel employeeModel;

    private ObservableList<EmployeeModel> employeesData;

    private ServiceProvider provider = ServiceProvider.getInstance();
    private EmployeeService employeeService = provider.getEmployeeService();
    private PositionService positionService = provider.getPositionService();
    private AuthService authService = provider.getAuthService();



    @FXML
    private Label welcomeLabel;
    @FXML
    private TableView<EmployeeModel> employeeTable;
    @FXML
    private TextField loginTxt;
    @FXML
    private TextField fioTxt;
    @FXML
    private ComboBox<String> positionBox;

    @FXML
    public void init(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;

        welcomeLabel.setText(employeeModel.getPosition() + " " + employeeModel.getFio());


        try{
            List<EmployeeModel> employees = employeeService.getAll();
            employeesData = FXCollections.observableArrayList(employees);

            TableColumn<EmployeeModel, String> loginColumn = new TableColumn<>("Логин");
            loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));

            TableColumn<EmployeeModel, String> passwordColumn = new TableColumn<>("Пароль");
            passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

            TableColumn<EmployeeModel, String> fioColumn = new TableColumn<>("ФИО");
            fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));

            TableColumn<EmployeeModel, String> positionColumn = new TableColumn<>("Должность");
            positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

            employeeTable.setItems(employeesData);
            employeeTable.getColumns().addAll(loginColumn, passwordColumn, fioColumn, positionColumn);

            List<Position> positions = positionService.getAll();
            List<String> positionsNames = new ArrayList<>();


            positions.forEach(position ->
                    positionsNames.add(position.getName()));

            positionBox.setItems(FXCollections.observableArrayList(positionsNames));

            /////////////////////////////////////////////////////////////

        } catch (Exception e){

        }
    }

    public void addNewEmployee(){
        String login = loginTxt.getText();
        String fio = fioTxt.getText();
        String position = positionBox.getValue();


        int idPosition;

        try {
            employeesData.clear();

            idPosition = positionService.getIdByName(position);

            employeeService.save(fio, idPosition);

            Employee employee = employeeService.getByFio(fio);

            authService.save(login, employee.getId());

            employeesData.addAll(employeeService.getAll());

            loginTxt.setText("");
            fioTxt.setText("");

        } catch (Exception e){
            e.printStackTrace();
            e.getLocalizedMessage();
        }
    }

    public void updateEmployee(){
        if (fioTxt.getText().isEmpty() && positionBox.getValue() == null){
            return;
        }

        String newFio;
        String oldFio;
        String position;

        Map params = new HashMap<>();

        int idPosition;
        Long idEmployee;

        try {
            TableView.TableViewSelectionModel<EmployeeModel> currentEmployee = employeeTable.getSelectionModel();
            oldFio = currentEmployee.getSelectedItem().getFio();
            idEmployee = employeeService.getByFio(oldFio).getId();

            if(!fioTxt.getText().isEmpty()){
                newFio = fioTxt.getText();

                params.put("fio", newFio);
            }

            if (positionBox.getValue() != null){
                position = positionBox.getValue();
                idPosition = positionService.getIdByName(position);

                params.put("position", idPosition);
            }

            params.put("id", idEmployee);

            employeesData.clear();
            employeeService.update(params);
            employeesData.addAll(employeeService.getAll());

            loginTxt.setText("");
            fioTxt.setText("");


        } catch (Exception e){
            e.printStackTrace();
            e.getLocalizedMessage();
        }
    }

    public void deleteEmployee(){
        String fio;
        Long idEmployee;

        try {
            TableView.TableViewSelectionModel<EmployeeModel> currentEmployee = employeeTable.getSelectionModel();
            fio = currentEmployee.getSelectedItem().getFio();
            idEmployee = employeeService.getByFio(fio).getId();

            employeesData.clear();
            employeeService.delete(idEmployee);
            employeesData.addAll(employeeService.getAll());

            loginTxt.setText("");
            fioTxt.setText("");


        } catch (Exception e){
            e.printStackTrace();
            e.getLocalizedMessage();
        }
    }
}
