package goit.group8.finalproject.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "descr")
    private String descr;
    @Column(name = "demands")
    private String demands;
    @Column(name = "cost")
    private double cost;
    @Column(name = "deadline")
    private Date deadline;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDemands() {
        return demands;
    }

    public void setDemands(String demands) {
        this.demands = demands;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", demands='" + demands + '\'' +
                ", cost=" + cost +
                ", deadline=" + deadline +
                '}';
    }
}

