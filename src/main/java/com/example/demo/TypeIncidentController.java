package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TypeIncident;
import com.example.demo.services.TypeIncidentService;
import com.example.demo.repositoryDAO.TypeIncidentRepository;
import java.util.List;

@RestController
@RequestMapping("/type-incidents")
public class TypeIncidentController {

    private final TypeIncidentService typeIncidentService;

    @Autowired
    public TypeIncidentController(TypeIncidentService typeIncidentService) {
        this.typeIncidentService = typeIncidentService;
    }

    @GetMapping
    public ResponseEntity<List<TypeIncident>> getAllTypeIncidents() {
        List<TypeIncident> typeIncidents = typeIncidentService.getAllTypeIncidents();
        return ResponseEntity.ok(typeIncidents);
    }

   /* @PostMapping
    public ResponseEntity<TypeIncident> createTypeIncident(@RequestBody TypeIncident typeIncident) {
        TypeIncident createdTypeIncident = typeIncidentService.createTypeIncident(typeIncident);
        return ResponseEntity.ok(createdTypeIncident);
    }
*/
    
}
