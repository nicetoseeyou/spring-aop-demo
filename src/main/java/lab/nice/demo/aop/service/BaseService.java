package lab.nice.demo.aop.service;

public interface BaseService<Entity, ID> {
    void save(Entity entity);

    Entity findById(ID id);
}
