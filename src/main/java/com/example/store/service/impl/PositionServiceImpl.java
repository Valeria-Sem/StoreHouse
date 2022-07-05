package com.example.store.service.impl;

import com.example.store.dao.DAOException;
import com.example.store.dao.DAOProvider;
import com.example.store.dao.EmployeeDAO;
import com.example.store.dao.PositionDAO;
import com.example.store.entity.Position;
import com.example.store.model.EmployeeModel;
import com.example.store.service.PositionService;
import com.example.store.service.ServiceException;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    @Override
    public List<Position> getAll() throws ServiceException {
        List<Position> positions;

        DAOProvider provider = DAOProvider.getInstance();
        PositionDAO positionDAO = provider.getPositionDAO();

        try{
            positions = positionDAO.getAll();
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return positions;
    }

    @Override
    public int getIdByName(String name) throws ServiceException {
        int id;

        DAOProvider provider = DAOProvider.getInstance();
        PositionDAO positionDAO = provider.getPositionDAO();

        try{
            id = positionDAO.getIdByName(name);
        } catch (DAOException e){
            throw new ServiceException(e.getLocalizedMessage(), e);
        }

        return id;
    }
}
