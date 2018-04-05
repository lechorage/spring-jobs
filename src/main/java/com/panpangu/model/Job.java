package com.panpangu.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lechorage
 */

@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    @Id
    private String id;
    @Column
    private String desc;
    @Column
    private String company;
    @Column
    private String company_url;
    @Column
    private String url;
    @Column
    private String location;
    @Column
    private String origin;
    @Column
    private Boolean applied;
    @Column
    private Double rank;

    public Job() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(desc);
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Boolean getApplied() {
        return applied;
    }

    public void setApplied(Boolean applied) {
        this.applied = applied;
    }

    public Double getRank() {
        return rank;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

