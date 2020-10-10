package by.academy.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Block {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id;

    String hash;

    String previousHash;

    String data;

    long timeStamp;

    int nonce;

}
