package com.example.kanzeparovrr.postterminalcardapplicationmir.hl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hyperledger.fabric.sdk.Enrollment;



import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * maybe one day i'll make data layer prettier.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "password"})
@ToString(exclude = {"password"})

public class HLUser implements  Serializable,org.hyperledger.fabric.sdk.User {

    public HLUser(){
        enrollment=null;
    }


    private long id;

    @JsonProperty("roles")
   // @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
   // @Singular
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

  /*  @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> result = new HashSet<>(getPrivileges());
        result.addAll(springRoles);
        return result;
    }*/

    @JsonIgnore
    public Set<String> getAuthorities() {
        return getAuthorities();
    }

    ////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @JsonIgnore
    @Override
    public String getName() {
        return username;
    }

    @JsonIgnore
    @Override
    public Set<String> getRoles() {
        return springRoles;
    }

    @JsonIgnore
    @Override
    public Enrollment getEnrollment() {
        return enrollment;
    }
}
