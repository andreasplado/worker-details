package com.futumap.webapi.service;

import com.futumap.webapi.dao.entity.WorkerEntity;
import com.futumap.webapi.respository.WorkerRepository;
import com.futumap.webapi.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService implements IExcelService {

    final static Logger logger = LoggerFactory.getLogger(ExcelService.class);

    @Autowired
    WorkerRepository repository;

    @Override
    public void save(MultipartFile file) {
        try {
            List<WorkerEntity> tutorials = ExcelUtils.excelToWorkerList(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            logger.error("Error:" + e.getMessage());
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public List<WorkerEntity> getAll() {
        return repository.findAll();
    }
}
