package com.example.store.service;

import com.example.store.service.impl.AuthServiceImpl;
import com.example.store.service.impl.EmployeeServiceImpl;
import com.example.store.service.impl.PositionServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final AuthService authService = new AuthServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final PositionService positionService = new PositionServiceImpl();



    public ServiceProvider() {
    }


    public static ServiceProvider getInstance() {
        return instance;
    }

    public AuthService getAuthService() {
        return authService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public PositionService getPositionService() {
        return positionService;
    }
}
