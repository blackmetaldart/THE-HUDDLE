# PROJECT-TWO-BASE

## BY : ALEXANDER BEACH  &&  ZAINAB AKRAMI

### PROJECT TWO BASE - A REDDIT CLONE USING JAVA AND SPRING FRAMEWORK

### BRIEF DESCRIPTION
This project was written to produce the back-end for a blog-like site. It provides the ability to create/save a user along with a user profile. It also provides log-in functionality with the ability to create, save, and delete posts and comments.


### TECHNOLOGIES USED
* [INTELLIJ](https://www.jetbrains.com/idea/) - The IDE used for the Java
* [POSTGRESQL](https://www.postgresql.org) The object-relational database system used with SQL
* [MAVEN](https://maven.apache.org/) - Dependency Management 
* [ATOM](https://atom.io) - The cool text editor used to write the HTML, CSS, and JavaScript files.

### APPROACH TAKEN
We began with utilizing Spring Initializer to build the project using Spring Frameworks. We added our dependencies and mapped out the goals for the application. This helped us understand how to progress through the application's development. Afterwards, we had to implement the functionality in stages. We mapped out all of the endpoints, their purpose, and the privileges needed to access them. We collaborated on a previous project, so the work flow was a lot more cohesive. COMMIT, COMMIT, COMMIT!!

We worked together to set goals and deadlines, and we kept to them. We made sure not to get caught up in the impossible by thinking about what needed to be accomplished rather than what we wanted to be accomplished. We also did a lot of pair programming, so we were able to error-check and learn from each other.

### HOW TO USE
The back-end of the application is ready-to-use. You can add roles through any database management system like PostgreSQL. You would have to set a database in the application-dev.properties, here:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/
```
along with the username and password. 

You also have to go into the PostgreSQL system from the terminal and enter two commands :
```
CREATE USER [ENTER THE USERNAME YOU CHOSE] WITH PASSWORD '[ENTER THE PASSWORD YOU CHOSE]';
```
```
GRANT ALL PRIVILEGES ON DATABASE [NAME OF THE DATABASE YOU ARE USING] TO [ENTER THE USERNAME YOU CHOSE];
```
*For everything in brackets : You choose the word and the casing, but no spaces!

The rest of the code is commented for your understanding.

### UNSOLVED PROBLEMS


### AUTHORS
* **ZAINAB AKRAMI** - [GITHUB](https://github.com/zainab21)
* **ALEXANDER BEACH** - [GITHUB](https://github.com/MrAlexBeach)

