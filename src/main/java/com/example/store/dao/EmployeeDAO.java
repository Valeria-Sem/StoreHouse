package com.example.store.dao;

import com.example.store.entity.Employee;
import com.example.store.model.EmployeeModel;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    List<EmployeeModel> getAll() throws DAOException;

    void save(String fio, int idPosition) throws DAOException;

    void update(Map params) throws DAOException;

    Employee getByFio(String fio) throws DAOException;

    void delete(Long id) throws DAOException;
}
