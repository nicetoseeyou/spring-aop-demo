package lab.nice.demo.aop.aop;

import lab.nice.demo.aop.common.RouteName;
import lab.nice.demo.aop.service.NotifierService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorNotifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorNotifier.class);

    @Autowired
    private NotifierService notifierService;

    @Pointcut(value = "execution(* lab.nice.demo.aop.service.impl..*Monitor*.*save(..))")
    public void pointCut() {
    }

    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("After {}.{} {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), joinPoint.getKind());
        notifierService.routing(RouteName.KAFKA, joinPoint.getArgs());
    }
}
