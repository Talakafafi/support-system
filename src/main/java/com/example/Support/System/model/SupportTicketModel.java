package com.example.Support.System.model;

import com.example.Support.System.entity.support.Severity;
import com.example.Support.System.entity.support.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportTicketModel {

    private String id;
    private String userName;
    private String email;
    private Status status;

    private String customerName;
    private Severity severity;
    private String summary;
    private String description;
    private String problemType;
    private String affectedEnvironment;
    private Boolean slaScopeEnabled;
    private Integer responseSlaHours;
    private LocalDateTime createdAt;
    private LocalDateTime startedAt;
    private LocalDateTime expectedClosedAt;

    private String endPoint;
    private String rootCauseAnalyticsDescription;
    private LocalDateTime rootCauseAnalyticsDate;
    private String correctiveActions;
    private String preventiveActions;
    private LocalDateTime preventiveActionPlanDueDate;
    private String lessonsLearnt;
}
