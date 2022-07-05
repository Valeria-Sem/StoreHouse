package com.example.store.service;

import com.example.store.dao.DAOException;
import com.example.store.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAll() throws ServiceException;

    int getIdByName(String name) throws ServiceException;


}
