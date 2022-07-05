package com.example.store.dao;

import com.example.store.entity.Position;

import java.util.List;

public interface PositionDAO {
    List<Position> getAll() throws DAOException;

    int getIdByName(String name) throws DAOException;
}
