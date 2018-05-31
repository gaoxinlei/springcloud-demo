package com.example.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            int factor = (int)(100*Math.random());
            if(factor%5==1){
                context.getResponse().setCharacterEncoding("UTF-8");
                context.getResponse().setContentType("application/json;charset=utf-8");
                context.set("isSuccess",false);
                try {
                    context.getResponse().getWriter().write("无token加上运气不好,运气因子:"+factor);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        context.getResponse().getWriter().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                context.set("isSuccess",true);
            }
        }
        return null;
    }
}
