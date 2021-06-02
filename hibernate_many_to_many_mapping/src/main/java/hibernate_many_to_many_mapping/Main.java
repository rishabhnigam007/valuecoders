package hibernate_many_to_many_mapping;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		// Get SessionFactory using HibernateUtil Class
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		// Get Session object from SessionFactory
		Session session=sf.openSession();
		
		// Begin Transaction
		Transaction t=session.beginTransaction();
		
		// Create Bank Model Data
		Bank bank1 = new Bank();
		
		System.out.println("Enter First Bank Name : ");
		String name1=sc.next();
        bank1.setName(name1);
        
        System.out.println("Enter First Bank Branch Name : ");
        String branch1=sc.next();
        bank1.setBranchName(branch1);
        
        System.out.println("Enter First Bank Swift Code : ");
        String swiftcode1=sc.next();
        bank1.setSwiftCode(swiftcode1);
       
        // Second Bank Name
        Bank bank2 = new Bank();
        
        System.out.println("Enter Second Bank Name : ");
		String name2=sc.next();
        bank2.setName(name2);
        
        System.out.println("Enter Second Bank Branch Name : ");
        String branch2=sc.next();
        bank2.setBranchName(branch2);
        
        System.out.println("Enter Second Bank Swift Code : ");
        String swiftcode2=sc.next();
        bank2.setSwiftCode(swiftcode2);
       
        Set<Bank> banks = new HashSet<>();
        banks.add(bank1);
        banks.add(bank2);
 
        // Create Customer Model Data
        // Customer 1
        Customer customer1 = new Customer();
        
        System.out.println("Enter Email : ");
        String email1=sc.next();
        customer1.setEmail(email1);
        
        System.out.println("Enter Name : ");
        String cname1=sc.next();
        customer1.setName(cname1);
        
        System.out.println("Enter Mobile No. : ");
        long mobile1=(long) sc.nextDouble();
        customer1.setMobileNo(mobile1);
       
        // Customer 2
        Customer customer2 = new Customer();
        
        System.out.println("Enter Email : ");
        String email2=sc.next();
        customer2.setEmail(email2);
        
        System.out.println("Enter Name : ");
        String cname2=sc.next();
        customer2.setName(cname2);
        
        System.out.println("Enter Mobile No. : ");
        long mobile2=(long) sc.nextDouble();
        customer2.setMobileNo(mobile2);
       
        // Customer 3
        Customer customer3 = new Customer();
        
        System.out.println("Enter Email : ");
        String email3=sc.next();
        customer3.setEmail(email3);
        
        System.out.println("Enter Name : ");
        String cname3=sc.next();
        customer3.setName(cname3);
        
        System.out.println("Enter Mobile No. : ");
        long mobile3=(long) sc.nextDouble();
        customer3.setMobileNo(mobile3);
       
        // Customer 4
        Customer customer4 = new Customer();
        
        System.out.println("Enter Email : ");
        String email4=sc.next();
        customer4.setEmail(email4);
        
        System.out.println("Enter Name : ");
        String cname4=sc.next();
        customer4.setName(cname4);
        
        System.out.println("Enter Mobile No. : ");
        long mobile4=(long) sc.nextDouble();
        customer4.setMobileNo(mobile4);
       
       
        Set<Customer> customersList1 = new HashSet<>();
        customersList1.add(customer1);
        customersList1.add(customer2);
        bank1.setCustomers(customersList1); // This shows that this bank have two customers 1 & 2
       
        Set<Customer> customersList2 = new HashSet<>();
        customersList2.add(customer2);
        customersList2.add(customer3);
        customersList2.add(customer4);
        bank2.setCustomers(customersList2); // This Shows that customer 2,3 and 4 have this bank
        
        session.save(bank1);
        session.save(bank2);
 
        // Commit the transaction and close the session
        t.commit();
        session.close();
		sf.close();
		sc.close();
        System.out.println("successfully persisted Bank and Customer details");
	}
}

/*

One record of a table ‘A’ is associated with multiple records of table ‘B’ and One record of a table ‘B’ is associated with multiple records of table ‘A’.

In this mapping, an additional temporary table called “Join table” is required to store the primary keys of both the tables as a foreign keys.

We need to instruct Hibernate how the Join table has to be constructed.

Example:
Consider Bank and Customer

One Bank can have multiple customers and One customer can have multiple bank accounts.

*/