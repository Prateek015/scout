package scout.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rolespermissions.model.Attendance;
import com.example.rolespermissions.model.Salary;
import com.example.rolespermissions.service.AttendanceService;
import com.example.rolespermissions.service.SalaryService;

@RestController
@RequestMapping("/hr")
public class HRController {
    
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private SalaryService salaryService;

    // Fetch attendance records
    @GetMapping("/attendance")
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> attendanceRecords = attendanceService.getAllAttendance();
        return ResponseEntity.ok(attendanceRecords);
    }

    // Calculate salaries based on attendance
    @PostMapping("/calculate-salary")
    public ResponseEntity<Salary> calculateSalary(@RequestBody Salary salary) {
        Salary calculatedSalary = salaryService.calculateSalary(salary);
        return ResponseEntity.ok(calculatedSalary);
    }
}