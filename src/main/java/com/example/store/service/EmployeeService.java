package com.example.store.service;

import com.example.store.dao.DAOException;
import com.example.store.entity.Employee;
import com.example.store.model.EmployeeModel;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeModel> getAll() throws ServiceException;

    void save(String fio, int idPosition) throws ServiceException;

    Employee getByFio(String fio) throws ServiceException;

    void update(Map params) throws ServiceException;

    void delete(Long id) throws ServiceException;

}
