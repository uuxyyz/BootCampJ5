package com.colvir.lesson07.dao;

import com.colvir.lesson07.model.CarType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CarTypeDaoImpl implements CarTypeDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private RowMapper<CarType> getCarTypeRowMapper() {
        return (rs, rowNum) ->
                new CarType(rs.getInt("id"), rs.getString("name"));
    }

    @Override
    public List<CarType> getCarTypes() {
        return jdbcTemplate.query("select id, name from car_types order by id",
                new MapSqlParameterSource(), getCarTypeRowMapper());

    }
}
