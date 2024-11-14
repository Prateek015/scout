package scout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rolespermissions.model.User;
import com.example.rolespermissions.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private UserService userService;

    // Fetch all Sales Managers
    @GetMapping("/sales-managers")
    public ResponseEntity<List<User>> getSalesManagers() {
        List<User> salesManagers = userService.getUsersByRole("SALES_MANAGER");
        return ResponseEntity.ok(salesManagers);
    }

    // Add new Sales Manager
    @PostMapping("/add-sales-manager")
    public ResponseEntity<User> addSalesManager(@RequestBody User user) {
        user.setRole("SALES_MANAGER");
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Add new Labour under a Sales Manager
    @PostMapping("/add-labour")
    public ResponseEntity<User> addLabour(@RequestBody User user) {
        user.setRole("LABOUR");
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Delete Sales Manager or Labour
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // View Locations of Sales Managers and Labours
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> viewLocations() {
        List<Location> locations = userService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
}