package project1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.anthony.dao.EmployeeDAO;
import com.anthony.dao.EmployeeDAOFactory;
import com.anthony.dao.ManagerDAO;
import com.anthony.dao.ManagerDAOFactory;
import com.anthony.employee.Employee;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;
import com.anthony.manager.Manager;

public class TestCases {

	@Test
	public void getPastReimbursementsTest() {
		EmployeeDAO empDao = EmployeeDAOFactory.getEmployeeDao();
		List<PastReimbursement> reimbursements = empDao.viewPastReimbursements(1);
		assertNotEquals(null, reimbursements);

		
	}

	@Test
	public void employeeLoginTest() {
		EmployeeDAO empDao = EmployeeDAOFactory.getEmployeeDao();
		Employee tempEmployee = empDao.employeeLogin(1, "john", "doe");		
		assertEquals(1, tempEmployee.getEmp_id());

		
	}

	@Test
	public void managerLoginTest() {
		ManagerDAO manDao = ManagerDAOFactory.getManagerDao();
		Manager tempManager = manDao.mangerLogin(1, "a", "z");
		assertEquals(1, tempManager.getMan_id());

		
	}

//	@Test
//	public void getPastReimbursementsTest() {
//		EmployeeDAO empDao = EmployeeDAOFactory.getEmployeeDao();
//		List<PastReimbursement> reimbursements = empDao.viewPastReimbursements(1);
//		assertNotEquals(null, reimbursements);
//		
//	}
	
}
