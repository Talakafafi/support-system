package com.example.Support.System.service;

import com.example.Support.System.entity.support.Severity;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

        supportTicketModel.setSeverity(Severity.OPENED);

        supportTicketModel.setCorrectiveActions("Mock corrective action");
        supportTicketModel.setPreventiveActions("Mock preventive action");
        supportTicketModel.setPreventiveActionPlanDueDate(LocalDateTime.now().plusDays(7));

        supportTicketModel.setLessonsLearnt("Mock lessons learnt");

        SupportTicket ticketEntity = SupportTicketMapper.toEntity(supportTicketModel);
        return SupportTicketMapper.toModel(supportRepository.save(ticketEntity));
    }

    public SupportTicketModel getTicket(final String id) {
        return SupportTicketMapper.toModel(supportRepository.getById(id));
    }

    public SupportTicketModel updateTicket(final String id, SupportTicketModel model) {
        SupportTicket ticket = supportRepository.getById(id);

        Optional.ofNullable(model.getUserName()).ifPresent(ticket::setUserName);
        Optional.ofNullable(model.getEmail()).ifPresent(ticket::setEmail);
        Optional.ofNullable(model.getStatus()).ifPresent(ticket::setStatus);

        Optional.ofNullable(model.getCustomerName()).ifPresent(ticket::setCustomerName);
        Optional.ofNullable(model.getSeverity()).ifPresent(ticket::setSeverity);
        Optional.ofNullable(model.getSummary()).ifPresent(ticket::setSummary);
        Optional.ofNullable(model.getDescription()).ifPresent(ticket::setDescription);
        Optional.ofNullable(model.getProblemType()).ifPresent(ticket::setProblemType);
        Optional.ofNullable(model.getAffectedEnvironment()).ifPresent(ticket::setAffectedEnvironment);

        Optional.ofNullable(model.getSlaScopeEnabled()).ifPresent(ticket::setSlaScopeEnabled);
        Optional.ofNullable(model.getResponseSlaHours()).ifPresent(ticket::setResponseSlaHours);

        Optional.ofNullable(model.getCreatedAt()).ifPresent(ticket::setCreatedAt);
        Optional.ofNullable(model.getStartedAt()).ifPresent(ticket::setStartedAt);
        Optional.ofNullable(model.getExpectedClosedAt()).ifPresent(ticket::setExpectedClosedAt);

        Optional.ofNullable(model.getEndPoint()).ifPresent(ticket::setEndPoint);
        Optional.ofNullable(model.getRootCauseAnalyticsDescription()).ifPresent(ticket::setRootCauseAnalyticsDescription);
        Optional.ofNullable(model.getRootCauseAnalyticsDate()).ifPresent(ticket::setRootCauseAnalyticsDate);
        Optional.ofNullable(model.getCorrectiveActions()).ifPresent(ticket::setCorrectiveActions);
        Optional.ofNullable(model.getPreventiveActions()).ifPresent(ticket::setPreventiveActions);
        Optional.ofNullable(model.getPreventiveActionPlanDueDate()).ifPresent(ticket::setPreventiveActionPlanDueDate);
        Optional.ofNullable(model.getLessonsLearnt()).ifPresent(ticket::setLessonsLearnt);

        return SupportTicketMapper.toModel(supportRepository.save(ticket));
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
