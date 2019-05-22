package za.ac.cput.repository.StudySource.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.repository.StudySource.StudyMaterialRepository;

import java.util.*;

@Repository("studyMaterialRepository")
public class StudyMaterialRepositoryImpl implements StudyMaterialRepository {

    private static StudyMaterialRepositoryImpl repository = null;
    private Map<String, StudyMaterial> studyMaterials;

    private StudyMaterialRepositoryImpl() {
        this.studyMaterials = new HashMap<>();
    }

    public static StudyMaterialRepository getRepository(){
        if(repository == null) repository = new StudyMaterialRepositoryImpl();
        return repository;
    }

    public StudyMaterial create(StudyMaterial studyMaterial){
        this.studyMaterials.put(studyMaterial.getMaterialId(),studyMaterial);
        return studyMaterial;
    }

    public StudyMaterial read(String studyMaterialId){
        return this.studyMaterials.get(studyMaterialId);
    }

    public StudyMaterial update(StudyMaterial studyMaterial) {
        this.studyMaterials.replace(studyMaterial.getMaterialId(),studyMaterial);
        return this.studyMaterials.get(studyMaterial.getMaterialId());
    }

    public void delete(String getMaterialIdId) {
        this.studyMaterials.remove(getMaterialIdId);
    }

    public Set<StudyMaterial> getAll(){
        Collection<StudyMaterial> studyMaterials = this.studyMaterials.values();
        Set<StudyMaterial> set = new HashSet<>();
        set.addAll(studyMaterials);
        return set;
    }
}

