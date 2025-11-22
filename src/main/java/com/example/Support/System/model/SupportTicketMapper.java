package com.example.Support.System.model;

import com.example.Support.System.entity.support.CustomIdGenerator;
import com.example.Support.System.entity.support.Status;
import com.example.Support.System.entity.support.SupportTicket;

public class SupportTicketMapper {

    public static SupportTicketModel toModel(SupportTicket ticket) {
        if (ticket == null) return null;

        SupportTicketModel model = new SupportTicketModel();

        model.setId(ticket.getId());
        model.setUserName(ticket.getUserName());
        model.setEmail(ticket.getEmail());
        model.setStatus(ticket.getStatus());

        model.setCustomerName(ticket.getCustomerName());
        model.setSeverity(ticket.getSeverity());
        model.setSummary(ticket.getSummary());
        model.setDescription(ticket.getDescription());
        model.setProblemType(ticket.getProblemType());
        model.setAffectedEnvironment(ticket.getAffectedEnvironment());


        model.setSlaScopeEnabled(ticket.getSlaScopeEnabled());
        model.setResponseSlaHours(ticket.getResponseSlaHours());

        model.setCreatedAt(ticket.getCreatedAt());
        model.setStartedAt(ticket.getStartedAt());
        model.setExpectedClosedAt(ticket.getExpectedClosedAt());

        model.setEndPoint(ticket.getEndPoint());
        model.setRootCauseAnalyticsDescription(ticket.getRootCauseAnalyticsDescription());
        model.setRootCauseAnalyticsDate(ticket.getRootCauseAnalyticsDate());
        model.setCorrectiveActions(ticket.getCorrectiveActions());
        model.setPreventiveActions(ticket.getPreventiveActions());
        model.setPreventiveActionPlanDueDate(ticket.getPreventiveActionPlanDueDate());
        model.setLessonsLearnt(ticket.getLessonsLearnt());

        return model;
    }

    public static SupportTicket toEntity(SupportTicketModel model) {
        if (model == null) return null;

        SupportTicket ticket = new SupportTicket();

        ticket.setId(CustomIdGenerator.generateId());
        ticket.setUserName(model.getUserName());
        ticket.setEmail(model.getEmail());
        ticket.setStatus(model.getStatus()); // kept as you defined

        ticket.setCustomerName(model.getCustomerName());
        ticket.setSeverity(model.getSeverity());
        ticket.setSummary(model.getSummary());
        ticket.setDescription(model.getDescription());
        ticket.setProblemType(model.getProblemType());
        ticket.setAffectedEnvironment(model.getAffectedEnvironment());


        ticket.setSlaScopeEnabled(model.getSlaScopeEnabled());
        ticket.setResponseSlaHours(model.getResponseSlaHours());

        ticket.setCreatedAt(model.getCreatedAt());
        ticket.setStartedAt(model.getStartedAt());
        ticket.setExpectedClosedAt(model.getExpectedClosedAt());

        ticket.setEndPoint(model.getEndPoint());
        ticket.setRootCauseAnalyticsDescription(model.getRootCauseAnalyticsDescription());
        ticket.setRootCauseAnalyticsDate(model.getRootCauseAnalyticsDate());
        ticket.setCorrectiveActions(model.getCorrectiveActions());
        ticket.setPreventiveActions(model.getPreventiveActions());
        ticket.setPreventiveActionPlanDueDate(model.getPreventiveActionPlanDueDate());
        ticket.setLessonsLearnt(model.getLessonsLearnt());

        return ticket;
    }

}

