package org.acme;

import io.quarkus.arc.profile.IfBuildProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;

@IfBuildProfile("dev")
@Priority(201)
@Interceptor
@Logged
public class LogInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(LogInterceptor.class);

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        LOG.info("Intercepting");
        return ctx.proceed();
    }


}
