package lab.nice.demo.aop.service.impl;

import lab.nice.demo.aop.common.RouteName;
import lab.nice.demo.aop.model.Metrics;
import lab.nice.demo.aop.service.NotifierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "notifierService")
public class NotifierServiceImpl implements NotifierService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotifierServiceImpl.class);

    @Override
    public void routing(RouteName name, Object[] args) {
        LOGGER.info("Routing with Routing Name: {}", name);
        switch (name) {
            case KAFKA:
                notifyKafka((Metrics) args[0]);
                break;
            case OTHER:
                notifyOther((Long) args[0]);
                break;
            default:
                LOGGER.info("Not Supported Notifier Routing Name {}", name);
        }
    }

    @Override
    public void notifyKafka(Metrics metrics) {
        LOGGER.info("Notify Kafka {}", metrics);
    }

    @Override
    public void notifyOther(Long other) {
        LOGGER.info("Notify Other {}", other);
    }
}
