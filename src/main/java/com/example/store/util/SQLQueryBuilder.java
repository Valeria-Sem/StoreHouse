package com.example.store.util;

import java.util.Map;

public class SQLQueryBuilder {

    public static String createSqlUpdateAuthQuery(Map<String, String> properties) {
        StringBuilder sql = new StringBuilder("update auth set ");

        for (String property : properties.keySet()) {
            switch (property) {
                case ("login"):
                    if (properties.get(property) != null) {
                        sql.append(" login = '").append(properties.get(property)).append("' ,");
                    }
                    break;
                case ("password"):
                    if (properties.get(property) != null) {
                        sql.append(" password = '").append(properties.get(property)).append("' ,");
                    }
                    break;
                case ("id"):
                    if (properties.get(property) != null) {
                        sql.append(" where id = ").append(properties.get(property));
                    }
                    break;
                default:
                    int coma = sql.lastIndexOf(",");
                    if(coma > 0) {
                        sql.deleteCharAt(coma);
                    }
                    break;
            }
        }

        return sql.toString();
    }

    public static String createSqlUpdateEmployeeQuery(Map properties) {
        StringBuilder sql = new StringBuilder("update employee set ");

        for (Object property : properties.keySet()) {
            switch (property.toString()) {
                case ("fio"):
                    if (properties.get(property) != null) {
                        sql.append(" fio = '").append(properties.get(property)).append("' ,");
                    }
                    break;
                case ("position"):
                    if (properties.get(property) != null) {
                        sql.append(" id_position = ").append(properties.get(property)).append(" ,");
                    }
                    break;
            }
        }

        if (properties.get("id") != null) {
            sql.append(" where id = ").append(properties.get("id"));
        }

        int coma = sql.lastIndexOf(",");
        if(coma > 0) {
            sql.deleteCharAt(coma);
        }

        return sql.toString();
    }
}
