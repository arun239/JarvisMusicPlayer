package com.jarvis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by arungu on 1/11/2016.
 */
@MappedSuperclass
public class BaseEntity {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(length = 36, unique = true)
    String id;

    @JsonIgnore
    Date createAt;

    @JsonIgnore
    Date updateAt;

    @JsonIgnore
    @Version
    Long version = 0L;

    public String getId() {
        return id;
    }

    @JsonIgnore
    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @PrePersist
    protected void onCreate()
    {
        this.createAt = new Date();
    }

    @PreUpdate
    protected void onUpdate()
    {
        this.updateAt = new Date();
    }
}
