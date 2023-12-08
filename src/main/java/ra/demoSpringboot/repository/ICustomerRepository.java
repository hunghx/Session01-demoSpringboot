package ra.demoSpringboot.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.demoSpringboot.dto.CustomerResponse;
import ra.demoSpringboot.model.Customer;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long> {
 // không cần định nghĩa các phương thức crud
    List<Customer> findAllByNameContainingIgnoreCase(String name);

    // Query
//    @Query(value = "select count(c.id) from Customer c where c.sex = :sex")
    @Query(nativeQuery = true,value = "select count(*) from customers where sex = :sex")
    long countCustomerBySex(@Param("sex") Boolean sex);

    @Query(value = "SELECT new ra.demoSpringboot.dto.CustomerResponse(c.id,c.name,c.phone,c.sex,c.birthDay,a.area) from Customer c join Address a on c.addressId=a.id")
    List<CustomerResponse> findCustomersWithAddress();

}
