package com.zt.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p/>类文件: com.zt.filter
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/18 16:11
 */
//@Component
public class GatewayFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(GatewayFilter.class);
    /**
     * <p/>方法功能描述: 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @作者: luj
     * @时间: 2017/4/18 16:16
     */
    @Override
    public String filterType() {
        return "pre";
    }
    
    /**
     * <p/>方法功能描述: 过滤的顺序
     * 
     * @作者: luj
     * @时间: 2017/4/18 16:12
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * <p/>方法功能描述: 这里可以写逻辑判断，是否要过滤，true,永远过滤。 默认false
     *
     * @作者: luj
     * @时间: 2017/4/18 16:13
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("request.getMethod: {} request.getRequestURL: {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        logger.info("request.getParameter a: {}", request.getParameter("a"));
        if(accessToken == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        logger.info("ok");
        return null;
    }
}
