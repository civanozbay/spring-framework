package com.orm.entity;

import com.orm.entity.PaymentDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;
//    private Status paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;
    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    public Payment(LocalDate createdDate, BigDecimal amount) {
        this.createdDate = createdDate;
        this.amount = amount;
//        this.paymentStatus = paymentStatus;
    }
}
