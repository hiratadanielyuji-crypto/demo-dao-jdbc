package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department dep = departmentDao.findById(5);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department dept : list) {
			System.out.println(dept);
		}
		
		System.out.println("=== TEST 3: department insert ====");
		Department newDep = new Department();
		newDep.setName("Controles");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New department Id = " + newDep.getId()); 
		
		System.out.println("\n=== TEST 4: department update ====");
		departmentDao.findById(5);
		dep.setName("teste");
		departmentDao.update(dep);
		System.out.println("Update complete!");
		
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.println("Enter id for delete test:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
