package za.ac.cput.controller.studySources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.StudySource.StudyMaterial;
import za.ac.cput.Factory.StudySource.StudyMaterialFactory;
import za.ac.cput.service.StudySource.StudyMaterialService;

import java.util.Set;

@RestController
@RequestMapping("/studyMaterial")
public class StudyMaterialController {
    @Autowired
    @Qualifier("studyMaterialServiceImpl")
    private StudyMaterialService service;

    @PostMapping("/create/{materialId, materialDesc}")
    @ResponseBody
    public StudyMaterial create(@PathVariable String materialId, String materialDesc) {
        StudyMaterial studyMaterial = StudyMaterialFactory.buildStudyMaterial(materialId, materialDesc);
        return service.create(studyMaterial);
    }

    @PostMapping("/update")
    @ResponseBody
    public StudyMaterial update(StudyMaterial studyMaterial) {
        return service.update(studyMaterial);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public StudyMaterial read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<StudyMaterial> getAll() {
        return service.getAll();
    }
}
