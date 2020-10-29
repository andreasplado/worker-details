package com.futumap.webapi.service;

import com.futumap.webapi.dao.entity.WorkerEntity;
import java.util.List;
import java.util.Optional;

public interface IWorkerService {

    List<WorkerEntity> findAll();
    WorkerEntity save (WorkerEntity workerEntity);
    Iterable<WorkerEntity> saveAll (List<WorkerEntity> workerEntity);
    WorkerEntity update(WorkerEntity workerEntity);
    void delete(Integer id);
    void deleteAll();
    Optional<WorkerEntity> findById(Integer id);
    boolean exists(Integer id);
}
