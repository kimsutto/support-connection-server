package sp.supportconnection.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AvailableSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="available_id")
    private Long id;

    @Column(name="total_amount")
    private int totalAmount;

    @Column(name="cash_amount")
    private int cashAmount;

    @Column(name="financial_amount")
    private int financialAmount;

}
