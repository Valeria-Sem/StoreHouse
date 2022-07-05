package com.example.store.service.impl;

import com.example.store.dao.AuthDAO;
import com.example.store.dao.DAOException;
import com.example.store.dao.DAOProvider;
import com.example.store.dao.EmployeeDAO;
import com.example.store.entity.Employee;
import com.example.store.model.EmployeeModel;
import com.example.store.service.EmployeeService;
import com.example.store.service.ServiceException;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<EmployeeModel> getAll() throws ServiceException {
        List<EmployeeModel> employeeModels;

        DAOProvider provider = DAOProvider.getInstance();
        EmployeeDAO employeeDAO = provider.getEmployeeDAO();

        try{
            employeeModels = employeeDAO.getAll();
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return employeeModels;
    }

    @Override
    public void save(String fio, int idPosition) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        EmployeeDAO employeeDAO = provider.getEmployeeDAO();

        try{
            employeeDAO.save(fio, idPosition);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Employee getByFio(String fio) throws ServiceException {
        Employee employee;

        DAOProvider provider = DAOProvider.getInstance();
        EmployeeDAO employeeDAO = provider.getEmployeeDAO();

        try{
            employee = employeeDAO.getByFio(fio);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return employee;
    }

    @Override
    public void update(Map params) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        EmployeeDAO employeeDAO = provider.getEmployeeDAO();

        try{
            employeeDAO.update(params);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        EmployeeDAO employeeDAO = provider.getEmployeeDAO();

        try{
            employeeDAO.delete(id);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }
    }
}
