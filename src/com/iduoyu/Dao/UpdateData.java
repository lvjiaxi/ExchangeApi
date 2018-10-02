package com.iduoyu.Dao;

import com.iduoyu.uilts.JavaUiltsData;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 更新一条数据的封装
 */
public class UpdateData {
    public static int UpdateOneData(String sql, Object...args) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(JavaUiltsData.dataSource);
        int update = queryRunner.update(sql,args);
        return update;
    }
}
