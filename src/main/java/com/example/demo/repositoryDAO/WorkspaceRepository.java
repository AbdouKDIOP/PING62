package com.example.demo.repositoryDAO;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

}
