package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hyperledger.fabric.sdk.Enrollment;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "password"})
@ToString(exclude = {"password"})
/*@Entity
@Table(name = "users",
        indexes = {@Index(name = "userName", columnList = "username")},
        uniqueConstraints = {@UniqueConstraint(name = "uniqueUsername", columnNames = {"username"})})*/
public class User implements /*UserDetails,*/ Serializable,org.hyperledger.fabric.sdk.User {

    public User (){
        enrollment=null;
    }


/*    @Id
    @GeneratedValue*/
    private long id;

    @JsonProperty("roles")
    //@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Singular
    private Set<String> springRoles;

    //@ElementCollection(targetClass = Privilege.class, fetch = FetchType.EAGER)
    @Singular
    private Set<String> privileges;

    private String username;

    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String affiliation;

    private String mspId;

    private String account;

   // @OneToOne(optional = true, targetEntity = HLEnrollment.class, cascade = ALL)
    Enrollment enrollment;


    @JsonIgnore
    @Override
    public String getName() {
        return username;
    }

    @JsonIgnore
    @Override
    public Set<String> getRoles() {
        return Collections.unmodifiableSet(springRoles);
    }

    @JsonIgnore
    @Override
    public Enrollment getEnrollment() {
        return enrollment;
    }
}