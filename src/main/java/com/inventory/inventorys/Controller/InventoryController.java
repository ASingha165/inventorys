package com.inventory.inventorys.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.inventorys.model.Inventory;
import com.inventory.inventorys.repository.InventoryRepository;
import java.util.List;
@RestController
public class InventoryController {
    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Get all inventory items
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // Add more endpoints for CRUD operations as needed
    @PostMapping
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory item not found"));
    }
    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, Inventory updatedInventory) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory item not found"));
        inventory.setName(updatedInventory.getName());
        inventory.setQuantity(updatedInventory.getQuantity());
        inventory.setPrice(updatedInventory.getPrice());
        return inventoryRepository.save(inventory);
    }
    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
    }
}
