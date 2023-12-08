package ra.demoSpringboot.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

// Entity
@Entity // chú thích lớp ánh xạ
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // cấu hình tự sinh id
    private Long id;
    @Column(name = "customer_name")
    private String name;

    @Column(unique = true)
    private String phone;
    private Boolean sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "address_id")
    private String addressId;

    public Customer() {
    }

    public Customer(Long id, String name, String phone, Boolean sex, Date birthDay, String addressId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.birthDay = birthDay;
        this.addressId = addressId;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
