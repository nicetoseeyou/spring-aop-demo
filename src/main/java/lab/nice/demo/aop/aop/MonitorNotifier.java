package lab.nice.demo.aop.aop;

import lab.nice.demo.aop.model.Metrics;
import lab.nice.demo.aop.service.NotifierService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
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

    @After(value = "execution(* lab.nice.demo.aop.service.impl..*KafkaMonitor*.*save(..))")
    public void afterKafkaMetricsSaved(JoinPoint joinPoint) {
        LOGGER.info("After {}.{} {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), joinPoint.getKind());
        notifierService.notifyKafka((Metrics) joinPoint.getArgs()[0]);
    }

    @After(value = "execution(* lab.nice.demo.aop.service.impl..*OtherMonitor*.*save(..))")
    public void afterOtherMetricsSaved(JoinPoint joinPoint) {
        LOGGER.info("After {}.{} {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), joinPoint.getKind());
        notifierService.notifyOther((Long) joinPoint.getArgs()[0]);
    }
}
