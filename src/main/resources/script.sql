CREATE TABLE TERMS
(
  ID   INT PRIMARY KEY,
  TERM VARCHAR(96) NOT NULL UNIQUE
);

CREATE TABLE DEFINITIONS
(
  ID         INT PRIMARY KEY,
  DEFINITION VARCHAR(255) NOT NULL,
  TERM_ID    INT          NOT NULL,
  CONSTRAINT term_fk FOREIGN KEY (TERM_ID) REFERENCES TERMS (ID)
);

INSERT INTO TERMS VALUES (1, 'java');
INSERT INTO TERMS VALUES (2, 'int');
INSERT INTO TERMS VALUES (3, 'object');
INSERT INTO TERMS VALUES (4, 'process');
INSERT INTO TERMS VALUES (5, 'reference');
INSERT INTO TERMS VALUES (6, 'serialization');
INSERT INTO TERMS VALUES (7, 'import');
INSERT INTO TERMS VALUES (8, 'void');
INSERT INTO TERMS VALUES (9, 'wrapper');
INSERT INTO TERMS VALUES (10, 'abstract');
INSERT INTO TERMS VALUES (11, 'break');
INSERT INTO TERMS VALUES (12, 'casting');
INSERT INTO TERMS VALUES (13, 'do');
INSERT INTO TERMS VALUES (14, 'else');
INSERT INTO TERMS VALUES (15, 'enum');
INSERT INTO TERMS VALUES (16, 'field');
INSERT INTO TERMS VALUES (17, 'garbage collection');
INSERT INTO TERMS VALUES (18, 'hierarchy');
INSERT INTO TERMS VALUES (19, 'identifier');
INSERT INTO TERMS VALUES (20, 'instanceof');

INSERT INTO DEFINITIONS VALUES (1, 'Sun'' trademark for a set of technologies for creating and safely running software programs in both stand-alone and networked environments.', 1);
INSERT INTO DEFINITIONS VALUES (2, 'A Java keyword used to define a variable of type integer.', 2);
INSERT INTO DEFINITIONS VALUES (3, 'The principal building blocks of object-oriented programs. Each object is a programming unit consisting of data ( instance variables ) and functionality ( instance methods ).', 3);
INSERT INTO DEFINITIONS VALUES (4, 'A virtual address space containing one or more threads.', 4);
INSERT INTO DEFINITIONS VALUES (5, 'A variable data type in which the variable''s value is an address.', 5);
INSERT INTO DEFINITIONS VALUES (6, 'The encoding of objects, and the objects reachable from them, into a stream of bytes and the complementary reconstruction of the object graph from the stream.', 6);
INSERT INTO DEFINITIONS VALUES (7, 'A Java keyword used at the beginning of a source file that can specify classes or entire packages to be referred to later without including their package names in the reference.', 7);
INSERT INTO DEFINITIONS VALUES (8, 'A Java keyword used in method declarations to specify that the method does not return any value. void can also be used as a nonfunctional statement.', 8);
INSERT INTO DEFINITIONS VALUES (9, 'An object that encapsulates and delegates to another object to alter its interface or behavior in some way.', 9);
INSERT INTO DEFINITIONS VALUES (10, 'A Java keyword used in a class definition to specify that a class is not to be instantiated, but rather inherited by other classes. An abstract class can have abstract methods that are not implemented in the abstract class, but in subclasses.', 10);
INSERT INTO DEFINITIONS VALUES (11, 'A Java keyword used to resume program execution at the statement immediately following the current statement. If followed by a label, the program resumes execution at the labeled statement.', 11);
INSERT INTO DEFINITIONS VALUES (12, 'Explicit conversion from one data type to another.', 12);
INSERT INTO DEFINITIONS VALUES (13, 'A Java keyword used to declare a loop that will iterate a block of statements. The loop''s exit condition can be specified with the while keyword.', 13);
INSERT INTO DEFINITIONS VALUES (14, 'A Java keyword used to execute a block of statements in the case that the test condition with the if keyword evaluates to false.', 14);
INSERT INTO DEFINITIONS VALUES (15, 'A Java keyword used to declare an enumerated type.', 15);
INSERT INTO DEFINITIONS VALUES (16, 'A data member of a class. Unless specified otherwise, a field is not static.', 16);
INSERT INTO DEFINITIONS VALUES (17, 'The automatic detection and freeing of memory that is no longer in use. The Java runtime system performs garbage collection so that programmers never explicitly free objects.', 17);
INSERT INTO DEFINITIONS VALUES (18, 'A classification of relationships in which each item except the top one (known as the root) is a specialized form of the item above it. Each item can have one or more items below it in the hierarchy.', 18);
INSERT INTO DEFINITIONS VALUES (19, 'The name of an item in a program written in the Java programming language.', 19);
INSERT INTO DEFINITIONS VALUES (20, 'A two-argument Java keyword that tests whether the runtime type of its first argument is assignment compatible with its second argument.', 20);
INSERT INTO DEFINITIONS VALUES (21, 'The language we learn', 1);