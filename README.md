# PROJECT 1 - Employee Reimbursement Application

## Project Description

Web application using Servlets and Hibernate

## Technologies Used

* Intelij IDE
* Visual Studio Code
* Servlets
* Hibernate
* MySQL
* Tomcat


## Features

List of features ready and TODOs for future development
* Employee and Manager login and logout functionality
* Employees can apply for and check statuses of their reimbursements
* Managers can view all reimbursements, filter table, and approve or deny reimbursements as needed.

To-do list:
* connecting to aws might be good
* improving organization of code to remove some repitition and fix issues in the future
* Employee and manager creation in program

## Getting Started
   
(include git clone command)
> Download files using git clone https://github.com/AntyZhu1/project1.git
> Set up a mySql Database named project1
> Set up the following tables:
> employees:
> | emp_id       | int         | NO   | PRI | NULL    | auto_increment |
> | emp_username | varchar(50) | YES  | UNI | NULL    |                |
> | emp_password | varchar(50) | YES  |     | NULL    |                |

> managers:
> | man_id       | int         | NO   | PRI | NULL    | auto_increment |
> | man_username | varchar(50) | YES  | UNI | NULL    |                |
> | man_password | varchar(50) | YES  |     | NULL    |                |

> past_reimbursements
> | past_re_id          | int          | YES  |     | NULL    |       |
> | past_emp_id         | int          | YES  |     | NULL    |       |
> | past_type           | varchar(50)  | YES  |     | NULL    |       |
> | past_amount         | double       | YES  |     | NULL    |       |
> | past_desc           | varchar(120) | YES  |     | NULL    |       |
> | past_date           | varchar(50)  | YES  |     | NULL    |       |
> | past_approve_status | varchar(50)  | YES  |     | NULL    |       |

> pending_reimbursements
> | re_id     | int          | NO   | PRI | NULL    | auto_increment |
> | re_emp_id | int          | YES  |     | NULL    |                |
> | re_type   | varchar(50)  | YES  |     | NULL    |                |
> | re_amount | double       | YES  |     | NULL    |                |
> | re_desc   | varchar(120) | YES  |     | NULL    |                |
> | re_date   | varchar(50)  | YES  |     | NULL    |                |

(include all environment setup steps)
> in intellij, ensure that all maven dependencies are properly installed and that the tomcat server is also properly installed (10.0 was used)

> Be sure to include BOTH Windows and Unix command  
> Be sure to mention if the commands only work on a specific platform (eg. AWS, GCP)


## Usage

> Once installed, simply start the tomcat server and navigate to localhost:8080.
> Create an employee and a manager using mysql
> Login as either an employee or manager
> Use the functionalities

## Contributors

> Anthony Zhu

## License

This project uses the following license: [<license_name>](<link>).

