package goit.group8.finalproject.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "projectstatus")
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int status_id;

    @Column(name = "status_name")
    private String status_name;

    public Status() {
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Override
    public String toString() {
        return "Projectstatus{" +
                "status_id=" + status_id +
                ", status_name='" + status_name + '\'' +
                '}';
    }
}
