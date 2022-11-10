package com.springreact.reactspring.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springreact.reactspring.models.Transfer;
import com.springreact.reactspring.models.User;

@Repository
public interface TransferRepo extends JpaRepository<Transfer,Integer>{
    
    
}
