//package com.kiro.agenticai.config;
//
//import com.kiro.agenticai.model.*;
//import com.kiro.agenticai.repository.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Configuration
//public class DataSeeder {
//
//    @Bean
//    CommandLineRunner seedData(AlertRepository alertRepo, PatchRepository patchRepo, TaskRepository taskRepo) {
//        return args -> {
//            if (alertRepo.count() == 0) {
//                alertRepo.saveAll(List.of(
//                        Alert.builder().title("Server CPU Spike").severity("Critical").status("Active")
//                                .source("MonitoringAgent").timestamp(LocalDateTime.now().minusMinutes(10))
//                                .description("High CPU usage detected in Node 12.").build(),
//                        Alert.builder().title("Database Latency").severity("High").status("Resolved")
//                                .source("DBMonitor").timestamp(LocalDateTime.now().minusHours(2))
//                                .description("Slow query response on main DB cluster.").build(),
//                        Alert.builder().title("Memory Leak Detected").severity("Medium").status("Active")
//                                .source("AppHealthAgent").timestamp(LocalDateTime.now().minusMinutes(30))
//                                .description("Service XYZ is consuming excess memory over time.").build(),
//                        Alert.builder().title("Unauthorized Login Attempt").severity("High").status("Acknowledged")
//                                .source("SecurityAgent").timestamp(LocalDateTime.now().minusHours(1))
//                                .description("Multiple failed login attempts detected from external IP.").build(),
//                        Alert.builder().title("Network Packet Loss").severity("Low").status("Resolved")
//                                .source("NetworkMonitor").timestamp(LocalDateTime.now().minusDays(1))
//                                .description("Packet drop observed on VLAN-24 interface.").build(),
//                        Alert.builder().title("Disk Utilization Warning").severity("Medium").status("Active")
//                                .source("StorageAgent").timestamp(LocalDateTime.now().minusMinutes(50))
//                                .description("Disk usage above 85% on Server Node-7.").build(),
//                        Alert.builder().title("SSL Certificate Expiry").severity("High").status("Active")
//                                .source("SecurityAgent").timestamp(LocalDateTime.now().minusHours(4))
//                                .description("SSL certificate for portal.kiro.ai will expire in 3 days.").build(),
//                        Alert.builder().title("Service Timeout").severity("Critical").status("Active")
//                                .source("AppMonitor").timestamp(LocalDateTime.now().minusMinutes(5))
//                                .description("Timeout errors detected in authentication microservice.").build(),
//                        Alert.builder().title("Patch Deployment Failure").severity("High").status("Resolved")
//                                .source("PatchManager").timestamp(LocalDateTime.now().minusHours(3))
//                                .description("Rollback executed after failed patch deployment.").build(),
//                        Alert.builder().title("Queue Backlog Alert").severity("Medium").status("Acknowledged")
//                                .source("WorkflowEngine").timestamp(LocalDateTime.now().minusMinutes(90))
//                                .description("High message backlog in Kafka topic: events-stream.").build()
//                ));
//            }
//
//            if (patchRepo.count() == 0) {
//                patchRepo.saveAll(List.of(
//                        Patch.builder().name("Patch_1.2.3").impact("Medium").status("Deployed")
//                                .conflict("None").summary("Routine OS security patch for Linux kernel.").build(),
//                        Patch.builder().name("Patch_1.2.4").impact("High").status("Pending")
//                                .conflict("May overlap with Patch_1.2.3").summary("Database driver update.").build(),
//                        Patch.builder().name("Patch_2.0.1").impact("Low").status("Deployed")
//                                .conflict("None").summary("Minor UI fixes and performance enhancements.").build(),
//                        Patch.builder().name("Patch_2.1.0").impact("High").status("Testing")
//                                .conflict("Requires DB schema migration").summary("Application backend upgrade.").build(),
//                        Patch.builder().name("Patch_2.1.1").impact("Medium").status("Scheduled")
//                                .conflict("Potential overlap with Patch_2.1.0").summary("Security fix for authentication module.").build(),
//                        Patch.builder().name("Patch_3.0.0").impact("Critical").status("Pending")
//                                .conflict("Major version upgrade").summary("Infrastructure stack modernization rollout.").build(),
//                        Patch.builder().name("Patch_3.0.1").impact("Medium").status("Deployed")
//                                .conflict("None").summary("Critical bug fixes post 3.0.0 upgrade.").build(),
//                        Patch.builder().name("Patch_3.1.0").impact("Low").status("Planned")
//                                .conflict("None").summary("Feature enhancements and log optimizations.").build(),
//                        Patch.builder().name("Patch_3.1.1").impact("High").status("Pending Approval")
//                                .conflict("Requires downtime window").summary("Critical fix for data sync module.").build(),
//                        Patch.builder().name("Patch_3.2.0").impact("Medium").status("Under Review")
//                                .conflict("Depends on Patch_3.1.1").summary("Refactoring deployment pipeline configurations.").build()
//                ));
//            }
//
//            if (taskRepo.count() == 0) {
//                taskRepo.saveAll(List.of(
//                        Task.builder().title("Check Patch Logs").priority("High").status("Open")
//                                .relatedTo("Patch_1.2.3").summary("Verify successful deployment of OS patch.").build(),
//                        Task.builder().title("Analyze CPU Spike").priority("Medium").status("In Progress")
//                                .relatedTo("Server CPU Spike").summary("Investigate root cause of alert.").build(),
//                        Task.builder().title("Restart Database Node").priority("High").status("Completed")
//                                .relatedTo("Database Latency").summary("Restarted DB node to clear latency.").build(),
//                        Task.builder().title("Review Memory Leak").priority("High").status("Open")
//                                .relatedTo("Memory Leak Detected").summary("Debug memory heap usage in Service XYZ.").build(),
//                        Task.builder().title("Validate SSL Renewal").priority("Medium").status("Planned")
//                                .relatedTo("SSL Certificate Expiry").summary("Check renewal process before expiry date.").build(),
//                        Task.builder().title("Network Interface Cleanup").priority("Low").status("Open")
//                                .relatedTo("Network Packet Loss").summary("Clear stale routes on VLAN-24.").build(),
//                        Task.builder().title("Patch Conflict Assessment").priority("Medium").status("In Progress")
//                                .relatedTo("Patch_2.1.0").summary("Validate dependency with existing DB schema.").build(),
//                        Task.builder().title("Queue Optimization").priority("Medium").status("Planned")
//                                .relatedTo("Queue Backlog Alert").summary("Tune Kafka consumer group configs.").build(),
//                        Task.builder().title("Re-run Patch Deployment").priority("High").status("Pending")
//                                .relatedTo("Patch Deployment Failure").summary("Reattempt deployment after issue fix.").build(),
//                        Task.builder().title("Audit Security Logs").priority("High").status("In Progress")
//                                .relatedTo("Unauthorized Login Attempt").summary("Cross-check with SIEM for correlation.").build()
//                ));
//            }
//        };
//    }
//}


package com.kiro.agenticai.config;

import com.kiro.agenticai.model.*;
import com.kiro.agenticai.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(AlertRepository alertRepo, PatchRepository patchRepo, TaskRepository taskRepo) {
        return args -> {
            // Clear existing data for fresh demo
            alertRepo.deleteAll();
            patchRepo.deleteAll();
            taskRepo.deleteAll();

            System.out.println("🚀 Seeding comprehensive demo data into MongoDB...");

            // -------- ALERTS --------
            alertRepo.saveAll(List.of(
                    Alert.builder().title("Server CPU Spike").severity("Critical").status("Active")
                            .source("MonitoringAgent").timestamp(LocalDateTime.now())
                            .description("High CPU usage detected in Node 12.").build(),
                    Alert.builder().title("Database Latency").severity("High").status("Resolved")
                            .source("DBMonitor").timestamp(LocalDateTime.now().minusHours(2))
                            .description("Slow query response on main DB.").build(),
                    Alert.builder().title("Memory Leak Warning").severity("Medium").status("Active")
                            .source("AppMonitor").timestamp(LocalDateTime.now().minusMinutes(45))
                            .description("Application service 'api-core' memory increasing abnormally.").build(),
                    Alert.builder().title("Unauthorized Login Attempt").severity("Critical").status("Active")
                            .source("SecurityAgent").timestamp(LocalDateTime.now().minusMinutes(5))
                            .description("Failed login attempts detected from IP 172.16.0.22").build(),
                    Alert.builder().title("Disk Space Low").severity("High").status("Active")
                            .source("StorageMonitor").timestamp(LocalDateTime.now().minusHours(3))
                            .description("Less than 10% disk remaining on /var partition.").build(),
                    Alert.builder().title("Network Latency").severity("Medium").status("Resolved")
                            .source("NetWatcher").timestamp(LocalDateTime.now().minusHours(6))
                            .description("High ping detected between app servers.").build(),
                    Alert.builder().title("Patch Failure Detected").severity("High").status("Active")
                            .source("PatchAgent").timestamp(LocalDateTime.now().minusMinutes(30))
                            .description("Patch_1.2.5 failed to apply on Node 09.").build(),
                    Alert.builder().title("Service Unavailable").severity("Critical").status("Active")
                            .source("UptimeBot").timestamp(LocalDateTime.now().minusMinutes(20))
                            .description("Frontend service returned 503 errors.").build(),
                    Alert.builder().title("Configuration Drift").severity("Medium").status("Active")
                            .source("ConfigScanner").timestamp(LocalDateTime.now().minusMinutes(55))
                            .description("Inconsistent system config detected on Node 11.").build(),
                    Alert.builder().title("SSL Certificate Expiry").severity("Low").status("Pending")
                            .source("CertAgent").timestamp(LocalDateTime.now().minusHours(9))
                            .description("Certificate for api.kiro.local expires in 7 days.").build()
            ));

            // -------- PATCHES --------
            patchRepo.saveAll(List.of(
                    Patch.builder().name("Patch_1.2.3").impact("Medium").status("Deployed")
                            .conflict("None").summary("Routine OS security patch.").build(),
                    Patch.builder().name("Patch_1.2.4").impact("High").status("Pending")
                            .conflict("May overlap with Patch_1.2.3").summary("Database driver update.").build(),
                    Patch.builder().name("Patch_1.2.5").impact("High").status("Failed")
                            .conflict("Kernel dependency mismatch").summary("System kernel update.").build(),
                    Patch.builder().name("Patch_1.2.6").impact("Low").status("Testing")
                            .conflict("None").summary("Minor UI enhancement patch.").build(),
                    Patch.builder().name("Patch_1.3.0").impact("Critical").status("Pending")
                            .conflict("Requires Patch_1.2.5 success").summary("Core security vulnerability fix.").build(),
                    Patch.builder().name("Patch_DB_2.0").impact("High").status("Deployed")
                            .conflict("Database downtime required").summary("Major DB schema update.").build(),
                    Patch.builder().name("Patch_API_1.5").impact("Medium").status("Deployed")
                            .conflict("Minor endpoint changes").summary("Improved logging and API throttling.").build(),
                    Patch.builder().name("Patch_UI_1.1").impact("Low").status("Deployed")
                            .conflict("None").summary("Frontend accessibility improvements.").build(),
                    Patch.builder().name("Patch_SRV_1.0").impact("Medium").status("Pending")
                            .conflict("May affect load balancer routing").summary("Server performance optimization.").build(),
                    Patch.builder().name("Patch_OS_2.1").impact("Critical").status("In Review")
                            .conflict("Requires reboot").summary("OS kernel privilege escalation fix.").build()
            ));

            // -------- TASKS --------
            taskRepo.saveAll(List.of(
                    Task.builder().title("Check Patch Logs").priority("High").status("Open")
                            .relatedTo("Patch_1.2.3").summary("Verify successful deployment.").build(),
                    Task.builder().title("Analyze CPU Spike").priority("Medium").status("In Progress")
                            .relatedTo("Server CPU Spike").summary("Investigate root cause of alert.").build(),
                    Task.builder().title("Validate Disk Cleanup").priority("Low").status("Open")
                            .relatedTo("Disk Space Low").summary("Confirm cleanup scripts executed.").build(),
                    Task.builder().title("Review Failed Patch").priority("High").status("Open")
                            .relatedTo("Patch_1.2.5").summary("Analyze failure logs and retry patch.").build(),
                    Task.builder().title("Renew SSL Certificate").priority("Medium").status("Pending")
                            .relatedTo("SSL Certificate Expiry").summary("Renew certificate for api.kiro.local").build(),
                    Task.builder().title("Update Configurations").priority("Low").status("In Progress")
                            .relatedTo("Configuration Drift").summary("Apply standardized configs to Node 11.").build(),
                    Task.builder().title("Investigate Network Delay").priority("Medium").status("Resolved")
                            .relatedTo("Network Latency").summary("Traced delay to router congestion.").build(),
                    Task.builder().title("Restart Service Nodes").priority("High").status("In Progress")
                            .relatedTo("Service Unavailable").summary("Restart app pods after patch deployment.").build(),
                    Task.builder().title("Database Indexing").priority("Medium").status("Open")
                            .relatedTo("Database Latency").summary("Optimize queries for better performance.").build(),
                    Task.builder().title("Run Vulnerability Scan").priority("High").status("Pending")
                            .relatedTo("Patch_1.3.0").summary("Run post-patch vulnerability assessment.").build()
            ));

            System.out.println("✅ MongoDB seeding completed successfully!");
        };
    }
}
