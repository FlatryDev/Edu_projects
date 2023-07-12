package com.gihtub.onechesz.gpt_therapy.repositories;

import com.gihtub.onechesz.gpt_therapy.entities.EmailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailsRepository extends JpaRepository<EmailsEntity, Integer> {

}
