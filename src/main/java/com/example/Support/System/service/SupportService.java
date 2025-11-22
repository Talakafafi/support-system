package com.example.Support.System.service;

import com.example.Support.System.entity.support.Status;
import com.example.Support.System.entity.support.SupportRepository;
import com.example.Support.System.entity.support.SupportTicket;
import com.example.Support.System.entity.support.SupportTicketSpecification;
import com.example.Support.System.model.SupportTicketMapper;
import com.example.Support.System.model.SupportTicketModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupportService {

    final private SupportRepository supportRepository;

    public SupportService(final SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    public SupportTicketModel createTicket(SupportTicketModel supportTicketModel) {
        supportTicketModel.setSlaScopeEnabled(false);
        supportTicketModel.setResponseSlaHours(24);

        supportTicketModel.setEndPoint("/mock/endpoint");
        supportTicketModel.setRootCauseAnalyticsDescription("Mock RCA description");
        supportTicketModel.setRootCauseAnalyticsDate(LocalDateTime.now().plusDays(90));

        supportTicketModel.setCorrectiveActions("Mock corrective action");
        supportTicketModel.setPreventiveActions("Mock preventive action");
        supportTicketModel.setPreventiveActionPlanDueDate(LocalDateTime.now().plusDays(7));

        supportTicketModel.setLessonsLearnt("Mock lessons learnt");

        SupportTicket ticketEntity = SupportTicketMapper.toEntity(supportTicketModel);
        return SupportTicketMapper.toModel(supportRepository.save(ticketEntity));
    }

    public SupportTicketModel getTicket(final Long id) {
        return SupportTicketMapper.toModel(supportRepository.getById(id));
    }

    public SupportTicketModel updateTicket(SupportTicketModel supportTicketModel) {
        SupportTicket ticketEntity = SupportTicketMapper.toEntity(supportTicketModel);
        return SupportTicketMapper.toModel(supportRepository.save(ticketEntity));
    }

    public List<SupportTicketModel> getAllTicketByConsumer(final String name) {
        return supportRepository.getSupportTicketByCustomerName(name)
                .stream().map(SupportTicketMapper::toModel).toList();
    }

    public Page<SupportTicketModel> getTickets(
            String customerName,
            Status status,
            Pageable pageable
    ) {
        Specification<SupportTicket> spec =
                SupportTicketSpecification.build(customerName, status);

        return supportRepository.findAll(spec, pageable)
                .map(SupportTicketMapper::toModel);
    }

}
