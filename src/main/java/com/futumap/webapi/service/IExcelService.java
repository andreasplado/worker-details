package com.futumap.webapi.service;

import com.futumap.webapi.dao.entity.WorkerEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IExcelService {

    void save(MultipartFile file);
    List<WorkerEntity> getAll();
}
