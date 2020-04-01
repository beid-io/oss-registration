package io.beid.authorize;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "accesses")
public class Access implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="token")
    public String token;

    @Column(name="access_name")
    public String accessName;

}