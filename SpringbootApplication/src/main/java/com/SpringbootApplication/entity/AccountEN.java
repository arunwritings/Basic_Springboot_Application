package com.SpringbootApplication.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "accounts")
public class AccountEN {

    @Id
    @Column(name = "sc_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int serialNumber;

    @Column(name = "acc_no")
    private Long accountNumber;

    @Column(name = "name")
    private String customerName;

    @Column(name = "address")
    private String customerAddress;

    @Column(name = "phone")
    private Long phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountEN that = (AccountEN) o;
        return accountNumber != null && Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
