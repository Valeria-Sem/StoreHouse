package com.example.store.dao;

import com.example.store.entity.Auth;
import com.example.store.model.EmployeeModel;

import java.util.Map;

public interface AuthDAO {
    EmployeeModel authorise(String login, String password) throws DAOException;

    boolean save(String login, String password, int idEmpl) throws DAOException;

    boolean save(String login, Long idEmpl) throws DAOException;


    boolean update(Map<String, String> params) throws DAOException;

    Auth getById(int id) throws DAOException;

    void delete(int id) throws DAOException;
}
