package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface ProductRepository  extends CrudRepository<Product, Long>, QueryByExampleExecutor<Product> {

    /*@Query(value = "select P.ean, C.name, R.name, R.price, S.code 'size_id', S.name 'size_name', COL.code 'color_id', COL.name 'color_name'" +
            " FROM db_sid.product P \n" +
            "inner join db_sid.color C on P.color_id=C.code\n" +
            "inner join db_sid.reference R on P.reference_id = R.code\n" +
            "inner join db_sid.size S on P.size_id=S.code\n" +
            "inner join db_sid.color COL on P.color_id=COL.code\n" +
            "where P.ean= :id", nativeQuery = true)
    Optional<Product> findByIdProduct(@Param("id") Long id);*/

    @Query(value = "select * " +
            " FROM db_sid.product P \n" +
            "where P.ean= :id", nativeQuery = true)
    Optional<Product> findByIdProduct(@Param("id") Long id);

}
