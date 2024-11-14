package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Long> {


    @Query(value= "SELECT concat(usr_code,' - ',usr_ename) as supplier , usr_kid AS kid  FROM  s_usr  WHERE  LOWER(usr_ename) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(usr_code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findusrByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(supgst_ename,' - ',supgst_address) as supplier , supgst_kid AS kid  FROM  s_supplierGst  WHERE  LOWER(supgst_ename) LIKE LOWER(CONCAT('%', :query, '%')) AND assupmst_kid=:query2", nativeQuery = true)
    List<Object[]> findsupplierByQuery(@Param("query") String query,@Param("query2") String query2);

    @Query(value= "SELECT concat(assupmst_code,' - ',assupmst_ename) as supplier , assupmst_kid AS kid  FROM  s_assupmst  WHERE  LOWER(assupmst_ename) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findassupmstByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(zon_code,' - ',zon_ename) as supplier , zon_kid AS kid  FROM  s_zon  WHERE  LOWER(zon_ename) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(zon_code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findzoneByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(stat_code,' - ',stat_ename) as supplier , stat_kid AS kid  FROM  s_stat  WHERE  LOWER(stat_ename) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(stat_code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findstateByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(code,' - ',name) as supplier , kid AS kid  FROM  s_dept  WHERE  LOWER(name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findDepartmentByQuery(@Param("query") String query);


    @Query(value= "SELECT supgst_ename as supplier , supgst_kid AS kid  ,assupmst_kid AS Assupmstkid,(select assupmst_ename from s_assupmst where assupmst_kid=sup.assupmst_kid) AS assupmst_ename ,supgst_address AS address FROM  s_supplierGst sup WHERE  LOWER(supgst_ename) LIKE LOWER(CONCAT('%', :query, '%')) ", nativeQuery = true)
    List<Object[]> findAllsupplierByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(brn_brcod,' - ',brn_ename) as supplier , brn_brKid AS kid  FROM  s_brn  WHERE  LOWER(brn_ename) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(brn_brcod) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findbranchByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(rgn_code,' - ',rgn_ename) as supplier , id AS kid  FROM  s_divison  WHERE  LOWER(rgn_ename) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(rgn_code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> finddivisionByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(code,' - ',name) as supplier , kid AS kid  FROM  s_dept  WHERE  LOWER(name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findasectorByQuery(@Param("query") String query);

    @Query(value= "SELECT concat(now_code,' - ',now_ename) as supplier , ID AS kid  FROM  s_NatureOfWork  WHERE  LOWER(now_ename) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(now_code) LIKE LOWER(CONCAT('%', :query, '%'))", nativeQuery = true)
    List<Object[]> findNatureOfWorkByQuery(@Param("query") String query);

    @Modifying
    @Query(value= "update tender_detail SET proceed = 'Y' WHERE  id=:query", nativeQuery = true)
    int tenderApprove(@Param("query") String query);

    @Modifying
    @Query(value= "update tender_detail SET proceed = 'N' WHERE  id=:query", nativeQuery = true)
    int tenderNotApprove(@Param("query") String query);




}