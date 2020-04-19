package io.beid.module.econsent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "econsent")
@NoArgsConstructor
@AllArgsConstructor
public class ConsentEntity implements Persistable<String>, Serializable {

    @Id
    public String uuid;

    @Column(name = "is_accept")
    public Boolean isAccept;

    public Timestamp created;

    @Transient public boolean isNew = false;

    @Override
    public String getId() {
        return uuid;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

}
