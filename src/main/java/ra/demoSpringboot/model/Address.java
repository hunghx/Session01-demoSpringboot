package ra.demoSpringboot.model;


import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(columnDefinition = "text")
    private String area;

}
