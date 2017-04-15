package goit.group8.finalproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="application")
public class Application implements Serializable{
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

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn (name = "status_id")
    ProjectStatus status;

    public Application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (id != that.id) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (applydate != null ? !applydate.equals(that.applydate) : that.applydate != null) return false;
        if (freelancer != null ? !freelancer.equals(that.freelancer) : that.freelancer != null) return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (applydate != null ? applydate.hashCode() : 0);
        result = 31 * result + (freelancer != null ? freelancer.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", applydate=" + applydate +
                ", freelancer=" + freelancer +
                ", project=" + project +
                ", status=" + status +
                '}';
    }
}
