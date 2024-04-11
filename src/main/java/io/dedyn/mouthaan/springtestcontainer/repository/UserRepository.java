package io.dedyn.mouthaan.springtestcontainer.repository;

import io.dedyn.mouthaan.springtestcontainer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
