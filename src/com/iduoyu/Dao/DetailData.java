package com.iduoyu.Dao;


import com.iduoyu.Entity.Detail;
import com.iduoyu.uilts.JavaUiltsData;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DetailData {
    /**
     *
     * @param sql 传入的sql查询语句
     * @param args 传入的可变参数
     * @return  返回访问书籍的所有章节数
     * @throws
     */

    public static Detail getDetailData(String sql, Object...args) throws SQLException {  //获取单个信息
        QueryRunner queryRunner=new QueryRunner(JavaUiltsData.dataSource);
        Detail query = queryRunner.query(sql, new BeanHandler<Detail>(Detail.class), args);
        return  query;
    }
    public static List<Detail> getDetailDatas(String sql, Object...args) throws SQLException {  //获取多个信息
        QueryRunner queryRunner=new QueryRunner(JavaUiltsData.dataSource);
        List<Detail> query = queryRunner.query(sql, new BeanListHandler<Detail>(Detail.class), args);
        return query;
    }
}
