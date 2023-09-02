package com.medical.clinic.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "appointment")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name")
    @NonNull
    private String patientName;

    @Column(name = "mobile")
    @NonNull
    private String mobile;

    @Column(name = "cancle")
    private Boolean cancle;

    @Column(name = "reason")
    private String reason;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "reserve_at")
    @JsonFormat( pattern = "YYYY-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate reserveAt;

    @Column(name = "canceled_at" , nullable = true)
    @UpdateTimestamp
    private LocalDate canceledAt;
}
