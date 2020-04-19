package io.beid.module.econsent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    public Boolean is_accept;
    public Timestamp crated;
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
