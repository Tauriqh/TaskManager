package za.ac.cput.service.StudySource.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.repository.StudySource.StudyMaterialRepository;
import za.ac.cput.service.StudySource.StudyMaterialService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("studyMaterialServiceImpl")
public class StudyMaterialServiceImpl  implements StudyMaterialService {
    @Autowired
    @Qualifier("studyMaterialRepository")

    private StudyMaterialRepository repository;

    @Override
    public StudyMaterial create(StudyMaterial studyMaterial) {
        return repository.create(studyMaterial);
    }

    @Override
    public StudyMaterial update(StudyMaterial studyMaterial) {
        return repository.update(studyMaterial);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public StudyMaterial read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<StudyMaterial> getAll() {
        return repository.getAll();
    }
}