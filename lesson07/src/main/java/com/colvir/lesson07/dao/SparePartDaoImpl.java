package com.colvir.lesson07.dao;

import com.colvir.lesson07.model.CarType;
import com.colvir.lesson07.model.SparePart;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class SparePartDaoImpl implements SparePartDao {
    public static final String DELETE_SPARE_PART = "delete from spare_parts where id = :id";
    public static final String INSERT_SPARE_PART = "insert into spare_parts(name, cost, car_type_id) values (:name, :cost, :car_type_id)";
    public static final String UPDATE_SPARE_PART = "update spare_parts set name = :name, cost = :cost, car_type_id = :car_type_id where id = :id";
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String SELECT_SPARE_PART = """
            select
               sp.id, sp.name, sp.cost, ct.id as carTypeId, ct.name as carTypeName
            from
                spare_parts sp
            inner join car_types ct on ct.id = sp.car_type_id
            """;

    private MapSqlParameterSource getParamsWithId(Integer id) {
        return new MapSqlParameterSource().addValue("id", id);
    }

    private MapSqlParameterSource fillSparePartParams(MapSqlParameterSource params, SparePart sparePart) {
        return params.addValue("name", sparePart.getName()).addValue("cost", sparePart.getCost())
                .addValue("car_type_id", Objects.nonNull(sparePart.getCarType()) ? sparePart.getCarType().getId() : null);
    }

    private RowMapper<SparePart> getSparePartRowMapper() {
        return (rs, rowNum) -> {
            SparePart sparePart = new SparePart();
            sparePart.setId(rs.getInt("id"));
            sparePart.setName(rs.getString("name"));
            sparePart.setCost(rs.getFloat("cost"));
            CarType carType = new CarType();
            carType.setId(rs.getInt("carTypeId"));
            carType.setName(rs.getString("carTypeName"));
            sparePart.setCarType(carType);
            return sparePart;
        };
    }

    public SparePart findById(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SPARE_PART + " where sp.id = :id", getParamsWithId(id), getSparePartRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<SparePart> findAll() {
        return jdbcTemplate.query(SELECT_SPARE_PART + " order by sp.id", new MapSqlParameterSource(), getSparePartRowMapper());
    }

    public int delete(int id) {
        return jdbcTemplate.update(DELETE_SPARE_PART, getParamsWithId(id));
    }

    public SparePart save(SparePart sparePart) {
        SqlParameterSource params = fillSparePartParams(new MapSqlParameterSource(), sparePart);
        if (Objects.isNull(sparePart.getId())) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(INSERT_SPARE_PART, params, keyHolder);
            sparePart.setId((Integer) keyHolder.getKeys().get("id"));
        } else if (jdbcTemplate.update(UPDATE_SPARE_PART, fillSparePartParams(getParamsWithId(sparePart.getId()), sparePart)) == 0) {
            return null;
        }

        return sparePart;
    }
}
