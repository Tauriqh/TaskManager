package za.ac.cput.repository.StudySource;

import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.repository.IRepository;

import java.util.Set;


public interface StudyMaterialRepository extends IRepository<StudyMaterial, String> {
    Set<StudyMaterial> getAll();
}
