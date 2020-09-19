package sp.supportconnection.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor()
@Table(name="SUPPORT_DETAIL")
public class SupportDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="support_detail_id")
    private Long id;

    @Column(name="qualification")
    private String qualification;

    @Column(name="info")
    private String info;

    @Column(name="apply_info")
    private String applyInfo;

    @Column(name="required_documents")
    private String requiredDocuments;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="url")
    private String url;

    @Column(name="contact")
    private String contact;

}
