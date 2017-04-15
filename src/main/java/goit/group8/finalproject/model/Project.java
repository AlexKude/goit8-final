package goit.group8.finalproject.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="project")
public class Project implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "describe")
    private String describe;

    @Column(name = "demands")
    private String demands;

    @Column(name = "cost")
    private double cost;

    @Column(name = "deadline")
    private String deadline;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn (name = "status_id")
    ProjectStatus status;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Application> applications;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "finishdate")
    private Date finishDate;

    @Column(name = "notes")
    private String notes;

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDemands() {
        return demands;
    }

    public void setDemands(String demands) {
        this.demands = demands;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", demands='" + demands + '\'' +
                ", cost=" + cost +
                ", deadline='" + deadline + '\'' +
                ", status=" + status +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}

