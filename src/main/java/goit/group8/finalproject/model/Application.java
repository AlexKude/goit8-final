package goit.group8.finalproject.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "note")
    private String note;

    @Column(name = "applydate")
    private Date applydate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User freelancer;

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;

    public Application() {
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public User getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(User freelancer) {
        this.freelancer = freelancer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application)) return false;
        Application that = (Application) o;
        return id == that.id &&
                Objects.equals(getApplydate(), that.getApplydate()) &&
                Objects.equals(getFreelancer(), that.getFreelancer()) &&
                Objects.equals(getProject(), that.getProject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getApplydate(), getFreelancer(), getProject());
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", applydate=" + applydate +
                ", freelancer=" + freelancer +
                ", project=" + project +
                '}';
    }
}
