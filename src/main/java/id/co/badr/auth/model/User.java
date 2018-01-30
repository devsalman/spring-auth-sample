package id.co.badr.auth.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue
    private Integer Id;

    @Getter @Setter private String name;
    @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter @Setter private Timestamp createdAt;
    @Getter @Setter private Timestamp updatedAt;
    @Getter @Setter private Timestamp deletedAt;
}