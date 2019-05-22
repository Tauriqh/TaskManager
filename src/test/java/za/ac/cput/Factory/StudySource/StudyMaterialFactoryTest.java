package za.ac.cput.Factory.StudySource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.Factory.StudySource.StudyMaterialFactory;

public class StudyMaterialFactoryTest {

    private String materialId;
    private String materialDesc;

    @Before
    public void setUp() throws Exception {
        this.materialId = "1";
        this.materialDesc = "Java for Dummies Chapter 2";
    }

    @Test
    public void buildStudyMaterial() {
        StudyMaterial studyMaterial = StudyMaterialFactory.buildStudyMaterial(materialId, materialDesc);
        Assert.assertNotNull(studyMaterial.getMaterialId());
        Assert.assertNotNull(studyMaterial);
    }
}