package com.futumap.webapi.controller;

import com.futumap.webapi.dao.entity.JobCategoryEntity;
import com.futumap.webapi.dao.entity.WorkerEntity;
import com.futumap.webapi.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private static String KEY_JOBS = "worker";
    private static String KEY_CATEGORIES = "categories";

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getAll() {
        List<WorkerEntity> worker = workerService.findAll();
        HashMap<String, Object> combined = new HashMap<>();

        combined.put(KEY_JOBS, worker);

        if (combined.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(combined, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<WorkerEntity> get(@PathVariable("id") Integer id) {

        if (!workerService.exists(id)) {
            return new ResponseEntity<WorkerEntity>(HttpStatus.NOT_FOUND);
        }

        Optional<WorkerEntity> workers = workerService.findById(id);
        return workers.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK)).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public WorkerEntity create(@RequestBody WorkerEntity worker, UriComponentsBuilder ucBuilder) {
        workerService.save(worker);
        return worker;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<WorkerEntity> update(@PathVariable Integer id, @RequestBody WorkerEntity workerEntity) {

        if (workerService.exists(id)) {
            workerService.update(workerEntity);
            return new ResponseEntity<>(workerEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<WorkerEntity> delete(@PathVariable("id") Integer id) {

        if (!workerService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            workerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }

    @RequestMapping(value = "deleteall", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAll() {
        workerService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}