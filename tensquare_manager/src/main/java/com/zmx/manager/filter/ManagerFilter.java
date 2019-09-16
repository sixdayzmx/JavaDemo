package com.zmx.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class ManagerFilter extends ZuulFilter {

    /**
     *在请求前"pre"或者后执行"post"
     *
      * @return
     */
    @Override
    public String filterType() {
        return "pre";//之前过滤
    }

    /**
     *多个过滤器的执行顺序，数字越小，表示越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;//数组越小就越先执行
    }

    /**
     * 当前过滤器是否开启true表示开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作  return 任何object的值都表示继续执行。
     * setsendzullResponse(false)就表示不再继续执行。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("进过后台过滤器了！");
        return null;
    }
}
