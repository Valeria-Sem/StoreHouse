package com.example.store.dao.impl;

import com.example.store.dao.AuthDAO;
import com.example.store.dao.DAOException;
import com.example.store.dao.pool.DataSource;
import com.example.store.entity.Auth;
import com.example.store.model.EmployeeModel;
import com.example.store.util.SQLQueryBuilder;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Map;

public class AuthDaoImpl implements AuthDAO {
    private final Logger LOGGER = Logger.getLogger(AuthDaoImpl.class);

    private static final String AUTHORISE_QUERY ="select auth.id, auth.login, auth.password, employee.fio, position.name " +
            "from auth join employee on auth.id_empl = employee.id " +
            "join position on position.id = employee.id_position " +
            "where auth.login = ? and auth.password = ?";

    private final String INSERT_QUERY = "insert into auth (login, password, id_empl) values(?, ?, ?) ";
    private final String DELETE_QUERY = "delete from auth where id = ";
    private final String SELECT_BY_ID_QUERY = "select * from auth where id = ";

    private final String SAVE_NEW_EMPLOYEE_AUTH = "{call save_new_emp_auth(?, ?)}";



    private static final String ID ="id";
    private static final String LOGIN ="login";
    private static final String PASSWORD ="password";
    private static final String ID_EMPL ="id_empl";

    private static final String FIO ="fio";
    private static final String POSITION ="name";



    @Override
    public EmployeeModel authorise(String login, String password) throws DAOException {
        EmployeeModel employeeModel = null;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            connection = DataSource.getConnection();
            ps = connection.prepareStatement(AUTHORISE_QUERY);
            ps.setString(1, login);
            ps.setString(2, password);
            res = ps.executeQuery();

            while (res.next()){
                employeeModel = new EmployeeModel(res.getInt(ID), res.getString(LOGIN), res.getString(PASSWORD),
                        res.getString(FIO), res.getString(POSITION));


            }
        } catch (SQLException e) {
            LOGGER.error(" (authorise) -> some problems with extracting data");
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {

        }

        return employeeModel;
    }

    @Override
    public boolean save(String login, String password, int idEmpl) throws DAOException {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DataSource.getConnection();

            statement = connection.prepareStatement(INSERT_QUERY);

            statement.setString(1, login);
            statement.setString(2, password);
            statement.setInt(3, idEmpl);

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException e){
            LOGGER.error(" (save) -> some problems with saving data");
            throw new DAOException(e);

        } finally {

        }

        return isAdded;
    }

    @Override
    public boolean save(String login, Long idEmpl) throws DAOException {
        boolean isAdded = false;
        Connection connection = null;
        CallableStatement statement = null;

        try{
            connection = DataSource.getConnection();

            statement = connection.prepareCall(SAVE_NEW_EMPLOYEE_AUTH);

            statement.setString(1, login);
            statement.setLong(2, idEmpl);

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException e){
            LOGGER.error(" (save) -> some problems with saving data");
            throw new DAOException(e);

        } finally {

        }

        return isAdded;
    }

    @Override
    public boolean update(Map<String, String> params) throws DAOException {
        boolean isUserUpdate;
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DataSource.getConnection();

            statement = connection.prepareStatement(SQLQueryBuilder.createSqlUpdateAuthQuery(params));

            statement.executeUpdate();
            statement.close();

            isUserUpdate = true;

        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.error(" (update) -> some problems with updating data");
            throw new DAOException(e);

        } finally {

        }

        return isUserUpdate;

    }

    @Override
    public Auth getById(int id) throws DAOException {
        Auth auth = null;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            connection = DataSource.getConnection();
            ps = connection.prepareStatement(SELECT_BY_ID_QUERY + id);
            res = ps.executeQuery();

            while (res.next()){
                auth = new Auth(res.getInt(ID), res.getString(LOGIN), res.getString(PASSWORD), res.getLong(ID_EMPL));


            }
        } catch (SQLException e) {
            LOGGER.error(" (getById) -> some problems with extracting data");
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {

        }

        return auth;
    }

    @Override
    public void delete(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(DELETE_QUERY + id);
            statement.executeUpdate();

        } catch (SQLException e){
            LOGGER.error(" (delete) -> some problems with deleting auth");
            throw new DAOException(e);

        } finally {

        }
    }
}
