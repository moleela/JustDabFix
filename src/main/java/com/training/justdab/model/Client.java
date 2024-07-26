package com.training.justdab.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Client extends User {

    @ManyToOne
    @JoinColumn(name = "advisor_id",  referencedColumnName = "id")
    private Employee advisor;

    public Employee getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Employee advisor) {
        this.advisor = advisor;
    }
}
