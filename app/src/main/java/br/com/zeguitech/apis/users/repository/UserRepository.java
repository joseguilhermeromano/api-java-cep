package br.com.zeguitech.apis.users.repository;

import br.com.zeguitech.apis.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos adicionais podem ser definidos aqui, se necessário
}
