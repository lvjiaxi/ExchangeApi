package com.iduoyu.Json;

import com.iduoyu.Dao.DetailData;
import com.iduoyu.Entity.Detail;
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
@WebServlet(name = "HuobiServlet",urlPatterns = "/HuobiJson")
public class HuobiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql="select * from detail where exchange=1";
        List<Detail> list=null;
        try {
           list = DetailData.getDetailDatas(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter writer = response.getWriter();
        writer.print(jsonArray);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
