package com.springreact.reactspring.Respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springreact.reactspring.models.Newfd;


@Repository
public interface NewFdRep extends JpaRepository<Newfd,Integer>
{

}
