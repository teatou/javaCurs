package com.example.kr1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Record {
    private Long id;
    private String type;
    private String kind;
    private float sum;
    private String client;

    protected Record() {
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

    public float getSum() { return sum; }

    public void setSum(float sum) { this.sum = sum; }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "student [id=" + id + ", type=" + type +", kind=" + kind + ", sum=" + sum + ", client=" + client + "]";
    }
}
