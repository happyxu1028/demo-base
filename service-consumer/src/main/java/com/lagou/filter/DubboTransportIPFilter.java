package com.lagou.filter;

import com.lagou.holder.WebRequestHolder;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 21:17
 */
@Activate(group = {CommonConstants.CONSUMER})
public class DubboTransportIPFilter implements Filter {


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        ServletRequest servletRequest = WebRequestHolder.getServletRequest();
        if(null != servletRequest){
            RpcContext.getContext().setAttachment("request_host_ip", servletRequest.getRemoteHost());
        }


        return invoker.invoke(invocation);
    }

}
