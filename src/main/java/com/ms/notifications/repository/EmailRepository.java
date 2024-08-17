package com.ms.notifications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.notifications.model.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, String>{

}
