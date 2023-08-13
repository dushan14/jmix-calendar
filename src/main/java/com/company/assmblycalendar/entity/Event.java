package com.company.assmblycalendar.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "EVENT")
@Entity
public class Event {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_")
    private LocalDate date;

    @Column(name = "PHASE1")
    private Character phase1;

    @Column(name = "PHASE2")
    private Character phase2;

    @Column(name = "PHASE3")
    private Character phase3;

    @Column(name = "PHASE4")
    private Character phase4;

    public Character getPhase4() {
        return phase4;
    }

    public void setPhase4(Character phase4) {
        this.phase4 = phase4;
    }

    public Character getPhase3() {
        return phase3;
    }

    public void setPhase3(Character phase3) {
        this.phase3 = phase3;
    }

    public Character getPhase2() {
        return phase2;
    }

    public void setPhase2(Character phase2) {
        this.phase2 = phase2;
    }

    public Character getPhase1() {
        return phase1;
    }

    public void setPhase1(Character phase1) {
        this.phase1 = phase1;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("description", this.description);
        jsonObject.put("date", this.date);
        jsonObject.put("phase1", this.phase1);
        jsonObject.put("phase2", this.phase2);
        jsonObject.put("phase3", this.phase3);
        jsonObject.put("phase4", this.phase4);
        return jsonObject;
    }
}