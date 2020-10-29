package com.futumap.webapi.service;

import com.futumap.webapi.dao.entity.WorkerEntity;
import com.futumap.webapi.respository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService implements IWorkerService {

    @Autowired
    private WorkerRepository repository;

    @Override
    public List<WorkerEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public WorkerEntity save(WorkerEntity workerEntity) {
        return repository.save(workerEntity);
    }

    @Override
    public Iterable<WorkerEntity> saveAll(List<WorkerEntity> workerEntity) {
        return repository.saveAll(workerEntity);
    }

    @Override
    public WorkerEntity update(WorkerEntity workerEntity) {
        if(repository.existsById(workerEntity.getId())){
            repository.save(workerEntity);
        }
        return workerEntity;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<WorkerEntity> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return repository.existsById(id);
    }

}