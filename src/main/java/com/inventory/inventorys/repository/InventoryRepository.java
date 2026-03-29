package com.inventory.inventorys.repository;
import com.inventory.inventorys.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
