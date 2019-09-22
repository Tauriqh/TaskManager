package za.ac.cput.service.StudySource.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.Factory.StudySource.StudyMaterialFactory;
import za.ac.cput.repository.StudySource.StudyMaterialRepository;
import za.ac.cput.repository.StudySource.impl.StudyMaterialRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class StudyMaterialServiceImplTest {
    private StudyMaterialRepository repository;
    private StudyMaterial studyMaterial;

    private StudyMaterial getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudyMaterialRepositoryImpl.getRepository();
        this.studyMaterial = StudyMaterialFactory.buildStudyMaterial("1","Java for Dummies Chapter 2");
    }

    @Test
    public void create() {
        StudyMaterial info = this.repository.create(this.studyMaterial);
        //System.out.println("In create, created = " + info);
        Assert.assertSame(info, this.studyMaterial);
    }

    @Test
    public void read() {
        StudyMaterial saved = getSaved();
        StudyMaterial read = this.repository.read(saved.getMaterialId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        String updateString = "Harry Potter";
        StudyMaterial studyMaterial = new StudyMaterial.Builder().copy(getSaved()).materialDesc(updateString).build();
        //System.out.println("In update, about_to_updated = " + studyMaterial);
        this.repository.update(studyMaterial);
        Assert.assertSame(updateString, studyMaterial.getMaterialDesc());
    }

    @Test
    public void e_delete() {
        StudyMaterial saved = getSaved();
        this.repository.delete(saved.getMaterialId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<StudyMaterial> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
    }
}