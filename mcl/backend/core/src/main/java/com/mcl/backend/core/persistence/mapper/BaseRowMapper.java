package com.mcl.backend.core.persistence.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("baseRowMapper")
public abstract class BaseRowMapper<T extends Object> implements RowMapper<T> {

	private Set<String> setAvailableColumns;
	
    private ResultSet rs;
    
    public BaseRowMapper() {
    }
    
    private void init(ResultSet rs) throws SQLException {
        this.rs = rs;
        setAvailableColumns = new HashSet<String>();
        final ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        
        // Get the column names; column indices start from 1
        for (int i = 1; i < (columnCount + 1); i++) {
            setAvailableColumns.add(rsmd.getColumnLabel(i));
        }
    }
 
    @Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        
            init(rs);
        return mapRowImpl(rs, rowNum);
    }
 
    public abstract T mapRowImpl(ResultSet rs, int rowNum) throws SQLException;
 
    public boolean hasColumn(String columnLabel) {
        return (setAvailableColumns.contains(columnLabel));
    }
}
