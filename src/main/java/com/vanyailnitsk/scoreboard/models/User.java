package com.vanyailnitsk.scoreboard.models;

import com.vanyailnitsk.scoreboard.tasks.AlgorithmTaskResult;
import com.vanyailnitsk.scoreboard.tasks.TestResult;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer userId;
    private String name;
    @Column(unique = true, updatable = false, nullable = false)
    private String email;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();



    @OneToMany(mappedBy = "user")
    private List<TestResult> testScores;

    @OneToMany(mappedBy = "user")
    private List<AlgorithmTaskResult> algorithmScores;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addTestScore(TestResult result) {
        testScores.add(result);
    }
    public void addAlgorithmScore(AlgorithmTaskResult result) {
        algorithmScores.add(result);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TestResult> getTestScores() {
        return testScores;
    }

    public void setTestScores(List<TestResult> testScores) {
        this.testScores = testScores;
    }

    public List<AlgorithmTaskResult> getAlgorithmScores() {
        return algorithmScores;
    }

    public void setAlgorithmScores(List<AlgorithmTaskResult> algorithmScores) {
        this.algorithmScores = algorithmScores;
    }

    public int getTestTasksCompleted() {
        if (testScores==null) {
            return 0;
        }
        return (int) testScores.stream().filter(a -> a.getScore() > 70).count();
    }

    public int getAlgorithmTasksCompleted() {
        if (algorithmScores == null) {
            return 0;
        }
        return (int) algorithmScores.stream().filter(a -> a.isCorrect()).count();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
