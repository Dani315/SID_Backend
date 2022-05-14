package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, String> {

    Optional<Product> findByEAN(String id);
    /*@Query(value = "select P.ean, C.name, R.name, R.price, S.code 'size_id', S.name 'size_name', COL.code 'color_id', COL.name 'color_name'" +
            " FROM db_sid.product P \n" +
            "inner join db_sid.color C on P.color_id=C.code\n" +
            "inner join db_sid.reference R on P.reference_id = R.code\n" +
            "inner join db_sid.size S on P.size_id=S.code\n" +
            "inner join db_sid.color COL on P.color_id=COL.code\n" +
            "where P.ean= :id", nativeQuery = true)
    Optional<Product> findByIdProduct(@Param("id") Long id);*/

    /*@Query(value = "select C.code 'colorId', S.code 'sizeId',C.name 'colorName', S.name 'sizeName'\n" +
            " FROM db_sid.product P\n" +
            "inner join color C \n" +
            "on P.color_id = C.code\n" +
            "inner join size S\n" +
            "on P.size_id = S.code\n" +
            "where P.ean= :id", nativeQuery = true)
    Optional<ProductReference> findByIdProduct(@Param("id") Long id);*/

}
