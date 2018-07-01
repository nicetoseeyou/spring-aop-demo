package lab.nice.demo.aop.service;

import lab.nice.demo.aop.common.RouteName;
import lab.nice.demo.aop.model.Metrics;

public interface NotifierService {
    void routing(RouteName name, Object[] args);
    void notifyKafka(Metrics metrics);
    void notifyOther(Long other);
}
