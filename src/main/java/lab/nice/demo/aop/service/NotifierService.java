package lab.nice.demo.aop.service;

import lab.nice.demo.aop.model.Metrics;

public interface NotifierService {
    void notifyKafka(Metrics metrics);
    void notifyOther(Long other);
}
