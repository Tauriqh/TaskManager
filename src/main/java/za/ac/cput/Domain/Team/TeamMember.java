package za.ac.cput.Domain.Team;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class TeamMember {
    private String memberId;
    private String memberName;

    private TeamMember(){}

    private TeamMember(Builder builder) {
        this.memberId = builder.memberId;
        this.memberName = builder.memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public static class Builder {
        private String memberId;
        private String memberName;

        public Builder memberId( String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder memberName( String memberName) {
            this.memberName = memberName;
            return this;
        }

        public Builder copy(TeamMember teamMember) {
            this.memberId = teamMember.memberId;
            this.memberName = teamMember.memberName;
            return this;
        }

        public TeamMember build() {
            return new TeamMember(this);
        }

    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember teamMember = (TeamMember) o;
        return memberId.equals(teamMember.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
