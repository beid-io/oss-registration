package io.beid.module.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@Entity
@Table(name = "register")
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEntity implements Persistable<String>, Serializable {

    @Id
    public String id;

    public String citizenid;
    public String name;
    public String surname;
    public String dob;
    public String lasercode;
    public Long income;
    public String email;
    public String mobileno;
    public String lineid;
    public Integer receivefrom;
    public String contactaddress;
    public String docaddress;

    @Transient
    public boolean isNew = false;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

}
