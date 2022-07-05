package com.example.store.service;

import com.example.store.entity.Auth;
import com.example.store.model.EmployeeModel;

import java.util.Map;

public interface AuthService {
    EmployeeModel authorise(String login, String password) throws ServiceException;

    boolean save(String login, String password, int idEmpl) throws ServiceException;

    boolean save(String login, Long idEmpl) throws ServiceException;
    boolean update(Map<String, String> params) throws ServiceException;

    Auth getById(int id) throws ServiceException;

    void delete(int id) throws ServiceException;
}
