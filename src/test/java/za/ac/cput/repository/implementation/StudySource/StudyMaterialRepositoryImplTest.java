package za.ac.cput.repository.implementation.StudySource;

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

public class StudyMaterialRepositoryImplTest {

    private StudyMaterialRepository repository;
    private StudyMaterial studyMaterial;

    private StudyMaterial getSaved() {
        Set<StudyMaterial> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudyMaterialRepositoryImpl.getRepository();
        this.studyMaterial = StudyMaterialFactory.buildStudyMaterial("1","Java for Dummies Chapter 2");
    }

    @Test
    public void create() {
        StudyMaterial info = this.repository.create(this.studyMaterial);
        d_getAll();
        Assert.assertSame(info, this.studyMaterial);
    }

    @Test
    public void read() {
        StudyMaterial saved = getSaved();
        StudyMaterial read = this.repository.read(saved.getMaterialId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();
    }

    @Test
    public void update() {
        String updateString = "Harry Potter";
        StudyMaterial studyMaterial = new StudyMaterial.Builder().copy(getSaved()).materialDesc(updateString).build();
        System.out.println("In update, about_to_updated = " + studyMaterial);
        StudyMaterial updated = this.repository.update(studyMaterial);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getMaterialDesc());
        d_getAll();
    }

    @Test
    public void e_delete() {
        StudyMaterial saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getMaterialId());
        d_getAll();
        Set<StudyMaterial> tasks = this.repository.getAll();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void d_getAll() {
        Set<StudyMaterial> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}