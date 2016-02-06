// PayrollSystemTest.java
// Employee hierarchy test program.
import java.util.Scanner;

public class PayrollSystemTest
{
   public static void main( String args[] )
   {

      // Salaried employee
      Scanner in = new Scanner(System.in);
      System.out.println("Enter salaried employee's first name");
      String firstName = in.nextLine;
      System.out.println("Enter salaried employee's last name");
      String lastName = in.nextLine;
      System.out.println("Enter salaried employee's social security number");
      String ssn = in.nextLine;
      System.out.println("Enter salaried employee's weekly salary amount");
      double salary = in.nextDouble;
      System.out.println("Enter salaried employee's birth month");
      int birthMonth = in.nextInt;
      System.out.println("Enter salaried employee's birth day`");
      int birthDay = in.nextInt;
      System.out.println("Enter salaried employee's birth year");
      int birthYear = in.nextInt;
      SalariedEmployee salariedEmployee =
         new SalariedEmployee( firstName, lastName, ssn, salary, birthMonth, birthDay, birthYear );

      // Hourly employee
      System.out.println("Enter hourly employee's first name");
      String firstName = in.nextLine;
      System.out.println("Enter hourly employee's last name");
      String lastName = in.nextLine;
      System.out.println("Enter hourly employee's social security number");
      String ssn = in.nextLine;
      System.out.println("Enter hourly employee's hourly wage");
      double hourlyWage = in.nextDouble;
      System.out.println("Enter hourly employee's number of hours worked");
      double hoursWorked = in.nextDouble;
      System.out.println("Enter hourly employee's birth month");
      int birthMonth = in.nextInt;
      System.out.println("Enter hourly employee's birth day`");
      int birthDay = in.nextInt;
      System.out.println("Enter hourly employee's birth year");
      int birthYear = in.nextInt;
      HourlyEmployee hourlyEmployee =
         new HourlyEmployee( firstName, lastName, ssn, hourlyWage, hoursWorked, birthMonth, birthDay, birthYear );

      // Commission employee
      System.out.println("Enter commission employee's first name");
      String firstName = in.nextLine;
      System.out.println("Enter commission employee's last name");
      String lastName = in.nextLine;
      System.out.println("Enter commission employee's social security number");
      String ssn = in.nextLine;
      System.out.println("Enter commission employee's gross sales");
      double grossSales = in.nextDouble;
      System.out.println("Enter commission employee's commission rate");
      double commissionRate = in.nextDouble;
      System.out.println("Enter commission employee's birth month");
      int birthMonth = in.nextInt;
      System.out.println("Enter commission employee's birth day`");
      int birthDay = in.nextInt;
      System.out.println("Enter commission employee's birth year");
      int birthYear = in.nextInt;
      CommissionEmployee commissionEmployee =
         new CommissionEmployee(
         firstName, lastName, ssn, grossSales, commissionRate, birthMonth, birthDay, birthYear );

      // Base plus commission employee
      System.out.println("Enter base plus commission employee's first name");
      String firstName = in.nextLine;
      System.out.println("Enter base plus commission employee's last name");
      String lastName = in.nextLine;
      System.out.println("Enter base plus commission employee's social security number");
      String ssn = in.nextLine;
      System.out.println("Enter base plus commission employee's gross sales");
      double grossSales = in.nextDouble;
      System.out.println("Enter base plus commission employee's commission rate");
      double commissionRate = in.nextDouble;
      System.out.println("Enter base plus commission employee's salary");
      double salary = in.nextDouble;
      System.out.println("Enter base plus commission employee's birth month");
      int birthMonth = in.nextInt;
      System.out.println("Enter base plus commission employee's birth day`");
      int birthDay = in.nextInt;
      System.out.println("Enter base plus commission employee's birth year");
      int birthYear = in.nextInt;
      BasePlusCommissionEmployee basePlusCommissionEmployee =
         new BasePlusCommissionEmployee(
         firstName, lastName, ssn, grossSales, commissionRate, salary, birthMonth, birthDay, birthYear );

      System.out.println( "Employees processed individually:\n" );

      System.out.printf( "%s\n%s: $%,.2f\n\n",
         salariedEmployee, "earned", salariedEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings() );
      System.out.printf( "%s\n%s: $%,.2f\n\n",
         basePlusCommissionEmployee,
         "earned", basePlusCommissionEmployee.earnings() );

      // create four-element Employee array
      Employee employees[] = new Employee[ 4 ];

      // initialize array with Employees
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = hourlyEmployee;
      employees[ 2 ] = commissionEmployee;
      employees[ 3 ] = basePlusCommissionEmployee;

      System.out.println( "Employees processed polymorphically:\n" );

      int currentMonth = 11;

      // generically process each element in array employees
      for ( Employee currentEmployee : employees )
      {

        /* In a loop, calculate the monthly paycheck amount for

        each Employee (polymorphically), and add a $100.00 bonus to the person's monthly

        payroll amount if the current month (i.e. November) is the month in which the

        Employee's birthday occurs.*/
        double weeklyPaycheckAmount = currentEmployee.earnings();
        double monthlyPaycheckAmount = weeklyPaycheckAmount * 4;
        if ( currentEmployee.getBirthDate.getMonth() == currentMonth)
        {
            monthlyPaycheckAmount = monthlyPaycheckAmount + 100;
        }

         System.out.println( currentEmployee ); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if ( currentEmployee instanceof BasePlusCommissionEmployee )
         {
            // downcast Employee reference to
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee =
               ( BasePlusCommissionEmployee ) currentEmployee;

            double oldBaseSalary = employee.getBaseSalary();
            employee.setBaseSalary( 1.10 * oldBaseSalary );
            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f\n",
               employee.getBaseSalary() );
         } // end if

         System.out.printf(
            "earned $%,.2f\n\n", currentEmployee.earnings() );
      } // end for

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "Employee %d is a %s\n", j,
            employees[ j ].getClass().getName() );
   } // end main
} // end class PayrollSystemTest
