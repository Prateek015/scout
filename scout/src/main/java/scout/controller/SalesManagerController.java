package scout.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rolespermissions.model.User;
import com.example.rolespermissions.model.Attendance;
import com.example.rolespermissions.service.UserService;
import com.example.rolespermissions.service.AttendanceService;

@RestController
@RequestMapping("/sales-manager")
public class SalesManagerController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AttendanceService attendanceService;

    // Fetch Labours within the Sales Manager's area
    @GetMapping("/labours")
    public ResponseEntity<List<User>> getLaboursInArea(@RequestParam String area) {
        List<User> labours = userService.getLaboursByArea(area);
        return ResponseEntity.ok(labours);
    }

    // Add new Labour
    @PostMapping("/add-labour")
    public ResponseEntity<User> addLabour(@RequestBody User user) {
        user.setRole("LABOUR");
        User createdLabour = userService.saveUser(user);
        return ResponseEntity.ok(createdLabour);
    }

    // Track in-time and out-time of Labours
    @PostMapping("/track-attendance")
    public ResponseEntity<Attendance> trackAttendance(@RequestBody Attendance attendance) {
        Attendance recordedAttendance = attendanceService.saveAttendance(attendance);
        return ResponseEntity.ok(recordedAttendance);
    }
}