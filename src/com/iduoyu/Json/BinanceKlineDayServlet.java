package com.iduoyu.Json;

import com.iduoyu.Dao.DetailData;
import com.iduoyu.Dao.KlineDayDate;
import com.iduoyu.Entity.Detail;
import com.iduoyu.Entity.KlineDay;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * 接口测试，局部刷新
 */
@WebServlet(name = "BinanceKlineDayServlet",urlPatterns = "/BinanceKlineDayJson")
public class BinanceKlineDayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql="select * from klineday where symbol='ETHBTC'";
        List<KlineDay> list=null;
        try {
           list = KlineDayDate.getKlineDayDatas(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter writer = response.getWriter();
        writer.print(list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
