package com.example.store.dao.impl;

import com.example.store.dao.DAOException;
import com.example.store.dao.EmployeeDAO;
import com.example.store.dao.pool.DataSource;
import com.example.store.entity.Employee;
import com.example.store.model.EmployeeModel;
import com.example.store.util.SQLQueryBuilder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDAO {
    private final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);

    private static final String GET_ALL_QUERY ="select auth.id, auth.login, auth.password, employee.fio, position.name " +
            "from employee join auth on auth.id_empl = employee.id " +
            "join position on position.id = employee.id_position";

    private final String INSERT_QUERY = "insert into employee (fio, id_position) values(?, ?) ";
    private final String DELETE_QUERY = "delete from employee where id = ";
    private final String SELECT_BY_ID_QUERY = "select * from employee where id = ";
    private final String SELECT_BY_NAME_QUERY = "select * from employee where fio = ?";

    private static final String ID ="id";
    private static final String LOGIN ="login";
    private static final String PASSWORD ="password";
    private static final String ID_POSITION ="id_position";

    private static final String FIO ="fio";
    private static final String POSITION ="name";

    @Override
    public List<EmployeeModel> getAll() throws DAOException {
        List<EmployeeModel> employees = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            connection = DataSource.getConnection();
            ps = connection.prepareStatement(GET_ALL_QUERY);
            res = ps.executeQuery();

            while (res.next()){
                EmployeeModel employeeModel = new EmployeeModel(res.getInt(ID),
                        res.getString(LOGIN), res.getString(PASSWORD),
                        res.getString(FIO), res.getString(POSITION));

                employees.add(employeeModel);
            }
        } catch (SQLException e) {
            LOGGER.error(" (authorise) -> some problems with extracting data");
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {

        }

        return employees;
    }

    @Override
    public void save(String fio, int idPosition) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DataSource.getConnection();

            statement = connection.prepareStatement(INSERT_QUERY);

            statement.setString(1, fio);
            statement.setInt(2, idPosition);

            statement.executeUpdate();

        } catch (SQLException e){
            LOGGER.error(" (save) -> some problems with saving data");
            throw new DAOException(e);

        } finally {

        }
    }

    @Override
    public void update(Map params) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DataSource.getConnection();

            statement = connection.prepareStatement(SQLQueryBuilder.createSqlUpdateEmployeeQuery(params));

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.error(" (update) -> some problems with updating data");
            throw new DAOException(e);

        } finally {

        }
    }

    @Override
    public Employee getByFio(String fio) throws DAOException {
        Employee employee = null;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            connection = DataSource.getConnection();
            ps = connection.prepareStatement(SELECT_BY_NAME_QUERY);
            ps.setString(1, fio);

            res = ps.executeQuery();

            while (res.next()){
                employee = new Employee(res.getLong(ID),
                        res.getString(FIO), res.getInt(ID_POSITION));

            }
        } catch (SQLException e) {
            LOGGER.error(" (getByFio) -> some problems with extracting data");
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {

        }

        return employee;
    }

    @Override
    public void delete(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(DELETE_QUERY + id);
            statement.executeUpdate();

        } catch (SQLException e){
            LOGGER.error(" (delete) -> some problems with deleting employee");
            throw new DAOException(e);

        } finally {

        }
    }
}
