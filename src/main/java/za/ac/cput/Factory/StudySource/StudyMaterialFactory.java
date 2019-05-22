package za.ac.cput.Factory.StudySource;

import za.ac.cput.Domain.StudySource.StudyMaterial;

public class StudyMaterialFactory {
    public static StudyMaterial buildStudyMaterial(String materialId, String materialDesc) {
        return new StudyMaterial.Builder()
                .materialId(materialId)
                .materialDesc(materialDesc)
                .build();
    }
}
