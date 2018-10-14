package com.iduoyu.Dao;

import com.iduoyu.Entity.KlineDay;
import com.iduoyu.uilts.JavaUiltsData;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class KlineDayDate {
    public static KlineDay getOneKlineDayData(String sql, Object...args) throws SQLException {  //获取单个信息
        QueryRunner queryRunner=new QueryRunner(JavaUiltsData.dataSource);
        KlineDay query = queryRunner.query(sql, new BeanHandler<KlineDay>(KlineDay.class), args);
        return  query;
    }
    public static  List<KlineDay> getKlineDayDatas(String sql, Object...args) throws SQLException {  //获取多个信息
        QueryRunner queryRunner=new QueryRunner(JavaUiltsData.dataSource);
        List<KlineDay> query = queryRunner.query(sql, new BeanListHandler<KlineDay>(KlineDay.class), args);
        return query;
    }
}
