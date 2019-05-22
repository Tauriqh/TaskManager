package za.ac.cput.service.StudySource;

import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.service.IService;

import java.util.Set;

public interface StudyMaterialService extends IService<StudyMaterial, String> {
    Set<StudyMaterial> getAll();
}
