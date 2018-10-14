package com.iduoyu.Filter;

import com.iduoyu.Dao.DetailData;
import com.iduoyu.Entity.Detail;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebFilter(filterName = "DetailFilter",urlPatterns = "/index.jsp")
public class DetailFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        String sql="select * from detail order by dayturnvolume desc";
        List<Detail> detailDatas=null;

        try {
           detailDatas = DetailData.getDetailDatas(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(detailDatas);
        request.setAttribute("detailDatas",detailDatas);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
