package com.pgi.vasileios.cipherAPI;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "substitutions")
public class SubstitutionStrings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",nullable=false)
    private String name;
    @Column(name="clearAlphabet",nullable=false)
    private String clearAlphabet;
    @Column(name="cipherAlphabet",nullable=false)
    private String cipherAlphabet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClearAlphabet() {
        return clearAlphabet;
    }

    public void setClearAlphabet(String clearAlphabet) {
        this.clearAlphabet = clearAlphabet;
    }

    public String getCipherAlphabet() {
        return cipherAlphabet;
    }

    public void setCipherAlphabet(String cipherAlphabet) {
        this.cipherAlphabet = cipherAlphabet;
    }

    public SubstitutionStrings () {

    }

    public SubstitutionStrings( String name, String clearAlphabet, String cipherAlphabet) {
        this.id = getId();
        this.name = name;
        this.clearAlphabet = clearAlphabet;
        this.cipherAlphabet = cipherAlphabet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubstitutionStrings map = (SubstitutionStrings) o;
        return cipherAlphabet == map.cipherAlphabet &&
                Objects.equals(id, map.id) &&
                Objects.equals(clearAlphabet, map.clearAlphabet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clearAlphabet, cipherAlphabet);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Substitution Strings{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", clearAlphabet='").append(clearAlphabet).append('\'');
        sb.append(", cipherAlphabet=").append(cipherAlphabet);
        sb.append('}');
        return sb.toString();
    }
}
