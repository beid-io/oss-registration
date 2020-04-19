package io.beid.module.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity implements Persistable<String>, Serializable {

    @Id
    public String uuid;

    @Column(name = "json_data")
    public String jsonData;

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
