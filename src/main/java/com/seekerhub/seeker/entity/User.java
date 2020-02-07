package com.seekerhub.seeker.entity;

import com.seekerhub.seeker.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true , nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true , nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = { // هنا اسوي جوين لل٢ تيبلز عشان العلاقة ماني تو ماني
            @JoinColumn(name = "user_id" , referencedColumnName = "id") // التيبل الاول
    }, inverseJoinColumns = {
            @JoinColumn(name = "role_id" , referencedColumnName = "id") // التيبل الثاني
    })
    private Set<Role> roles = new HashSet<>();

    @Column(unique = true)
    private String phone_number;

    @Column(unique = true)
    private String national_id;
    private String rating;

    // TODO: User Entity: cascade = CascadeType.REMOVE
    @OneToOne(mappedBy = "user")
    private Employer employer;

    @OneToOne(mappedBy = "user")
    private Freelancer freelancer;

    @Column(columnDefinition = "boolean default true")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private RoleEnum current_type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private StorageDocument avatar;

}
