package za.ac.cput.Domain.StudySource;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class StudyMaterial {
    private String materialId;
    private String materialDesc;

    private StudyMaterial(){}

    private StudyMaterial(Builder builder) {
        this.materialId = builder.materialId;
        this.materialDesc = builder.materialDesc;
    }

    public String getMaterialId() {
        return materialId;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public static class Builder {
        private String materialId;
        private String materialDesc;

        public Builder materialId( String materialId) {
            this.materialId = materialId;
            return this;
        }

        public Builder materialDesc( String materialDesc) {
            this.materialDesc = materialDesc;
            return this;
        }

        public Builder copy(StudyMaterial studyMaterial) {
            this.materialId = studyMaterial.materialId;
            this.materialDesc = studyMaterial.materialDesc;
            return this;
        }

        public StudyMaterial build() {
            return new StudyMaterial(this);
        }

    }

    @Override
    public String toString() {
        return "StudyMaterial{" +
                "materialId=" + materialId + '\'' +
                ", materialDesc=" + materialDesc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyMaterial studyMaterial = (StudyMaterial) o;
        return materialId.equals(studyMaterial.materialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialId);
    }
}
