DROP TABLE IF EXISTS support_ticket;
CREATE TABLE support_ticket (
                                id VARCHAR(255) PRIMARY KEY,
                                user_name VARCHAR(255),
                                email VARCHAR(255),
                                comments TEXT,
                                status VARCHAR(50),

                                customer_name VARCHAR(255),
                                severity VARCHAR(50),
                                summary TEXT,
                                description TEXT,
                                problem_type VARCHAR(255),
                                affected_environment VARCHAR(255),

                                sla_scope_enabled BOOLEAN,
                                response_sla_hours INTEGER,

                                created_at TIMESTAMP,
                                started_at TIMESTAMP,
                                expected_closed_at TIMESTAMP,

                                end_point TEXT,
                                root_cause_analytics_description TEXT,
                                root_cause_analytics_date TIMESTAMP,
                                corrective_actions TEXT,
                                preventive_actions TEXT,
                                preventive_action_plan_due_date TIMESTAMP,
                                lessons_learnt TEXT
);
