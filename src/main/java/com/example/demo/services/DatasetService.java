package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dataset;
import com.example.demo.model.User;
import com.example.demo.repositoryDAO.DatasetRepository;

@Service
public class DatasetService {

    @Autowired
    private DatasetRepository datasetRepository;

    public List<Dataset> findAll() {
        return datasetRepository.findAll();
    }

    public Dataset save(Dataset dataset) {
        return datasetRepository.save(dataset);
    }

    public List<Dataset> getDatasetByUser(User user) {
        return datasetRepository.findByUser(user);
    }
}