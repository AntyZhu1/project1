package project1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.anthony.dao.EmployeeDAO;
import com.anthony.dao.EmployeeDAOFactory;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;

public class TestCases {

	@Test
	public void canRetrieveReimbursements() {
		EmployeeDAO empDao = EmployeeDAOFactory.getEmployeeDao();
		
		List<PastReimbursement> reimbursements = empDao.viewPastReimbursements(1);
		
		assertNotEquals(null, reimbursements);
		
	}
	
}
