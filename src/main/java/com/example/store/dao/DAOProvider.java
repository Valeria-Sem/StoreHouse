package com.example.store.dao;

import com.example.store.dao.impl.AuthDaoImpl;
import com.example.store.dao.impl.EmployeeDaoImpl;
import com.example.store.dao.impl.PositionDaoImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private static final AuthDAO authDAO = new AuthDaoImpl();
    private final EmployeeDAO employeeDAO = new EmployeeDaoImpl();

    private final PositionDAO positionDAO = new PositionDaoImpl();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public AuthDAO getAuthDAO() {
        return authDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public PositionDAO getPositionDAO() {
        return positionDAO;
    }
}
