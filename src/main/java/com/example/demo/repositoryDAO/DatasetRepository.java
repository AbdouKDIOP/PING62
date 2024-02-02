package com.example.demo.repositoryDAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dataset;
import com.example.demo.model.User;

@Repository
public interface DatasetRepository extends JpaRepository<Dataset, Long> {
	Dataset findByIdDataset(Long idDataset);
	List<Dataset> findByUser(User user);
}