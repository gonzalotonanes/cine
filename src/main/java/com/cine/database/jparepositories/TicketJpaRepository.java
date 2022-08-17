package com.cine.database.jparepositories;

import com.cine.database.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, String> {

    @Query("SELECT COUNT(t) FROM TicketEntity t WHERE t.idFunction=?1 ")
    int countAvailability(int idFunction);
}
