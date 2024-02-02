package com.example.demo.services;
import com.example.demo.model.Dataset;
import com.example.demo.repositoryDAO.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DatasetService {

    @Autowired
    private DatasetRepository datasetRepository;

    public List<Dataset> findAll() {
        return datasetRepository.findAll();
    }

}