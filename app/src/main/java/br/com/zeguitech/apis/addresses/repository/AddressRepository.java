package br.com.zeguitech.apis.addresses.repository;

import br.com.zeguitech.apis.addresses.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Métodos adicionais podem ser definidos aqui, se necessário
}
