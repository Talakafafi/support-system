package com.example.Support.System.entity.support;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SUPPORT_TICKET")
public class SupportTicket {
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

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "severity")
    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "problem_type")
    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    @Column(name = "affected_environment")
    public String getAffectedEnvironment() {
        return affectedEnvironment;
    }

    public void setAffectedEnvironment(String affectedEnvironment) {
        this.affectedEnvironment = affectedEnvironment;
    }

    @Column(name = "sla_scope_enabled")
    public Boolean getSlaScopeEnabled() {
        return slaScopeEnabled;
    }

    public void setSlaScopeEnabled(Boolean slaScopeEnabled) {
        this.slaScopeEnabled = slaScopeEnabled;
    }

    @Column(name = "response_sla_hours")
    public Integer getResponseSlaHours() {
        return responseSlaHours;
    }

    public void setResponseSlaHours(Integer responseSlaHours) {
        this.responseSlaHours = responseSlaHours;
    }

    @Column(name = "created_at")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "started_at")
    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    @Column(name = "expected_closed_at")
    public LocalDateTime getExpectedClosedAt() {
        return expectedClosedAt;
    }

    public void setExpectedClosedAt(LocalDateTime expectedClosedAt) {
        this.expectedClosedAt = expectedClosedAt;
    }

    @Column(name = "end_point")
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Column(name = "root_cause_analytics_description")
    public String getRootCauseAnalyticsDescription() {
        return rootCauseAnalyticsDescription;
    }

    public void setRootCauseAnalyticsDescription(String rootCauseAnalyticsDescription) {
        this.rootCauseAnalyticsDescription = rootCauseAnalyticsDescription;
    }

    @Column(name = "root_cause_analytics_date")
    public LocalDateTime getRootCauseAnalyticsDate() {
        return rootCauseAnalyticsDate;
    }

    public void setRootCauseAnalyticsDate(LocalDateTime rootCauseAnalyticsDate) {
        this.rootCauseAnalyticsDate = rootCauseAnalyticsDate;
    }

    @Column(name = "corrective_actions")
    public String getCorrectiveActions() {
        return correctiveActions;
    }

    public void setCorrectiveActions(String correctiveActions) {
        this.correctiveActions = correctiveActions;
    }

    @Column(name = "preventive_actions")
    public String getPreventiveActions() {
        return preventiveActions;
    }

    public void setPreventiveActions(String preventiveActions) {
        this.preventiveActions = preventiveActions;
    }

    @Column(name = "preventive_action_plan_due_date")
    public LocalDateTime getPreventiveActionPlanDueDate() {
        return preventiveActionPlanDueDate;
    }

    public void setPreventiveActionPlanDueDate(LocalDateTime preventiveActionPlanDueDate) {
        this.preventiveActionPlanDueDate = preventiveActionPlanDueDate;
    }

    @Column(name = "lessons_learnt")
    public String getLessonsLearnt() {
        return lessonsLearnt;
    }

    public void setLessonsLearnt(String lessonsLearnt) {
        this.lessonsLearnt = lessonsLearnt;
    }

}
