package by.academy.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id;

    String currency;

    String secretKey;

    @PositiveOrZero
    long balance;
}
