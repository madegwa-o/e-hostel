package com.guava.E_HOSTELS.communications.issues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByUserIdAndRole(Long userId, UserRole role);
}
