package com.tzword.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jianghy
 * @Description: 过滤
 * @date 2020/12/8 16:46
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    
    /**
     * @Description: shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @param  1 
     * @return boolean 
     * @throws
     * @author jianghy
     * @date 2020/12/8 16:54 
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    
    /**
     * @Description: run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @param  1 
     * @return java.lang.Object 
     * @throws
     * @author jianghy
     * @date 2020/12/8 16:54 
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >> %s",request.getMethod(),request.getRequestURL()));
        String token = request.getParameter("token");
        if (token == null){
            log.info("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("ok");
        return null;
    }

    /**
     * @Description: filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @param  1 
     * @return java.lang.String 
     * @throws
     * @author jianghy
     * @date 2020/12/8 16:53 
     */
    @Override
    public String filterType() {
        return "pre";
    }

    
    /**
     * @Description: filterOrder：过滤的顺序
     * @param  1 
     * @return int 
     * @throws
     * @author jianghy
     * @date 2020/12/8 16:54 
     */
    @Override
    public int filterOrder() {
        return 0;
    }
}
