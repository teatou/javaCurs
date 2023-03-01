package com.example.kr1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Machine {
    private Long id;
    private String type;
    private String kind;
    private java.util.Date arrived;
    private java.util.Date gone;
    private String driver;

    protected Machine() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public java.util.Date getArrived() {
        return arrived;
    }

    public void setArrived(java.util.Date arrived) {
        this.arrived = arrived;
    }

    public java.util.Date getGone() {
        return gone;
    }

    public void setGone(java.util.Date gone) {
        this.gone = gone;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "student [id=" + id + ", type=" + type +", kind=" + kind + ", arrived=" + arrived + ", gone=" + gone + ", driver=" + driver + "]";
    }
}
