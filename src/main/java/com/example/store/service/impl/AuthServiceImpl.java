package com.example.store.service.impl;

import com.example.store.dao.AuthDAO;
import com.example.store.dao.DAOException;
import com.example.store.dao.DAOProvider;
import com.example.store.entity.Auth;
import com.example.store.model.EmployeeModel;
import com.example.store.service.AuthService;
import com.example.store.service.ServiceException;

import java.util.Map;

public class AuthServiceImpl implements AuthService {
    @Override
    public EmployeeModel authorise(String login, String password) throws ServiceException {
        EmployeeModel employeeModel;

        DAOProvider provider = DAOProvider.getInstance();
        AuthDAO authDAO = provider.getAuthDAO();

        try{
            employeeModel = authDAO.authorise(login, password);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return employeeModel;
    }

    @Override
    public boolean save(String login, String password, int idEmpl) throws ServiceException {
        boolean isAdded = false;

        DAOProvider provider = DAOProvider.getInstance();
        AuthDAO authDAO = provider.getAuthDAO();

        try{
            isAdded = authDAO.save(login, password, idEmpl);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public boolean save(String login, Long idEmpl) throws ServiceException {
        boolean isAdded = false;

        DAOProvider provider = DAOProvider.getInstance();
        AuthDAO authDAO = provider.getAuthDAO();

        try{
            isAdded = authDAO.save(login, idEmpl);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public boolean update(Map<String, String> params) throws ServiceException {
        boolean isUpdate = false;

        DAOProvider provider = DAOProvider.getInstance();
        AuthDAO authDAO = provider.getAuthDAO();

        try{
            isUpdate = authDAO.update(params);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isUpdate;
    }

    @Override
    public Auth getById(int id) throws ServiceException {
        Auth auth;

        DAOProvider provider = DAOProvider.getInstance();
        AuthDAO authDAO = provider.getAuthDAO();

        try{
            auth = authDAO.getById(id);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return auth;
    }

    @Override
    public void delete(int id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        AuthDAO authDAO = provider.getAuthDAO();

        try{
            authDAO.delete(id);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }
}
