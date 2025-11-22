package com.example.Support.System.entity.support;

import com.example.Support.System.entity.ApplicationRepository;
import com.example.Support.System.model.SupportTicketModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.net.http.HttpHeaders;
import java.util.List;

@Repository
public interface SupportRepository extends ApplicationRepository<SupportTicket, String> {
    List<SupportTicket> getSupportTicketByCustomerName(String name);

    Page<SupportTicket> findAll(Specification<SupportTicket> spec, Pageable pageable);
}
