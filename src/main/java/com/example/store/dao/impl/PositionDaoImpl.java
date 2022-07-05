package com.example.store.dao.impl;

import com.example.store.dao.DAOException;
import com.example.store.dao.PositionDAO;
import com.example.store.dao.pool.DataSource;
import com.example.store.entity.Position;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDAO {
    private final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);

    private static final String GET_ALL_QUERY ="select * from position";

    private final String INSERT_QUERY = "insert into employee (fio, id_position) values(?, ?) ";
    private final String DELETE_QUERY = "delete from employee where id = ";
    private final String SELECT_BY_ID_QUERY = "select * from auth where id = ";
    private final String SELECT_ID_BY_NAME_QUERY = "select id from position where name = ?";


    private static final String ID ="id";
    private static final String POSITION ="name";
    @Override
    public List<Position> getAll() throws DAOException {
        List<Position> positions = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            connection = DataSource.getConnection();
            ps = connection.prepareStatement(GET_ALL_QUERY);
            res = ps.executeQuery();

            while (res.next()){
                Position position = new Position(res.getLong(ID), res.getString(POSITION));

                positions.add(position);
            }
        } catch (SQLException e) {
            LOGGER.error(" (getAll) -> some problems with extracting data");
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {

        }

        return positions;
    }

    @Override
    public int getIdByName(String name) throws DAOException {
        int positionId = 0;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            connection = DataSource.getConnection();
            ps = connection.prepareStatement(SELECT_ID_BY_NAME_QUERY);
            ps.setString(1, name);
            res = ps.executeQuery();

            while (res.next()){
                positionId = res.getInt(ID);

            }
        } catch (SQLException e) {
            LOGGER.error(" (getAll) -> some problems with extracting data");
            throw new DAOException(e.getLocalizedMessage(), e);

        } finally {

        }

        return positionId;
    }
}
