package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.Details;
import com.nscs.SBMaster.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details ,String> {
    Details findByTicketNo(String ticketNo);
}
